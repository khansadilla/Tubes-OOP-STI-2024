package com.pvz;

import java.util.ArrayList;
import java.util.List;
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
    
    public void gameReset()
    {
        this.map = new Map(6, 11); 
        this.sun.setValue(50);
        this.random = new Random();
        this.isGameOver = false;
        this.timer = Timer.getInstance();
        this.zombieFactory = new ZombieFactory();
        Zombie.setTotalZombie(0);
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

    public void checkGameOver()
    {
        if ((timer.getElapsedTime()%200000>160000 || timer.getElapsedTime()%200000<20000) && timer.getElapsedTime()>160000)
        {
            if(Zombie.getTotalZombie()==0) {isGameOver = true; System.out.println("Game Over! You Won!!!");}
        }
        for (int i=0; i<map.getHeight(); i++)
        {
            if(map.getTile(i, 0).isOccupiedByZombie()) {isGameOver = true; System.out.println("Game Over!!! You Lose!!!");}
        }
    }

    public void update()
    {
        List<Zombie> toRemove = new ArrayList<>();
        for (int i=0; i<6; i++)
        {
            for (int j=1; j<map.getWidth()-1; j++)
            {
                Tile tile=map.getTile(i, j);
                if(tile.isOccupiedByPlant())
                {
                    Plant plant = tile.getPlant();
                    if(plant.getHealth()<=0) tile.removePlant();
                }
                if(tile.isOccupiedByZombie())
                {
                    for(Zombie zombie : tile.getListZombie())
                    {
                        if(zombie.getHealth()<=0) {
                            toRemove.add(zombie);
                        }
                    }
                    Zombie.setTotalZombie(Zombie.getTotalZombie()-toRemove.size());
                    tile.getListZombie().removeAll(toRemove);
                }
            }
        }
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
    
    public void plant(int row, int col, int type) throws IllegalArgumentException, IllegalPlantingException{
        Plant plant = null;
        try {
            plant = deck.getPlantInt(type);

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
            
            if (spawnRoll < 0.3 && Zombie.getTotalZombie()<1) {  // 30% chance
                System.out.println("Ini jumlah zombie :"+Zombie.getTotalZombie());
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
