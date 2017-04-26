package fr.definity.api.inventory;

import org.bukkit.entity.Player;

/**
 * @author Dinnerwolph
 */
public abstract class IStatsInventory extends IInventory {

    protected String progress;
    protected String progressFinished;


    public IStatsInventory(Player player, boolean execute) {
        super(player, execute);
    }

    @Override
    public void init(Player player, boolean execute) {
        progress = "§a§bProgression: §b%progress%§7/§b%count%";
        progressFinished = "$a$bProgression: $bTerminé !";
        this.player = player;
        load();
        if(execute)
            openInventory();
    }
}
