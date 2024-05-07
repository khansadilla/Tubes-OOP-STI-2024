package com.pvz;

public class Sun {
    private static Sun instance;
    private int value;

    private Sun(){
        value=0;
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
    public void decSun(int x){
        value-=x;
    }
    public int getValue(){
        return value;
    }
    public void generateSun(int x){
        //generate pake thread
    }
}
