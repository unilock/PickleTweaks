package com.blakebr0.pickletweaks.registry;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.blakebr0.pickletweaks.PickleTweaks;
import com.blakebr0.pickletweaks.config.ModConfig;
import com.blakebr0.pickletweaks.feature.item.ItemCoalPiece;
import com.blakebr0.pickletweaks.feature.item.ItemCoin;
import com.blakebr0.pickletweaks.feature.item.ItemDiamondApple;
import com.blakebr0.pickletweaks.feature.item.ItemDyePowder;
import com.blakebr0.pickletweaks.feature.item.ItemEmeraldApple;
import com.blakebr0.pickletweaks.feature.item.ItemGrassFiber;
import com.blakebr0.pickletweaks.feature.item.ItemHammer;
import com.blakebr0.pickletweaks.feature.item.ItemMagnet;
import com.blakebr0.pickletweaks.feature.item.ItemMesh;
import com.blakebr0.pickletweaks.feature.item.ItemMortarAndPestle;
import com.blakebr0.pickletweaks.feature.item.ItemNightvisionGoggles;
import com.blakebr0.pickletweaks.feature.item.ItemNightvisionGogglesC;
import com.blakebr0.pickletweaks.feature.item.ItemPPM4;
import com.blakebr0.pickletweaks.feature.item.ItemPaxel;
import com.blakebr0.pickletweaks.feature.item.ItemReinforcement;
import com.blakebr0.pickletweaks.feature.item.ItemRepairKit;
import com.blakebr0.pickletweaks.feature.item.ItemRepairKitCustom;
import com.blakebr0.pickletweaks.feature.item.ItemWateringCan;
import com.blakebr0.pickletweaks.feature.item.tool.ItemModAxe;
import com.blakebr0.pickletweaks.feature.item.tool.ItemModHoe;
import com.blakebr0.pickletweaks.feature.item.tool.ItemModPickaxe;
import com.blakebr0.pickletweaks.feature.item.tool.ItemModShears;
import com.blakebr0.pickletweaks.feature.item.tool.ItemModShovel;
import com.blakebr0.pickletweaks.feature.item.tool.ItemModSword;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {

	public static ItemCoalPiece itemCoalPiece = new ItemCoalPiece();
	public static ItemDiamondApple itemDiamondApple = new ItemDiamondApple();
	public static ItemEmeraldApple itemEmeraldApple = new ItemEmeraldApple();
	public static ItemWateringCan itemWateringCan = new ItemWateringCan();
	public static ItemHammer itemHammer = new ItemHammer();
	public static ItemGrassFiber itemGrassFiber = new ItemGrassFiber();
	public static ItemMesh itemGrassFiberMesh = new ItemMesh("grass_fiber_mesh", 19);
	public static ItemMesh itemMesh = new ItemMesh("mesh", 63);
	public static ItemMesh itemReinforcedMesh = new ItemMesh("reinforced_mesh", 511);
	public static ItemMagnet itemMagnet = new ItemMagnet();
	public static ItemNightvisionGoggles itemNightvisionGoggles = new ItemNightvisionGoggles();
	public static ItemNightvisionGogglesC itemNightVisionGogglesC = new ItemNightvisionGogglesC();
	public static ItemMortarAndPestle itemMortarAndPestle = new ItemMortarAndPestle();
	public static ItemDyePowder itemDyePowder = new ItemDyePowder();
	public static ItemRepairKit itemRepairKit = new ItemRepairKit();
	public static ItemRepairKitCustom itemRepairKitCustom = new ItemRepairKitCustom();
	public static ItemReinforcement itemReinforcement = new ItemReinforcement();

	public static ItemPaxel itemWoodenPaxel = new ItemPaxel("wooden_paxel", ToolMaterial.WOOD);
	public static ItemPaxel itemStonePaxel = new ItemPaxel("stone_paxel", ToolMaterial.STONE);
	public static ItemPaxel itemIronPaxel = new ItemPaxel("iron_paxel", ToolMaterial.IRON);
	public static ItemPaxel itemGoldenPaxel = new ItemPaxel("golden_paxel", ToolMaterial.GOLD);
	public static ItemPaxel itemDiamondPaxel = new ItemPaxel("diamond_paxel", ToolMaterial.DIAMOND);

	// Thermal Foundation tool material stats
	// https://github.com/CoFH/ThermalFoundation/blob/master/src/main/java/cofh/thermalfoundation/init/TFEquipment.java
	public static final ToolMaterial MATERIAL_ALUMINUM = EnumHelper.addToolMaterial("PT:ALUMINUM", 1, 225, 10.0F, 1.0F, 14);
	public static final ToolMaterial MATERIAL_COPPER = EnumHelper.addToolMaterial("PT:COPPER", 1, 175, 4.0F, 0.75F, 6);
	public static final ToolMaterial MATERIAL_TIN = EnumHelper.addToolMaterial("PT:TIN", 1, 200, 4.5F, 1.0F, 7);
	public static final ToolMaterial MATERIAL_BRONZE = EnumHelper.addToolMaterial("PT:BRONZE", 2, 500, 6.0F, 2.0F, 15);
	public static final ToolMaterial MATERIAL_LEAD = EnumHelper.addToolMaterial("PT:LEAD", 1, 150, 5.0F, 1.0F, 9);
	public static final ToolMaterial MATERIAL_SILVER = EnumHelper.addToolMaterial("PT:SILVER", 2, 200, 6.0F, 1.5F, 20);
	public static final ToolMaterial MATERIAL_NICKEL = EnumHelper.addToolMaterial("PT:NICKEL", 2, 300, 6.5F, 2.5F, 18);
	public static final ToolMaterial MATERIAL_INVAR = EnumHelper.addToolMaterial("PT:INVAR", 2, 450, 7.0F, 3.0F, 16);
	public static final ToolMaterial MATERIAL_CONSTANTAN = EnumHelper.addToolMaterial("PT:CONSTANTAN", 2, 275, 6.0F, 1.5F, 20);
	public static final ToolMaterial MATERIAL_ELECTRUM = EnumHelper.addToolMaterial("PT:ELECTRUM", 0, 100, 14.0F, 0.5F, 30);
	public static final ToolMaterial MATERIAL_STEEL = EnumHelper.addToolMaterial("PT:STEEL", 2, 500, 6.5F, 2.5F, 10);
	public static final ToolMaterial MATERIAL_PLATINUM = EnumHelper.addToolMaterial("PT:PLATINUM", 4, 1700, 9.0F, 4.0F, 9);

	public static ItemPaxel itemAluminumPaxel = new ItemPaxel("aluminum_paxel", MATERIAL_ALUMINUM, "ingotAluminum");
	public static ItemPaxel itemCopperPaxel = new ItemPaxel("copper_paxel", MATERIAL_COPPER, "ingotCopper");
	public static ItemPaxel itemTinPaxel = new ItemPaxel("tin_paxel", MATERIAL_TIN, "ingotTin");
	public static ItemPaxel itemBronzePaxel = new ItemPaxel("bronze_paxel", MATERIAL_BRONZE, "ingotBronze");
	public static ItemPaxel itemLeadPaxel = new ItemPaxel("lead_paxel", MATERIAL_LEAD, "ingotLead");
	public static ItemPaxel itemSilverPaxel = new ItemPaxel("silver_paxel", MATERIAL_SILVER, "ingotSilver");
	public static ItemPaxel itemNickelPaxel = new ItemPaxel("nickel_paxel", MATERIAL_NICKEL, "ingotNickel");
	public static ItemPaxel itemInvarPaxel = new ItemPaxel("invar_paxel", MATERIAL_INVAR, "ingotInvar");
	public static ItemPaxel itemConstantanPaxel = new ItemPaxel("constantan_paxel", MATERIAL_CONSTANTAN, "ingotConstantan");
	public static ItemPaxel itemElectrumPaxel = new ItemPaxel("electrum_paxel", MATERIAL_ELECTRUM, "ingotElectrum");
	public static ItemPaxel itemSteelPaxel = new ItemPaxel("steel_paxel", MATERIAL_STEEL, "ingotSteel");
	public static ItemPaxel itemPlatinumPaxel = new ItemPaxel("platinum_paxel", MATERIAL_PLATINUM, "ingotPlatinum");

	public static final ToolMaterial MATERIAL_FLINT = EnumHelper.addToolMaterial("PT:FLINT", 1, 157, 3.8F, 1.0F, 10);
	public static ItemModSword itemFlintSword = new ItemModSword("flint_sword", MATERIAL_FLINT);
	public static ItemModPickaxe itemFlintPickaxe = new ItemModPickaxe("flint_pickaxe", MATERIAL_FLINT);
	public static ItemModShovel itemFlintShovel = new ItemModShovel("flint_shovel", MATERIAL_FLINT);
	public static ItemModAxe itemFlintAxe = new ItemModAxe("flint_axe", MATERIAL_FLINT);
	public static ItemModHoe itemFlintHoe = new ItemModHoe("flint_hoe", MATERIAL_FLINT);
	public static ItemModShears itemFlintShears = new ItemModShears("flint_shears", MATERIAL_FLINT);
	public static ItemPaxel itemFlintPaxel = new ItemPaxel("flint_paxel", MATERIAL_FLINT);

	public static ItemCoin itemCoin = new ItemCoin();
	public static ItemPPM4 itemPPM4 = new ItemPPM4();
	
	public static ItemModSword itemCopperSword = new ItemModSword("copper_sword", MATERIAL_COPPER, "ingotCopper");
	public static ItemModPickaxe itemCopperPickaxe = new ItemModPickaxe("copper_pickaxe", MATERIAL_COPPER, "ingotCopper");
	public static ItemModShovel itemCopperShovel = new ItemModShovel("copper_shovel", MATERIAL_COPPER, "ingotCopper");
	public static ItemModAxe itemCopperAxe = new ItemModAxe("copper_axe", MATERIAL_COPPER, "ingotCopper");
	public static ItemModHoe itemCopperHoe = new ItemModHoe("copper_hoe", MATERIAL_COPPER, "ingotCopper");
	public static ItemModSword itemBronzeSword = new ItemModSword("bronze_sword", MATERIAL_BRONZE, "ingotBronze");
	public static ItemModPickaxe itemBronzePickaxe = new ItemModPickaxe("bronze_pickaxe", MATERIAL_BRONZE, "ingotBronze");
	public static ItemModShovel itemBronzeShovel = new ItemModShovel("bronze_shovel", MATERIAL_BRONZE, "ingotBronze");
	public static ItemModAxe itemBronzeAxe = new ItemModAxe("bronze_axe", MATERIAL_BRONZE, "ingotBronze");
	public static ItemModHoe itemBronzeHoe = new ItemModHoe("bronze_hoe", MATERIAL_BRONZE, "ingotBronze");

	public static void init() {
		final ModRegistry registry = PickleTweaks.REGISTRY;

		registry.register(itemCoalPiece, "coal_piece");
		registry.register(itemDiamondApple, "diamond_apple");
		registry.register(itemEmeraldApple, "emerald_apple");
		registry.register(itemWateringCan, "watering_can");
		registry.register(itemHammer, "hammer");
		registry.register(itemGrassFiber, "grass_fiber");
		registry.register(itemGrassFiberMesh, "grass_mesh");
		registry.register(itemMesh, "mesh");
		registry.register(itemReinforcedMesh, "reinforced_mesh");
		registry.register(itemMagnet, "magnet");
		registry.register(itemNightvisionGoggles, "nightvision_goggles");
		registry.register(itemNightVisionGogglesC, "nightvision_goggles_c");
		registry.register(itemMortarAndPestle, "mortar_and_pestle");
		registry.register(itemDyePowder, "dye_powder");
		registry.register(itemRepairKit, "repair_kit");
		registry.register(itemRepairKitCustom, "repair_kit_custom");
		//registry.register(itemReinforcement, "reinforcement");

		registry.register(itemWoodenPaxel, "wooden_paxel", new ItemStack(Blocks.PLANKS, 1, OreDictionary.WILDCARD_VALUE));
		registry.register(itemStonePaxel, "stone_paxel", new ItemStack(Blocks.COBBLESTONE));
		registry.register(itemIronPaxel, "iron_paxel", new ItemStack(Items.IRON_INGOT));
		registry.register(itemGoldenPaxel, "golden_paxel", new ItemStack(Items.GOLD_INGOT));
		registry.register(itemDiamondPaxel, "diamond_paxel", new ItemStack(Items.DIAMOND));

		if (ModConfig.confModSupportPaxels) {
			registry.register(itemAluminumPaxel, "aluminum_paxel");
			registry.register(itemCopperPaxel, "copper_paxel");
			registry.register(itemTinPaxel, "tin_paxel");
			registry.register(itemBronzePaxel, "bronze_paxel");
			registry.register(itemLeadPaxel, "lead_paxel");
			registry.register(itemSilverPaxel, "silver_paxel");
			registry.register(itemNickelPaxel, "nickel_paxel");
			registry.register(itemInvarPaxel, "invar_paxel");
			registry.register(itemConstantanPaxel, "constantan_paxel");
			registry.register(itemElectrumPaxel, "electrum_paxel");
			registry.register(itemSteelPaxel, "steel_paxel");
			registry.register(itemPlatinumPaxel, "platinum_paxel");
		}

		if (ModConfig.confFlintTools) {
			registry.register(itemFlintSword, "flint_sword", new ItemStack(Items.FLINT));
			registry.register(itemFlintPickaxe, "flint_pickaxe", new ItemStack(Items.FLINT));
			registry.register(itemFlintShovel, "flint_shovel", new ItemStack(Items.FLINT));
			registry.register(itemFlintAxe, "flint_axe", new ItemStack(Items.FLINT));
			registry.register(itemFlintHoe, "flint_hoe", new ItemStack(Items.FLINT));
			registry.register(itemFlintPaxel, "flint_paxel", new ItemStack(Items.FLINT));
			registry.register(itemFlintShears, "flint_shears", new ItemStack(Items.FLINT));
		}

		registry.register(itemCoin, "coin");
		registry.register(itemPPM4, "ppm4");
		
		if (ModConfig.confPPM4) {
			registry.register(itemCopperSword, "copper_sword");
			registry.register(itemCopperPickaxe, "copper_pickaxe");
			registry.register(itemCopperShovel, "copper_shovel");
			registry.register(itemCopperAxe, "copper_axe");
			registry.register(itemCopperHoe, "copper_hoe");
			registry.register(itemBronzeSword, "bronze_sword");
			registry.register(itemBronzePickaxe, "bronze_pickaxe");
			registry.register(itemBronzeShovel, "bronze_shovel");
			registry.register(itemBronzeAxe, "bronze_axe");
			registry.register(itemBronzeHoe, "bronze_hoe");
		}
	}
}
