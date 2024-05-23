package com.pvz.plants;

import com.pvz.Timer;
public class Seed {     
    private PlantType type;
    private boolean onCooldown;
    private long lastUsed;
    private Timer time=Timer.getInstance();
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
        if (time.getCurrentTime() - lastUsed < type.getCooldown()) {
            onCooldown = true;
        }
        onCooldown = false;
        return onCooldown;
    }

    public void setOnCooldown(boolean value) {
        onCooldown = value;
    }

    public void setLastUsed(long time) {
        lastUsed = time;
    }

}