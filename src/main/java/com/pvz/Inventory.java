package com.pvz;

import java.util.ArrayList;

import com.pvz.plants.Seed;
import com.pvz.plants.PlantType;
public class Inventory {
    static private ArrayList<Seed> seeds;

    public Inventory(){
        seeds = new ArrayList<>();
        seeds.add(new Seed(PlantType.Peashooter));
        seeds.add(new Seed(PlantType.Sunflower));
        seeds.add(new Seed(PlantType.Wallnut));
        seeds.add(new Seed(PlantType.Tallnut));
        seeds.add(new Seed(PlantType.Squash));
        seeds.add(new Seed(PlantType.Lilypad));
        seeds.add(new Seed(PlantType.Kelp));
        seeds.add(new Seed(PlantType.Snowpea));
        seeds.add(new Seed(PlantType.Sunbean));
        seeds.add(new Seed(PlantType.Jalapeno));
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }

    public Seed getSeed(String type) {
        for (Seed seed : seeds) {
            if (seed.getType().getName().equals(type)) {
                return seed;
            }
        }
        // throw new IllegalArgumentException("Seed not found");
        System.out.println("Seed not found");
        return null;
    }

    public Seed getSeedInt(Integer slot) {
        if (slot < 1 || slot > seeds.size()) {
            System.out.println("Invalid slot number");
            return null;
        }
        return seeds.get(slot - 1);
    }

    public void printInventory() {
        System.out.println("Inventory: ");
        for (Seed seed : seeds) {
            System.out.printf("%d. ", seeds.indexOf(seed) + 1);
            System.out.println(seed.getType().getName());
        }
    }
}
