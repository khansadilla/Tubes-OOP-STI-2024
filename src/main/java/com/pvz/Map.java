package com.pvz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List.*;

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

        public void update()
        {
            checkAttackZombie();
            checkAttackPlant();
            checkMove();
        }

        public void checkMove()
        {
            for (int row = 0; row < height; row++) {
                for (int col = 1; col < width-1; col++)
                {
                    List<Zombie> movZombies=tiles[row][col].moveZombie();
                    if(!movZombies.isEmpty())
                    {
                        for (Zombie zombie : movZombies)
                        {
                            tiles[row][col-1].addZombie(zombie);
                        }
                    }
                }
            }
        }
        

        public void checkAttackZombie()
        {
            for (int row = 0; row < height; row++) {
                for (int col = 1; col < width-1; col++)
                {
                    if(tiles[row][col].isOccupiedByPlant() && tiles[row][col].isOccupiedByZombie())
                    {
                        tiles[row][col].zombieAttack();
                    }
                }
            }
        }

        public void checkAttackPlant()
        {
            for (int row = 0; row < height; row++) {
                Tile attackZombieAt=null;
                int j;
                for (j=0; j<width; j++)
                    {
                        if(tiles[row][j].isOccupiedByZombie()) {attackZombieAt=tiles[row][j]; break;}
                    }
                for (int col = 1; col < width-1; col++)
                {
                    
                    if(tiles[row][col].isOccupiedByPlant())
                    {
                        Plant plant= tiles[row][col].getPlant();
                        if(plant.getRange()>=j-col && time.Attack(plant.getSinceLastAttack(), plant.getAttackSpeed()))
                        {
                            for (Zombie zombie : attackZombieAt.getListZombie())
                            {
                                plant.attack(zombie);
                            }
                            attackZombieAt.getListZombie().removeIf(zombie -> zombie.getHealth()<=0);
                        }
                    }
                }
            }
        }
        public void printMap() {
        for (int row = 0; row < height; row++) {     // row
            for (int col = 0; col < width; col++) {  // column
                System.out.print("[ ");
                if(tiles[row][col].isOccupiedByPlant()) System.out.print("P");
                if(tiles[row][col].isOccupiedByZombie()) System.out.printf("Z%d",tiles[row][col].getListZombie().size());
                System.out.print(" ] ");
                if (col == width-1) {
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
}
