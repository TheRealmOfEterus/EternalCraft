package eternalcraft.common.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.Item;
import eternalcraft.common.Eternalcraft;

/**
 * @author Master801
 */
public abstract class ItemEC extends Item {
	
	public ItemEC(int itemID, int stackSize, int damage) {
		super(itemID);
		setFull3D();
		setMaxStackSize(stackSize);
		setMaxDamage(damage);
		setCreativeTab(Eternalcraft.tabEternalCraft);
	}

	public ItemEC(int itemID, int stackSize) {
		this(itemID, stackSize, 0);
	}
	
}
