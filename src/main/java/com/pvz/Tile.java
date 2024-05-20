package com.pvz;

import java.util.List;
import com.pvz.plants.Plant;
import com.pvz.zombies.Zombie;
import java.util.ArrayList;
import com.pvz.ExceptionHandling.*;

public abstract class Tile {
    private String type;
    private List<Zombie> ZombieList;
    private Plant plant;
    Timer time = new Timer();

    public Tile() {
        this.ZombieList = new ArrayList<>();
        this.plant = null;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean isOccupiedByPlant() {
        return !(plant == null  || !plant.getName().equals("Lilypad"));
    }

    public boolean isOccupiedByZombie() {
        return (!ZombieList.isEmpty());
    }

    public abstract boolean isPlantValid(Plant plant);

    public void addZombie(Zombie zombie) {
        ZombieList.add(zombie);
    }

    public void addPlant(Plant plant) throws IllegalPlantingException {
        if (!isPlantValid(plant)) {
            throw new IllegalArgumentException("Plant is not valid");
        } else if (isOccupiedByPlant()) {
            throw new IllegalPlantingException("Tile is occupied by plant");
        } else {
            this.plant = plant;
        }
    }

    public void removePlant() {
        plant = null;
    }

    public List<Zombie> moveZombie() {
        List<Zombie> movZombies = new ArrayList<>();
        List<Zombie> toRemove = new ArrayList<>();
        for(Zombie zombie : ZombieList)
        {
            if(time.zombieMove(zombie.getSinceLastMove()))
            {
                movZombies.add(zombie);
                zombie.setSinceLastMove(time.getCurrentTime());
                toRemove.add(zombie);
            }
        }
        ZombieList.removeAll(toRemove);
        return movZombies;
    }

    public void zombieAttack() {
        for (Zombie zombie : ZombieList) {
            if (time.Attack(zombie.getSinceLastAttack(), zombie.getAttackSpeed())) {
                zombie.attack(plant);
                zombie.setSinceLastAttack(time.getCurrentTime());
            }
        }
        if (plant.getHealth() <= 0)
            plant = null;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public List<Zombie> getListZombie() {
        return ZombieList;
    }
}
