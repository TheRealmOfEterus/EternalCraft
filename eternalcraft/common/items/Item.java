package eternalcraft.common.items;

/**
 * @author Azhdev
 */

import eternalcraft.common.Eternalcraft;
import eternalcraft.common.core.EternalcraftSettings;
import eternalcraft.common.items.actualItems.ItemHammer;
import net.minecraft.item.Item;


public class item {
	
	//create the items 
		public static Item hammer;
	
	//initialize the items
	public static void init(){
		hammer = new ItemHammer(itemInfo.HAMMER_ID);
	}
	
	public static EternalcraftSettings settings() {
		return Eternalcraft.instance.settings;
	}
}
