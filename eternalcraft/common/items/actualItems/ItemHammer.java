package eternalcraft.common.items.actualItems;

/**
 * @author Azhdev
 */

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eternalcraft.common.items.itemInfo;

public class ItemHammer extends Item {

	public ItemHammer(int ID) {
		super(ID);
		this.setUnlocalizedName(itemInfo.HAMMER_UNLOC);
		
	}
	
	public boolean isFull3D(){
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(itemInfo.TEXTURE_LOC + ":" + itemInfo.HAMMER_ICON);
	}
}
