package fr.definity.api.utils;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullPlayer
{
  public static void setItemHeads(Player player, int place)
  {
    ItemStack Item = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
    SkullMeta StatsMeta = (SkullMeta)Item.getItemMeta();
    StatsMeta.setOwner(player.getName());
    Item.setItemMeta(StatsMeta);
    player.getInventory().setItem(place, Item);
  }
  
  public static void setItemHeadsName(Player player, String name, int place)
  {
    ItemStack Item = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
    SkullMeta itemMeta = (SkullMeta)Item.getItemMeta();
    itemMeta.setDisplayName(name);
    itemMeta.setOwner(player.getName());
    Item.setItemMeta(itemMeta);
    player.getInventory().setItem(place, Item);
  }
  
  public static ItemStack getHeadName(String name)
  {
    ItemStack Item = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
    SkullMeta itemMeta = (SkullMeta)Item.getItemMeta();
    itemMeta.setDisplayName(name);
    itemMeta.setOwner(name);
    Item.setItemMeta(itemMeta);
    return Item;
  }
}