
package net.mcreator.gcfix.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.gcfix.ElementsGCFix;

import java.util.List;

@ElementsGCFix.ModElement.Tag
public class ItemSproutTowerDisc extends ElementsGCFix.ModElement {
	@GameRegistry.ObjectHolder("gcfix:sprouttowerdisc")
	public static final Item block = null;
	public ItemSproutTowerDisc(ElementsGCFix instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("gcfix:sprouttowerdisc", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("sprouttowerdisc", ElementsGCFix.sounds.get(new ResourceLocation("gcfix:sprouttowertheme")));
			setUnlocalizedName("sprouttowerdisc");
			setRegistryName("sprouttowerdisc");
			setCreativeTab(CreativeTabs.MISC);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("legendary");
			list.add("special");
		}
	}
}
