package eternalcraft.common.helpers;

import java.util.HashMap;

import eternalcraft.common.core.Reference;
import eternalcraft.common.machines.MachineType;

/**
 * 
 * @author bau5
 *
 */
public class TextureHelper {
	public static final TextureHelper instance = new TextureHelper();
	public static final String TEXTURE_LOC = Reference.TEXTURE_LOC;
	public static HashMap<Integer, String[]> machineTextureNamesMap = new HashMap<Integer, String[]>();
	public static final String[] sides = {
		"top", "front", "front_on", "side"
	};
	public static String[] getTextureNamesForType(MachineType machineType) {
		return machineTextureNamesMap.get(machineType.ordinal());
	}
	public static void buildFurnaceTextureNames(){
		for(MachineType type : MachineType.values()){
			String[] names = new String[sides.length];
			for(int i = 0; i < names.length; i++)
				names[i] = String.format("%s_%s", type.name().toLowerCase(), sides[i]);
			machineTextureNamesMap.put(type.ordinal(), names);
		}
	}
	/**
	 * While facing south (or block in hand)
	 * 		bottom: 0
	 * 		top   : 1
	 * 		front : 2
	 * 		back  : 3
	 * 		right : 4
	 * 		left  : 5
	 */
	public enum Side{
		BOTTOM(),
		TOP(),
		BACK(),
		FRONT(),
		LEFT(),
		RIGHT(),
	}
	
	public static final int BOTTOM = 0;
	public static final int TOP = 1;
	public static final int BACK = 2;
	public static final int FRONT = 3;
	public static final int RIGHT = 5;
	public static final int LEFT = 4;
}
