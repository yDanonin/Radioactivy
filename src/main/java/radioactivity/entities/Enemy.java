package radioactivity.entities;

public class Enemy extends BaseCharacter {

    public Enemy(String name, int life, int damage, int velocity) {
        super(name, life, damage, velocity);
    }

    public void attack(BaseCharacter target) {
        target.takeDamage(super.getDamage());
        System.out.println(super.getName() + " atacou " + target.getName() + " causando " + super.getDamage() + " de dano.");
    }

}
