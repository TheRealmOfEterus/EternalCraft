package eternalcraft.common.machines.tileentity;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import eternalcraft.common.machines.IMachine;
import eternalcraft.common.machines.MachineType;

/**
 * 
 * @author bau5
 *
 */
public class TileEntityMachine extends TileEntity implements IMachine{
	private HashMap<String, Object> machineModifiers = new HashMap();
	private byte facingDirection = -1;
	public TileEntityMachine(){
		
	}
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		setDirectionFacing(tagCompound.getByte("facing"));
		readMachinePropertiesFromNBT(tagCompound);
	}
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setByte("facing", facingDirection);
		writeMachinePropertiesToNBT(tagCompound);
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
	@Override
	public void setMachineProperty(String key, Object value) {
		if(machineModifiers.containsKey(key)){
			machineModifiers.remove(key);
			machineModifiers.put(key, value);
		}
	}
	@Override
	public Object getMachineProperty(String key) {
		if(!machineModifiers.containsKey(key))
			return "[null]";
		else
			return machineModifiers.get(key);
	}
	@Override
	public void writeMachinePropertiesToNBT(NBTTagCompound mainTag) {
		
	}
	@Override
	public void readMachinePropertiesFromNBT(NBTTagCompound mainTag) {
		
	}
}
