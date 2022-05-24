import java.util.Random;

public class Fighter {
    static Random rand = new Random();

    private String name;
    private int health;
    private int damage;
    public boolean alive;

    public Fighter(String name) {
        this.name = name;
        this.health = rand.nextInt(1000) + 1;
        this.damage = rand.nextInt(100) + 1;
        this.alive = true;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void hit(int intHit) {
        health -= intHit;
    }
}
