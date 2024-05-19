package com.pvz;

import java.util.ArrayList;

import com.pvz.ExceptionHandling.IllegalTypeException;
import com.pvz.plants.*;

public class Deck {
    private ArrayList<Seed> seeds;
    private PlantFactory plantFactory;
    private Timer timer = Timer.getInstance();
    
    public Deck(){
        ArrayList<Seed> seeds=new ArrayList<>();
    }

    public Plant Plant(String type)  {
        try {
            for (Seed seed : seeds) {
                if (seed.getType().getName().equals(type)) {
                    if (!seed.isOnCooldown()) {
                        Plant plant = plantFactory.create(System.currentTimeMillis(), type);
                        seed.setOnCooldown(true);
                        seed.setLastUsed(timer.getCurrentTime());
                        return plant;
                    } else {
                        System.out.println("Plant is on cooldown");
                    }
                } else {
                    System.out.println("Plant not found");
                }
            }
        } catch (IllegalTypeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void Dig(int row, int col) {
        
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }
    
    public void setSeeds(ArrayList<Seed> seeds) {
        this.seeds = seeds;
    }
}
