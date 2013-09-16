package eternalcraft.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import eternalcraft.client.renderers.FurnaceItemRenderer;
import eternalcraft.common.Eternalcraft;
import eternalcraft.common.core.CommonProxy;
import eternalcraft.common.helpers.TextureHelper;

/**
 * Handles client only calls, such as rendering.
 * 
 * @author bau5
 *
 */
public class ClientProxy extends CommonProxy {
	/**
	 * Register renderers with Forge, such as for Tile Entities
	 */
	@Override
	public void registerRenderInformation() {
		//TODO custom item renderer
//		MinecraftForgeClient.registerItemRenderer(Eternalcraft.instance.settings.getMachinesID(), new FurnaceItemRenderer());
	}
	
	@Override
	public World getClientSideWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}
}
