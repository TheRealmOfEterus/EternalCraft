package eternalcraft.common.machines;

import cpw.mods.fml.common.registry.GameRegistry;
import eternalcraft.common.Eternalcraft;
import eternalcraft.common.core.EternalcraftSettings;
import eternalcraft.common.helpers.TextureHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class EternalcraftMachines {
	
	public static Block machineBlock;
	public static void initialize() {
		TextureHelper.buildFurnaceTextureNames();
		machineBlock = new BlockECFurnace(settings().getMachineBlockID(), Material.iron).setUnlocalizedName("ec.machineblock").setCreativeTab(Eternalcraft.tabEternalCraft);
		GameRegistry.registerBlock(machineBlock, ItemBlockECMachine.class, "ec_machineblock");
		registerMachineTileEntities();
	}
	
	private static void registerMachineTileEntities() {
		for(FurnaceType furnace : FurnaceType.values())
			GameRegistry.registerTileEntity(furnace.theTileClass, "ec_machine_"+furnace.name());
	}

	public static EternalcraftSettings settings() {
		return Eternalcraft.instance.settings;
	}

}
