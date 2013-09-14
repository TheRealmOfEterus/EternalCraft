package eternalcraft.common.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eternalcraft.common.Eternalcraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

/**
 * 
 * @author bau5
 *
 */
public class ItemMachineTool extends Item{

	public ItemMachineTool(int id) {
		super(id);
		setMaxDamage(0);
		setMaxStackSize(1);
		setCreativeTab(Eternalcraft.tabEternalCraft);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return Item.stick.getIconFromDamage(damage);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registrar) {
		super.registerIcons(registrar);
	}
}
