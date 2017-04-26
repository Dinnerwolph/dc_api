package fr.definity.api.utils.Flags;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class FlagsUtils {

	public static HashMap<Player, FlagsType> Flags = new HashMap<>();

	public static FlagsType getFlags(Player target) {
		return Flags.get(target);
	}

	public static void addFlags(Player target, FlagsType flagsType) {
		Flags.put(target, flagsType);
	}

	public static void remmoveFlags(Player target) {
		Flags.remove(target);
	}
	
	public static boolean isFlaged(Player player){
		if(Flags.containsKey(player)) return true;
		return false;
	}
}
