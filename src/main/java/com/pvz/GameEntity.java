package com.pvz;

import java.util.List;

public class GameEntity {
    private List<Zombie> ZombieList;
    private List<Plant> PlantList;
    private Map map;

    public GameEntity(Map map) {
        this.map = new Map(5, 8); 
    }

    public void printMap() {
        for (Tile[] row : map.getTiles()) {
            for (Tile element : row) {
              // Do something with the element
              System.out.print(element + " ");
            }
            System.out.println(); // Go to next line after each row
          }
    }

    public void addPlant(Plant plant){
        PlantList.add(plant);
    }

    public void spawnZombie(Zombie zombie) {
        // randomize zombie location
        // randomize zombie type
        ZombieList.add(zombie);
    }
}
