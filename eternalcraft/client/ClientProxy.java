package eternalcraft.client;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.world.World;
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
	}
	
	@Override
	public World getClientSideWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}
}
