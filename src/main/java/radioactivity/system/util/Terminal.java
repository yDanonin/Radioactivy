package radioactivity.system.util;

import java.util.Scanner;

public class Terminal {
    public static void clearTerminal(){
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if(System.getProperty("os.name").contains("Linux")) {
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int tryParseToInt(String i){
        try{
            int res = Integer.parseInt(i);
            return res;
        } catch (Exception e){
            System.out.println("Tente digitar algum número");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            return tryParseToInt(input);
        }
    }
}
