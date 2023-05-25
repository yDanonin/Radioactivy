package radioactivity.system;

import radioactivity.story.PlayerDies;
import radioactivity.system.util.Terminal;
import radioactivity.graphics.GameOver;

import java.util.Scanner;

public class WriteGameOver {
    public static void write() throws InterruptedException {
        Thread.sleep(5000);

        Terminal.clearTerminal();

        TextAnimation store = new TextAnimation(PlayerDies.storyPlayerDies(), 40);
        Thread t = new Thread(store);
        t.start();
        t.join();

        TextAnimation gameOver = new TextAnimation(GameOver.drawGameOver(), 20);
        Thread t1 = new Thread(gameOver);
        t1.start();
        t1.join();

        System.out.println("Pressione Enter");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
