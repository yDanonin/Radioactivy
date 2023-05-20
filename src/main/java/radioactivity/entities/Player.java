package radioactivity.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends BaseCharacter {
    private List<Item> inventory;
    private Item equippedItem;

    public Player(String name, int life, int damage, int velocity) {
        super(name, life, damage, velocity);
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item){
        if(this.inventory.size() + item.size <= 4){
            this.inventory.add(item);
            System.out.println("Item adicionado com sucesso!");
        } else {
            System.out.println("Limite máximo de itens atingido!");
        }
    }

    public void attack(BaseCharacter target) {
        double attackSpeed = super.getAttackSpeed();
        if(equippedItem != null){
            attackSpeed = equippedItem.attackSpeed;
        }
        for(int i = 0; i < ((int) (attackSpeed / 0.5)); i++){
            target.takeDamage(calcDamage());
            System.out.println(super.getName() + " atacou " + target.getName() + " causando " + super.getDamage() + " de dano.");
        }
    }

    private int calcDamage(){
        Random r = new Random();
        int damage = super.getDamage();
        if(equippedItem != null){
            damage = r.nextInt(equippedItem.damage.min, equippedItem.damage.max);
        }

        return (int) (damage + ( damage * new Random().nextDouble(0, 1)));
    }


}
