package com.pvz.plants;

public enum PlantType {
    Peashooter("Peashooter",10, 100),
    Sunflower("Sunflower", 10, 50),
    Wallnut("Wallnut", 20, 50),
    Tallnut("Tallnut", 20, 100),
    Squash("Squash", 20, 50),
    Lilypad("Lilypad", 10, 25),
    Kelp("Kelp", 20, 50),
    Snowpea("Snowpea", 10, 175),
    Sunbean("Sunbean", 20, 175),
    Jalapeno("Jalapeno", 20, 200);

    private final String name;
    private final int cooldown;
    private final int cost;

    PlantType(String name, int cooldown, int cost) {
        this.name = name;
        this.cooldown = cooldown;
        this.cost = cost;
    }

    public int getCooldown() {
        return cooldown;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
