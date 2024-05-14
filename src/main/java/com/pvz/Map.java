package com.pvz;

public class Map {
        private Tile[][] tiles; // Tiles[row][column]
        private int width;
        private int height;
    
        public Map(int height, int width) {     // change to factory?
            //tiles = new Tile[height][width];
            for (int row = 0; row < width; row++) {
                for (int col = 0; col < height; col++) {
                    if (row < 2 && row > 3) {   // row 0, 1, 4, 5 = dirt
                        setTile(row, col, new Dirt(row, col));
                    } else {
                        setTile(row, col, new Pool(row, col));
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
}
