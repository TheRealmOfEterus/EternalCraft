package eternalcraft.common;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import eternalcraft.common.core.CommonProxy;
import eternalcraft.common.core.CreativeTabEC;
import eternalcraft.common.core.EternalcraftSettings;
import eternalcraft.common.core.Reference;
import eternalcraft.common.core.handlers.ConfigHandler;
import eternalcraft.common.core.handlers.ECPacketHandler;
import eternalcraft.common.core.handlers.LanguageHandler;
import eternalcraft.common.core.handlers.VersionCheckHandler.VersionChecker;
import eternalcraft.common.machines.EternalcraftMachines;


@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
@NetworkMod(serverSideRequired=false, clientSideRequired=true, channels={Reference.CHANNEL},
			packetHandler=ECPacketHandler.class)
public class Eternalcraft {
	@Instance(Reference.MOD_ID)
	public static Eternalcraft instance;
	public static CreativeTabEC tabEternalCraft;
	@SidedProxy(clientSide="eternalcraft.client.ClientProxy",
				serverSide="eternalcraft.common.core.CommonProxy")
	public static CommonProxy proxy;
	
	public static int GUI_ID = 0;
	
	public EternalcraftSettings settings;
	
	@EventHandler
	public void preInitialization(FMLPreInitializationEvent ev){
		settings = ConfigHandler.loadConfig(new Configuration(ev.getSuggestedConfigurationFile()));
		if(settings.doVersionCheck())
			VersionChecker.go();
		LanguageHandler.loadLangauges();
		initParts();
	}
	
	@EventHandler
	public void initialization(FMLInitializationEvent ev){
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
	}
	
	public void initParts(){
		tabEternalCraft = new CreativeTabEC("tabEternalCraft");
		EternalcraftMachines.initialize();
	}
}
