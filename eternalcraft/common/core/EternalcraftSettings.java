package eternalcraft.common.core;

/**
 * 
 * @author bau5
 *
 */
public class EternalcraftSettings {
	public boolean VERSION_CHECK;
	public boolean successfullyLoaded = false;
	public int MACHINE_BLOCK_ID;
	public int MACHINES_ID;
	public int MACHINE_PART_ID;
	public int MACHINE_TOOL_ID;
	
	public boolean doVersionCheck(){
		return VERSION_CHECK;
	}
	public boolean loadedSuccessfully(){
		return successfullyLoaded;
	}
	public int getMachineBlockID() {
		return MACHINE_BLOCK_ID;
	}
	public int getMachinesID() {
		return MACHINES_ID;
	}
	public int getMachinePartItemID() {
		return MACHINE_PART_ID;
	}
	public int getMachineToolID() {
		return MACHINE_TOOL_ID;
	}
	public EternalcraftSettings getDefaults() {
		EternalcraftSettings defaults = new EternalcraftSettings();
		defaults.VERSION_CHECK = true;
		defaults.MACHINES_ID = 2870;
		defaults.MACHINE_BLOCK_ID = 2871;
		defaults.MACHINE_PART_ID = 20870;
		defaults.MACHINE_TOOL_ID = 20871;
		defaults.VERSION_CHECK = true;
		defaults.successfullyLoaded = true;
		return defaults;
	}
}
