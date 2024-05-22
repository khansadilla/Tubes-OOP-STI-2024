package com.pvz.plants;

import com.pvz.ExceptionHandling.IllegalTypeException;
import com.pvz.Interface.Factory;

public class PlantFactory implements Factory<Plant> {
    @Override
    public Plant create(long timeCreated, String type) throws IllegalTypeException {
        switch (type) {
            case "Peashooter":
                return new Peashooter();
            case "Sunflower":
                return new Sunflower();
            case "Wallnut":
                return new Wallnut();
            case "Jalapeno":
                return new Jalapeno();
            case "Lilypad":
                return new Lilypad();
            case "Tallnut":
                return new Tallnut();
            case "Kelp":
                return new Kelp();
            case "Squash":
                return new Squash();
            case "Sunbean":
                return new Sunbean();
            case "Snowpea":
                return new Snowpea();
            default:
                throw new IllegalTypeException("Zombie type not found.");
        }
    }
}
