package eternalcraft.common.items.actualItems;

import net.minecraft.client.renderer.texture.IconRegister;
import eternalcraft.common.items.ItemEC;

/**
 * Brought this class file back from the dead with the commit thing.
 * With some *minor* changes though. ;)
 * @author Master801
 */
public class ItemMachinePart extends ItemEC {

	public ItemMachinePart(int itemID, int stackSize, int damage) {
		super(itemID, stackSize, damage);
	}
	
	public ItemMachinePart(int itemID, int stackSize) {
		super(itemID, stackSize, 0);
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		super.registerIcons(register);
	}
	
}
