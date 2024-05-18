package com.pvz.zombies;

import com.pvz.Interface.Factory;
import com.pvz.Point;
import com.pvz.ExceptionHandling.*;;

public class ZombieFactory implements Factory<Zombie> {
    @Override
    public Zombie create(long timeCreated, String type, Point position) throws IllegalTypeException {
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
