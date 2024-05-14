import java.lang.Thread;
import java.util.Random;
package src.main.java.com.pvz;

public class Sun implements Runnable{
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
        while (true){
            try{
                Thread.sleep(Math.random()*5000+5000);
                value+=25;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }Thread.start();
    }
}
