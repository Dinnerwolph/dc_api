package fr.definity.api.listeners.player;

import fr.definity.api.API;
import fr.definity.api.database.tables.PlayerInfo;
import fr.definity.api.player.DefinityPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Dinnerwolph
 */

public class Join implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(!(new PlayerInfo().contains(player.getUniqueId()))) {

        }
        DefinityPlayer definityPlayer = new DefinityPlayer(player);
        API.getInstance().addDefinityPlayer(definityPlayer);
    }
}