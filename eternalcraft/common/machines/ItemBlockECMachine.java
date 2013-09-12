package eternalcraft.common.machines;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author bau5
 *
 */
public class ItemBlockECMachine extends ItemBlockWithMetadata{

	private final String machineNames[] = {
		"stonefurnace", "ironfurnace"	
	};
	
	public ItemBlockECMachine(int id, Block mainBlock) {
		super(id, mainBlock);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName(itemStack) +"." +machineNames[itemStack.getItemDamage()];
	}
}
