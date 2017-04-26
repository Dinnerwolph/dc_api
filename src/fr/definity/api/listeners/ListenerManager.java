package fr.definity.api.listeners;

import fr.definity.api.API;
import fr.definity.api.listeners.player.Join;
import fr.definity.api.listeners.player.Quit;
import org.bukkit.plugin.PluginManager;

/**
 * @author Dinnerwolph
 */

public class ListenerManager {

    private API plugin = API.getInstance();
    private PluginManager manager = plugin.getServer().getPluginManager();

    public ListenerManager() {
        // player
        manager.registerEvents(new Join(), plugin);
        manager.registerEvents(new Quit(), plugin);
    }
}
