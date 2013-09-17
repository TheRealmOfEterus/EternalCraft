package eternalcraft.common.items;

import eternalcraft.common.core.Reference;

/**
 * @author Azhdev
 */
public class ItemInfo {

	//items id's
	public static int HAMMER_ID = EternalcraftItems.settings().getMachineToolID();
	public static int HAMMER_DEFAULT = EternalcraftItems.settings().getDefaults().getMachineToolID();
		//misc integers
	public static int ID_CORRECTION = 256;
	//item strings
	//Unlocalized names
	public static String BASE = "ec.";
	public static String HAMMER_UNLOC = BASE + "hammer";
	
	//texture strings
	public static String TEXTURE_LOC = Reference.TEXTURE_LOC;
	public static String HAMMER_ICON = "Hammer";
}
