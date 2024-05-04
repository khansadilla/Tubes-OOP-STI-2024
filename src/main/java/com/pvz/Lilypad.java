package src.main.java.com.pvz;
public class Lilypad extends Plant{
    private boolean isOccupied = false;

    public Lilypad(Point position) {
        super("Lilypad", 25, 100,0, 0, 0, 10, position, true);
    }

    public boolean isOccupied() {
        return true;
    }

    public void increasePlantHealth() {

    }
}