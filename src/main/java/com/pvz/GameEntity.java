package com.pvz;

import java.util.HashMap;
import java.util.List;

import com.pvz.plants.Peashooter;
import com.pvz.plants.Plant;
import com.pvz.zombies.BucketHeadZombie;
import com.pvz.zombies.Zombie;

public class GameEntity {
    private Map map;
    private Sun sun;
    private boolean isGameOver;

    public GameEntity() {
        this.map = new Map(6, 11); 
        this.sun = Sun.getInstance();
    }

    public int getSun() {
        return sun.getValue();
    }

    public Map getMap() {
        return map;
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
