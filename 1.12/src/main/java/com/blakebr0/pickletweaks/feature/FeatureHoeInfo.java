package com.blakebr0.pickletweaks.feature;

import java.util.ListIterator;

import org.lwjgl.input.Keyboard;

import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.pickletweaks.PickleTweaks;
import com.blakebr0.pickletweaks.config.ModConfig;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FeatureHoeInfo {
	
    //@SubscribeEvent
    public void onRightClickBlock(UseHoeEvent event){
		if (!ModConfig.confHoeInfoTooltip) { return; }
		if (event.getEntityPlayer() == null) { return; }
    	
    	ItemStack stack = event.getEntityPlayer().getHeldItemMainhand();
    	if (stack == null){ return; }
    	    	
    	if (stack.getItem() instanceof ItemHoe) {
    		NBTTagCompound tag = stack.getOrCreateSubCompound(PickleTweaks.MOD_ID);
    		if (!((tag.getInteger("BlocksTilled") + 1) >= Integer.MAX_VALUE)) {
    			tag.setInteger("BlocksTilled", tag.getInteger("BlocksTilled") + 1);
    		}
    	}
    }

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void addToolInfoTooltip(ItemTooltipEvent event) {
		if (!ModConfig.confHoeInfoTooltip) { return; }
        if (event.getEntityPlayer() == null) { return; }
        
        ItemStack stack = event.getItemStack();
        ListIterator<String> tooltip = event.getToolTip().listIterator();
        
        if (stack.getItem() instanceof ItemHoe) {
            boolean shift = false;
            if (Keyboard.isCreated()) {
                shift = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
            }
            
            while (tooltip.hasNext()) {
            	tooltip.next();
            	if (shift) {
            		tooltip.add(Utils.localize("tooltip.pt.durability") + " " + getDurability(stack));
            		//tooltip.add(Utils.localize("tooltip.pt.blocks_tilled") + " " + getBlocksTilled(stack));
            	} else {
            		tooltip.add(Utils.localize("tooltip.pt.hold_shift_for_info"));
            	}
            	break;
            }
        }
	}
	
	public String getDurability(ItemStack stack) {
		if (stack.getMaxDamage() == -1) {
			return Utils.localize("tooltip.pt.unbreakable");
		}
		int durability = stack.getMaxDamage() - stack.getItemDamage();
		return durability + Colors.GRAY + "/" + Colors.WHITE + stack.getMaxDamage();
	}
	
	public int getBlocksTilled(ItemStack stack) {
		NBTTagCompound tag = stack.getOrCreateSubCompound(PickleTweaks.MOD_ID);
		if (tag.hasKey("BlocksTilled")) {
			if ((tag.getInteger("BlocksTilled") + 1) >= Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			return tag.getInteger("BlocksTilled");
		}
		return 0;
	}
}