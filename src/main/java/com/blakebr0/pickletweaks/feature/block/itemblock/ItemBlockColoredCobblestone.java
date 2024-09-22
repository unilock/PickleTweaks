package com.blakebr0.pickletweaks.feature.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockColoredCobblestone extends ItemBlock {

	public ItemBlockColoredCobblestone(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public String getTranslationKey(ItemStack stack) {
		return super.getTranslationKey(stack) + "_" + EnumDyeColor.byMetadata(stack.getMetadata()).getTranslationKey();
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
}
