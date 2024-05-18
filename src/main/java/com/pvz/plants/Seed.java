package com.pvz.plants;

public class Seed {     
    private PlantType type;
    private boolean onCooldown;

    public Seed(PlantType type) {
        this.type = type;
    }

    public PlantType getType() {
        return type;
    }

    public boolean isOnCooldown() {
        return onCooldown;
    }

    public int getCooldown() {
        return type.getCooldown();
    }
}