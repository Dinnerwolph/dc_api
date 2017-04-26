package fr.definity.api.commands;

import at.TimoCraft.TimoCloud.api.TimoCloudAPI;
import at.TimoCraft.TimoCloud.api.TimoCloudBukkitAPI;
import com.mojang.authlib.GameProfile;
import fr.definity.api.API;
import fr.definity.api.database.tables.PlayerInfo;
import fr.definity.api.player.DefinityPlayer;
import fr.definity.api.utils.ProfileLoader;
import fr.definity.api.utils.Utils;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author Dinnerwolph
 */

public class Nick implements CommandExecutor {

    private PlayerInfo playerInfo = new PlayerInfo();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof ConsoleCommandSender) return true;
        Player player = (Player) commandSender;
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        DefinityPlayer definityPlayer = API.getDefinityPlayer(player);
        String arg = null;

        if (args.length == 0 || args.length > 1) {
            displayHelp(player);
            return true;
        }
        if (args[0].equalsIgnoreCase("off")) {
            arg = definityPlayer.realName;
        } else {
            arg = args[0];
        }
        if (args[0].length() > 16) {
            player.sendMessage("§cVous devez utilisez un pseudo de 16 charactere maximum !");
            return true;
        }
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[0]);
        if (playerInfo.contains(offlinePlayer.getUniqueId())) {
            player.sendMessage("Ce joueurs s'est déjà connecté sur le serveur, vous ne pouvez pas prendre ce pseudo.");
            return true;
        }

        PacketPlayOutPlayerInfo removePacket = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, entityPlayer);
        try {
            updateSkin(player, arg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PacketPlayOutPlayerInfo addPacket = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, entityPlayer);
        for (Player players : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) players).getHandle().playerConnection.sendPacket(removePacket);
            ((CraftPlayer) players).getHandle().playerConnection.sendPacket(addPacket);
        }
        PacketPlayOutEntityDestroy destroyPacket = new PacketPlayOutEntityDestroy(entityPlayer.getId());
        PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn(entityPlayer);
        for (Player online : Bukkit.getOnlinePlayers()) {
            if (!online.equals(player)) {
                ((CraftPlayer) online).getHandle().playerConnection.sendPacket(destroyPacket);
                ((CraftPlayer) online).getHandle().playerConnection.sendPacket(packet);
            }
        }

        player.setDisplayName(args[0]);
        TimoCloudBukkitAPI fdp = TimoCloudAPI.getBukkitInstance();
        definityPlayer.setNickName(arg);
        if (arg.equalsIgnoreCase(definityPlayer.realName)) {
            playerInfo.setNickName(definityPlayer.getDefinityId(), "null");
            definityPlayer.groupId = playerInfo.getGroupId(definityPlayer.getDefinityId());
            player.setDisplayName(definityPlayer.realName);
        } else {
            playerInfo.setNickName(definityPlayer.getDefinityId(), arg);
        }

        if (fdp.getServerName().contains("Lobby")) {
            Utils.updateRank(player);
        }
        return true;
    }


    private void displayHelp(Player player) {
        player.sendMessage("");
        player.sendMessage("/nick <pseudo> : permet de changer de pseudo");
        player.sendMessage("/nick off : permet de reprendre son pseudo initial");
    }

    private void updateSkin(Player player, String name) throws IOException {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();

        entityPlayer.getStatisticManager().e();
        if (entityPlayer.getChatFlags() == EntityHuman.EnumChatVisibility.HIDDEN) {
            throw new IOException("Player denis skin packets!");
        }
        ProfileLoader profileLoader = new ProfileLoader(player.getUniqueId().toString(), name, name);
        GameProfile gameProfile = profileLoader.loadProfile();
        try {
            Field field = entityPlayer.getClass().getSuperclass().getDeclaredField("bH");
            field.setAccessible(true);
            field.set(entityPlayer, gameProfile);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}