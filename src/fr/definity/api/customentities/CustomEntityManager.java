package fr.definity.api.customentities;

import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.event.entity.CreatureSpawnEvent;

/**
 * @author Dinnerwolph
 */
 
public class CustomEntityManager {
 
    public static void make(EntityLiving nmsEntity, Location Location) {
        Location location = Location;
        World nmsWorld = ((CraftWorld) location.getWorld()).getHandle();
        nmsEntity.setPosition(location.getX(), location.getY() + 0.3, location.getZ());
        System.out.println(nmsEntity);
        nmsWorld.addEntity(nmsEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }
}