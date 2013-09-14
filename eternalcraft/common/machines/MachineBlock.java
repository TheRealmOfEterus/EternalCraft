package eternalcraft.common.machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eternalcraft.common.core.BlockECContainer;
/**
 * 
 * @author bau5
 *
 */
public class MachineBlock extends BlockECContainer {

	public MachineBlock(int id, Material mat) {
		super(id, mat);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xHit, float yHit, float zHit) {
		ItemStack held = player.getHeldItem();
		ItemStack screws = new ItemStack(EternalcraftMachines.machinePartItem, 12, 4);
		if(held.getItem().equals(EternalcraftMachines.machineToolItem) && held.getItemDamage() == 0){
			int screwCounter = 12;
			for(ItemStack is : player.inventory.mainInventory){
				if(is.getItem().equals(screws.getItem()) && is.getItemDamage() == screws.getItemDamage()){
					screws.stackSize -= is.stackSize;
					if(screws.stackSize <= 0)
						break;
				}
			}	
			if(screws.stackSize <= 0){
				System.out.println("Check!");
			}
		}
		return super.onBlockActivated(world, x, y, z, player, side, xHit, yHit, zHit);
	}
	 @Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int id, int side) {
		return Block.blockIron.getIcon(id, side);
	}
}
