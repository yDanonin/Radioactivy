package radioactivity.entities;

public abstract class BaseCharacter {
    private String name;
    private int life;
    private int damage;
    private double attackSpeed;

    public BaseCharacter(String name, int life, int damage, double attackSpeed){
        this.name = name;
        this.life = life;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public abstract void attack(BaseCharacter target);

    public void takeDamage(int damage) {
        this.life -= damage;
        System.out.println(this.name + " recebeu " + damage + " de dano. Vida restante: " + this.life);
    }

    public boolean isAlive(){ return life > 0; }

    public String getName() {
        return this.name;
    }

    public int getLife() {
        return this.life;
    }

    public int getDamage() {
        return this.damage;
    }

    public double getAttackSpeed() {
        return this.attackSpeed;
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

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }



}
