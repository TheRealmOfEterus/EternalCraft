package eternalcraft.common.core;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import eternalcraft.common.machines.tileentity.TileEntityECFurnace;

/**
 * A base for most of the blocks that will have an inventory
 * of some sort. Handles directional placing, droping ivnentory,
 * etc. All children will inherit this behavior.
 * 
 * @author bau5
 *
 */
public class BlockECContainer extends BlockContainer {
	
	protected BlockECContainer(int id, Material mat) {
		super(id, mat);
	}
	
	@Override
	public String getUnlocalizedName() {
		return super.getUnlocalizedName();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack){
		super.onBlockPlacedBy(world, x, y, z, living, stack);
        byte dir = 0;
        int plyrFacing = MathHelper.floor_double(((living.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if (plyrFacing == 0)
            dir = 2;
        if (plyrFacing == 1)
            dir = 5;
        if (plyrFacing == 2)
            dir = 3;
        if (plyrFacing == 3)
            dir = 4;
        TileEntity te = world.getBlockTileEntity(x, y, z);
        if (te != null && te instanceof TileEntityECFurnace)
        {
            ((TileEntityECFurnace)te).setDirFacing(dir);
            world.markBlockForUpdate(x, y, z);
        }
    }
	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6)
	{
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}
	public void dropItems(World world, int x, int y, int z) 
	{
		Random rand = new Random();
		
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(!(te instanceof IInventory))
			return;
		IInventory inv = (IInventory)te;
		int i = 0; 
		int size = inv.getSizeInventory();
		if(te instanceof TileEntityECFurnace)
			i = 27;
		for(; i < size; i++)
		{
			ItemStack item = inv.getStackInSlot(i);
			if(item != null && item.stackSize > 0)
			{
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;
				EntityItem ei = new EntityItem(world, x + rx, y + ry, z + rz,
						new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));
				if(item.hasTagCompound())
					ei.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				float factor = 0.05f;
				ei.motionX = rand.nextGaussian() * factor;
				ei.motionY = rand.nextGaussian() * factor + 0.2F;
				ei.motionZ = rand.nextGaussian() * factor;
				if(!world.isRemote)
					world.spawnEntityInWorld(ei);
				item.stackSize = 0;
			}
		}
	}
}
