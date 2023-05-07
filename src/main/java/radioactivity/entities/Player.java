package radioactivity.entities;

public class Player extends BaseCharacter {

    public Player(String name, int life, int damage, int velocity) {
        setName(name);
        setLife(life);
        setDamage(damage);
        setVelocity(velocity);
    }
}
