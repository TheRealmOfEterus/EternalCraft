package eternalcraft.common.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import eternalcraft.common.Eternalcraft;

/**
 * Used for items that have meta-data. Hence the name.
 * @author Master801
 */
public class ItemMetaEC extends Item {
	
	private final List metadataList = new ArrayList();
	private final HashMap itemHashMap = new HashMap();
	private final HashMap textureFileHashMap = new HashMap();
	private final HashMap unlocalizedNameHashMap = new HashMap();
	private String[] textureFileName = null;
	private ItemMetaEC item = null;
	
	public ItemMetaEC(int itemID) {
		super(itemID);
		setCreativeTab(Eternalcraft.tabEternalCraft);
		setFull3D();
	}
	
	/**
	 * Adds to item to the map.
	 * @author Master801
	 */
	public final void addItemToMap(ItemMetaEC item, int metadata, String[] textureFileName, String unlocalizedName, int stackSize, int itemDamage) {
		if (textureFileName == null) {
			this.textureFileName = textureFileName;
		}
		if (item != null) {
			this.item = item;
		}
		setUnlocalizedName(unlocalizedName);
		setMaxStackSize(stackSize);
		setMaxDamage(itemDamage);
		return;
	}

	@Override
	public void registerIcons(IconRegister register) {
		for(String textureFileNames : textureFileName != null ? textureFileName : null) {
			if (textureFileNames == null) {
				throw new NullPointerException("[Eternal-Craft] Failed to get texture file name('s) for ItemMetaEC!");
			}
		}
	}
	
}
