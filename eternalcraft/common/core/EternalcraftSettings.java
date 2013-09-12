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
	
	public boolean doVersionCheck(){
		return VERSION_CHECK;
	}
	public boolean loadedSuccessfully(){
		return successfullyLoaded;
	}
	public int getMachineBlockID() {
		return MACHINE_BLOCK_ID;
	}
	public EternalcraftSettings getDefaults() {
		EternalcraftSettings defaults = new EternalcraftSettings();
		defaults.VERSION_CHECK = true;
		defaults.MACHINE_BLOCK_ID = 2870;
		defaults.VERSION_CHECK = true;
		defaults.successfullyLoaded = true;
		return defaults;
	}
}
