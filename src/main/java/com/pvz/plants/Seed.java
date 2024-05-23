package com.pvz.plants;

public class Seed {     
    private PlantType type;
    private boolean onCooldown;
    private long lastUsed;

    public Seed(PlantType type) {
        this.type = type;
    }

    public int getCooldown() {
        return type.getCooldown();
    }
    
    public PlantType getType() {
        return type;
    }

    public long getLastUsed() {
        return lastUsed;
    }
    
    public boolean isOnCooldown() {
        if (System.currentTimeMillis() - lastUsed > type.getCooldown()) {
            onCooldown = false;
        }
        return onCooldown;
    }

    public void setOnCooldown(boolean value) {
        onCooldown = value;
    }

    public void setLastUsed(long time) {
        lastUsed = time;
    }

}