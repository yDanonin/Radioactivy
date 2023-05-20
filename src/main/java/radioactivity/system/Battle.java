package radioactivity.system;

import radioactivity.entities.Enemy;
import radioactivity.entities.Player;

public class Battle {
    public Battle(Player player, Enemy enemy){
        boolean turn = true;

        while(player.isAlive() && enemy.isAlive()){
            if(turn){
                player.attack(enemy);
                turn = false;
            }
            else {
                enemy.attack(player);
                turn = true;
            }
        }

    }

}
