package com.pvz;

import java.util.ArrayList;

import com.pvz.ExceptionHandling.*;
import com.pvz.plants.*;

public class Deck {
    private ArrayList<Seed> seeds;
    private PlantFactory plantFactory;
    private Timer timer = Timer.getInstance();
    
    public Deck(){
        seeds = new ArrayList<>();
        plantFactory = new PlantFactory();
    }

    public boolean isEmpty() {
        return seeds.isEmpty();
    }

    public boolean isFull() {
        return (seeds.size() == 6);
    }

    public Plant getPlant(String type) throws CooldownException{
        try {
            boolean found = false;
            for (Seed seed : seeds) {
                if (seed.getType().getName().equals(type)) {
                    found = true;
                    if (seed.isOnCooldown()) {
                        throw new CooldownException("Plant is on cooldown");
                        // System.out.println("Plant is on cooldown");
                    } else {
                        Plant plant = plantFactory.create(System.currentTimeMillis(), type);
                        seed.setLastUsed(timer.getCurrentTime());
                        return plant;
                    }
                }
            }
            if (!found) {
                System.out.println("Plant not found");
            }
        } catch (IllegalTypeException e) {
            System.out.println(e.getMessage());
        }
        catch (CooldownException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Plant getPlantInt(int slot) throws CooldownException {
        Plant plant = null;
        try {
            if (slot < 1 || slot > seeds.size()) {
                System.out.println("Invalid slot number");
            }
            Seed seed = seeds.get(slot - 1);
            if (seed.isOnCooldown()) {
                // System.out.println("Plant is on cooldown");
                throw new CooldownException("Plant is on cooldown");
            } else {
                plant = plantFactory.create(System.currentTimeMillis(), seed.getType().getName());
                seed.setLastUsed(timer.getCurrentTime());
            }
        } catch (IllegalTypeException e) {
            System.out.println(e.getMessage());
        } catch (CooldownException e) {
            System.out.println(e.getMessage());
        }
        return plant;
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }

    public void swapSeeds(int x, int y) {
        if (x < 0 || x >= seeds.size() || y < 0 || y >= seeds.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
            // System.out.println("Index out of bounds");
        } else {
            Seed temp = seeds.get(x);
            seeds.set(x, seeds.get(y));
            seeds.set(y, temp);
        }
    }

    public void addSeed(Seed seed) {
        if (!isFull()){
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
        if (slot > seeds.size() ) {
            throw new IndexOutOfBoundsException("Slot not found");
            // System.out.println("Slot not found");
        } else {
            if (seeds.isEmpty()) {
                throw new IndexOutOfBoundsException("Deck is empty");
            } else {
                if (seeds.get(slot) == null) {
                    // System.out.println("Slot is empty");
                    throw new IndexOutOfBoundsException("Slot is empty");
                } else {
                    seeds.remove(slot);
                }
            }
        }
    }

    public void printDeck() {
        System.out.println("Deck: ");
        for (Seed seed : seeds) {
            System.out.printf("%d. ", seeds.indexOf(seed) + 1);
            System.out.println(seed.getType().getName());
        }
    }

    public void printDeckVertical() {
        System.out.print("Deck: ");
        for (Seed seed : seeds) {
            System.out.printf("%d. " , seeds.indexOf(seed)+1);
            System.out.print( seed.getType().getName() +"(" + seed.getType().getCost() +") | ");
        }
        System.out.println();
    }
}
