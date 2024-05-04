package src.main.java.com.pvz;

public class HulkZombie extends Zombie{
    private boolean alreadyPlantSquashed;
    public HulkZombie()
    {
        super("Hulk Zombie", 200,100,1,false,5);
        alreadyPlantSquashed=false;
    }

    public void plantSquashing()
    {
        
    }
}
