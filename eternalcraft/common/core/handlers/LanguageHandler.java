package eternalcraft.common.core.handlers;

import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.registry.LanguageRegistry;
import eternalcraft.common.core.Reference;

/**
 * Loads all the languages that are shown as supported by {@link Reference}.LANG_LOCATION
 * @author bau5
 *
 */
public class LanguageHandler {
	
	public static final void loadLangauges() {
		for(String lang : Reference.SUPPORTED_LANGUAGES) {
			LanguageRegistry.instance().loadLocalization(new ResourceLocation(Reference.LANG_LOCATION +lang +".xml").getResourcePath(), lang, true);
		}
	}
	
}
