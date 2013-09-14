package eternalcraft.common.machines;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eternalcraft.common.Eternalcraft;
/**
 * 
 * @author bau5
 *
 */
public class ItemMachinePart extends Item{
	private final String[] itemNames= {
		"panel", "grinder", "grinderbody", "grinderset", "screw"
	};
	public ItemMachinePart(int id, int damage) {
		super(id);
		setMaxStackSize(64);
		setMaxDamage(0);
		setCreativeTab(Eternalcraft.tabEternalCraft);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		switch(damage){
		case 0: return Block.blockIron.getIcon(damage, 0);
		case 1: return Item.comparator.getIconFromDamage(0);
		case 2: return Block.blockGold.getIcon(damage, 0);
		case 3: return Item.diamond.getIconFromDamage(0);
		case 4: return Item.seeds.getIconFromDamage(0);
		default: return null;
		}
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list) {
		list.add(new ItemStack(this, 1, 0));
		list.add(new ItemStack(this, 1, 1));
		list.add(new ItemStack(this, 1, 2));
		list.add(new ItemStack(this, 1, 3));
		list.add(new ItemStack(this, 1, 4));
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "." +itemNames[stack.getItemDamage()];
	}
}
