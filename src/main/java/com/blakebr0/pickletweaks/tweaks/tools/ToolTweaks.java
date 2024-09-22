package com.blakebr0.pickletweaks.tweaks.tools;

import java.util.HashSet;
import java.util.Set;

import com.blakebr0.pickletweaks.config.ModConfig;

import net.minecraft.item.Item;

public class ToolTweaks {
	
	public static Set<Item> uselessTools = new HashSet<>();
	public static Set<Item> uselessHoes = new HashSet<>();
	public static Set<Item> uselessWeapons = new HashSet<>();
	
    public static void findToolsFromConfig() {
    	
    	for (String identifier : ModConfig.confUselessTools) {
            Item item = Item.getByNameOrId(identifier);
            uselessTools.add(item);
    	}
    	
    	for (String identifier : ModConfig.confUselessHoes) { 
            Item item = Item.getByNameOrId(identifier);
            uselessHoes.add(item);
    	}
    	
    	for (String identifier : ModConfig.confUselessWeapons) {
            Item item = Item.getByNameOrId(identifier);
            uselessWeapons.add(item);
		}
	}
}
