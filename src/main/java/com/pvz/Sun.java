package src.main.java.com.pvz;

public class Sun {
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
        //generate pake thread
    }
}
