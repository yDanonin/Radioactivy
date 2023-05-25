package radioactivity.story;

public class SecondBattle {
    public static String secondBattleTitle() {
        return """
                 Seu Abílio x Criaturas Mutantes.
               
               """;
    }
    public static String storySecondBattle() {
        return """
                 Após uma árdua batalha contra essas criaturas, Seu Abílio saiu vitorioso,
                 com seu instinto nato de detetive ele começou a investigar a cena,
                 ele notou que esses animais haviam deixado alguns rastros de sujeira e pus
                 que escorriam de seus corpos pela rua, e decidiu os seguir.
                 Ao final dos rastros deixados pelas criaturas, seu Abílio chegou a um bueiro,
                 o que o levou a conclusão de que os animais teriam vindo do esgoto da cidade.
                 O detetive desce ao sistema de esgoto de Chernoville, e lá logo de cara
                 encontra mais animais parecidos com os que atacaram os cidadãos nas ruas.
                 
                 Faça sua escolha:
                 
                 [1] Lutar
                 
                 [2] Fugir
                 
                """;

    }
    public static String playerWinsSecondBattle() {
        return """
                 Novo item obtido:
                                
                 Machado de Lenhador
                 Dano: 12 - 14
                 Vel. ataque: 1.5
                """;
    }
    public static String playerRunsSecondBattle() {
        return """
                 Após uma batalha intensa como a anterior, seu Abílio não se sentia preparado
                 no momento para enfrentar inimigos novamente, por isso tomou a sábia decisão de recuar.
                """;
    }
}