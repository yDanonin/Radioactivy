package radioactivity.entities;

public class BaseCharacter {
    private String name;
    private int life;
    private int damage;
    private int velocity;

    public String getName() {
        return this.name;
    }

    public int getLife() {
        return this.life;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }


}
