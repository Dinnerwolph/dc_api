package fr.definity.api.utils.Flags;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.definity.api.API;


public enum FlagsType {

	SMAP("Spam"), SPAM_SIGN("Spam de panneaux"), DOUBLE_JUMP("Double jump");

	String FlagsName;

	private FlagsType(String FlagsName) {
		this.FlagsName = FlagsName;
	}

	public static void setTemporyFlags(FlagsType flagsType, int CountDown_sanction, final Player player) {
		FlagsUtils.addFlags(player, flagsType);
		new BukkitRunnable() {

			@Override
			public void run() {
				FlagsUtils.remmoveFlags(player);
			}
		}.runTaskLater(API.getInstance(), CountDown_sanction);
	}
}
