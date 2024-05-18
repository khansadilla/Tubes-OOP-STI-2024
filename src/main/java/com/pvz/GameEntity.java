package com.pvz;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.pvz.plants.Plant;
import com.pvz.zombies.Zombie;

public class GameEntity {
    private HashMap<Point, List<Zombie>> ZombieList;
    private HashMap<Point, Plant> alivePlants;
    private Deck deck;
    private Map map;
    private Sun sun;
    private Timer timer;
    private boolean isGameOver;
    private Random random;
    private float spawnRoll;

    public GameEntity() {
        this.map = new Map(6, 11); 
        this.sun = Sun.getInstance();
        this.random = new Random();
        this.isGameOver = false;
        this.ZombieList = new HashMap<>();
        this.alivePlants = new HashMap<>();
        ZombieList.clear();
        alivePlants.clear();
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

    public HashMap<Point, List<Zombie>> getZombieList() {
        return ZombieList;
    }

    public HashMap<Point, Plant> getAlivePlants() {
        return alivePlants;
    }
    
    public boolean isGameOver() {
        return isGameOver;
    }

    public void plant(Point position, String type) {
        Plant plant = deck.Plant(type, position);
        alivePlants.put(position, plant);
    }

    public void spawnZombie() {
        spawnRoll = random.nextFloat();
        if (spawnRoll < 0.3) {
            for (int i = 0; i < 5; i++) {
                // Zombie zombie = new NormalZombie();
                // ZombieList.get(new Point(0, i)).add(zombie);
            }
        }
    }

    public void update() {
        System.out.println();
        System.out.println("Sun: " + sun.getValue());
        sun.generateSun();

        for (List<Zombie> zombies : ZombieList.values()) {
            for (Zombie zombie : zombies) {
                // zombie.move();
            }
        }
        
        // update plants
        for (Plant plants : alivePlants.values()) {
            // plant.update();
        }
    }
}
