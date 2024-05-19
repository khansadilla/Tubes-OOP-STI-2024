package com.pvz.plants;


public class Jalapeno extends Plant{
    public Jalapeno() {
        super("Jalapeno", 200, 100,5000, 0, -1, 20, false);
    }

    public void selfDestruct() {
        this.setHealth(0);
    }
}

