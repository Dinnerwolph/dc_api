package fr.definity.api.inventory;

import org.bukkit.entity.Player;

/**
 * @author Dinnerwolph
 */
public abstract class IGamesInventory extends IInventory {

    protected String online;


    public IGamesInventory(Player player, boolean execute) {
        super(player, execute);
    }

    @Override
    public void init(Player player, boolean execute) {
        online = "§7Il y a §c%online% joueurs §7en ligne sur ce jeu.";
        this.player = player;
        load();
        if(execute)
            openInventory();
    }
}
