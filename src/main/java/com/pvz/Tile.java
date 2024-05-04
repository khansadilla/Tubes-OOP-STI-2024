package src.main.java.com.pvz;
import java.util.List;


import java.util.ArrayList;
public class Tile {
    private String type;
    private Point position;
    private List<Zombie> ZombieList;
    private List<Plant> PlantList;

    public Tile(int x, int y){
        this.position = new Point(x,y);
    }
    public Tile (int x, int y, String u){
        this.position=new Point(x,y);
        type=u;
    }

    public void setType(String type){
        this.type=type;
    }
    public Point getPosition(){
        return position;
    }

    public String getType(){
        return type;
    }
    public boolean isOccupied(){
        return ! PlantList.isEmpty();
    }
    public void addPlant(Plant plant){
        PlantList.add(plant);
    }
    public boolean isPlantValid(Plant plant){
        if (!plant.isIsaquatic()){
            return true;
        }
        return false;
    }

}