package com.pvz.plants;

import java.util.ArrayList;
import java.util.List;

import com.pvz.Map;
import com.pvz.Tile;
import com.pvz.zombies.Zombie;

public class Jalapeno extends Plant{
    public Jalapeno() {
        super("Jalapeno", 200, 100,5000, 0, -1, 20, false);
    }

    public void selfDestruct() {
        this.setHealth(0);
    }

    public void skill(Map map, int row) {
        List<Zombie> toRemove = new ArrayList<>();
        for (int i = 1; i < map.getWidth(); i++) {
            Tile attackZombieAt= map.getTiles()[row][i];
            for (Zombie zombie : attackZombieAt.getListZombie()) {
                toRemove.add(zombie);
            }
            Zombie.setTotalZombie(Zombie.getTotalZombie()-toRemove.size());
            attackZombieAt.getListZombie().removeAll(toRemove);
        }
    }
}

