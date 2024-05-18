package com.pvz;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.pvz.plants.Plant;
import com.pvz.zombies.Zombie;

public class GameEntity {
    private HashMap<Point, List<Zombie>> ZombieList;
    private HashMap<Point, List<Plant>> PlantList;
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
        this.PlantList = new HashMap<>();
        ZombieList.clear();
        PlantList.clear();
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

    public HashMap<Point, List<Plant>> getPlantList() {
        return PlantList;
    }
    
    public boolean isGameOver() {
        return isGameOver;
    }

    public void plant(Point position, Plant plant) {
        // PlantList.get(position).add(plant);
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
        for (List<Plant> plants : PlantList.values()) {
            for (Plant plant : plants) {
                // plant.update();
            }
        }
    }
}
