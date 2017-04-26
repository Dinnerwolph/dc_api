package fr.definity.api.utils;

import fr.definity.api.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 * @author Dinnerwolph
 */

public class Utils {

    public static void updateRank(Player player) {
        for (Player p2 : Bukkit.getOnlinePlayers()) {
            update(player, p2);
        }
    }

    public static void update(Player player, Player target) {
        Scoreboard scoreboard = target.getScoreboard();
        Team team;
        int groupId = API.getDefinityPlayer(player).getGroupId();
        int scoreboardId = API.getInstance().getGroups(groupId).getScoreboardId();
        if (scoreboard.getTeam(scoreboardId + "") == null) {
            team = scoreboard.registerNewTeam(scoreboardId + "");
            team.setPrefix(API.getInstance().getGroups(API.getDefinityPlayer(player).getGroupId()).getPrefix() +
                    " ");
            team.setSuffix(" " + API.getInstance().getGroups(API.getDefinityPlayer(player).getGroupId()).getSuffix());
        } else {
            team = scoreboard.getTeam(scoreboardId + "");
        }
        team.addPlayer(player);
    }
}
