package eternalcraft.common.machines;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

/**
 * 
 * @author bau5
 *
 */
public class ItemBlockECMachine extends ItemBlockWithMetadata{

	private final String machineNames[] = {
		"furnace","grinder"	
	};
	
	public ItemBlockECMachine(int id, Block mainBlock) {
		super(id, mainBlock);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName(itemStack) +"." +machineNames[itemStack.getItemDamage()];
	}
	@Override
	public boolean placeBlockAt(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ, int metadata) {
		boolean bool = super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY,
				hitZ, metadata + 1);
		IMachine machine = (IMachine) world.getBlockTileEntity(x, y, z);
		if(machine != null){
			if(metadata == 0){
				if(stack.stackTagCompound != null && stack.stackTagCompound.hasKey("machineModifiers")){
					machine.readMachinePropertiesFromNBT(stack.stackTagCompound);
				}
			}
		}
		return bool;
	}
	
}
