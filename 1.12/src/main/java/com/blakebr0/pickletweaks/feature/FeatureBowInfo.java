package com.blakebr0.pickletweaks.feature;

import java.util.ListIterator;

import org.lwjgl.input.Keyboard;

import com.blakebr0.cucumber.helper.StackHelper;
import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.pickletweaks.PickleTweaks;
import com.blakebr0.pickletweaks.config.ModConfig;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FeatureBowInfo {

	@SubscribeEvent
	public void onEntityKilled(LivingDeathEvent event) {
		if (!ModConfig.confBowInfoTooltip) { return; }
		DamageSource source = event.getSource();
		Entity entity = source.getTrueSource();
		if (entity != null && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack stack = player.getHeldItemMainhand();
			if (!StackHelper.isNull(stack) && stack.getItem() != null) {
				if (stack.getItem() instanceof ItemBow) {
					NBTTagCompound tag = stack.getOrCreateSubCompound(PickleTweaks.MOD_ID);
					if (!((tag.getInteger("EnemiesKilled") + 1) >= Integer.MAX_VALUE)) {
						tag.setInteger("EnemiesKilled", tag.getInteger("EnemiesKilled") + 1);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityDamaged(LivingHurtEvent event) {
		if (!ModConfig.confBowInfoTooltip) { return; }
		DamageSource source = event.getSource();
		Entity entity = source.getTrueSource();
		if (entity != null && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack stack = player.getHeldItemMainhand();
			if (!StackHelper.isNull(stack) && stack.getItem() != null) {
				if (stack.getItem() instanceof ItemBow) {
					NBTTagCompound tag = stack.getOrCreateSubCompound(PickleTweaks.MOD_ID);
					if (!((tag.getInteger("DamageDealt") + event.getAmount()) >= Integer.MAX_VALUE)) {
						EntityLivingBase living = event.getEntityLiving();
						if (living.getHealth() < event.getAmount()) {
							tag.setInteger("DamageDealt", tag.getInteger("DamageDealt") + (int) living.getHealth());
						} else {
							tag.setInteger("DamageDealt", tag.getInteger("DamageDealt") + (int) event.getAmount());
						}
					}
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void addSwordInfoTooltip(ItemTooltipEvent event) {
		if (!ModConfig.confBowInfoTooltip) { return; }
		if (event.getEntityPlayer() == null) { return; }

		ItemStack stack = event.getItemStack();
		ListIterator<String> tooltip = event.getToolTip().listIterator();

		if (stack.getItem() instanceof ItemBow) {
			boolean shift = false;
			if (Keyboard.isCreated()) {
				shift = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
			}

			while (tooltip.hasNext()) {
				tooltip.next();
				if (shift) {
					tooltip.add(Utils.localize("tooltip.pt.durability") + " " + getDurability(stack));
					tooltip.add(Utils.localize("tooltip.pt.ammo") + " " + getAmmo(event.getEntityPlayer()));
					tooltip.add(Utils.localize("tooltip.pt.enemies_killed") + " " + getEnemiesKilled(stack));
					tooltip.add(Utils.localize("tooltip.pt.damage_dealt") + " " + getDamageDealt(stack));
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
	
	public int getAmmo(EntityPlayer player) {
		int ammo = 0;
		ItemStack offHand = player.inventory.offHandInventory.get(0);
		if (offHand.getItem() instanceof ItemArrow) {
			ammo += offHand.getCount(); 
		}
		for (ItemStack stack : player.inventory.mainInventory) {
			if (stack.getItem() instanceof ItemArrow) {
				ammo += stack.getCount();
			}
		}
		return ammo;
	}

	public int getEnemiesKilled(ItemStack stack) {
		NBTTagCompound tag = stack.getOrCreateSubCompound(PickleTweaks.MOD_ID);
		if (tag.hasKey("EnemiesKilled")) {
			if ((tag.getInteger("EnemiesKilled") + 1) >= Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			return tag.getInteger("EnemiesKilled");
		}
		return 0;
	}

	public int getDamageDealt(ItemStack stack) {
		NBTTagCompound tag = stack.getOrCreateSubCompound(PickleTweaks.MOD_ID);
		if (tag.hasKey("DamageDealt")) {
			if ((tag.getInteger("DamageDealt") + 1) >= Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			return tag.getInteger("DamageDealt");
		}
		return 0;
	}
}
