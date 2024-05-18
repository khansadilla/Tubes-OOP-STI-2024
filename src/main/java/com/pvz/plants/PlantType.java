package com.pvz.plants;

public enum PlantType {
    Peashooter(10),
    Sunflower(10),
    Wallnut(20),
    Tallnut(20),
    Squash(20),
    Lilypad(10),
    Kelp(20),
    Snowpea(10),
    Sunbean(20),
    Jalapeno(20);
    private final int cooldown;

    PlantType(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCooldown() {
        return cooldown;
    }
}
