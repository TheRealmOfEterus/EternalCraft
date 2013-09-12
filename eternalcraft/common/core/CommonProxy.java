package eternalcraft.common.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import eternalcraft.client.GuiECFurnace;
import eternalcraft.client.GuiECFurnace.Gui;
import eternalcraft.common.Eternalcraft;
import eternalcraft.common.machines.FurnaceType;
import eternalcraft.common.machines.tileentity.ContainerECFurnaceStone;
import eternalcraft.common.machines.tileentity.TileEntityECFurnace;

/**
 * The CommonProxy, handles all GUI interactions.
 * 
 * @author bau5
 *
 */
public class CommonProxy implements IGuiHandler {

	/**
	 *  Only invoked by the client.
	 */
	public void registerRenderInformation() { }
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te == null || !(te instanceof TileEntityECFurnace))
			return null;
		
		switch(ID){
		case 0: return new ContainerECFurnaceStone(player.inventory, (TileEntityECFurnace)te);
		case 1: return new ContainerFurnace(player.inventory, (TileEntityECFurnace)te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te == null || !(te instanceof TileEntityECFurnace))
				return null;
		switch(ID){
		case 0: return new GuiECFurnace(Gui.STONE, player.inventory, ((TileEntityECFurnace)te));
		case 1: return new GuiECFurnace(Gui.IRON, player.inventory, ((TileEntityECFurnace)te));
		}
		return null;
	}
	
	public void openFurnaceGUI(EntityPlayer player, World world, int x, int y, int z, int meta){
		player.openGui(Eternalcraft.instance, meta, world, x, y, z);
	}
	
	public World getClientSideWorld(){
		return null;
	}
}
