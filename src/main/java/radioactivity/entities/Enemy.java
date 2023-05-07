package radioactivity.entities;

public class Enemy extends BaseCharacter {
    public Enemy(int life, int damage, int velocity) {
        setLife(life);
        setDamage(damage);
        setVelocity(velocity);
    }

    public Enemy(String name, int life, int damage, int velocity) {
        setName(name);
        setLife(life);
        setDamage(damage);
        setVelocity(velocity);
    }


}
