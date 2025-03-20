public class Game {
    private String difficulty; // 1 - Fácil, 2 - Médio e 3 - Difícil
    private int points;
    private int attempts;
    private int randomNumber;

    public Game(int difficulty) {
        switch (difficulty){
            case 1:
                this.difficulty = "Fácil";
                this.points = 100;
                this.attempts = 10;
                this.randomNumber = (int) (Math.random() * 49)+1;
                break;
            case 2:
                this.difficulty = "Médio";
                this.points = 200;
                this.attempts = 7;
                this.randomNumber = (int) (Math.random() * 99)+1;
                break;
            case 3:
                this.difficulty = "Difícil";
                this.points = 300;
                this.attempts = 5;
                this.randomNumber = (int) (Math.random() * 199)+1;
                break;
        }
    }
}
