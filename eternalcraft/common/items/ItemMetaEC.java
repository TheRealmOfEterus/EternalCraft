package eternalcraft.common.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eternalcraft.common.Eternalcraft;

//FIXME Textures do not load correctly, and items are missing from creative tab?
/**
 * Used for items that have meta-data. Hence the name. Set the Item's stacksize manually!
 * @author Master801
 */
public class ItemMetaEC extends Item {
	
	private final List metadataList = new ArrayList();
	private final HashMap itemTextureFileHashMap = new HashMap();
	private final HashMap itemUnlocalizedNameHashMap = new HashMap();
	private final HashMap itemStackSizeHashMap = new HashMap();
	private final Icon[] itemIcons = new Icon[16];
	
	public ItemMetaEC(int itemID) {
		super(itemID);
		setCreativeTab(Eternalcraft.tabEternalCraft);
		setFull3D();
		setHasSubtypes(true);
	}
	
	/**
	 * Adds to item to the list/maps.
	 * @author Master801
	 */
	public final void addItemToMap(int metadata, String unlocalizedName, String textureFileName, int stackSize) {
		if (metadata > 0) {
			metadataList.add(metadata);
		}
		if (unlocalizedName != null) {
			itemUnlocalizedNameHashMap.put(metadata, "item." + unlocalizedName);
		}
		if (textureFileName == null) {
			itemTextureFileHashMap.put(metadata, (String)textureFileName);
		}
		if (stackSize > 0) {
			itemStackSizeHashMap.put(metadata, stackSize);
		}
		return;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		final String prefix = "eternalcraft" + ":";
		for(int i = 0; i < ((Integer)metadataList.get(0) + 1); i++) {
			switch(i) {
			case 0:
				itemIcons[0] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(0));
				break;
			case 1:
				itemIcons[1] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(1));
				break;
			case 2:
				itemIcons[2] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(2));
				break;
			case 3:
				itemIcons[3] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(3));
				break;
			case 4:
				itemIcons[4] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(4));
				break;
			case 5:
				itemIcons[5] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(5));
				break;
			case 6:
				itemIcons[6] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(6));
				break;
			case 7:
				itemIcons[7] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(7));
				break;
			case 8:
				itemIcons[8] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(8));
				break;
			case 9:
				itemIcons[9] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(9));
				break;
			case 10:
				itemIcons[10] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(10));
				break;
			case 11:
				itemIcons[11] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(11));
				break;
			case 12:
				itemIcons[12] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(12));
				break;
			case 13:
				itemIcons[13] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(13));
				break;
			case 14:
				itemIcons[14] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(14));
				break;
			case 15:
				itemIcons[15] = register.registerIcon(prefix + (String) itemTextureFileHashMap.get(15));
				break;
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int itemMetaData) {
		switch(itemMetaData) {
		case 0:
			return itemIcons[0] != null ? itemIcons[0] : null;
		case 1:
			return itemIcons[1] != null ? itemIcons[1] : null;
		case 2:
			return itemIcons[2] != null ? itemIcons[2] : null;
		case 3:
			return itemIcons[3] != null ? itemIcons[3] : null;
		case 4:
			return itemIcons[4] != null ? itemIcons[4] : null;
		case 5:
			return itemIcons[5] != null ? itemIcons[5] : null;
		case 6:
			return itemIcons[6] != null ? itemIcons[6] : null;
		case 7:
			return itemIcons[7] != null ? itemIcons[7] : null;
		case 8:
			return itemIcons[8] != null ? itemIcons[8] : null;
		case 9:
			return itemIcons[9] != null ? itemIcons[9] : null;
		case 10:
			return itemIcons[10] != null ? itemIcons[10] : null;
		case 11:
			return itemIcons[11] != null ? itemIcons[11] : null;
		case 12:
			return itemIcons[12] != null ? itemIcons[12] : null;
		case 13:
			return itemIcons[13] != null ? itemIcons[13] : null;
		case 14:
			return itemIcons[14] != null ? itemIcons[14] : null;
		case 15:
			return itemIcons[15] != null ? itemIcons[15] : null;
		default:
			return null;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int meta, CreativeTabs tab, List list) {
		for(int i = 0; i < ((Integer)metadataList.get(0) + 1); i++) {
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getUnlocalizedName(ItemStack stack) {
		try {
			return (String)itemUnlocalizedNameHashMap.get(stack.getItemDamage());
		} catch(Exception var1) {
			var1.printStackTrace();
			throw new IndexOutOfBoundsException();
		}
	}
	
}
