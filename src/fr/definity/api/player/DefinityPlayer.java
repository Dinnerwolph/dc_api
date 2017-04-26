package fr.definity.api.player;

import at.TimoCraft.TimoCloud.api.TimoCloudAPI;
import at.TimoCraft.TimoCloud.api.TimoCloudBukkitAPI;
import fr.definity.api.API;
import fr.definity.api.database.ServerTypes;
import fr.definity.api.database.tables.PlayerInfo;
import fr.definity.api.database.tables.PlayerStats;
import fr.definity.api.player.stats.StatsBombArming;
import fr.definity.api.player.stats.StatsFishingWars;
import fr.definity.api.player.stats.StatsTheBlock;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author Dinnerwolph
 */

public class DefinityPlayer {

    private Player player;
    public UUID uuid;
    private int definityId;
    public int groupId;
    public final int realGroup;
    private int xp;
    private int coins;
    private int ors;
    private PlayerInfo playerInfo = new PlayerInfo();
    private PlayerStats playerStats = new PlayerStats();
    private StatsFishingWars statsFishingWars;
    private StatsBombArming statsBombArming;
    private StatsTheBlock statsTheBlock;
    public final String realName;
    private String nickName;


    public DefinityPlayer(Player player) {
        this.player = player;
        realName = player.getName();
        uuid = player.getUniqueId();
        if (!playerInfo.contains(uuid))
            playerInfo.create(player);
        definityId = playerInfo.getDefinityId(uuid);
        groupId = playerInfo.getGroupId(definityId);
        realGroup = groupId;
        xp = playerInfo.getXp(definityId);
        coins = playerInfo.getCoins(definityId);
        ors = playerInfo.getOrs(definityId);
        statsFishingWars = new StatsFishingWars(playerStats.getStatsKill(definityId, ServerTypes.FISHING_WARS), playerStats.getStatsWins(definityId, ServerTypes.FISHING_WARS),
                playerStats.getStatsLoses(definityId, ServerTypes.FISHING_WARS), playerStats.getFishingWarsSmallFish(definityId), playerStats.getFishingWarsBigFish(definityId),
                playerStats.getStatsGames(definityId, ServerTypes.FISHING_WARS));
        statsTheBlock = new StatsTheBlock(playerStats.getStatsKill(definityId, ServerTypes.THEBLOCK), playerStats.getStatsDeaths(definityId, ServerTypes.THEBLOCK), playerStats.getStatsWins(definityId, ServerTypes.THEBLOCK),
                playerStats.getStatsLoses(definityId, ServerTypes.THEBLOCK), playerStats.getTheBlockBlocks(definityId), playerStats.getTheBlockFinalsKills(definityId),
                playerStats.getStatsGames(definityId, ServerTypes.THEBLOCK));
        statsBombArming = new StatsBombArming(playerStats.getStatsKill(definityId, ServerTypes.BOMBE_ARMING),
                playerStats.getStatsDeaths(definityId, ServerTypes.BOMBE_ARMING), playerStats.getStatsWins(definityId, ServerTypes.BOMBE_ARMING),
                playerStats.getStatsLoses(definityId, ServerTypes.BOMBE_ARMING), playerStats.getBombeArmingBombArmed(definityId),
                playerStats.getBombeArmingBombDefused(definityId), playerStats.getBombeArmingBombEquipeElimine(definityId),
                playerStats.getStatsGames(definityId, ServerTypes.BOMBE_ARMING));
        this.nickName = playerInfo.getNickName(definityId);
        if (hasNickName()) {
            setNickName(nickName);
            player.setDisplayName(nickName);
        } else {
            groupId = playerInfo.getGroupId(definityId);
        }
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
        playerInfo.setGroupId(definityId, groupId);
    }

    public int getDefinityId() {
        return definityId;
    }


    public Integer getCoins() {
        return coins;
    }

    public void addCoins(int amount) {
        coins = coins + amount;
    }

    public Integer getOrs() {
        return ors;
    }

    public void addOrs(int amount) {
        ors = ors + amount;
    }

    public Integer getXp() {
        return xp;
    }

    public void addXp(int amount) {
        xp = xp + amount;
    }

    public Integer getLevel() {
        return xp / 500;
    }

    public void sendToRandomLobby() {
        TimoCloudBukkitAPI timoCloudBukkitAPI = TimoCloudAPI.getBukkitInstance();
        List<String> list = timoCloudBukkitAPI.getOnlineServersByGroup("Lobby");
        list = timoCloudBukkitAPI.getOnlineServersByGroup("Lobby");
        list = timoCloudBukkitAPI.getOnlineServersByGroup("Lobby");
        list = timoCloudBukkitAPI.getOnlineServersByGroup("Lobby");
        list = timoCloudBukkitAPI.getOnlineServersByGroup("Lobby");
        list = timoCloudBukkitAPI.getOnlineServersByGroup("Lobby");
        list = timoCloudBukkitAPI.getOnlineServersByGroup("Lobby");
        list = timoCloudBukkitAPI.getOnlineServersByGroup("Lobby");
        list = timoCloudBukkitAPI.getOnlineServersByGroup("Lobby");
        Random random = new Random();
        int i = random.nextInt(list.size());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        if (i == 0)
            i = 1;
        try {
            out.writeUTF("Connect");
            out.writeUTF("Lobby-" + i);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(API.getInstance(), "BungeeCord", b.toByteArray());
    }

    public Integer getStatsFishingWarsKills() {
        return statsFishingWars.getKills();
    }

    public void setStatsFishingWarsKills(int kills) {
        statsFishingWars.setKills(kills);
    }

    public void addStatsFishingWarsKills(int kills) {
        statsFishingWars.setKills(getStatsFishingWarsKills() + kills);
    }

    public Integer getStatsFishingWarsWins() {
        return statsFishingWars.getWins();
    }

    public void setStatsFishingWarsWins(int wins) {
        statsFishingWars.setWins(wins);
    }

    public void addStatsFishingWarsWins(int wins) {
        statsFishingWars.setWins(getStatsFishingWarsWins() + wins);
    }

    public Integer getStatsFishingWarsLoses() {
        return statsFishingWars.getLoses();
    }

    public void setStatsFishingWarsLoses(int loses) {
        statsFishingWars.setLoses(loses);
    }

    public void addStatsFishingWarsLoses(int loses) {
        statsFishingWars.setLoses(getStatsFishingWarsLoses() + loses);
    }

    public Integer getStatsFishingWarsSmallFish() {
        return statsFishingWars.getSmallFish();
    }

    public void setStatsFishingWarsSmallFish(int smallFish) {
        statsFishingWars.setSmallFish(smallFish);
    }

    public void addStatsFishingWarsSmallFish(int smallFish) {
        statsFishingWars.setSmallFish(getStatsFishingWarsSmallFish() + smallFish);
    }

    public Integer getStatsFishingWarsBigFish() {
        return statsFishingWars.getBigFish();
    }

    public void setStatsFishingWarsBigFish(int bigFish) {
        statsFishingWars.setBigFish(bigFish);
    }

    public void addStatsFishingWarsBigFish(int bigFish) {
        statsFishingWars.setBigFish(getStatsFishingWarsBigFish() + bigFish);
    }

    public Integer getStatsFishingWarsGames() {
        return statsFishingWars.getGames();
    }

    public void setStatsFishingWarsGames(int games) {
        statsFishingWars.setGames(games);
    }

    public void addStatsFishingWarsGames(int games) {
        statsFishingWars.setGames(getStatsFishingWarsGames() + games);
    }

    public Integer getStatsBombArmingKills() {
        return statsBombArming.getKills();
    }

    public void setStatsBombArmingKills(int kills) {
        statsBombArming.setKills(kills);
    }

    public void addStatsBombArmingKills(int kills) {
        statsBombArming.setKills(getStatsBombArmingKills() + kills);
    }

    public Integer getStatsBombArmingDeaths() {
        return statsBombArming.getDeaths();
    }

    public void setStatsBombArmingDeaths(int deaths) {
        statsBombArming.setDeaths(deaths);
    }

    public void addStatsBombArmingDeaths(int deaths) {
        statsBombArming.setDeaths(getStatsBombArmingDeaths() + deaths);
    }

    public Integer getStatsBombArmingWins() {
        return statsBombArming.getWins();
    }

    public void setStatsBombArmingWins(int wins) {
        statsBombArming.setWins(wins);
    }

    public void addStatsBombArmingWins(int wins) {
        statsBombArming.setWins(getStatsBombArmingWins() + wins);
    }

    public Integer getStatsBombArmingLoses() {
        return statsBombArming.getLoses();
    }

    public void setStatsBombArmingLoses(int loses) {
        statsBombArming.setLoses(loses);
    }

    public void addStatsBombArmingLoses(int loses) {
        statsBombArming.setLoses(getStatsBombArmingLoses() + loses);
    }

    public Integer getStatsBombArmingBombArmed() {
        return statsBombArming.getBombArmed();
    }

    public void setStatsBombArmingBombArmed(int bombArmed) {
        statsBombArming.setBombArmed(bombArmed);
    }

    public void addStatsBombArmingBombArmed(int bombArmed) {
        statsBombArming.setBombArmed(getStatsBombArmingBombArmed() + bombArmed);
    }

    public Integer getStatsBombArmingBombDefused() {
        return statsBombArming.getBombDefused();
    }

    public void setStatsBombArmingBombDefused(int bombDefused) {
        statsBombArming.setBombDefused(bombDefused);
    }

    public void addStatsBombArmingBombDefused(int bombDefused) {
        statsBombArming.setBombDefused(getStatsBombArmingBombDefused() + bombDefused);
    }

    public Integer getStatsBombArmingEquipeElimine() {
        return statsBombArming.getEquipeElimine();
    }

    public void setStatsBombArmingEquipeElimine(int equipeElimine) {
        statsBombArming.setEquipeElimine(equipeElimine);
    }

    public void addStatsBombArmingEquipeElimine(int equipeElimine) {
        statsBombArming.setEquipeElimine(getStatsBombArmingEquipeElimine() + equipeElimine);
    }

    public Integer getStatsBombArmingGames() {
        return statsBombArming.getGames();
    }

    public void setStatsBombArmingGames(int games) {
        statsTheBlock.setGames(games);
    }

    public void addStatsBombArmingGames(int games) {
        statsTheBlock.setGames(getStatsTheBlockGames() + games);
    }

    public Integer getStatsTheBlockKills() {
        return statsTheBlock.getKills();
    }

    public void setStatsTheBlockKills(int kills) {
        statsTheBlock.setKills(kills);
    }

    public void addStatsTheBlockKills(int kill) {
        statsTheBlock.setGames(getStatsTheBlockKills() + kill);
    }

    public Integer getStatsTheBlockDeaths() {
        return statsTheBlock.getDeaths();
    }

    public void setStatsTheBlockDeaths(int deaths) {
        statsTheBlock.setDeaths(deaths);
    }

    public void addStatsTheBlockDeaths(int deaths) {
        statsTheBlock.setDeaths(getStatsTheBlockDeaths() + deaths);
    }

    public Integer getStatsTheBlockWins() {
        return statsTheBlock.getWins();
    }

    public void setStatsTheBlockWins(int wins) {
        statsTheBlock.setWins(wins);
    }

    public void addStatsTheBlockWins(int wins) {
        statsTheBlock.setWins(getStatsTheBlockWins() + wins);
    }

    public Integer getStatsTheBlockLoses() {
        return statsTheBlock.getLoses();
    }

    public void setStatsTheBlockLoses(int loses) {
        statsTheBlock.setLoses(loses);
    }

    public void addStatsTheBlockLoses(int loses) {
        statsTheBlock.setLoses(getStatsTheBlockLoses() + loses);
    }

    public Integer getStatsTheBlockBlock() {
        return statsTheBlock.getBlock();
    }

    public void setStatsTheBlockBlock(int block) {
        statsTheBlock.setBlock(block);
    }

    public void addStatsTheBlockBlock(int block) {
        statsTheBlock.setBlock(getStatsTheBlockBlock() + block);
    }

    public Integer getStatsTheBlockFinalsKills() {
        return statsTheBlock.getFinalsKills();
    }

    public void setStatsTheBlockFinalsKills(int finalsKills) {
        statsTheBlock.setFinalsKills(finalsKills);
    }

    public void addStatsTheBlockFinalsKills(int finalsKills) {
        statsTheBlock.setFinalsKills(getStatsTheBlockFinalsKills() + finalsKills);
    }

    public Integer getStatsTheBlockGames() {
        return statsTheBlock.getGames();
    }

    public void setStatsTheBlockGames(int games) {
        statsTheBlock.setGames(games);
    }

    public void addStatsTheBlockGames(int games) {
        statsTheBlock.setGames(getStatsTheBlockGames() + games);
    }


    public boolean hasNickName() {
        if (nickName == null || nickName.equalsIgnoreCase("") || nickName.equalsIgnoreCase("null"))
            return false;
        return true;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
        playerInfo.setNickName(definityId, nickName);
        Random random = new Random();
        int i = random.nextInt(15);
        if (i == 0) {
            groupId = 0;
        } else if (i > 0 && i <= 10) {
            groupId = 10;
        } else if (i > 10) {
            groupId = 15;
        }
    }

    public String getNickName() {
        return nickName;
    }
}
