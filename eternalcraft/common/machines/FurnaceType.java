package eternalcraft.common.machines;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eternalcraft.common.Eternalcraft;
import eternalcraft.common.helpers.TextureHelper;
import eternalcraft.common.machines.tileentity.TileEntityECFurnace;
import eternalcraft.common.machines.tileentity.TileEntityFurnaceIron;
import eternalcraft.common.machines.tileentity.TileEntityFurnaceStone;

/**
 * 
 * @author bau5
 *
 */
public enum FurnaceType {
	STONE(TileEntityFurnaceStone.class, Eternalcraft.GUI_ID++),
	IRON(TileEntityFurnaceIron.class, Eternalcraft.GUI_ID++);
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	public Class<? extends TileEntityECFurnace> theTileClass;
	public int guiID;
	
	FurnaceType(Class<? extends TileEntityECFurnace> tileClass, int id){
		theTileClass = tileClass;
		guiID = id;
	}
	
	public void makeIcons(IconRegister registrar){
		icons = new Icon[4];
		int counter = 0;
		String[] names = TextureHelper.getTextureNamesForType(this);
		for(String str : names)
			icons[counter++] = registrar.registerIcon(String.format("%s:%s", TextureHelper.TEXTURE_LOC, str));
	}
	
	public Icon getIconBySide(int side, int dir){
		if(dir == 0 || dir == 3){
			switch(side){
			case TextureHelper.TOP:   return icons[0];
			case TextureHelper.BOTTOM:return icons[0];
			case TextureHelper.FRONT: return icons[1];
			default: return icons[3];
			}
		}else if(dir == 2){
			 if(side == TextureHelper.BACK)
				return icons[1];
		}else if(dir == 5){
			if(side == TextureHelper.RIGHT)
				return icons[1];
		}else if(dir == 4){
			if(side == TextureHelper.LEFT)
				return icons[1];
		}
		switch(side){
		case TextureHelper.TOP:   return icons[0];
		case TextureHelper.BOTTOM:return icons[0];
		default: return icons[3];
		}
	}

	public static TileEntity makeTileEntity(int meta) {
		if(meta < values().length){
			try{
				TileEntityECFurnace furnace = values()[meta].theTileClass.newInstance();
				return furnace;
			}catch(Exception ex){
				//You did it wrong!
				ex.printStackTrace();
			}
		}
		return null;
	}
}
