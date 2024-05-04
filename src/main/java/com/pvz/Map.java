package src.main.java.com.pvz;
public class Map {
    private Tile[][] tiles;

    public Map(int width, int height) {
        tiles = new Tile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (j < 2 && j > 4) {
                    setTile(i, j, new Tile("Grass"));
                } else {
                    setTile(i, j, new Tile("Water"));
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
