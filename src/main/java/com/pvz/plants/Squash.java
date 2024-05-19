package com.pvz.plants;


public class Squash extends Plant{
    public Squash() {
        super("Squash", 50, 100,5000, 0, 1, 20, false);
    }

    public void selfDestruct() {
        this.setHealth(0);
    }
}