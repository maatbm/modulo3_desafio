import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private final String difficulty; // 1 - Fácil, 2 - Médio e 3 - Difícil
    private int points, attempts, randomNumber, limit = 0;
    private final int lossPoints;

    ArrayList<Integer> randomSequence = new ArrayList<>(3);

    public Game(int difficulty) {
        switch (difficulty) {
            case 1 -> {
                this.difficulty = "Fácil";
                this.points = 100;
                this.attempts = 10;
                this.lossPoints = 8;
                this.limit = 50;
                this.randomNumber = (int) (Math.random() * (limit-1)) + 1;
            }
            case 2 -> {
                this.difficulty = "Médio";
                this.points = 200;
                this.attempts = 7;
                this.lossPoints = 20;
                this.limit = 100;
                this.randomNumber = (int) (Math.random() * (limit-1)) + 1;
            }
            case 3 -> {
                this.difficulty = "Difícil";
                this.points = 300;
                this.attempts = 5;
                this.lossPoints = 50;
                this.limit = 200;
                this.randomNumber = (int) (Math.random() * (limit-1)) + 1;
            }
            case 4 -> {
                this.difficulty = "Modo sequência";
                this.points = 500;
                this.attempts = 15;
                this.lossPoints = 30;
                for (int i = 0; i < 3; i++) {
                    randomSequence.add((int) (Math.random() * 49) + 1);
                }
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
                }else {
                    System.out.print("Quer uma dica? \n1 - Sim \n2 - Não \n");
                    int opt = sc.nextInt();
                    if(opt ==1 ){
                        while (true){
                            try {
                                RulesAndOptions.tipsOptions();
                                int tipOpt = sc.nextInt();
                                enterTip(tipOpt, number);
                                break;
                            }catch (IllegalArgumentException e){
                                System.out.println("Opção inválida");
                            }catch (InputMismatchException e){
                                System.out.println("Insira apenas números inteiors");
                                sc.nextLine();
                            }
                        }
                    }
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

    // Checks the number entered by the user
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
            differenceTip(number, randomNumber);
            return false;
        }
    }

    // Tips
    private void enterTip(int option, int number){
        switch (option){
            case 1 -> parityTip();
            case 2 -> halfTip(number);
            case 3 -> hotColdTip(number);
            default -> throw new IllegalArgumentException();
        }
    }

    private static void differenceTip(int number, int randomNumber) {
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

    private void parityTip(){
        if(randomNumber%2==0){
            System.out.println("o número aleatório é par");
        }else {
            System.out.println("O número aleatório é ímpar");
        }
        points -= 10;
    }

    private void halfTip(int number){
        if(limit/2>number){
            System.out.println("O número aleatório está na metade inferior");
        }else {
            System.out.println("O número aleatório está na metade superior");
        }
        points -= 20;
    }

    private void hotColdTip(int number){
        int difference = Math.abs(number - randomNumber);
        if(difference<=5){
            System.out.println("Você está MUITO quente");
        } else if (difference<=10){
            System.out.println("Você está quente");
        } else if (difference<=15){
            System.out.println("Você está morno");
        }else {
            System.out.println("Você está frio");
        }
        points -= 15;
    }

    // Handling score history
    public static void addGameHistory(ArrayList<Game> gameArrayList, Game game) {
        if(gameArrayList.isEmpty() || gameArrayList.get(0).getPoints() < game.getPoints()){
            gameArrayList.add(0, game);
            System.out.println("Parabéns! Você atingiu um novo recorde!");
        } else if (gameArrayList.size() < 10) {
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
            for (int i = 1; i <gameArrayList.size(); i++) {
                System.out.println("Jogo " + i);
                System.out.println("Dificuldade: " + gameArrayList.get(i).getDifficulty());
                System.out.println("Pontuação: " + gameArrayList.get(i).getPoints());
                System.out.println("----------");
            }
            System.out.println("RECORDE");
            System.out.println("Dificuldade: " + gameArrayList.get(0).getDifficulty());
            System.out.println("Pontos: " + gameArrayList.get(0).getPoints());
            System.out.println("----------");
        }
    }

    // Getters and setters
    public String getDifficulty() {
        return difficulty;
    }

    public int getPoints() {
        return points;
    }
}
