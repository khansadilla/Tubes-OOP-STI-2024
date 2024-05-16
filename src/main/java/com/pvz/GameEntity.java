package com.pvz;

import java.util.HashMap;
import java.util.List;

import com.pvz.plants.Plant;
import com.pvz.zombies.Zombie;

public class GameEntity {
    private HashMap<Point, List<Zombie>> ZombieList;
    private HashMap<Point, List<Plant>> PlantList;
    private Map map;
    private Sun sun;
    private boolean isGameOver;

    public GameEntity() {
        this.map = new Map(5, 8); 
        this.sun = Sun.getInstance();
    }

    public int getSun() {
        return sun.getValue();
    }

    public Map getMap() {
        return map;
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



    public void update() {
        // update sun
        // sun.generateSun(1);
        // update zombies
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
