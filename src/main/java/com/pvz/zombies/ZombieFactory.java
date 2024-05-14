package com.pvz.zombies;

import com.pvz.Interface.Factory;
import com.pvz.ExceptionHandling.*;;

public final class ZombieFactory implements Factory<Zombie> {
    @Override
    public Zombie create(int timeCreated, String type) throws IllegalTypeException {
        switch (type) {
            case "Normal Zombie":
                return new NormalZombie();
            case "Conehead Zombie":
                return new ConeheadZombie();
            // continue for all zombie types
            default:
                throw new IllegalTypeException("Zombie type not found.");
        }
    }
    
}
