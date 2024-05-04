package src.main.java.com.pvz;
public class Squash extends Plant{
    public Squash(Point position) {
        super("Squash", 50, 100,5000, 0, 1, 20, position, false);
    }

    public void selfDestruct() {
        this.setHealth(0);
    }
}