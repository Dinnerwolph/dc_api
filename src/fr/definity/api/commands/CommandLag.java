package fr.definity.api.commands;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class CommandLag implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	  {
	    String date = new SimpleDateFormat("E dd MMM y / HH:mm:ss").format(new Date(System.currentTimeMillis()));
	    
	    Player p = (Player)sender;
	    int ping = ((CraftPlayer)p).getHandle().ping;
	    if (label.equalsIgnoreCase("lag"))
	    {
			p.sendMessage("§6§m----------------------------------------------------");
			p.sendMessage("§bInformation de latence §c- §e" + date);
			p.sendMessage("");
			p.sendMessage("§6Votre ping §7(le temps de connexion) §6avec le serveur§a " + ping + " MS");
			p.sendMessage("");
			p.sendMessage("§6Le TPS est de : §a" + fr.definity.api.utils.Lag.getTPS());
			p.sendMessage("\u00a77Le TPS correspond à la charge serveur. §a20 §c= §aParfait");
			p.sendMessage("§6§m----------------------------------------------------");
	    
	    }
	        return false;
	    }
	  }
