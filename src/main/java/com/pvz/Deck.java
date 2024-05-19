package com.pvz;

import java.util.ArrayList;

import com.pvz.plants.*;

public class Deck {
    private ArrayList<Seed> seeds;
    private PlantFactory plantFactory;
    
    public Deck(){
        ArrayList<Seed> seeds=new ArrayList<>();
    }

    public Plant Plant(String type, Point position)  {
        try {
            for (Seed seed : seeds) {
                if (seed.getType().getName().equals(type)) {
                    if (!seed.isOnCooldown()) {
                        Plant plant = plantFactory.create(System.currentTimeMillis(), type);
                        
                    } else {
                        System.out.println("Plant is on cooldown");
                    }
                } else {
                    System.out.println("Plant not found");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void Dig(Point position) {
        
    }
    public ArrayList<Seed> getSeeds() {
        return seeds;
    }
    public void setSeeds(ArrayList<Seed> seeds) {
        this.seeds = seeds;
    }
}
