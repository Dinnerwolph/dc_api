package fr.definity.api.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;

/**
 * @author Dinnerwolph
 */

public class Nick {

    public Nick(Player player, String name) {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, entityPlayer);
        entityPlayer.playerConnection.sendPacket(packet);
        ProfileLoader profileLoader = new ProfileLoader(player.getUniqueId(), name);
        GameProfile gameProfile = profileLoader.loadProfile();
        setField(entityPlayer, "bH", gameProfile);
        packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, entityPlayer);
        entityPlayer.playerConnection.sendPacket(packet);
    }

    private static void setField(Object edit, String fieldName, Object value) {
        try {
            Field field = edit.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(edit, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private class ProfileLoader {
        private final String uuid;
        private final String name;

        public ProfileLoader(UUID uuid, String name) {
            this.uuid = uuid.toString() == null ? null : uuid.toString().replace("-", "");
            String displayName = ChatColor.translateAlternateColorCodes('&', name);
            this.name = ChatColor.stripColor(displayName);
        }

        public GameProfile loadProfile() {
            UUID id = uuid == null ? parseUUID(getUUID(name)) : parseUUID(uuid);
            GameProfile profile = new GameProfile(id, name);
            addProperties(profile);
            return profile;
        }

        private void addProperties(GameProfile profile) {
            String uuid = getUUID(name);
            try {
                // Get the name from SwordPVP
                URL url = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid + "?unsigned=false");
                URLConnection uc = url.openConnection();
                uc.setUseCaches(false);
                uc.setDefaultUseCaches(false);
                uc.addRequestProperty("User-Agent", "Mozilla/5.0");
                uc.addRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
                uc.addRequestProperty("Pragma", "no-cache");

                // Parse it
                String json = new Scanner(uc.getInputStream(), "UTF-8").useDelimiter("\\A").next();
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(json);
                JSONArray properties = (JSONArray) ((JSONObject) obj).get("properties");
                for (int i = 0; i < properties.size(); i++) {
                    try {
                        JSONObject property = (JSONObject) properties.get(i);
                        String name = (String) property.get("name");
                        String value = (String) property.get("value");
                        String signature = property.containsKey("signature") ? (String) property.get("signature") : null;
                        if (signature != null) {
                            profile.getProperties().put(name, new Property(name, value, signature));
                        } else {
                            profile.getProperties().put(name, new Property(value, name));
                        }
                    } catch (Exception e) {
                        Bukkit.getLogger().log(Level.WARNING, "Failed to apply auth property", e);
                    }
                }
            } catch (Exception e) {
                ; // Failed to load skin
            }
        }

        @SuppressWarnings("deprecation")
        private String getUUID(String name) {
            return Bukkit.getOfflinePlayer(name).getUniqueId().toString().replaceAll("-", "");
        }

        private UUID parseUUID(String uuidStr) {
            // Split uuid in to 5 components
            String[] uuidComponents = new String[]{uuidStr.substring(0, 8),
                    uuidStr.substring(8, 12), uuidStr.substring(12, 16),
                    uuidStr.substring(16, 20),
                    uuidStr.substring(20, uuidStr.length())
            };

            // Combine components with a dash
            StringBuilder builder = new StringBuilder();
            for (String component : uuidComponents) {
                builder.append(component).append('-');
            }

            // Correct uuid length, remove last dash
            builder.setLength(builder.length() - 1);
            return UUID.fromString(builder.toString());
        }
    }
}
