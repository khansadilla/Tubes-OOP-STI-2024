package com.pvz;

public class Timer {
    private static Timer instance;
    private static long startTime;
    private static long currentTime = System.currentTimeMillis();
    private static long elapsedTime;
    
    public Timer() {
        startTime = currentTime;
    }

    public static Timer getInstance() {
        if (instance == null) {
            instance = new Timer();
        }
        return instance;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getCurrentTime() {
        currentTime = System.currentTimeMillis();
        return currentTime;
    }

    public long getElapsedTime() {
        elapsedTime = (currentTime - startTime);
        return elapsedTime;
    }    
    public boolean zombieMove(long timeCreated)
    {
        if(elapsedTime%5000==0) return true;
        return false;
    }
    public boolean Attack(long sinceLastAttack, int attackSpeed)
    {
        if(getCurrentTime()-sinceLastAttack>=attackSpeed*1000 || sinceLastAttack==0) return true;
        return false;
    }

}
