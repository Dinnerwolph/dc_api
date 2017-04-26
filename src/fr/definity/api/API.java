package fr.definity.api;

import fr.definity.api.commands.CommandLag;
import fr.definity.api.commands.Nick;
import fr.definity.api.database.ConnectionDriver;
import fr.definity.api.database.tables.Group;
import fr.definity.api.groups.Groups;
import fr.definity.api.listeners.ListenerManager;
import fr.definity.api.player.DefinityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class API extends JavaPlugin {

    private static API instance;
    private static Map<UUID, DefinityPlayer> definityPlayer = new HashMap();
    private Map<Integer, Groups> groups = new HashMap();

    public void onEnable() {
        instance = this;
        new ListenerManager();
        getCommand("lag").setExecutor(new CommandLag());
        getCommand("nick").setExecutor(new Nick());
        ConnectionDriver.openConnection();
        new Group().getAllGroups();
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    public void onDisable() {
        ConnectionDriver.closeConnection();
    }

    public static API getInstance() {
        return instance;
    }

    public static DefinityPlayer getDefinityPlayer(Player player) {
        return definityPlayer.get(player.getUniqueId());
    }

    public static DefinityPlayer getDefinityPlayer(UUID uuid) {
        return definityPlayer.get(uuid);
    }

    public void addDefinityPlayer(DefinityPlayer definityPlayer) {
        API.definityPlayer.put(definityPlayer.uuid, definityPlayer);
    }

    public void removeDefinityPlayer(DefinityPlayer definityPlayer) {
        API.definityPlayer.remove(definityPlayer.uuid);
    }

    public void removeDefinityPlayer(Player player) {
        API.definityPlayer.remove(player.getUniqueId());
    }

    public void removeDefinityPlayer(UUID uuid) {
        API.definityPlayer.remove(uuid);
    }

    public void addGroups(Groups groups) {
        this.groups.put(groups.getLadder(), groups);
    }

    public Groups getGroups(int groupId) {
        return groups.get(groupId);
    }
}
