package fr.definity.api.customentities;

import net.minecraft.server.v1_8_R3.EntityVillager;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import net.minecraft.server.v1_8_R3.World;

/**
 * @author Dinnerwolph
 */

public class CustomVillager extends EntityVillager {


    public CustomVillager(World world) {
        this(world, "");
    }


    public CustomVillager(World world, String displayName) {
        super(world);
        getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(-3.0D);
    }

    @Override
    public void g(double d0, double d1, double d2) {
        return;
    }

    @Override
    protected String z() {
        return "";
    }

    @Override
    protected String bo() {
        return "";
    }

    @Override
    protected String bp() {
        return "";
    }
}
