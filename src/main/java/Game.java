import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private final String difficulty; // 1 - Fácil, 2 - Médio e 3 - Difícil
    private int points, attempts;
    private final int lossPoints;
    private int randomNumber = 0;
    ArrayList<Integer> randomSequence = new ArrayList<>(3);

    public Game(int difficulty) {
        switch (difficulty) {
            case 1 -> {
                this.difficulty = "Fácil";
                this.points = 100;
                this.attempts = 10;
                this.lossPoints = 8;
                this.randomNumber = (int) (Math.random() * 49) + 1;
                System.out.println(randomNumber);
            }
            case 2 -> {
                this.difficulty = "Médio";
                this.points = 200;
                this.attempts = 7;
                this.lossPoints = 20;
                this.randomNumber = (int) (Math.random() * 99) + 1;
            }
            case 3 -> {
                this.difficulty = "Difícil";
                this.points = 300;
                this.attempts = 5;
                this.lossPoints = 50;
                this.randomNumber = (int) (Math.random() * 199) + 1;
                System.out.println(randomNumber);
            }
            case 4 -> {
                this.difficulty = "Modo sequência";
                this.points = 500;
                this.attempts = 15;
                this.lossPoints = 30;
                for (int i = 0; i < 3; i++) {
                    randomSequence.add((int) (Math.random() * 49) + 1);
                }
                System.out.println(randomSequence);
            }
            default -> throw new IllegalArgumentException();
        }
    }

    public void enterNumber(Scanner sc) {
        int number;
        for (int i = attempts; i > 0; i--) {
            while (true) {
                try {
                    System.out.println("Insira um número inteiro");
                    number = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Insira apenas números inteiros");
                    sc.nextLine();
                }
            }
            if (difficulty.equals("Modo sequência")) {
                if(verifySequenceNumber(number)){
                    break;
                }
            } else {
                if(verifyNumber(number)){
                    break;
                }
            }
            System.out.println("Tentativas restantes: " + attempts);
            System.out.println("----------");
            if (i == 1) {
                System.err.println("suas tentativas acabaram, inicie um novo jogo");
                System.out.println("O número era: " + randomNumber);
            }
        }
    }

    public Boolean verifySequenceNumber(int number) {
        Integer numberObj = number;
        if (randomSequence.contains(numberObj)) {
            randomSequence.remove(numberObj);
            if (randomSequence.isEmpty()) {
                points += (attempts*50);
                System.out.println("Você acertou todos os números da lista!");
                System.out.println("Pontuação obtida: " + points);
                return true;
            } else {
                System.out.println("Parabéns, você acertou um dos números da lista!");
            }
        }
        points -= lossPoints;
        attempts -= 1;
        return false;
    }

    public Boolean verifyNumber(int number) {
        if (number == randomNumber) {
            points += (attempts * 50);
            System.out.println("Parabéns, você acertou o número!");
            System.out.println("Pontuação: " + points);
            return true;
        } else {
            points -= lossPoints;
            attempts -= 1;
            differenceTricky(number, randomNumber);
            return false;
        }
    }

    private static void differenceTricky(int number, int randomNumber) {
        int difference = Math.abs(number - randomNumber);
        if (difference <= 5) {
            System.out.println("Você está extremamente perto, tente novamente");
        } else if (difference <= 15) {
            System.out.println("Você está perto do número, tente novamente");
        } else if (difference <= 30) {
            System.out.println("Ainda não está tão perto, tente novamente");
        } else {
            System.out.println("Você está bem longe do número, tente novamente");
        }
    }

    public static void addGameHistory(ArrayList<Game> gameArrayList, Game game) {
        if (gameArrayList.size() < 10) {
            gameArrayList.add(game);
        } else {
            System.err.print("Limite de partidas no histórico atingido. \nAs próximas partidas não serão salvas.");
        }
    }

    public static void showGameHistory(ArrayList<Game> gameArrayList) {
        System.out.println("HISTÓRICO DE PARTIDAS");
        if (gameArrayList.isEmpty()) {
            System.err.println("Histórico vazio, complete ao menos uma partida");
        } else {
            for (int i = 0; i < gameArrayList.size(); i++) {
                System.out.println("Jogo " + (i + 1));
                System.out.println("Dificuldade: " + gameArrayList.get(i).getDifficulty());
                System.out.println("Pontuação: " + gameArrayList.get(i).getPoints());
                System.out.println("----------");
            }
        }
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getPoints() {
        return points;
    }
}
