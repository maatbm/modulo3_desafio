public class RulesAndOptions {
    public static void homeOptions() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Bem-vindo ao jogo de adivinhação!");
        System.out.println("1 - Iniciar novo jogo;");
        System.out.println("2 - Ver regras;");
        System.out.println("3 - Ver histórico de pontuações;");
        System.out.println("4 - Sair");
        System.out.println("Insira o número da opção desejada:");
    }

    public static void difficulties(){
        System.out.println("Escolha sua dificuldade");
        System.out.println("1 - Fácil: Adivinhar um número entre 1 e 50, com 10 tentativas");
        System.out.println("2 - Médio: Adivinhar um número entre 1 e 100, com 7 tentativas");
        System.out.println("3 - Difícil: Adivinhar um número entre 1 e 200, com 5 tentativas");
        System.out.println("4 - Modo sequência: Serão gerados três números de uma vez, entre 1 e 50, deverá acertar todos com 15 tentativas.");
        System.out.println("Insira a opção desejada: ");
    }

    public static void rules(){
        System.out.println("Regras:");
        System.out.println("Cada dificuldade tem uma pontuação base diferente:");
        System.out.print("Fácil: 100 \nMédio: 200 \nDifícil: 300 \n");
        System.out.println("----------");
        System.out.println("Cada dificuldade tem um número específico de tentativas:");
        System.out.print("Fácil: 10 \nMédio: 7: \nDifícil: 5 \n");
        System.out.println("----------");
        System.out.println("A cada tentativa usada, será descontada uma quantidade de pontos:");
        System.out.print("Fácil: 8 \nMédio: 20 \nDifícil: 50 \n");
        System.out.println("----------");
        System.out.println("Bônus por conclusão rápida: +50 pontos por cada tentativa não usada.");
        System.out.println("----------");
    }

    public static void tipsOptions(){
        System.out.println("1 - dica de paridade(par/ímpar) -10 pontos");
        System.out.println("2 - dica se o número está na metade superior ou inferior do limite. -20 pontos");
        System.out.println("3 - dica de quente/frio com base na proximidade do seu palpite com o número aleatório. -15 pontos");
    }
}
