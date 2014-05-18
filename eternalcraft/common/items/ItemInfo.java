package eternalcraft.common.items;

import eternalcraft.common.core.Reference;

/**
 * @author Azhdev
 */
public class ItemInfo {

	//items id's
	public static final int HAMMER_ID = EternalcraftItems.settings().getMachineToolID();
	public static final int HAMMER_DEFAULT = EternalcraftItems.settings().getDefaults().getMachineToolID();
		//misc integers
	public static final int ID_CORRECTION = 256;
	//item strings
	//Unlocalized names
	public static final String BASE = "ec.";
	public static final String HAMMER_UNLOC = BASE + "hammer";
	
	//texture strings
	public static final String TEXTURE_LOC = Reference.TEXTURE_LOC;
	public static final String HAMMER_ICON = "Hammer";
}
