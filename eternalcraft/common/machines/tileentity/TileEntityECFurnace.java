package eternalcraft.common.machines.tileentity;

import cpw.mods.fml.common.network.PacketDispatcher;
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

public class TileEntityECFurnace extends TileEntityFurnace implements IInventory, ISidedInventory {
	private byte dirFacing = 0;
	protected int decrementValue;	
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
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setByte("facing", dirFacing);
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
		setDirFacing(tagCompound.getByte("facing"));
	}
	
	public void setDirFacing(byte dirFacing) {
		this.dirFacing = dirFacing;
	}
	public byte getDirFacing() {
		return dirFacing;
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
}
