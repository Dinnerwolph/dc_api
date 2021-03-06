package fr.definity.api.items;

import java.lang.reflect.Field;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;

public class GlowEffect extends EnchantmentWrapper{
	
	  private static Enchantment glow;
	    private final static int ENCHANTMENT_ID = 254;
	    private final static String ENCHANTMENT_NAME = "GlowEffect";
	 
	    public GlowEffect(int id) {
	        super(id);
	    }
	 
	    @Override
	    public boolean canEnchantItem(ItemStack item) {
	        return true;
	    }
	 
	    @Override
	    public boolean conflictsWith(Enchantment other) {
	        return false;
	    }
	 
	    @Override
	    public EnchantmentTarget getItemTarget() {
	        return null;
	    }
	 
	    @Override
	    public int getMaxLevel() {
	        return 5;
	    }
	 
	    @Override
	    public String getName() {
	        return ENCHANTMENT_NAME;
	    }
	 
	    @Override
	    public int getStartLevel() {
	        return 1;
	    }
	 
	    public static Enchantment getGlow() {
	        if (glow != null) {
	            return glow;
	        }
	 
	        try {
	            Field acceptingNewField = Enchantment.class.getDeclaredField("acceptingNew");
	            acceptingNewField.setAccessible(true);
	            acceptingNewField.set(null, true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        try {
	            glow = new GlowEffect(ENCHANTMENT_ID);
	            Enchantment.registerEnchantment(glow);
	        } catch(IllegalArgumentException e) {
	            glow = Enchantment.getByName(ENCHANTMENT_NAME); 
	        }
	 
	        return glow;
	    }
	 
	    public static ItemStack addGlow(ItemStack item) {
	        if(item == null)
	            return null;
	 
	        Enchantment glow = getGlow();
	        if(glow != null)
	            item.addEnchantment(glow, 1);
	        return item;
	   }
}
