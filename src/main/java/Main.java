import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Game> gameHistory = new ArrayList<>(10);

        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                try {
                    RulesAndOptions.homeOptions();
                    int homeOpt = sc.nextInt();

                    switch (homeOpt) {
                        case 1 -> {
                            RulesAndOptions.difficulties();
                            int difficulty = sc.nextInt();
                            Game game = new Game(difficulty);
                            game.enterNumber(sc);
                            Game.addGameHistory(gameHistory, game);
                        }
                        case 2 -> RulesAndOptions.rules();
                        case 3 -> Game.showGameHistory(gameHistory);
                        case 4 -> {
                            System.out.println("Jogo encerrado com sucesso!");
                            return;
                        }
                        default -> System.err.println("Opção inválida inserida");
                    }

                } catch (IllegalArgumentException e) {
                    System.err.println("Dificuldade inválida, tente novamente");
                } catch (Exception e) {
                    System.err.println("Ocorreu algum erro ao executar o sistema, tente novamente " + e);
                    sc.nextLine();
                }
            }
        }
    }
}