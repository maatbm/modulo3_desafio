import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int homeOpt;
        int gameHistoryIndex = 0;

        RulesAndOptions rules_options = new RulesAndOptions();
        Scanner sc = new Scanner(System.in);
        Game[] gameHistory = new Game[10];

        while (true) {
            try {
                rules_options.homeOptions();
                homeOpt = sc.nextInt();

                switch (homeOpt) {
                    case 1 -> {
                        rules_options.difficulties();
                        int difficulty = sc.nextInt();
                        Game game = new Game(difficulty);
                        for (int i = game.getAttempts(); i > 0; i--) {
                            System.out.println("Insira um número inteiro:");
                            int opt = sc.nextInt();
                            if (game.verifyNumber(opt)) {
                                break;
                            }
                        }
                        gameHistory[gameHistoryIndex] = game;
                        gameHistoryIndex++;
                    }
                    case 2 -> rules_options.rules();
                    case 3 -> {
                        System.out.println("Histórico de pontuações:");
                        for (int i = 0; i < gameHistory.length; i++) {
                            if (gameHistory[i] != null) {
                                System.out.println("Jogo: " + (i + 1));
                                System.out.println("Pontuação: " + gameHistory[i].getPoints());
                                System.out.println("Dificuldade: " + gameHistory[i].getDifficulty());
                                System.out.println("----------");
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Jogo encerrado com sucesso!");
                        System.exit(0);
                    }
                    default -> System.err.println("Opção inválida inserida");
                }

            } catch (IllegalArgumentException e) {
                System.err.println("Dificuldade inválida, tente novamente");
            } catch (Exception e) {
                System.err.println("Ocorreu algum erro ao executar o sistema, tente novamente");
                sc.nextLine();
            }
        }
    }
}