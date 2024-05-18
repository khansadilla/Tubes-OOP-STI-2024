package com.pvz;

import java.util.HashMap;
import java.util.List;
import java.util.List.*;

import com.pvz.plants.Plant;
import com.pvz.zombies.Zombie;

public class Map {
    private Tile[][] tiles; 
    private int width;
    private int height;
    
    public Map(int height, int width) {
        this.width = width;
        this.height = height;
        tiles = new Tile[height][width];
        for (int row = 0; row < width-1; row++) {
            for (int col = 0; col < height-1; col++) {
                if (row < 2 || row > 3) {   // row 0, 1, 4, 5 = dirt
                    setTile(col, row, new Dirt(row, col));
                } else {
                    setTile(col, row, new Pool(row, col));
                }
            }
        }
    }
    
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }
    
    public void setTile(int x, int y, Tile tile) {
        tiles[x][y] = tile;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
        
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void printMap(GameEntity game) {
        Map map = game.getMap();
        for (int row = 0; row < map.getHeight(); row++) {     // row
            for (int col = 0; col < map.getWidth(); col++) {  // column
                Point tempPoint = new Point(row, col);
                System.out.print("[ ");
                printPlantinTile(game, tempPoint);
                printZombieinTile(game, tempPoint);
                System.out.print(" ] ");
                if (col == map.getWidth()-1) {
                    System.out.println();
                }
            }
        }
    }

    public void printZombieinTile(GameEntity game, Point tempPoint) {       // this is very inefficient bro 
        HashMap<Point, List<Zombie>> ZombieList = game.getZombieList();
        if (ZombieList.get(tempPoint) != null){   
            for (Zombie zombie : ZombieList.get(tempPoint)) {
                System.out.print(zombie.getName().charAt(0));   // replace with zombie code
                System.out.println(" ");
            }
        } else {
            System.out.print("");
        }
    }

    public void printPlantinTile(GameEntity game, Point tempPoint) {
        HashMap<Point, List<Plant>> PlantList = game.getPlantList();
        if (PlantList.get(tempPoint) != null){   
            for (Plant plant : PlantList.get(tempPoint)) {
                System.out.print(plant.getName().charAt(0));   // replace with plant code
                System.out.println(" ");
            }
        } else {
            System.out.print(" ");
        }
    }
}
