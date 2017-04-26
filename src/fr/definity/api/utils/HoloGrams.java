package fr.definity.api.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import fr.definity.api.API;

public class HoloGrams {
	
public static void setHologram(String name, Player player){
		
		ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
		
		as.setVisible(false);
		as.setGravity(false);
		as.setMarker(true);
		as.setRemoveWhenFarAway(false);
		as.setSmall(true);
		as.setCustomNameVisible(true);
		as.setCustomName(name);
	}
	
public static void setHologramLocation(String name, Location location){
		
		ArmorStand as = (ArmorStand) Bukkit.getWorlds().get(0).spawnEntity(location, EntityType.ARMOR_STAND);
		
		as.setVisible(false);
		as.setGravity(false);
		as.setMarker(true);
		as.setRemoveWhenFarAway(false);
		as.setSmall(true);
		as.setCustomNameVisible(true);
		as.setCustomName(name);
	}
	
	/**
	 * @param Name = Nom d l'holograme
	 * @param PlayerUtils = recuperer sa location
	 * @param delay = Temps pour le remove
	 */
	public static void setHologramDelay(String name, Player player, long delay){
	
		final ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
		
		as.setVisible(false);
		as.setGravity(false);
		as.setMarker(true);
		as.setRemoveWhenFarAway(false);
		as.setSmall(true);
		as.setCustomNameVisible(true);
		as.setCustomName(name);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(API.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				as.remove();				
			}
		}, delay);
	}
}