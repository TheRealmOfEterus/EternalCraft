package eternalcraft.common.machines.tileentity;

import eternalcraft.common.machines.IMachine;
import eternalcraft.common.machines.MachineType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * 
 * @author bau5
 *
 */
public class TileEntityMachine extends TileEntity implements IMachine{
	private byte facingDirection = -1;
	public TileEntityMachine(){
		
	}
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		setDirectionFacing(tagCompound.getByte("facing"));
	}
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setByte("facing", facingDirection);
	}
	@Override
	public byte getDirectionFacing() {
		return facingDirection;
	}

	@Override
	public void setDirectionFacing(byte dir) {
		facingDirection = dir;
	}

	@Override
	public MachineType getMachineType() {
		return null;
	}

	@Override
	public boolean isActive() {
		return false;
	}
}
