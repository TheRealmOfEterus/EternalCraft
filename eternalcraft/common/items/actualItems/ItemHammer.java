package eternalcraft.common.items.actualItems;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eternalcraft.common.items.ItemInfo;

/**
 * @author Azhdev
 */
public class ItemHammer extends Item {

	public ItemHammer(int ID) {
		super(ID);
		setMaxDamage(0);
		setMaxStackSize(1);
		this.setUnlocalizedName(ItemInfo.HAMMER_UNLOC);
		setFull3D();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.HAMMER_ICON);
	}

}
