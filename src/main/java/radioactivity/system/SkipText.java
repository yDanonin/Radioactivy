package radioactivity.system;

import radioactivity.system.util.Terminal;

import java.util.Scanner;

public class SkipText implements Runnable{
    TextAnimation textAnimation;
    Thread thread;


    public SkipText(TextAnimation textAnimatio, Thread thread ) {
        this.textAnimation = textAnimatio;
        this.thread = thread;
    }

    @Override
    public void run(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        textAnimation.stopAnimation();

    }

}
