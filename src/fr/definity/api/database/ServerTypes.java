package fr.definity.api.database;

/**
 * @author Dinnerwolph
 */

public enum ServerTypes {

    THEBLOCK("TheBlock"),
    FISHING_WARS("FishingWars"),
    BOMBE_ARMING("BombArming");

    private String name;

    ServerTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
