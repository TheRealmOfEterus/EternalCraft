package eternalcraft.common.items;

/**
 * @author Azhdev
 */
import eternalcraft.common.Eternalcraft;
import eternalcraft.common.core.EternalcraftSettings;
import eternalcraft.common.items.actualItems.ItemHammer;
import eternalcraft.common.items.actualItems.ItemMachinePart;
import net.minecraft.item.Item;


public class EternalcraftItems {
	
	//create the items 
	public static Item hammer;
	public static Item machinePartItem;
	
	//initialize the items
	public static void init(){
		hammer = new ItemHammer(ItemInfo.HAMMER_ID).setCreativeTab(Eternalcraft.tabEternalCraft);
		machinePartItem = new ItemMachinePart(settings().getMachinePartItemID(), 0).setUnlocalizedName("ec.machinepart");
	}
	
	public static EternalcraftSettings settings() {
		return Eternalcraft.instance.settings;
	}
}
