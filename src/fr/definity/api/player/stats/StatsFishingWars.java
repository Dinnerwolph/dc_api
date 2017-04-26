package fr.definity.api.player.stats;

/**
 * @author Dinnerwolph
 */
public class StatsFishingWars {

    private int kills;
    private int wins;
    private int loses;
    private int smallFish;
    private int bigFish;
    private int games;

    public StatsFishingWars(int kills, int wins, int loses, int smallFish, int bigFish, int games) {
        this.kills = kills;
        this.wins = wins;
        this.loses = loses;
        this.smallFish = smallFish;
        this.bigFish = bigFish;
        this.games = games;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
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

    public int getSmallFish() {
        return smallFish;
    }

    public void setSmallFish(int smallFish) {
        this.smallFish = smallFish;
    }

    public int getBigFish() {
        return bigFish;
    }

    public void setBigFish(int bigFish) {
        this.bigFish = bigFish;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }
}
