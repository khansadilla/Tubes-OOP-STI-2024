package src.main.java.com.pvz;

public class Sun implements Runnable{
    private int sun;

    public Sun(){
        sun=0;
    }
    public void setSun(int x){
        sun=x;
    }
    public void addSun(int x){
        sun+=x;
    }
    public void decSun(int x){
        sun-=x;
    }
    public int getSun(){
        return sun;
    }
    public void generateSun(int x){
        sun+=25;
        public void run(){
            Thread.sleep((long) Math.random()*(5000)+5000);
        } thread.start();
    }
}
