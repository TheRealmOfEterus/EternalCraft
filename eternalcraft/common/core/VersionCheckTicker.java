package eternalcraft.common.core;

import java.util.EnumSet;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

/**
 * If the mod is out of date, it will notify the user when he enters the world.
 * @author bau5
 */
public class VersionCheckTicker implements ITickHandler {

	private boolean init = true;

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if (init) {
			for (TickType tickType : type) {
				if (tickType == TickType.CLIENT) {
					if (FMLClientHandler.instance().getClient().currentScreen == null) {
						init = false;
						if (!Reference.UP_TO_DATE) {
							FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("A new version of " + Reference.MOD_NAME + " is available.\n    Version: " + Reference.LATEST_VERSION + ": " + Reference.LATEST_CHANGES);
							FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("This update is " + Reference.UPDATE_IMPORTANCE + " - " + Reference.UPDATE_URL);
						}
					}
				}
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return null;
	}

	@Override
	public String getLabel() {
		return null;
	}

}
