package fr.definity.api.player.stats;

/**
 * @author Dinnerwolph
 */
public class StatsBombArming {

    private int kills;
    private int deaths;
    private int wins;
    private int loses;
    private int bombArmed;
    private int bombDefused;
    private int equipeElimine;
    private int games;

    public StatsBombArming(int kills, int deaths, int wins, int loses, int bombArmed, int bombDefused, int equipeElimine, int games) {
        this.kills = kills;
        this.deaths = deaths;
        this.wins = wins;
        this.loses = loses;
        this.bombArmed = bombArmed;
        this.bombDefused = bombDefused;
        this.equipeElimine = equipeElimine;
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

    public int getBombArmed() {
        return bombArmed;
    }

    public void setBombArmed(int bombArmed) {
        this.bombArmed = bombArmed;
    }

    public int getBombDefused() {
        return bombDefused;
    }

    public void setBombDefused(int bombDefused) {
        this.bombDefused = bombDefused;
    }

    public int getEquipeElimine() {
        return equipeElimine;
    }

    public void setEquipeElimine(int equipeElimine) {
        this.equipeElimine = equipeElimine;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }
}
