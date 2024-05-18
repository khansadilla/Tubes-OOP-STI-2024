package com.pvz.plants;

public enum PlantType {
    Peashooter("Peashooter",10),
    Sunflower("Sunflower", 10),
    Wallnut("Wallnut", 20),
    Tallnut("Tallnut", 20),
    Squash("Squash", 20),
    Lilypad("Lilypad", 10),
    Kelp("Kelp", 20),
    Snowpea("Snowpea", 10),
    Sunbean("Sunbean", 20),
    Jalapeno("Jalapeno", 20);

    private final String name;
    private final int cooldown;

    PlantType(String name, int cooldown) {
        this.name = name;
        this.cooldown = cooldown;
    }

    public int getCooldown() {
        return cooldown;
    }

    public String getName() {
        return name;
    }
}
