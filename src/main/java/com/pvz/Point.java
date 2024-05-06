package com.pvz;

public class Point {
    private int x;
    private int y;

    public Point(){
        this.x=0;
        this.y=0;
    }
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void setAbsis(int x){
        this.x=x;
    }
    public void setOrdinat(int y){
        this.y=y;
    }
    public int getAbsis(){
        return x;
    }
    public int getOrdinat(){
        return y;
    }
    public void changePoint(int x, int y){
        this.x=x;
        this.y=y;
    }
}
