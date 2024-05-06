package com.pvz;

public class Tile {
    private String type;
    private Point position;
    private boolean isOccupied;

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
        return isOccupied;
    }
    public boolean isPlantValid(Plant plant){
        if (!plant.isAquatic()){
            return true;
        }
        return false;
    }

}