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
        /* sets X coordinate */
        this.x=x;
    }
    public void setOrdinat(int y){
        /* sets Y coordinate */
        this.y=y;
    }
    public int getAbsis(){
        /* returns X coordinate */
        return x;
    }
    public int getOrdinat(){
        /* returns Y coordinate */
        return y;
    }
    public void changePoint(int x, int y){
        this.x=x;
        this.y=y;
    }
}
