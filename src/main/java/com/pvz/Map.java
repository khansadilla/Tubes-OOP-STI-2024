package com.pvz;

import java.util.HashMap;
import java.util.List;

import com.pvz.plants.Plant;
import com.pvz.zombies.Zombie;

public class Map {
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String RESET = "\033[0m";      // Text Reset
    private Tile[][] tiles; 
    private int width;
    private int height;
    
    public Map(int height, int width) {
        this.width = width;
        this.height = height;
        tiles = new Tile[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i < 2 || i > 3) {   // row 0, 1, 4, 5 = dirt
                    setTile(i, j, new Dirt(i, j));
                } else {
                    setTile(i, j, new Pool(i, j));
                }
            }
        }
    }
    
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }
    
    public void setTile(int row, int col, Tile tile) {
        tiles[row][col] = tile;
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
                Tile tempTile = map.getTile(row, col);
                if (tempTile instanceof Dirt) {
                    System.out.print(GREEN + "[ ");
                    printPlantinTile(game, tempPoint);
                    printZombieinTile(game, tempPoint);
                    System.out.print(" ]"+ RESET);
                } else {
                    System.out.print(BLUE +"[ ");
                    printPlantinTile(game, tempPoint);
                    printZombieinTile(game, tempPoint);
                    System.out.print(" ]" + RESET);

                }

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
        HashMap<Point, Plant> plant = game.getAlivePlants();
        if (plant.get(tempPoint) != null){   
                System.out.print(plant.get(tempPoint).getName().charAt(0));   // replace with plant code
                System.out.println(" ");
        } else {
            System.out.print(" ");
        }
    }
}
