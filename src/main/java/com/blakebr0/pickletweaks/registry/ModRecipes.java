package com.blakebr0.pickletweaks.registry;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.pickletweaks.config.ModConfig;
import com.blakebr0.pickletweaks.feature.crafting.GridRepairRecipe;
import com.blakebr0.pickletweaks.feature.item.ItemRepairKit;
import com.blakebr0.pickletweaks.feature.item.ItemRepairKitCustom;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {

	public static final String[] MATERIALS = new String[] { "Iron", "Gold", "Copper", "Tin", "Silver", "Lead",
			"Aluminum", "Nickel", "Platinum", "Iridium", "Mithril", "Steel", "Electrum", "Invar", "Bronze",
			"Constantan", "Signalum", "Lumium", "Enderium" };

	public static void init() {
		if (ModConfig.confGridRepair) {
			ForgeRegistries.RECIPES.register(new GridRepairRecipe());
		}
		
		if (ModConfig.confReinforcement) {
			//ForgeRegistries.RECIPES.register(new ReinforcementRecipe());
		}
		
		ItemRepairKit.initRecipes();
		ItemRepairKitCustom.initRecipes();
	}

	public static void postInit() {
		if (ModConfig.confHammerToPlateRecipes && ModConfig.confHammer) {
            for (String material : MATERIALS) {
                if (!OreDictionary.getOres("ingot" + material, false).isEmpty() && !OreDictionary.getOres("plate" + material, false).isEmpty()) {
                    String ingot = "ingot" + material;
                    ItemStack plate = OreDictionary.getOres("plate" + material).get(0).copy();
                    RecipeHelper.addShapelessRecipe(plate, new ItemStack(ModItems.itemHammer, 1, OreDictionary.WILDCARD_VALUE), ingot, ingot);
                }
            }
		}
	}
}
