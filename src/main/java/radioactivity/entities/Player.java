package radioactivity.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends BaseCharacter {
    private List<Item> inventory;
    private Item equippedItem;

    public Player(String name, int life, int damage, double velocity) {
        super(name, life, damage, velocity);
        this.inventory = new ArrayList<>();
    }

    public void removeItem(Item item){
        inventory.remove(item);
    }

    public void addItem(Item item){
        if(this.inventory.size() + item.getSize() <= 4){
            this.inventory.add(item);
        } else {
            System.out.println("Limite máximo de itens atingido!");
        }
    }

    public List<Item> getInventory(){
        return this.inventory;
    }

    public Item getEquippedItem(){
        return this.equippedItem;
    }

    public void setEquippedItem(Item equippedItem) {
        this.equippedItem = equippedItem;
    }

    public void attack(BaseCharacter target) {
        double attackSpeed = super.getAttackSpeed();
        if(equippedItem != null){
            attackSpeed = equippedItem.getAttackSpeed();
        }
        for(int i = 0; i < ((int) (attackSpeed / 0.5)); i++){
            int finalDamage = calcDamage();
            target.takeDamage(finalDamage);
            System.out.println(super.getName() + " atacou " + target.getName() + " causando " + finalDamage + " de dano.");
        }
    }

    private int calcDamage(){
        Random r = new Random();
        int damage = super.getDamage();
        if(equippedItem != null){
            damage = r.nextInt(equippedItem.getDamage().min, equippedItem.getDamage().max);
        }

        return (int) (damage + ( damage * new Random().nextDouble(0, 1)));
    }


}
