package eternalcraft.common.machines.tileentity;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagByteArray;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import eternalcraft.common.machines.IMachine;
import eternalcraft.common.machines.MachineType;
/**
 * 
 * @author bau5
 *
 */
public class TileEntityMachineBase extends TileEntityMachine implements IMachine {

	private HashMap<Byte, Byte> byteMap = new HashMap<Byte, Byte>();
	
	public TileEntityMachineBase(){
		
	}
	
	public void setWatchableByte(byte id, byte val){
		byteMap.put(id, val);
	}
	public byte getWatchableByte(byte id){
		return byteMap.get(id);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		NBTTagList list = new NBTTagList();
		for(byte b : byteMap.keySet()){
			
		}
	}
	@Override
	public byte getDirectionFacing() {
		return super.getDirectionFacing();
	}

	@Override
	public void setDirectionFacing(byte dir) {
		super.setDirectionFacing(dir);
	}

	@Override
	public MachineType getMachineType() {
		return MachineType.BASE;
	}

	@Override
	public boolean isActive() {
		return false;
	}
}
