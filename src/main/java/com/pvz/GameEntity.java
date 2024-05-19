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
    private int totalZombie;
    
    
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

        this.totalZombie=0;
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
    
    public void plant(int row, int col, String type) {
        Plant plant = deck.Plant(type);
        if (plant != null) {
            map.getTile(row, col).addPlant(plant);
        }
    }
    
    public void spawnZombieinRow() {
        for (int i = 0; i < map.getHeight(); i++) {
            Tile tile = map.getTile(i , 10);
            spawnRoll = random.nextFloat(); // 0.0 < spawnRoll < 1.0
            
            if (spawnRoll < 0.3 && totalZombie<10) {  // 30% chance
                if (tile instanceof Pool) {
                    tile.addZombie(spawnZombiePool());
                    totalZombie++;
                } else {
                    tile.addZombie(spawnZombieDirt());
                    totalZombie++;
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
    public int getTotalZombie() {
        return totalZombie;
    }
    
    public void setTotalZombie(int totalZombie) {
        this.totalZombie = totalZombie;
    }
}
