package fr.definity.api.listeners.player;

import at.TimoCraft.TimoCloud.api.TimoCloudAPI;
import at.TimoCraft.TimoCloud.api.TimoCloudBukkitAPI;
import fr.definity.api.API;
import fr.definity.api.database.ServerTypes;
import fr.definity.api.database.tables.PlayerInfo;
import fr.definity.api.database.tables.PlayerStats;
import fr.definity.api.player.DefinityPlayer;
import org.apache.logging.log4j.core.net.Priority;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author Dinnerwolph
 */

public class Quit implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        PlayerInfo playerInfo = new PlayerInfo();
        PlayerStats playerStats = new PlayerStats();
        DefinityPlayer definityPlayer = API.getDefinityPlayer(player);
        int definityID = definityPlayer.getDefinityId();
        TimoCloudBukkitAPI timoCloudAPI = TimoCloudAPI.getBukkitInstance();
        if(timoCloudAPI.getServerName().contains("Lobby") || timoCloudAPI.getServerName().contains("fallback")) return;

        playerInfo.setCoins(definityID, definityPlayer.getCoins());
        playerInfo.setOrs(definityID, definityPlayer.getOrs());
        playerInfo.setXp(definityID, definityPlayer.getXp());

        playerStats.setStatsWins(definityID, ServerTypes.BOMBE_ARMING, definityPlayer.getStatsBombArmingWins());
        playerStats.setStatsWins(definityID, ServerTypes.THEBLOCK, definityPlayer.getStatsTheBlockWins());
        playerStats.setStatsWins(definityID, ServerTypes.FISHING_WARS, definityPlayer.getStatsFishingWarsWins());

        playerStats.setStatsDeaths(definityID, ServerTypes.BOMBE_ARMING, definityPlayer.getStatsBombArmingDeaths());
        playerStats.setStatsDeaths(definityID, ServerTypes.THEBLOCK, definityPlayer.getStatsTheBlockDeaths());

        playerStats.setStatsLoses(definityID, ServerTypes.BOMBE_ARMING, definityPlayer.getStatsBombArmingLoses());
        playerStats.setStatsLoses(definityID, ServerTypes.THEBLOCK, definityPlayer.getStatsTheBlockLoses());
        playerStats.setStatsLoses(definityID, ServerTypes.FISHING_WARS, definityPlayer.getStatsFishingWarsLoses());

        playerStats.setStatsKill(definityID, ServerTypes.BOMBE_ARMING, definityPlayer.getStatsBombArmingKills());
        playerStats.setStatsKill(definityID, ServerTypes.THEBLOCK, definityPlayer.getStatsTheBlockKills());
        playerStats.setStatsKill(definityID, ServerTypes.FISHING_WARS, definityPlayer.getStatsFishingWarsKills());

        playerStats.setStatsGames(definityID, ServerTypes.BOMBE_ARMING, definityPlayer.getStatsBombArmingGames());
        playerStats.setStatsGames(definityID, ServerTypes.THEBLOCK, definityPlayer.getStatsTheBlockGames());
        playerStats.setStatsGames(definityID, ServerTypes.FISHING_WARS, definityPlayer.getStatsFishingWarsGames());

        playerStats.setTheBlockBlocks(definityID, definityPlayer.getStatsTheBlockBlock());
        playerStats.setTheBlockFinalsKills(definityID, definityPlayer.getStatsTheBlockFinalsKills());

        playerStats.setFishingWarsBigFish(definityID, definityPlayer.getStatsFishingWarsBigFish());
        playerStats.setFishingWarsSmallFish(definityID, definityPlayer.getStatsFishingWarsSmallFish());

        playerStats.setBombArmingBombArmed(definityID, definityPlayer.getStatsBombArmingBombArmed());
        playerStats.setBombArmingBombDefused(definityID, definityPlayer.getStatsBombArmingBombDefused());
        playerStats.setBombArmingEquipeElimine(definityID, definityPlayer.getStatsBombArmingEquipeElimine());


        API.getInstance().removeDefinityPlayer(player);
    }
}
