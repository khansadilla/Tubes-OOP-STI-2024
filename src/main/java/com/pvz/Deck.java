package com.pvz;

import java.util.ArrayList;

import com.pvz.ExceptionHandling.IllegalTypeException;
import com.pvz.plants.*;

public class Deck {
    private ArrayList<Seed> seeds;
    private PlantFactory plantFactory;
    private Timer timer = Timer.getInstance();
    
    public Deck(){
        seeds = new ArrayList<>();
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

    public void swapSeeds(int x, int y) {
        Seed temp = seeds.get(x);
        seeds.set(x, seeds.get(y));
        seeds.set(y, temp);
    }

    public void addSeed(Seed seed) {
        if (seeds.size() < 6){
            if (!seeds.contains(seed)) {
                seeds.add(seed);
            } else {
                throw new IllegalArgumentException("Seed already in deck");
                // System.out.println("Seed already in deck");
            }
        } else {
            throw new IndexOutOfBoundsException("Deck is full");
            // System.out.println("Deck is full");
        }
    }

    public void removeSeed(int slot) {
        if (seeds.size() < slot) {
            if (seeds.isEmpty()) {
                throw new IndexOutOfBoundsException("Deck is empty");
            } else {
                if (seeds.get(slot) != null) {
                    seeds.remove(slot);
                } else {
                    // throw new IndexOutOfBoundsException("Slot is empty");
                    System.out.println("Slot is empty");
                }
            }
        } else {
            throw new IndexOutOfBoundsException("Slot not found");
            // System.out.println("Slot not found");
        }
    }

    public void printDeck() {
        System.out.println("Deck: ");
        for (Seed seed : seeds) {
            System.out.printf("%d. ", seeds.indexOf(seed) + 1);
            System.out.println(seed.getType().getName());
        }
    }
}
