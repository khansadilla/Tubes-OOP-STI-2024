package com.pvz.plants;

import com.pvz.Sun;
import com.pvz.Timer;

public class Sunflower extends Plant{
    private long sinceLastSun;
    private Sun sun = Sun.getInstance();
    private Timer timer = Timer.getInstance();


    public Sunflower() {
        super("Sunflower", 50, 100, 0, 0, 0, 10,  false);
        sinceLastSun = timer.getCurrentTime();
    }

    public void skill(){
        if (timer.getCurrentTime() - sinceLastSun >= 3000) {
            sun.addSun(25);
            sinceLastSun = timer.getCurrentTime();
            // System.out.println("Sunflower skill");
        }
    }

    public long getSinceLastSun() {
        return sinceLastSun;
    }
}
