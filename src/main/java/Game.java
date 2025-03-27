public class Game {
    private String difficulty; // 1 - Fácil, 2 - Médio e 3 - Difícil
    private int points, attempts, lossPoints,randomNumber;

    public Game(int difficulty) {
        switch (difficulty){
            case 1 ->{
                this.difficulty = "Fácil";
                this.points = 100;
                this.attempts = 10;
                this.lossPoints = 8;
                this.randomNumber = (int) (Math.random() * 49)+1;
            }
            case 2 ->{
                this.difficulty = "Médio";
                this.points = 200;
                this.attempts = 7;
                this.lossPoints = 20;
                this.randomNumber = (int) (Math.random() * 99)+1;
            }
            case 3 ->{
                this.difficulty = "Difícil";
                this.points = 300;
                this.attempts = 5;
                this.lossPoints = 50;
                this.randomNumber = (int) (Math.random() * 199)+1;
            }
            default -> System.err.println("Opção inválida inserida");
        }
    }

    public Boolean verifyNumber(int number){
        if(number == randomNumber){
            points += (attempts*50);
            System.out.println("Parabéns, você acertou o número!");
            System.out.println("Pontuação: " + points);
            return true;
        }else {
            points -= lossPoints;
            attempts -= 1;
            if(attempts == 0){
                System.out.println("Suas tentativas acabaram, inicie um novo jogo.");
            }else {
                System.out.printf("tente novamente \n tentativas restantes: %d \n ---------- \n", attempts);
            }
            return false;
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
