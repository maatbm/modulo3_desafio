public class Game {
    private String difficulty; // 1 - Fácil, 2 - Médio e 3 - Difícil
    private int points, attempts, randomNumber;

    public Game(int difficulty) {
        switch (difficulty){
            case 1:
                this.difficulty = "Fácil";
                this.points = 100;
                this.attempts = 10;
                this.randomNumber = (int) (Math.random() * 49)+1;
                System.out.println("Número aleatório, fácil: " + randomNumber);
                break;
            case 2:
                this.difficulty = "Médio";
                this.points = 200;
                this.attempts = 7;
                this.randomNumber = (int) (Math.random() * 99)+1;
                System.out.println("Número aleatório, médio: " + randomNumber);
                break;
            case 3:
                this.difficulty = "Difícil";
                this.points = 300;
                this.attempts = 5;
                this.randomNumber = (int) (Math.random() * 199)+1;
                System.out.println("Número aleatório, difícil: " + randomNumber);
                break;
        }
    }

    public Boolean verifyNumber(int number){
        if(number == randomNumber){
            points += (attempts*50);
            return true;
        }else {
            points -= 15;
            attempts -= 1;
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
