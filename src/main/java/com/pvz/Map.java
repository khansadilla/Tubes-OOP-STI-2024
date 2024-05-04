package src.main.java.com.pvz;

public class Map {
        private Tile[][] tiles;
    
        public Map(int width, int height) {
            //tiles = new Tile[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i < 2 && i > 4) {   
                        setTile(i, j, new Tile(i, j, "Grass"));
                    } else {
                        setTile(i, j, new Tile(i, j, "Water"));
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
}
