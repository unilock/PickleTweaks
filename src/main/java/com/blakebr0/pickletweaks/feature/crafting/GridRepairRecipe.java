package com.blakebr0.pickletweaks.feature.crafting;

import com.blakebr0.pickletweaks.Tags;
import com.blakebr0.pickletweaks.config.ModConfig;
import com.blakebr0.pickletweaks.feature.item.ItemRepairKit;
import com.blakebr0.pickletweaks.feature.item.ItemRepairKitCustom;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

public class GridRepairRecipe extends Impl<IRecipe> implements IRecipe {
	
	public GridRepairRecipe() {
		this.setRegistryName(Tags.MOD_ID, "grid_repair");
	}

	@Override
	public boolean matches(InventoryCrafting inv, World world) {
		return !getRepairOutput(inv).isEmpty();
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return getRepairOutput(inv);
	}
	
	public ItemStack getRepairOutput(InventoryCrafting inv) {
		if (ModConfig.confRequires3x3) {
			if (inv.getWidth() < 3 || inv.getHeight() < 3) {
				return ItemStack.EMPTY;
			}
		}
		
		ItemStack tool = ItemStack.EMPTY;
		boolean foundTool = false;
		NonNullList<ItemStack> inputs = NonNullList.create();
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack slotStack = inv.getStackInSlot(i);
			
			if (slotStack.isEmpty()) {
				continue;
			}
			
			ItemStack newSlotStack = slotStack.copy();
			newSlotStack.setCount(1);
			
			if (!foundTool && newSlotStack.isItemStackDamageable()) {
				tool = newSlotStack;
				foundTool = true;
			} else {
				inputs.add(newSlotStack);
			}
		}
		
		if (tool.isEmpty()) {
			return ItemStack.EMPTY;
		}
		
		if (!ModConfig.confAllowArmor && tool.getItem() instanceof ItemArmor) {
			return ItemStack.EMPTY;
		}
		
		if (!tool.isItemDamaged()) {
			return ItemStack.EMPTY;
		}
		
		if (inputs.isEmpty()) {
			return ItemStack.EMPTY;
		}
		
		if (tool.getItem().hasContainerItem(tool)) {
			return ItemStack.EMPTY;
		}
		
		if (GridRepairBlacklist.isBlacklisted(tool.getItem())) {
			return ItemStack.EMPTY;
		}
		
		int repairCost = ModConfig.confRepairCost;
		
		if (ModConfig.confCheaperShovel && tool.getItem() instanceof ItemSpade) {
			repairCost = Math.max(1, repairCost / 2);
		}
		
		int damage = tool.getMaxDamage() / repairCost;
		
		double matCount = 0;
		boolean repairKit = false, maxed = false;
		
		for (ItemStack mat : inputs) {
			if (maxed) return ItemStack.EMPTY;
			
			if (!repairKit && mat.getItem() instanceof ItemRepairKit) {
				if (matCount > 0) {
					return ItemStack.EMPTY;
				}
				
				ItemRepairKit kit = (ItemRepairKit) mat.getItem();
				if (ItemRepairKit.isKitValid(tool, kit.getKit(mat))) {
					repairKit = true;
				}
			} else if (!repairKit && mat.getItem() instanceof ItemRepairKitCustom) {
				if (matCount > 0) {
					return ItemStack.EMPTY;
				}
				
				ItemRepairKitCustom kit = (ItemRepairKitCustom) mat.getItem();
				if (ItemRepairKitCustom.isKitValid(tool, kit.getKit(mat))) {
					repairKit = true;
				}
			} else if (!repairKit && !mat.getItem().hasContainerItem(mat)) {
				double matValue = GridRepairHelper.getMaterialValue(tool, mat);
				if (matValue == 0) return ItemStack.EMPTY;

				matCount += matValue;
				
				if (tool.getItemDamage() - (damage * matCount) <= 0) {
					maxed = true;
				}
			} else {
				return ItemStack.EMPTY;
			}
		}
		
		if (!repairKit && matCount == 0) {
			return ItemStack.EMPTY;
		}
		
		if (repairKit) {
			tool.setItemDamage(0);
		} else {
			tool.setItemDamage(tool.getItemDamage() - (int) (damage * matCount));
		}

		return tool;
	}

	@Override
	public boolean canFit(int width, int height) {
		return !ModConfig.confRequires3x3 || (width >= 3 && height >= 3);
	}

	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}
	
//	@Override
//	public boolean isHidden() {
//		return true;
//	}
}
