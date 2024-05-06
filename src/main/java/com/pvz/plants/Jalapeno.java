package com.pvz.plants;

import com.pvz.Point;

public class Jalapeno extends Plant{
    public Jalapeno(Point position) {
        super("Jalapeno", 200, 100,5000, 0, -1, 20, position, false);
    }

    public void selfDestruct() {
        this.setHealth(0);
    }
}

