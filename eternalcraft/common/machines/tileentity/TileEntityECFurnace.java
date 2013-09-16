package eternalcraft.common.machines.tileentity;

import cpw.mods.fml.common.network.PacketDispatcher;
import eternalcraft.common.machines.IMachine;
import eternalcraft.common.machines.MachineType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * 
 * @author bau5
 *
 */
public class TileEntityECFurnace extends TileEntityFurnace implements IMachine, IInventory, ISidedInventory {
	private byte dirFacing = 0;
	protected int decrementValue;	
	
	public TileEntityECFurnace(){
		
	}
	
	@Override
	public void updateEntity()
    {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;

        if (this.furnaceBurnTime > 0)
        {
            this.furnaceBurnTime -= decrementValue;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.furnaceBurnTime == 0 && canSmelt())
            {
                this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(getStackInSlot(1));

                if (this.furnaceBurnTime > 0)
                {
                    flag1 = true;

                    if (getStackInSlot(1) != null)
                    {
                        --getStackInSlot(1).stackSize;

                        if (getStackInSlot(1).stackSize == 0)
                        {
                        	setInventorySlotContents(1, getStackInSlot(1).getItem().getContainerItemStack(getStackInSlot(1)));
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                this.furnaceCookTime += decrementValue;

                if (this.furnaceCookTime == 200)
                {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
            }
            else
            {
                this.furnaceCookTime = 0;
            }

            if (flag != this.furnaceBurnTime > 0)
            {
            	flag1 = true;
            	PacketDispatcher.sendPacketToAllAround(xCoord, yCoord, zCoord, 30D, worldObj.getWorldInfo().getVanillaDimension(), getDescriptionPacket());
                int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
                int id = worldObj.getBlockId(xCoord, yCoord, zCoord);
                worldObj.setBlock(xCoord, yCoord, zCoord, 0);
                worldObj.setBlock(xCoord, yCoord, zCoord, id);
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, meta, 1);
                this.validate();
                worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, this);
            }
        }
        if (flag1)
        {
            this.onInventoryChanged();
        }
    }
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new Packet132TileEntityData(xCoord, yCoord, zCoord, 2, nbt);
		
	}
	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
		readFromNBT(pkt.data);
	}
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		setDirectionFacing(tagCompound.getByte("facing"));
		readMachinePropertiesFromNBT(tagCompound);
	}
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setByte("facing", dirFacing);
		writeMachinePropertiesToNBT(tag);
	}
	/* 
	 * Private function in TileEntityFurnace we need access to... 
	 */
	private boolean canSmelt()
    {
        if (getStackInSlot(0) == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.getStackInSlot(0));
            if (itemstack == null) return false;
            if (getStackInSlot(2) == null) return true;
            if (!getStackInSlot(2).isItemEqual(itemstack)) return false;
            int result = getStackInSlot(2).stackSize + itemstack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

	@Override
	public byte getDirectionFacing() {
		return this.dirFacing;
	}

	@Override
	public void setDirectionFacing(byte dir) {
		this.dirFacing = dir;
	}

	@Override
	public MachineType getMachineType() {
		return MachineType.FURNACE;
	}
	
	@Override
	public boolean isActive() {
		return this.isBurning();
	}

	@Override
	public String getMachineProperty(String id) {
		return new String("" +decrementValue);
	}

	@Override
	public void setMachineProperty(String key, String value) {
		if(key.equalsIgnoreCase("decrementValue"))
			decrementValue = Integer.parseInt(value);
	}

	@Override
	public void writeMachinePropertiesToNBT(NBTTagCompound mainTag) {
		NBTTagCompound modifierTag = new NBTTagCompound();
		modifierTag.setString(MachineType.FURNACE.modifiers[0], "2");
		mainTag.setCompoundTag("machineModifiers", modifierTag);		
	}

	@Override
	public void readMachinePropertiesFromNBT(NBTTagCompound mainTag) {
		NBTTagCompound modifierTag = mainTag.getCompoundTag("machineModifiers");
		int val = Integer.parseInt(modifierTag.getString(MachineType.FURNACE.modifiers[0]));
		decrementValue = val;
	}
}
