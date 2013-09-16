package eternalcraft.common.machines;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eternalcraft.common.Eternalcraft;
import eternalcraft.common.helpers.TextureHelper;
import eternalcraft.common.machines.tileentity.TileEntityECFurnace;
import eternalcraft.common.machines.tileentity.TileEntityMachine;

/**
 * 
 * @author bau5
 *
 */
public enum MachineType {
	BASE(TileEntityMachine.class, new String[]{}, -1),
	FURNACE(TileEntityECFurnace.class, new String[]{ "decrementValue" }, Eternalcraft.GUI_ID++);
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	public Class<? extends TileEntity> theMachine;
	public String[] modifiers;
	public int guiID;
	public int tileType;
	
	MachineType(Class<? extends TileEntity> tileClass, String[] modifiers, int guiid){
		theMachine = tileClass;
		guiID = guiid;
		tileType = this.ordinal();
		this.modifiers = modifiers;
	}
	
	public void makeIcons(IconRegister registrar){
		icons = new Icon[4];
		int counter = 0;
		String[] names = TextureHelper.getTextureNamesForType(this);
		for(String str : names)
			icons[counter++] = registrar.registerIcon(String.format("%s:%s", TextureHelper.TEXTURE_LOC, str));
	}
	
	public Icon getIconBySide(int side, int dir, boolean isActive){
		if(dir == 0 || dir == 3){
			switch(side){
			case TextureHelper.TOP:   return icons[0];
			case TextureHelper.BOTTOM:return icons[0];
			case TextureHelper.FRONT: return icons[1];
			default: return icons[3];
			}
		}else if(dir == 2){
			 if(side == TextureHelper.BACK)
				return icons[isActive ? 2:1];
		}else if(dir == 5){
			if(side == TextureHelper.RIGHT)
				return icons[isActive ? 2:1];
		}else if(dir == 4){
			if(side == TextureHelper.LEFT)
				return icons[isActive ? 2:1];
		}
		switch(side){
		case TextureHelper.TOP:   return icons[0];
		case TextureHelper.BOTTOM:return icons[0];
		default: return icons[3];
		}
	}
	
	public String[] getModifiers(){
		return modifiers;
	}

	public static TileEntity makeTileEntity(int meta) {
		if(meta < values().length){
			try{
				TileEntity machine = values()[meta].theMachine.newInstance();
				return machine;
			}catch(Exception ex){
				//You did it wrong!
				ex.printStackTrace();
			}
		}
		return null;
	}
}
