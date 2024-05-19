package com.pvz;

import com.pvz.plants.Plant;

public class Dirt extends Tile {
    public Dirt(){
        super.setType("Dirt");
    }
    public boolean isPlantValid(Plant plant){
        if (!plant.isAquatic()){
            return true;
        }
        return false;
    }
}
