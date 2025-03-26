import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int homeOpt;
        int gameHistoryIndex = 0;

        RulesAndOptions rules_options = new RulesAndOptions();
        Scanner sc = new Scanner(System.in);
        Game[] gameHistory = new Game[10];

        while (true) {
            do{
                rules_options.homeOptions();
                homeOpt = sc.nextInt();
                if (homeOpt <= 0 || homeOpt > 4) {
                    System.out.println("Oopção inválida inserida");
                }
            }while (homeOpt<=0 || homeOpt>4);

            switch (homeOpt) {
                case 1:
                    rules_options.difficulties();
                    int difficulty = sc.nextInt();
                    Game game = new Game(difficulty);
                    for (int i = game.getAttempts(); i > 0; i--) {
                        System.out.println("Tentativas restantes: " + (i - 1));
                        System.out.println("Insira um número inteiro:");
                        int opt = sc.nextInt();
                        if (game.verifyNumber(opt)) {
                            System.out.println("Parabéns, você acertou!");
                            System.out.println("Pontos obtidos: " + game.getPoints());
                            break;
                        } else {
                            if (i != 1) {
                                System.out.println("Tente novamente");
                            }
                        }
                    }
                    System.out.println("Suas tentativas acabaram, inicie um novo jogo");
                    gameHistory[gameHistoryIndex] = game;
                    gameHistoryIndex ++;
                    break;
                case 2:
                    System.out.println("Regras");
                    break;
                case 3:
                    System.out.println("Histórico de pontuações:");
                    for(int i=0; i<gameHistory.length; i++){
                        if(gameHistory[i] != null){
                            System.out.println("Jogo: " + (i+1));
                            System.out.println("Pontuação: " + gameHistory[i].getPoints());
                            System.out.println("Dificuldade: " + gameHistory[i].getDifficulty());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Jogo encerrado com sucesso!");
                    System.exit(0);
            }
        }
    }
}