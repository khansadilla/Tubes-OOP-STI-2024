package com.pvz;

import java.util.List;

import com.pvz.plants.Plant;
import com.pvz.zombies.Zombie;

public class GameEntity {
    private List<Zombie> ZombieList;
    private List<Plant> PlantList;
    private Map map;
    private Sun sun;

    public GameEntity() {
        this.map = new Map(5, 8); 
        this.sun = Sun.getInstance();
    }

    public int getSun() {
        return sun.getValue();
    }

    public void printMap() {
        for (int row = 0; row < map.getHeight(); row++) {     // row
            for (int col = 0; col < map.getWidth(); col++) {  // column
                // Tile tempTile = map.getTile(i, j);
                System.out.print("[ ");
                    // printZombieinTile(row, col);
                    // printPlantinTile(row, col);
                System.out.print(" ] ");
                if (col == map.getWidth()-1) {
                    System.out.print("%n");
                }
            }
        }
    }

    public void printZombieinTile(int row, int col) {       // this is very inefficient bro 
        for (int i = 0; i < ZombieList.size(); i++) {       // maybe replace with hashmap
            Zombie zombie = ZombieList.get(i);
            if ((zombie.getPosition().getAbsis() == col) && 
                 zombie.getPosition().getOrdinat() == row) {
                    System.out.print(zombie.getName());
            }
        }        
    }

    public void printPlantinTile(int row, int col) {

    }

    /* addPlant and spawnZombie will implement PlantFactory and ZombieFactory */
    public void addPlant(Plant plant){
        PlantList.add(plant);
    }

    public void spawnZombie(Zombie zombie) {
        // randomize zombie location
        // randomize zombie type
        ZombieList.add(zombie);
    }
}
