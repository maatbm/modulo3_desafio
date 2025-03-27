public class RulesAndOptions {
    public void homeOptions(){
        System.out.println("Bem-vindo ao jogo de adivinhação!");
        System.out.println("1 - Iniciar novo jogo;");
        System.out.println("2 - Ver regras;");
        System.out.println("3 - Ver histórico de pontuações;");
        System.out.println("4 - Sair");
        System.out.println("Insira o número da opção desejada:");
    }

    public void difficulties(){
        System.out.println("Escolha sua dificuldade");
        System.out.println("1 - Fácil;");
        System.out.println("2 - Médio:");
        System.out.println("3 - Difícil");
        System.out.println("Insira a opção desejada: ");
    }

    public void rules(){
        System.out.println("Regras:");
        System.out.println("Cada dificuldade tem uma pontuação base diferente:");
        System.out.print("Fácil: 100 \n Médio: 200 \n Difícil: 300 \n");
        System.out.println("----------");
        System.out.println("Cada dificuldade tem um número específico de tentativas:");
        System.out.print("Fácil: 10 \n Médio: 7: \n Difícil: 5 \n");
        System.out.println("----------");
        System.out.println("A cada tentativa usada, será descontada uma quantidade de pontos:");
        System.out.print("Fácil: 8 \n Médio: 20 \n Difícil: 50");
        System.out.println("----------");
        System.out.println("Bônus por conclusão rápida: +50 pontos por cada tentativa não usada.");
        System.out.println("----------");
    }
}
