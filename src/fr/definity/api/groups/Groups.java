package fr.definity.api.groups;

/**
 * @author Dinnerwolph
 */
public class Groups {

    private int ladder = 0; // default groups
    private String prefix = "";
    private String suffix = "";
    private int scoreboardId;

    public Groups(int ladder, String prefix, String suffix, int scoreboardId) {
        this.ladder = ladder;
        this.prefix = prefix;
        this.suffix = suffix;
        this.scoreboardId = scoreboardId;
    }

    public Integer getLadder() {
        return ladder;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public int getScoreboardId() {
        return scoreboardId;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "ladder=" + ladder +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", scoreboardId=" + scoreboardId +
                '}';
    }
}
