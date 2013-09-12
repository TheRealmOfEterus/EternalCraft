package eternalcraft.common.machines;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import eternalcraft.common.Eternalcraft;
import eternalcraft.common.core.BlockECContainer;
import eternalcraft.common.machines.tileentity.TileEntityECFurnace;
/**
 * 
 * @author bau5
 *
 */
public class BlockECFurnace extends BlockECContainer{
	
	protected BlockECFurnace(int id, Material mat) {
		super(id, mat);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y,
			int z, EntityPlayer player, int par6, float par7,
			float par8, float par9) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		if(te == null || player.isSneaking() || !(te instanceof TileEntityECFurnace)){
			return true;
		}
		Eternalcraft.proxy.openFurnaceGUI(player, world, x, y, z, meta);
		return true;
	}
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return FurnaceType.makeTileEntity(metadata);
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
	
	@Override
	public void registerIcons(IconRegister registrar) {
		for(FurnaceType type : FurnaceType.values())
			type.makeIcons(registrar);
	}
	@Override
	public Icon getBlockTexture(IBlockAccess blockAccess, int x,
			int y, int z, int par5) {
		if(Eternalcraft.proxy.getClientSideWorld() != null)
			blockAccess = Eternalcraft.proxy.getClientSideWorld();
		TileEntity te = blockAccess.getBlockTileEntity(x, y, z);
		if(te != null && te instanceof TileEntityECFurnace)
			return FurnaceType.STONE.getIconBySide(par5, ((TileEntityECFurnace)te).getDirFacing(), ((TileEntityECFurnace)te).isBurning());
		return super.getBlockTexture(blockAccess, x, y, z, par5);
	}
	@Override
	public Icon getIcon(int side, int meta) {
//		switch(meta){
//		case 0: return FurnaceType.STONE.getIconBySide(side, 0);
//		}
		return super.getIcon(side, meta);
	}
	
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 1));
	}
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
	}
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		if(Eternalcraft.proxy.getClientSideWorld() == null)
			return super.getLightValue(world, x, y, z);
		world = Eternalcraft.proxy.getClientSideWorld();
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te == null || !(te instanceof TileEntityECFurnace))
			return super.getLightValue(world, x, y, z);
		if(((TileEntityECFurnace)te).isBurning())
			return 13;
		else
			return super.getLightValue(world, x, y, z);
			
	}
}
