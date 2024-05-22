package com.pvz.plants;

import com.pvz.zombies.Zombie;
import com.pvz.Timer;

public class Snowpea extends Plant{
    private Timer time = Timer.getInstance();

    public Snowpea() {
        super("Snow pea", 175, 100,25, 4, -1, 10, false);
    }

    public void skill(Zombie zombie) {
        reduceAttackSpeed(zombie);
        reduceMovementSpeed(zombie);
        zombie.setSlowed(true);
        zombie.setTimeSinceLastSlowed(time.getCurrentTime());
    }

    public void reduceAttackSpeed(Zombie zombie) {
        zombie.setAttackSpeed(zombie.getAttackSpeed()*2);
    }

    public void reduceMovementSpeed(Zombie zombie) {
        zombie.setMovementSpeed(zombie.getMovementSpeed()*2);
    }
}