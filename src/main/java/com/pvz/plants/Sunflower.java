package com.pvz.plants;

import com.pvz.GameEntity;
import com.pvz.Point;

public class Sunflower extends Plant{
    public Sunflower(Point position) {
        super("Sunflower", 50, 100, 0, 0, 0, 10, position,  false);
    }

    public void generateSun(GameEntity game){
    }
}
