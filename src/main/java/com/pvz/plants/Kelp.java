package com.pvz.plants;

import com.pvz.Point;

public class Kelp extends Plant{
    public Kelp(Point position) {
        super("Kelp", 50, 100,5000, 0, 1, 20, position, true);
    } 

    public void selfDestruct() {
        this.setHealth(0);
    }
}