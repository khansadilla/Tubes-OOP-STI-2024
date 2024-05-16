package com.pvz;

public class Timer {
    private static long startTime;
    private static long currentTime = System.currentTimeMillis();
    private static long elapsedTime;
    
    public long getStartTime() {
        return startTime;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public long getElapsedTime() {
        elapsedTime = currentTime - startTime;
        return elapsedTime;
    }
}
