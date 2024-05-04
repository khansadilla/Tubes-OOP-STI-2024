package src.main.java.com.pvz;


public class Pool extends Tile {
    private boolean hasLilypad;
    public Pool(int x, int y){
        super(x,y);
        super.setType("Pool");
        hasLilypad=false;
    }
    public boolean hasLilypad(){
        return hasLilypad;
    }
    public void combinePlant(Plant plant){
        if (hasLilypad()){
            plant.setHealth(plant.getHealth()+100);
        }
    }
    public boolean isPlantValid(Plant plant){
        if (plant.isIsaquatic() && hasLilypad()){
            return true;
        }
        return false;
    }
    
}
