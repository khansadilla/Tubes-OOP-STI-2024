package com.pvz;

import java.util.Random;

import com.pvz.plants.*;
import com.pvz.zombies.*;
import com.pvz.ExceptionHandling.*;

public class GameEntity {
    private Deck deck;
    private Inventory inventory;
    private Map map;
    private Sun sun;
    private Timer timer;
    private boolean isGameOver;
    
    private Random random;
    private float spawnRoll;
    private String[] poolTypeZombies = {"Ducky Tube Zombie", "Dolphin Rider Zombie"};
    private String[] dirtTypeZombies = {"Normal Zombie", "Conehead Zombie", "Buckethead Zombie",
    "Digger Zombie", "Hulk Zombie", "Pole Vaulting Zombie", 
    "Trex Zombie", "Wizard Zombie"};
    private ZombieFactory zombieFactory;
    
    public GameEntity() {
        this.map = new Map(6, 11); 
        this.sun = Sun.getInstance();
        this.random = new Random();
        this.isGameOver = false;
        this.timer = Timer.getInstance();
        this.zombieFactory = new ZombieFactory();
        this.deck = new Deck();
        this.inventory = new Inventory();
    }
    
    public int getSun() {
        return sun.getValue();
    }
    
    public Map getMap() {
        return map;
    }
    
    public Timer getTimer() {
        return timer;
    }

    public Deck getDeck() {
        return deck;
    }

    public Inventory getInventory() {
        return inventory;
    }
    
    public boolean isGameOver() {
        return isGameOver;
    }
    
    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public void addSeed(String type) {
        Seed seed = inventory.getSeed(type);
        deck.addSeed(seed);
    }

    public void removeSeed(int slot) {
        deck.removeSeed(slot);
    }
    
    public void plant(int row, int col, String type) throws IllegalArgumentException, IllegalPlantingException{
        Plant plant = null;
        try {
            plant = deck.getPlant(type);

        } catch (CooldownException e) {
            // System.out.println(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
        if (plant != null) {
            int cost = plant.getCost();
            if (sun.getValue() < cost) {
                throw new IllegalArgumentException("Not enough sun");
            } else {
                sun.decreaseSun(cost);
            }
            try {
                // map.getTile(row, col+1).addPlant(plant);
                map.plant(row, col, plant);
            } catch (Exception e) {
                // System.out.println(e.getMessage());
                throw new IllegalPlantingException(e.getMessage()+": Game Entity");
            }
        }
    }

    public void Dig(int row, int col) {
        map.getTile(row, col).removePlant();
    }
    
    public void spawnZombieinRow() {
        for (int i = 0; i < map.getHeight(); i++) {
            Tile tile = map.getTile(i , 10);
            spawnRoll = random.nextFloat(); // 0.0 < spawnRoll < 1.0
            
            if (spawnRoll < 0.3 && Zombie.getTotalZombie()<10) {  // 30% chance
                if (tile instanceof Pool) {
                    tile.addZombie(spawnZombiePool());
                    Zombie.setTotalZombie(Zombie.getTotalZombie()+1);
                } else {
                    tile.addZombie(spawnZombieDirt());
                    Zombie.setTotalZombie(Zombie.getTotalZombie()+1);
                }
            }
        }
    }
    
    public Zombie spawnZombiePool() {
        try {
            int roll = random.nextInt(2); // 0 <= roll < 7
            return zombieFactory.create(timer.getCurrentTime(), poolTypeZombies[roll]);
        } catch (IllegalTypeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Zombie spawnZombieDirt() { 
        try {
            int roll = random.nextInt(8); // 0 <= roll < 8
            return zombieFactory.create(timer.getCurrentTime(), dirtTypeZombies[roll]);
        } catch (IllegalTypeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void printGame() {
        deck.printDeckVertical();
        map.printMap();
        System.out.println("Sun: " + sun.getValue());
    }
}
