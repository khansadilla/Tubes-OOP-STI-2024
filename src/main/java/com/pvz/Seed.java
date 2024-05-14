package com.pvz;

public class Seed {     
    private String type;
    private boolean onCooldown;
    private int cooldown;

    public Seed(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean isOnCooldown() {
        return onCooldown;
    }

    public int getCooldown() {
        return cooldown;
    }
}