package com.pvz;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.pvz.plants.Peashooter;
import com.pvz.plants.Plant;
import com.pvz.zombies.BucketHeadZombie;
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

    public void update(long currentTime) {
        map.update(currentTime);
    }

    // public void checkZombie(Zombie zombie) {
    //     if (zombie.canDoSkill()) {
    //         // zombie.skill();
    //     }
    //     if (zombie.canAttack()) {
    //         // zombie.attack();
    //     } else (zombie.canMove()) {
    //         // zombie.move();
    //     } 
    // }
}
