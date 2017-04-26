package fr.definity.api.inventory;


import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * @author Dinnerwolph
 */

public abstract class IInventory {

    protected Player player;
    protected Inventory inventory;

    public IInventory(Player player, boolean execute) {
        init(player, execute);
    }

    public void init(Player player, boolean execute) {
        this.player = player;
        load();
        if(execute)
            openInventory();
    }

    public abstract void openInventory();

    public abstract void load();

    public void setPlayer(Player player) {
        this.player = player;
    }
}
