import java.util.Scanner;

public class BarConta {

    // Constantes
    private static final double PRECO_INGRESSO_HOMEM = 10.00;
    private static final double PRECO_INGRESSO_MULHER = 8.00;
    private static final double PRECO_CERVEJA = 5.00;
    private static final double PRECO_REFRIGERANTE = 3.00;
    private static final double PRECO_ESPETINHO = 7.00;
    private static final double COUVERT_ARTISTICO = 4.00;
    private static final double LIMITE_ISENCAO_COUVERT = 30.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados do cliente
        System.out.print("Sexo (F para feminino, M para masculino): ");
        char sexo = scanner.next().charAt(0);
        System.out.print("Quantidade de cervejas: ");
        int quantidadeCervejas = scanner.nextInt();
        System.out.print("Quantidade de refrigerantes: ");
        int quantidadeRefrigerantes = scanner.nextInt();
        System.out.print("Quantidade de espetinhos: ");
        int quantidadeEspetinhos = scanner.nextInt();

        // Determinar o preço do ingresso conforme o sexo do cliente
        double valorIngresso = (sexo == 'M' || sexo == 'm') ? PRECO_INGRESSO_HOMEM : PRECO_INGRESSO_MULHER;

        // Calcular o valor do consumo
        double valorCervejas = quantidadeCervejas * PRECO_CERVEJA;
        double valorRefrigerantes = quantidadeRefrigerantes * PRECO_REFRIGERANTE;
        double valorEspetinhos = quantidadeEspetinhos * PRECO_ESPETINHO;
        double valorConsumo = valorCervejas + valorRefrigerantes + valorEspetinhos;

        // Verificar se o cliente paga o couvert artístico
        double valorCouvert = (valorConsumo > LIMITE_ISENCAO_COUVERT) ? 0.00 : COUVERT_ARTISTICO;

        // Calcular o valor total a ser pago
        double valorTotal = valorIngresso + valorConsumo + valorCouvert;

        // Exibir o relatório da conta
        System.out.println("----- Relatório da Conta -----");
        System.out.printf("Valor do ingresso: R$ %.2f%n", valorIngresso);
        System.out.printf("Valor das cervejas: R$ %.2f%n", valorCervejas);
        System.out.printf("Valor dos refrigerantes: R$ %.2f%n", valorRefrigerantes);
        System.out.printf("Valor dos espetinhos: R$ %.2f%n", valorEspetinhos);
        System.out.printf("Valor do consumo total: R$ %.2f%n", valorConsumo);
        System.out.printf("Couvert artístico: R$ %.2f%n", valorCouvert);
        System.out.printf("Valor total a pagar: R$ %.2f%n", valorTotal);

        scanner.close();
    }
}
