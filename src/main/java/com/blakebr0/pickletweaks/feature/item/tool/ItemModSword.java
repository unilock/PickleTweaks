package com.blakebr0.pickletweaks.feature.item.tool;

import com.blakebr0.cucumber.iface.IRepairMaterial;
import com.blakebr0.pickletweaks.PickleTweaks;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.oredict.OreDictionary;

public class ItemModSword extends ItemSword implements IRepairMaterial {

	private ItemStack repairMaterial;
	private String oreRepairMaterial;
	
	public ItemModSword(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName("pt." + name);
		this.setCreativeTab(PickleTweaks.CREATIVE_TAB);
	}
	
	public ItemModSword(String name, ToolMaterial material, String ore) {
		this(name, material);
		this.oreRepairMaterial = ore;
	}
	
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return oreRepairMaterial != null
				? OreDictionary.getOres(oreRepairMaterial).stream().anyMatch(stack -> stack.isItemEqual(repair))
				: OreDictionary.itemMatches(getRepairMaterial(), repair, false);    
	}

	@Override
	public ItemStack getRepairMaterial() {
		return this.repairMaterial;
	}

	@Override
	public void setRepairMaterial(ItemStack stack) {
		this.repairMaterial = stack;
	}
}
