package eternalcraft.common.machines.tileentity;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * 
 * @author bau5
 *
 */
public class ContainerECFurnace extends ContainerFurnace {

	public ContainerECFurnace(InventoryPlayer invPlayer,
			TileEntityFurnace furnace) {
		super(invPlayer, furnace);
	}
}
