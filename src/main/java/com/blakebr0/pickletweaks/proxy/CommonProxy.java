package com.blakebr0.pickletweaks.proxy;

import com.blakebr0.pickletweaks.GuiHandler;
import com.blakebr0.pickletweaks.PickleTweaks;
import com.blakebr0.pickletweaks.config.ModConfig;
import com.blakebr0.pickletweaks.feature.*;
import com.blakebr0.pickletweaks.feature.block.BlockColoredCobblestone;
import com.blakebr0.pickletweaks.feature.item.ItemDyePowder;
import com.blakebr0.pickletweaks.feature.item.ItemNightvisionGoggles;
import com.blakebr0.pickletweaks.network.NetworkHandler;
import com.blakebr0.pickletweaks.registry.ModBlocks;
import com.blakebr0.pickletweaks.registry.ModItems;
import com.blakebr0.pickletweaks.registry.ModRecipes;
import com.blakebr0.pickletweaks.tweaks.*;
import com.blakebr0.pickletweaks.tweaks.tools.ToolTweaks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		ModConfig.init(e.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new ModConfig());
		MinecraftForge.EVENT_BUS.register(PickleTweaks.REGISTRY);

		ModBlocks.init();
		ModItems.init();

		MinecraftForge.EVENT_BUS.register(new ItemNightvisionGoggles.Handler());
		MinecraftForge.EVENT_BUS.register(new ItemDyePowder.Handler());

		MinecraftForge.EVENT_BUS.register(new FeatureToolInfo());
		MinecraftForge.EVENT_BUS.register(new FeatureSwordInfo());
		MinecraftForge.EVENT_BUS.register(new FeatureHoeInfo());
		MinecraftForge.EVENT_BUS.register(new FeatureBowInfo());

		MinecraftForge.EVENT_BUS.register(new FeatureRightClickHarvest());

		MinecraftForge.EVENT_BUS.register(new TweakToolBreaking());
		//if (ModConfig.confReinforcement) MinecraftForge.EVENT_BUS.register(new ReinforcementHandler());
	}

	public void init(FMLInitializationEvent e) {
		ModRecipes.init();
		FMLInterModComms.sendMessage("waila", "register", "com.blakebr0.pickletweaks.feature.FeatureWailaTooltips.callbackRegister");
		NetworkRegistry.INSTANCE.registerGuiHandler(PickleTweaks.instance, new GuiHandler());
		NetworkHandler.init();

		if (ModConfig.confSharpeningKits && Loader.isModLoaded("tconstruct")) {
			MinecraftForge.EVENT_BUS.register(new TweakSharpeningKit());
		}
		
		BlockColoredCobblestone.addToChisel();
	}

	public void postInit(FMLPostInitializationEvent e) {
		ModConfig.postInit();
		ModRecipes.postInit();

		ToolTweaks.findToolsFromConfig();

		MinecraftForge.EVENT_BUS.register(new TweakFlintDrop());
		MinecraftForge.EVENT_BUS.register(new TweakToolUselessifier());
		MinecraftForge.EVENT_BUS.register(new TweakHoeUselessifier());
		MinecraftForge.EVENT_BUS.register(new TweakWeaponUselessifier());
	}
}
