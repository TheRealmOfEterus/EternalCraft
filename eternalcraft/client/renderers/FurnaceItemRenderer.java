package eternalcraft.client.renderers;

import eternalcraft.common.machines.tileentity.TileEntityECFurnace;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.client.IItemRenderer;

public class FurnaceItemRenderer implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type){
		case FIRST_PERSON_MAP: return false;
		default: return true;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type){
		case FIRST_PERSON_MAP: break;
		default: renderFurnace((RenderBlocks)data[0], item);
		}
	}
	
	private void renderFurnace(RenderBlocks renderBlocks, ItemStack item){
		TileEntityECFurnace tile = new TileEntityECFurnace();
		tile.readMachinePropertiesFromNBT(item.stackTagCompound);
		TileEntityRenderer.instance.renderTileEntityAt(tile, 0, 0, 0, 0);
	}
}
