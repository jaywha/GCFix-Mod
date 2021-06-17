package net.mcreator.gcfix.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.gcfix.ElementsGCFix;

import java.util.Random;

@ElementsGCFix.ModElement.Tag
public class ProcedureBreadOnStickToolRightClickedInAir extends ElementsGCFix.ModElement {
	public ProcedureBreadOnStickToolRightClickedInAir(ElementsGCFix instance) {
		super(instance, 6);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BreadOnStickToolRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure BreadOnStickToolRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).getFoodStats()
					.setFoodLevel((int) (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).getFoodStats().getFoodLevel() : 0) + 1));
		if (itemstack.attemptDamageItem((int) 1, new Random(), null)) {
			itemstack.shrink(1);
			itemstack.setItemDamage(0);
		}
	}
}
