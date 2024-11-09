import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Lampada lampada = new Lampada();
        Scanner scanner = new Scanner(System.in);


        lampada.inserirDados();

        int opcao;

        do {
            System.out.print("Ligar/Desligar lâmpada? 0 – Sair / 1 – Sim / 2 – Não\n");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    if (lampada.isLigada()) {
                        lampada.desligar();
                        System.out.println("# Lâmpada Desligada #");
                    } else {
                        lampada.ligar();
                        System.out.println("# Lâmpada Ligada #");
                    }
                    break;
                case 2:
                    if (lampada.isLigada()) {
                        System.out.println("# Lâmpada Ligada #");
                    } else {
                        System.out.println("# Lâmpada Desligada #");
                    }
                    break;
                case 0:
                    System.out.println("*** Você encerrou o software. ***");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}

