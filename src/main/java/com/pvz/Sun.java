package com.pvz;

import java.util.Random;

public class Sun {
    private static Sun instance;
    private int value;
    private Random random;
    private long lastSunTime;
    private int cooldown;
    private long currentTime;
    private Timer timer = Timer.getInstance();

    private Sun(){
        setValue(10000);
        random = new Random();
        lastSunTime = timer.getCurrentTime();
        currentTime = timer.getCurrentTime();
        setRandomCooldown();
    }

    public static Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }

    public void setValue(int x){
        value=x;
    }
    public void addSun(int x){
        value+=x;
    }
    public void decreaseSun(int x){
        value-=x;
    }
    public int getValue(){
        return value;
    }

    public void generateSun(){
        currentTime = timer.getCurrentTime();
        if (currentTime - lastSunTime > getCooldown() * 1000) {
            lastSunTime = currentTime;
            addSun(25);
            setRandomCooldown();
        }
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setRandomCooldown() {
        cooldown = random.nextInt(6) + 5;
        System.out.println("Sun cooldown: " + cooldown);
    }
}
