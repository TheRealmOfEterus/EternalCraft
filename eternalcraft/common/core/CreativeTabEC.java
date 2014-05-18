package eternalcraft.common.core;

import eternalcraft.common.machines.BlockECFurnace;
import eternalcraft.common.machines.EternalcraftMachines;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * @author bau5
 */
public class CreativeTabEC extends CreativeTabs{

	public CreativeTabEC(String label) {
		super(label);
	}
	
	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(EternalcraftMachines.machineBlock, 1, 0);
	}
	
}
