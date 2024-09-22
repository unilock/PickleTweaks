package com.blakebr0.pickletweaks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.blakebr0.cucumber.helper.CompoundTagHelper;
import com.blakebr0.cucumber.helper.NBTHelper;
import com.blakebr0.cucumber.registry.ModRegistry;
import com.blakebr0.pickletweaks.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION, dependencies = PickleTweaks.DEPENDENCIES, guiFactory = PickleTweaks.GUI_FACTORY)
public class PickleTweaks {

	public static final String DEPENDENCIES = "required-after:cucumber@[1.1.1,)";
	public static final String GUI_FACTORY = "com.blakebr0.pickletweaks.config.GuiFactory";

	public static final CreativeTabs CREATIVE_TAB = new PTCreativeTab(Tags.MOD_ID);
	public static final ModRegistry REGISTRY = ModRegistry.create(Tags.MOD_ID);
	public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_ID);
	public static final CompoundTagHelper TAG_HELPER = NBTHelper.newCompoundTagHelper(Tags.MOD_ID);
	
	@Instance(Tags.MOD_ID)
	public static PickleTweaks instance = new PickleTweaks();

	@SidedProxy(clientSide = "com.blakebr0.pickletweaks.proxy.ClientProxy", 
			    serverSide = "com.blakebr0.pickletweaks.proxy.ServerProxy")
	public static CommonProxy proxy;


	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

}
