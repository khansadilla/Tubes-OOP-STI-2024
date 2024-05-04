public class Plant {
    private String name;
    private int cost;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private int range;
    private int cooldown;
    private Point position;
    private boolean is_aquatic;

    public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown, Point point, boolean is_aquatic){
        this.name=name;
        this.cost=cost;
        this.health=health;
        this.attack_damage=attack_damage;
        this.attack_speed=attack_speed;
        this.range=range;
        this.cooldown=cooldown;
        this.position=point;
        this.is_aquatic=is_aquatic;
    }
    public int getDamage(){
        return attack_damage;
    }
    public int getSpeed(){
        return attack_speed;
    }
    public int getHealth(){
        return health;
    }
    public int getRange(){
        return range;
    }
    public String getName(){
        return name;
    }
}
