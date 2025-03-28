public class Game {
    private final String difficulty; // 1 - Fácil, 2 - Médio e 3 - Difícil
    private int points, attempts;
    private final int lossPoints;
    private final int randomNumber;

    public Game(int difficulty) {
        switch (difficulty) {
            case 1 -> {
                this.difficulty = "Fácil";
                this.points = 100;
                this.attempts = 10;
                this.lossPoints = 8;
                this.randomNumber = (int) (Math.random() * 49) + 1;
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
            }
            default -> throw new IllegalArgumentException();
        }
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
            int difference = Math.abs(number - randomNumber);
            differenceTricky(difference);
            return false;
        }
    }

    private void differenceTricky(int difference) {
        if (attempts > 0) {
            if (difference <= 5) {
                System.out.println("Você está extremamente perto!");
            } else if (difference <= 15) {
                System.out.println("Você está perto do número!");
            } else if (difference <= 30) {
                System.out.println("Ainda não está tão perto");
            } else {
                System.out.println("Você está bem longe do número.");
            }
            System.out.printf("Tente novamente \nTentativas restantes: %d \n----------\n", attempts);
        } else {
            System.out.println("Suas tentativas acabaram, inicie um novo jogo.");
            System.out.println("O número correto era: " + randomNumber);
        }
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getPoints() {
        return points;
    }

    public int getAttempts() {
        return attempts;
    }
}
