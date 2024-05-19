package com.pvz;

import java.util.List;
import java.util.Random;

import com.pvz.plants.Peashooter;
import com.pvz.plants.Plant;
import com.pvz.zombies.BucketHeadZombie;
import com.pvz.zombies.Zombie;

public class GameEntity {
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
    
    public boolean isGameOver() {
        return isGameOver;
    }

    public void update() {
        map.update();
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
