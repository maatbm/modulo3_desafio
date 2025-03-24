import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int homeOpt;

        RulesAndOptions rules_options = new RulesAndOptions();
        Scanner sc = new Scanner(System.in);
        while (true){
            while (true){
                try{
                    rules_options.homeOptions();
                    homeOpt = sc.nextInt();
                    if(homeOpt<=0 || homeOpt>4){
                        System.out.println("Oopção inválida inserida");
                    } else {
                        break;
                    }
                } catch (Exception e){
                    System.out.println("Insira apenas números:");
                    sc.nextLine();
                }
            }

            switch (homeOpt){
                case 1:
                    rules_options.difficulties();
                    int difficulty = sc.nextInt();
                    Game game = new Game(difficulty);
                    for(int i = game.getAttempts(); i>0; i--){
                        System.out.println("Tentativas restantes: " + i);
                        System.out.println("Insira um número inteiro:");
                        int opt = sc.nextInt();
                        if (game.verifyNumber(opt)){
                            System.out.println("Parabéns, você acertou!");
                            System.out.println("Pontos obtidos: " + game.getPoints());
                            break;
                        }else {
                            if(i != 1){
                                System.out.println("Tente novamente");
                            }
                        }
                        if(i == 1){
                            System.out.println("Suas tentativas acabaram, inicie um novo jogo");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Regras");
                    break;
                case 3:
                    System.out.println("Histórico de pontuações");
                    break;
                case 4:
                    System.out.println("Jogo encerrado com sucesso!");
                    System.exit(0);
            }
        }
    }
}
