package fr.definity.api.player.stats;

/**
 * @author Dinnerwolph
 */
public class StatsTheBlock {

    private int kills;
    private int deaths;
    private int wins;
    private int loses;
    private int block;
    private int finalsKills;
    private int games;

    public StatsTheBlock(int kills, int deaths, int wins, int loses, int block, int finalsKills, int games) {
        this.kills = kills;
        this.deaths = deaths;
        this.wins = wins;
        this.loses = loses;
        this.block = block;
        this.finalsKills = finalsKills;
        this.games = games;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getFinalsKills() {
        return finalsKills;
    }

    public void setFinalsKills(int finalsKills) {
        this.finalsKills = finalsKills;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }
}
