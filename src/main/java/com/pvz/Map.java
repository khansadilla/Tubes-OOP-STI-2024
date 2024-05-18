package com.pvz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List.*;

import com.pvz.plants.Plant;
import com.pvz.zombies.Zombie;

public class Map {
        private Tile tiles[][]; 
        // private List<List<Tile>> tileList;
        private int width;
        private int height;
        Timer time=new Timer();
        public Map(int height, int width) {     // change to factory?
            this.width = width;
            this.height = height;
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if (row < 2 || row > 3) {   // row 0, 1, 4, 5 = dirt
                        tiles[row][col]=new Dirt();
                    } else {
                        tiles[row][col]=new Pool();
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

        public void update()
        {
            checkAttackZombie();
            checkAttackPlant();
            checkSkill();
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
    public void printMap(GameEntity game) {
        Map map = game.getMap();
        for (int row = 0; row < map.getHeight(); row++) {     // row
            for (int col = 0; col < map.getWidth(); col++) {  // column
                //Point tempPoint = new Point(row, col);
                //System.out.print("[ ");
                //    printZombieinTile(game, tempPoint);
                //    printPlantinTile(game, tempPoint);
                //System.out.print(" ] ");
                //if (col == map.getWidth()-1) {
                //    System.out.print("%n");
                //}
            }
        }
    }
}
