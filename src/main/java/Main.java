import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int homeOpt;

        RulesAndOptions rules_options = new RulesAndOptions();
        while (true){
            try(Scanner sc = new Scanner(System.in)){ // Recebe a oção do usuário e faz as verficações de erro necessárias.
                while (true){
                    try{
                        rules_options.homeOptions();
                        homeOpt = sc.nextInt();
                        if(homeOpt<=0 || homeOpt>4){
                            System.out.println("Oopção inválida inserida");
                        }else if (homeOpt == 4){
                            System.out.println("Jogo encerrado com sucesso!");
                            System.exit(0);
                        } else {
                            break;
                        }
                    } catch (Exception e){
                        System.out.println("Insira apenas números:");
                        sc.nextLine();
                    }
                }
            }
            System.out.println("funcionou");
            break;
        }
    }
}
