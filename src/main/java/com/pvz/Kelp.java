package src.main.java.com.pvz;
public class Kelp extends Plant{
    public Kelp() {
        super("Kelp", 50, 100,5000, 0, 1, 20, true);
    }

    public void selfDestruct() {
        this.setHealth(0);
    }
}