package radioactivity.system;

import radioactivity.entities.Enemy;
import radioactivity.entities.Player;
import radioactivity.system.util.Terminal;
import radioactivity.entities.Item;

import java.util.List;
import java.util.Scanner;

public class Battle {

    Player player;
    Enemy enemy;

    public Battle(Player player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;

    }

    public boolean start(){
        boolean turn = true;
        while(player.isAlive() && enemy.isAlive()){
            if(turn){
                System.out.println("""
                        
                        [1] atacar
                        [2] ver inventário""");

                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                int opt = Terminal.tryParseToInt(input);

                if(opt == 2){
                    List<Item> inventory = player.getInventory();

//                    System.out.println(inventory);
//                    System.out.println(equippedItem);
                    if (inventory.size() > 0){
//                        System.out.println("HERE");
//                        System.out.println(inventory.get(0));
                        System.out.println("Inventário: ");
                        System.out.println(" Id \t | nome \t | dano \t | cura ");
                        System.out.println("--------------------------------------");

                        for(int i = 0; i < inventory.size(); i++){
                            System.out.println("["+ (i+1) +"]" + " \t | "
                                    + inventory.get(i).getName() + " \t | "
                                    + inventory.get(i).getDamage() + " \t | "
                                    + inventory.get(i).getHealing() + " "
                            );
                        }
                    }

                    if(player.getEquippedItem() != null){
                        System.out.println("\nItem equipado: " + player.getEquippedItem().getName());
                        System.out.println();
                    }
                    System.out.println("""    
                        [0] atacar 
                        [Id item] Usar item""");

                    input = scanner.nextLine();
                    opt = Terminal.tryParseToInt(input);
                    System.out.println(opt);
                    System.out.println(opt-1);
                    if(opt-1 >= 0 && opt-1 < inventory.size()){
                        System.out.println("Entrou no if");
                        if(inventory.get(opt-1).getHealing() > 0){
                            if(player.getLife() == 100){
                                System.out.println("Sua Vida já está cheia");
                            }
                            else{
                                System.out.println("Você usou o item: " + inventory.get(opt-1).getName());
                                player.setLife(player.getLife() + inventory.get(opt-1).getHealing());

                                if (player.getLife() > 100){
                                    player.setLife(100);
                                }
                                System.out.println("Você se curou e sua vida atual é: " + player.getLife());
                                player.removeItem(inventory.get(opt-1));
                            }
                        }
                        else{
                            if(player.getEquippedItem() != null){
                                Item temp = new Item(
                                    player.getEquippedItem().getDamage(),
                                    player.getEquippedItem().getAttackSpeed(),
                                    player.getEquippedItem().getSize(),
                                    player.getEquippedItem().getName(),
                                    player.getEquippedItem().getUsages()
                                );
                                player.setEquippedItem(inventory.get(opt-1));
                                player.removeItem(inventory.get(opt-1));
                                player.addItem(temp);
                            }
                            else {
                                player.setEquippedItem(inventory.get(opt-1));
                                player.removeItem(inventory.get(opt-1));
                            }
                        }
                    } else if (opt == 0) {
                        player.attack(enemy);
                        turn = false;
                    } else {
                        System.out.println("\nEscolha uma opção válida!!!\n");
                    }

                }
                else if(opt == 1){
                    player.attack(enemy);
                    turn = false;
                }
                else{
                    System.out.println("Escolha uma opção válida");
                }

            }
            else {
                System.out.println("\nVez do Inimigo: ");
                enemy.attack(player);
                turn = true;
            }
        }
        return player.isAlive();
    }



}
