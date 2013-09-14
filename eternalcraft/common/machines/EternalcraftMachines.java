package eternalcraft.common.machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import eternalcraft.common.Eternalcraft;
import eternalcraft.common.core.EternalcraftSettings;
import eternalcraft.common.helpers.TextureHelper;

public class EternalcraftMachines {
	
	public static Block machineBlock;
	public static Block machines;
	public static Item  machinePartItem;
	public static Item  machineToolItem;
	public static void initialize() {
		TextureHelper.buildFurnaceTextureNames();
		initBlocks();
		machinePartItem = new ItemMachinePart(settings().getMachinePartItemID(), 0).setUnlocalizedName("ec.machinepart");
		machineToolItem = new ItemMachineTool(settings().getMachineToolID()).setUnlocalizedName("ec.machinetool");
		GameRegistry.registerBlock(machineBlock, "ec_machineblock");
		GameRegistry.registerBlock(machines, ItemBlockECMachine.class, "ec_machines");
		registerMachineTileEntities();
	}
	
	private static void registerMachineTileEntities() {
		for(MachineType machine : MachineType.values())
			GameRegistry.registerTileEntity(machine.theMachine, "ec_machine_"+machine.name().toLowerCase());
	}
	private static void initBlocks(){
		machines = new BlockECFurnace(settings().getMachinesID(), Material.iron).setUnlocalizedName("ec.machines").setCreativeTab(Eternalcraft.tabEternalCraft);
		machineBlock = new MachineBlock(settings().getMachineBlockID(), Material.iron).setUnlocalizedName("ec.machineblock").setCreativeTab(Eternalcraft.tabEternalCraft);
	}

	public static EternalcraftSettings settings() {
		return Eternalcraft.instance.settings;
	}

	public static void initRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(machinePartItem, 1, 3), new Object[]{
			new ItemStack(machinePartItem, 1, 1), new ItemStack(machinePartItem, 1, 2)
		});
	}
}
