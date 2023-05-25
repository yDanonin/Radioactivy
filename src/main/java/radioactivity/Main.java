package radioactivity;


import radioactivity.graphics.Titles;
import radioactivity.story.*;
import radioactivity.entities.*;
import radioactivity.system.SkipText;
import radioactivity.system.TextAnimation;
import radioactivity.system.WriteGameOver;
import radioactivity.system.util.Terminal;
import java.util.Scanner;
import radioactivity.system.Battle;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean flag = true;

        while(flag) {

            Terminal.clearTerminal();

            TextAnimation title = new TextAnimation(Titles.drawGameName(), 0);
            Thread thTitle = new Thread(title);
            thTitle.start();
            thTitle.join();


            System.out.println("Select option");
            System.out.println("[1] start");
            System.out.println("[2] exit");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int opt = Terminal.tryParseToInt(input);

            switch (opt){
                case 1:
                    // faça tudo

                    Terminal.clearTerminal();
                    TextAnimation textAnimation = new TextAnimation(InitialStory.storyPrologue());
                    Thread t = new Thread(textAnimation);
                    Thread inputThread = new Thread(new SkipText(textAnimation, t));
                    inputThread.start();
                    t.start();
                    t.join();


                    TextAnimation textAnimation2 = new TextAnimation(InitialStory.storyBeginning(), 20);
                    Thread t2 = new Thread(textAnimation2);
                    Thread inputThread2 = new Thread(new SkipText(textAnimation2, t2));
                    inputThread2.start();
                    t2.start();
                    t2.join();



                    // Primeira Fase

                    TextAnimation textAnimation3 = new TextAnimation(FirstBattle.firstBattleTitle(), 20);
                    Thread t3 = new Thread(textAnimation3);
                    Thread inputThread3 = new Thread(new SkipText(textAnimation3, t3));
                    inputThread3.start();
                    t3.start();
                    t3.join();

                    TextAnimation textAnimation4 = new TextAnimation(FirstBattle.storyFirstBattle(), 20);
                    Thread t4 = new Thread(textAnimation4);
                    Thread inputThread4 = new Thread(new SkipText(textAnimation4, t4));
                    inputThread4.start();
                    t4.start();
                    t4.join();

                    Player mainCharacter = new Player("Seu Abílio", 100, 5, 0.5);
                    Enemy firstRadioactiveCreatures = new Enemy("Primeiras Criaturas Radioativas", 100, 3, 1);

                    Interval pieceOfWoodInterval = new Interval();
                    pieceOfWoodInterval.min = 4;
                    pieceOfWoodInterval.max = 6;
                    Item pieceOfWood = new Item(pieceOfWoodInterval, 1.0, 1, "Pedaço de Madeira");

                    Interval rustyPipeInterval = new Interval();
                    rustyPipeInterval.min = 8;
                    rustyPipeInterval.max = 12;
                    Item rustyPipe = new Item(rustyPipeInterval, 0.5, 1, "Cano Enferrujado");

                    Interval pieceOfGlassInterval = new Interval();
                    pieceOfGlassInterval.min = 6;
                    pieceOfGlassInterval.max = 12;
                    Item pieceOfGlass = new Item(pieceOfGlassInterval, 0.5, 1, "Pedaço de Vidro");

                    input = scanner.nextLine();
                    opt = Terminal.tryParseToInt(input);
                    boolean f = true;
                    while (f) {
                        switch (opt) {
                            case 1 -> {
                                mainCharacter.setEquippedItem(pieceOfWood);
                                f = false;
                            }
                            case 2 -> {
                                mainCharacter.setEquippedItem(rustyPipe);
                                f = false;
                            }
                            case 3 -> {
                                mainCharacter.setEquippedItem(pieceOfGlass);
                                f = false;
                            }
                            default -> {
                                input = scanner.nextLine();
                                opt = Terminal.tryParseToInt(input);
                            }
                        }
                    }

                    Battle firstBattle = new Battle(mainCharacter, firstRadioactiveCreatures);

                    if(!firstBattle.start()){
                        WriteGameOver.write();
                        break;
                    }

//                     Segunda fase

                    TextAnimation textAnimation5 = new TextAnimation(SecondBattle.storySecondBattle(), 20);
                    Thread t5 = new Thread(textAnimation5);
                    Thread inputThread5 = new Thread(new SkipText(textAnimation5, t5));
                    inputThread5.start();
                    t5.start();
                    t5.join();

                    input = scanner.nextLine();
                    opt = Terminal.tryParseToInt(input);

                    f = true;
                    while (f) {
                        switch (opt) {
                            case 1 -> {
                                TextAnimation textAnimation6 = new TextAnimation(SecondBattle.secondBattleTitle(), 20);
                                Thread t6 = new Thread(textAnimation6);
                                Thread inputThread6 = new Thread(new SkipText(textAnimation6, t6));
                                inputThread6.start();
                                t6.start();
                                t6.join();

                                Enemy radioactiveCreatures = new Enemy("Criaturas Radioativas", 150, 5, 0.5);
                                Battle secondBattle = new Battle(mainCharacter, radioactiveCreatures);

                                if(!secondBattle.start()){
                                    WriteGameOver.write();
                                    f = false;
                                    break;
                                } else{
                                    Interval lumberjackAxeInterval = new Interval();
                                    lumberjackAxeInterval.min = 12;
                                    lumberjackAxeInterval.max = 14;
                                    Item lumberjackAxe = new Item(lumberjackAxeInterval, 1.5, 2, "Machado de Lenhador");

                                    mainCharacter.addItem(mainCharacter.getEquippedItem());
                                    mainCharacter.setEquippedItem(lumberjackAxe);

                                    TextAnimation textAnimation7 = new TextAnimation(SecondBattle.playerWinsSecondBattle(), 20);
                                    Thread t7 = new Thread(textAnimation7);
                                    Thread inputThread7 = new Thread(new SkipText(textAnimation7, t7));
                                    inputThread7.start();
                                    t7.start();
                                    t7.join();
                                }
                                f = false;
                            }
                            case 2 -> {
                                TextAnimation textAnimation8 = new TextAnimation(SecondBattle.playerRunsSecondBattle(), 20);
                                Thread t8 = new Thread(textAnimation8);
                                Thread inputThread8 = new Thread(new SkipText(textAnimation8, t8));
                                inputThread8.start();
                                t8.start();
                                t8.join();
                                f = false;
                            }
                            default -> {
                                System.out.println("Escolha um valor válido");
                                input = scanner.nextLine();
                                opt = Terminal.tryParseToInt(input);
                            }
                        }
                    }



                    TextAnimation textAnimation9 = new TextAnimation(MiddleStory.storyMiddle(), 20);
                    Thread t9 = new Thread(textAnimation9);
                    Thread inputThread9 = new Thread(new SkipText(textAnimation9, t9));
                    inputThread9.start();
                    t9.start();
                    t9.join();

                    input = scanner.nextLine();
                    opt = Terminal.tryParseToInt(input);

                    f = true;

                    while(f) {
                        switch(opt) {

                            // Ir atrás do caminhão.
                            case 1 -> {
                                TextAnimation textAnimation10 = new TextAnimation(MiddleStory.playerGoToTheTruck(), 20);
                                Thread t10 = new Thread(textAnimation10);
                                Thread inputThread10 = new Thread(new SkipText(textAnimation10, t10));
                                inputThread10.start();
                                t10.start();
                                t10.join();


                                System.out.println("Seu Abílio lembrou que quando estava em casa guardou a sua arma em sua Mochila");
                                System.out.println("Novo item adquirido: Revólver do velho detetive");

                                //tenta adicionar Arma
                                System.out.println("""
                                        Escolha a arma de batalha, a arma não selecionada será descartada
                                        \n[1] """+ " " + mainCharacter.getEquippedItem().getName() +
                                        """
                                        
                                        \n[2] Revólver do velho detetive """);

                                input = scanner.nextLine();
                                opt = Terminal.tryParseToInt(input);

                                if(opt == 2){
                                    Interval oldRevolverInterval = new Interval();
                                    oldRevolverInterval.min = 10;
                                    oldRevolverInterval.max = 50;
                                    Item oldRevolver = new Item(oldRevolverInterval, 0.5, 2, "Revólver do Velho Detetive", 6);

                                    mainCharacter.setEquippedItem(oldRevolver);

                                    System.out.println("\nRevólver equipado\n");
                                }



                                TextAnimation textAnimation11 = new TextAnimation(ThirdBattle.thirdBattleTitle(), 20);
                                Thread t11 = new Thread(textAnimation11);
                                Thread inputThread11 = new Thread(new SkipText(textAnimation11, t11));
                                inputThread11.start();
                                t11.start();
                                t11.join();

                                Enemy giantRat = new Enemy("Rato Gigante", 300, 10, 0.5);

                                Battle thirdBattle = new Battle(mainCharacter, giantRat);

                                if(!thirdBattle.start()){
                                    WriteGameOver.write();
                                    f = false;
                                    break;
                                }

                                f = false;
                            }

                            // [2] Ir direto ao departamento de polícia.
                            case 2 -> {
                                TextAnimation textAnimation12 = new TextAnimation(MiddleStory.playerGoToPoliceDepartment(), 20);
                                Thread t12 = new Thread(textAnimation12);
                                Thread inputThread12 = new Thread(new SkipText(textAnimation12, t12));
                                inputThread12.start();
                                t12.start();
                                t12.join();

                                input = scanner.nextLine();
                                opt = Terminal.tryParseToInt(input);

                                flag = true;
                                while(flag){
                                    if(opt == 1){
                                        TextAnimation textAnimation13 = new TextAnimation(SurpriseBattle.surpriseBattleTitle(), 20);
                                        Thread t13 = new Thread(textAnimation13);
                                        Thread inputThread13 = new Thread(new SkipText(textAnimation13, t13));
                                        inputThread13.start();
                                        t13.start();
                                        t13.join();

                                        Enemy ratsNest = new Enemy("Ninho de Ratos", 200, 6, 1);

                                        Battle surpriseBattle = new Battle(mainCharacter, ratsNest);
                                        if(!surpriseBattle.start()){
                                            WriteGameOver.write();
                                            break;
                                        }

                                        flag = false;
                                        break;
                                    } else if (opt == 2){
                                        TextAnimation textAnimation14 = new TextAnimation(MiddleStory.playerRunsSurpriseBattle(), 20);
                                        Thread t14 = new Thread(textAnimation14);
                                        Thread inputThread14 = new Thread(new SkipText(textAnimation14, t14));
                                        inputThread14.start();
                                        t14.start();
                                        t14.join();

                                        input = scanner.nextLine();
                                        opt = Terminal.tryParseToInt(input);

                                        while(true){
                                            if(opt == 1){
                                                TextAnimation textAnimation15 = new TextAnimation(SurpriseBattle.surpriseBattleTitle(), 20);
                                                Thread t15 = new Thread(textAnimation15);
                                                Thread inputThread15 = new Thread(new SkipText(textAnimation15, t15));
                                                inputThread15.start();
                                                t15.start();
                                                t15.join();

                                                Enemy ratsNest = new Enemy("Ninho de Ratos", 200, 6, 1);

                                                Battle surpriseBattle = new Battle(mainCharacter, ratsNest);
                                                if(!surpriseBattle.start()){
                                                    WriteGameOver.write();
                                                    break;
                                                }

                                                flag = false;
                                                break;
                                            } else if (opt == 2){
                                                TextAnimation textAnimation16 = new TextAnimation(MiddleStory.playerRunsSurpriseBattleAgain(), 20);
                                                Thread t16 = new Thread(textAnimation16);
                                                Thread inputThread16 = new Thread(new SkipText(textAnimation16, t16));
                                                inputThread16.start();
                                                t16.start();
                                                t16.join();

                                                TextAnimation textAnimation17 = new TextAnimation(SpecialBattle.specialBattleTitle(), 20);
                                                Thread t17 = new Thread(textAnimation17);
                                                Thread inputThread17 = new Thread(new SkipText(textAnimation17, t17));
                                                inputThread17.start();
                                                t17.start();
                                                t17.join();

                                                Enemy theFear = new Enemy("O Medo", 300, 5, 0.5);
                                                Battle specialBattle = new Battle(mainCharacter, theFear);

                                                if(!specialBattle.start()){
                                                    WriteGameOver.write();
                                                    f = false;
                                                    break;
                                                }

                                                TextAnimation textAnimation18 = new TextAnimation(SpecialBattle.playerWinsSpecialBattleTitle(), 20);
                                                Thread t18 = new Thread(textAnimation18);
                                                Thread inputThread18 = new Thread(new SkipText(textAnimation18, t18));
                                                inputThread18.start();
                                                t18.start();
                                                t18.join();

                                                input = scanner.nextLine();
                                                opt = Terminal.tryParseToInt(input);

                                                if(opt == 1){
                                                    Item medicalKit = new Item(2, "Kit Médico", 1, 100);
                                                    mainCharacter.addItem(medicalKit);
                                                }

                                                TextAnimation textAnimation19 = new TextAnimation(SurpriseBattle.playerWinsSurpriseBattle(), 20);
                                                Thread t19 = new Thread(textAnimation19);
                                                Thread inputThread19 = new Thread(new SkipText(textAnimation19, t19));
                                                inputThread19.start();
                                                t19.start();
                                                t19.join();

                                                Enemy giantRat = new Enemy("Rato Gigante", 300, 10, 0.5);

                                                Battle thirdBattle = new Battle(mainCharacter, giantRat);
                                                if(!thirdBattle.start()){
                                                    WriteGameOver.write();
                                                    break;
                                                }

                                                flag = false;
                                                break;
                                            } else{
                                                System.out.println("Escolha uma opção válida");
                                                input = scanner.nextLine();
                                                opt = Terminal.tryParseToInt(input);
                                            }
                                        }

                                        flag = false;
                                        break;
                                    } else {
                                        System.out.println("Escolha uma opção válida");
                                        input = scanner.nextLine();
                                        opt = Terminal.tryParseToInt(input);
                                    }

                                }

                                TextAnimation textAnimation20 = new TextAnimation(MiddleStory.playerAfterWinRatsNest(), 20);
                                Thread t20 = new Thread(textAnimation20);
                                Thread inputThread20 = new Thread(new SkipText(textAnimation20, t20));
                                inputThread20.start();
                                t20.start();
                                t20.join();
                                System.out.println("Seu Abílio lembrou que quando estava em casa guardou a sua arma em sua Mochila");
                                System.out.println("Novo item adquirido: Revólver do velho detetive");

                                //tenta adicionar Arma
                                System.out.println("""
                                        Escolha a arma de batalha, a arma não selecionada será descartada
                                        \n[1] """+ " " + mainCharacter.getEquippedItem().getName() +
                                        """
                                        
                                        \n[2] Revólver do velho detetive """);

                                input = scanner.nextLine();
                                opt = Terminal.tryParseToInt(input);

                                if(opt == 2){
                                    Interval oldRevolverInterval = new Interval();
                                    oldRevolverInterval.min = 10;
                                    oldRevolverInterval.max = 50;
                                    Item oldRevolver = new Item(oldRevolverInterval, 0.5, 2, "Revólver do Velho Detetive", 6);

                                    mainCharacter.setEquippedItem(oldRevolver);

                                    System.out.println("\nRevólver equipado\n");
                                }



                                TextAnimation textAnimation21 = new TextAnimation(ThirdBattle.thirdBattleTitle(), 20);
                                Thread t21 = new Thread(textAnimation21);
                                Thread inputThread21 = new Thread(new SkipText(textAnimation21, t21));
                                inputThread21.start();
                                t21.start();
                                t21.join();

                                Enemy giantRat = new Enemy("Rato Gigante", 300, 10, 0.5);

                                Battle thirdBattle = new Battle(mainCharacter, giantRat);

                                if(!thirdBattle.start()){
                                    WriteGameOver.write();
                                    f = false;
                                    break;
                                }

                                f = false;
                            }

                            // [3] Continuar vasculhando a usina.
                            case 3 -> {
                                TextAnimation textAnimation22 = new TextAnimation(MiddleStory.playerSearchOnUsine(), 20);
                                Thread t22 = new Thread(textAnimation22);
                                Thread inputThread22 = new Thread(new SkipText(textAnimation22, t22));
                                inputThread22.start();
                                t22.start();
                                t22.join();

                                Item bandages = new Item(1, "Ataduras", 1, 60);
                                mainCharacter.addItem(bandages);

                                TextAnimation textAnimation23 = new TextAnimation(SurpriseBattle.playerWinsSurpriseBattle(), 20);
                                Thread t23 = new Thread(textAnimation23);
                                Thread inputThread23 = new Thread(new SkipText(textAnimation23, t23));
                                inputThread23.start();
                                t23.start();
                                t23.join();

                                Enemy giantRat = new Enemy("Rato Gigante", 300, 10, 0.5);

                                Battle thirdBattle = new Battle(mainCharacter, giantRat);
                                if(!thirdBattle.start()){
                                    WriteGameOver.write();
                                    break;
                                }

                                f = false;
                            }
                            default -> {
                                System.out.println("Escolha um valor válido");
                                input = scanner.nextLine();
                                opt = Terminal.tryParseToInt(input);
                            }
                        }

                    }

                    TextAnimation textAnimation20 = new TextAnimation(FinalStory.storyFinal(), 20);
                    Thread t20 = new Thread(textAnimation20);
                    Thread inputThread20 = new Thread(new SkipText(textAnimation20, t20));
                    inputThread20.start();
                    t20.start();
                    t20.join();

                    System.out.println("\n\nAperte enter para finalizar o jogo");
                    input = scanner.nextLine();
                    
                    break;
                case 2:
                    System.out.println("Bye SZ");
                    flag = false;
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
                    break;
            }
        }
        Interval pieceOfWoodInterval = new Interval();
        pieceOfWoodInterval.min = 4;
        pieceOfWoodInterval.max = 6;
        Item pieceOfWood = new Item(pieceOfWoodInterval, 1.0, 1, "Pedaço de Madeira");
//        pieceOfWood.name = "Pedaço de Madeira";
//        pieceOfWood.damage.min = 4;
//        pieceOfWood.damage.max = 6;
//        pieceOfWood.attackSpeed = 1;
//        pieceOfWood.size = 1;
        Interval rustyPipeInterval = new Interval();
        rustyPipeInterval.min = 8;
        rustyPipeInterval.max = 12;
        Item rustyPipe = new Item(rustyPipeInterval, 0.5, 1, "Cano Enferrujado");
//        rustyPipe.name = "Cano Enferrujado";
//        rustyPipe.damage.min = 8;
//        rustyPipe.damage.max = 12;
//        rustyPipe.attackSpeed = 0.5;
//        rustyPipe.size = 1;
        Interval pieceOfGlassInterval = new Interval();
        pieceOfGlassInterval.min = 6;
        pieceOfGlassInterval.max = 12;
        Item pieceOfGlass = new Item(pieceOfGlassInterval, 0.5, 1, "Pedaço de Vidro");
//        pieceOfGlass.name = "Pedaço de Vidro";
//        pieceOfGlass.damage.min = 6;
//        pieceOfGlass.damage.max = 12;
//        pieceOfGlass.attackSpeed = 0.5;
//        pieceOfGlass.size = 1;
        Interval lumberjackAxeInterval = new Interval();
        lumberjackAxeInterval.min = 12;
        lumberjackAxeInterval.max = 14;
        Item lumberjackAxe = new Item(lumberjackAxeInterval, 1.5, 2, "Machado de Lenhador");
//        lumberjackAxe.name = "Machado de Lenhador";
//        lumberjackAxe.damage.min = 12;
//        lumberjackAxe.damage.max = 14;
//        lumberjackAxe.attackSpeed = 1.5;
//        lumberjackAxe.size = 2;
        Interval oldRevolverInterval = new Interval();
        oldRevolverInterval.min = 40;
        oldRevolverInterval.max = 50;
        Item oldRevolver = new Item(oldRevolverInterval, 0.5, 2, "Revólver do Velho Detetive", 6);
//        oldRevolver.name = "Revólver do Velho Detetive";
//        oldRevolver.damage.min = 40;
//        oldRevolver.damage.max = 50;
//        oldRevolver.attackSpeed = 0.5;
//        oldRevolver.size = 2;
        Item bandages = new Item(1, "Ataduras", 1, 60);
//        bandages.name = "Ataduras";
//        bandages.size = 1;
//        bandages.healing = 60;
        Item medicalKit = new Item(2, "Kit Médico", 1, 100);
//        medicalKit.name = "Kit Médico";
//        medicalKit.size = 2;
//        medicalKit.healing = 100;

//        Player mainCharacter = new Player("Seu Abílio", 100, 5, 0.5);
//        Enemy giantRat = new Enemy("Rato Gigante", 300, 10, 0.5);
//        Enemy firstRadioactiveCreatures = new Enemy("Primeiras Criaturas Radioativas", 100, 3, 1);
//        Enemy radioactiveCreatures = new Enemy("Criaturas Radioativas", 150, 5, 0.5)
//        Enemy ratsNest = new Enemy("Ninho de Ratos", 200, 6, 1)
//        Enemy theFear = new Enemy("O Medo", 500, 5, 0.5);
//
//        Battle firstBattle = new Battle(mainCharacter, firstRadioactiveCreatures);
//        Battle secondBattle = new Battle(mainCharacter, radioactiveCreatures);
//        Battle thirdBattle = new Battle(mainCharacter, giantRat);
//        Battle surpriseBattle = new Battle(mainCharacter, ratsNest);
//        Battle specialBattle = new Battle(mainCharacter, theFear);



//        InitialStory.storyPrologue();
//        InitialStory.storyBeginning();
//        FirstBattle.firstBattleTitle();
//        FirstBattle.storyFirstBattle();
////        aqui o usuario digita qual arma ele quer pegar
////        aqui deve ser instanciada a classe battle, e feita a primeira batalha
////        se o jogador morrer, deve ser chamado
//        PlayerDies.storyPlayerDies();// gameover
//        SecondBattle.storySecondBattle();
////        aqui perguntamos se o jogador quer lutar ou fugir,
////        se ele decidir fugir se chama
//        SecondBattle.playerRunsSecondBattle();
////        se ele decidir lutar se chama:
//        SecondBattle.secondBattleTitle();
////        aqui deve ser instanciada a classe battle, e feita a segunda batalha
////        se o jogador morrer, deve ser chamado
//        PlayerDies.storyPlayerDies(); //e a batalha chamada novamente
//        SecondBattle.playerWinsSecondBattle();
//        MiddleStory.storyMiddle();
////        aqui deve ser pedido pro usuario escolher qual decisao ele vai tomar
////        se ele escolher vasculhar na usina deve ser chamado
//        MiddleStory.playerSearchOnUsine();
////        aqui ele escolhe novamente
////        se ele escolher ir direto pro caminhao
//        MiddleStory.playerGoToTheTruck();
//        ThirdBattle.thirdBattleTitle();
////        aqui deve ser instanciada a classe battle, e feita a terceira batalha
////        se ele escolher ir pro depto de policia
//        MiddleStory.playerGoToPoliceDepartment();
////        aqui o usuario deve escolher se luta ou foge, se escolher lutar deve ser chamado surpriseBattle.surpriseBattleTitle();
////        aqui deve ser instanciada a classe battle, e feita a batalha surpresa.
////        se escolher fugir, chamada
//        MiddleStory.playerRunsSurpriseBattle();
////        aqui ele escolhe entre lutar e fugir novamente, se ele lutar se chama surpriseBattle.surpriseBattleTitle e instancia a batalha
////        se ele fugir se chama
//        MiddleStory.playerRunsSurpriseBattleAgain();
//        SpecialBattle.specialBattleTitle();
////        aqui deve ser instanciada a classe battle, e feita a batalha especial
////        se ganhar chama specialBattle.playerWinsSpecialBattleTitle();
//        SurpriseBattle.surpriseBattleTitle();
////        aqui deve ser instanciada a classe battle, e feita a batalha surpresa
////        se ganhar chama
//        SurpriseBattle.playerWinsSurpriseBattle();
//        ThirdBattle.thirdBattleTitle();
////        aqui deve ser instanciada a classe battle, e feita a terceira batalha
////        NESTE PONTO AQUI, TODOS OS CAMINHOS CONVERGERAM PRA BATALHA CONTRA O RATO GIGANTE, E O JOGADOR EM TEORIA JA DERROTOU ELE
//        FinalStory.storyFinal();

    }
}