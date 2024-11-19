import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();

        System.out.println("=====================================");
        System.out.println("  ____        _   _   _            ");
        System.out.println(" |  _ \\ _   _| |_| |_| | ___   __ _ ");
        System.out.println(" | | | | | | | __| __| |/ _ \\ / _` |");
        System.out.println(" | |_| | |_| | |_| |_| | (_) | (_| |");
        System.out.println(" |____/ \\__,_|\\__|\\__|_|\\___/ \\__, |");
        System.out.println("                              |___/ ");
        System.out.println("=====================================");
        System.out.println("Bem-vindo ao Jogo da Velha!");
        System.out.println("Jogador 1: X | Jogador 2: O");
        System.out.println("Para jogar, insira as coordenadas (linha e coluna).");

        boolean jogoAtivo = true;
        while (jogoAtivo) {
            jogo.mostrarTabuleiro();
            System.out.println("Vez do jogador '" + jogo.getJogadorAtual() + "'.");
            System.out.print("Digite a linha: ");
            int linha = scanner.nextInt();
            System.out.print("Digite a coluna: ");
            int coluna = scanner.nextInt();

            if (!jogo.realizarJogada(linha, coluna)) {
                System.out.println("Coordenada inválida! Tente novamente.");
                continue;
            }

            if (jogo.verificarVencedor()) {
                jogo.mostrarTabuleiro();
                System.out.println("Parabéns! O jogador '" + jogo.getJogadorAtual() + "' venceu!");
                jogoAtivo = false;
            } else if (jogo.tabuleiroCompleto()) {
                jogo.mostrarTabuleiro();
                System.out.println("Empate! O tabuleiro está completo.");
                jogoAtivo = false;
            } else {
                jogo.alternarJogador();
            }
        }
        System.out.println("Fim do jogo. Obrigado por jogar!");
        scanner.close();
    }
}
