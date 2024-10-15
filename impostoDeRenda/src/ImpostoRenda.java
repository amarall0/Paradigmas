// Classe principal para calcular o imposto de renda
public class ImpostoRenda {

    // Constantes para os percentuais de imposto
    private static final double IMPOSTO_SALARIO_FAIXA1 = 0.0;   // Isento
    private static final double IMPOSTO_SALARIO_FAIXA2 = 0.10;  // 10% entre 3000 e 5000
    private static final double IMPOSTO_SALARIO_FAIXA3 = 0.20;  // 20% para 5000 ou mais

    private static final double IMPOSTO_SERVICOS = 0.15; // 15% sobre serviços
    private static final double IMPOSTO_GANHO_CAPITAL = 0.20; // 20% sobre ganho de capital
    private static final double ABATIMENTO_MAXIMO = 0.30; // 30% de abatimento

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Entrada de dados
        System.out.print("Renda anual com salário: ");
        double rendaAnualSalario = scanner.nextDouble();
        System.out.print("Renda anual com prestação de serviços: ");
        double rendaServicos = scanner.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        double ganhoCapital = scanner.nextDouble();
        System.out.print("Gastos médicos e educacionais: ");
        double gastosMedicosEducacionais = scanner.nextDouble();

        // Cálculo do imposto
        double impostoSalario = calcularImpostoSalario(rendaAnualSalario);
        double impostoServicos = rendaServicos * IMPOSTO_SERVICOS;
        double impostoGanhoCapital = ganhoCapital * IMPOSTO_GANHO_CAPITAL;

        // Soma dos impostos brutos
        double impostoBruto = impostoSalario + impostoServicos + impostoGanhoCapital;

        // Cálculo do abatimento
        double abatimento = Math.min(gastosMedicosEducacionais, impostoBruto * ABATIMENTO_MAXIMO);

        // Imposto líquido
        double impostoLiquido = impostoBruto - abatimento;

        // Exibição do relatório
        System.out.println("----- Relatório de Imposto de Renda -----");
        System.out.printf("Imposto sobre salário: R$ %.2f%n", impostoSalario);
        System.out.printf("Imposto sobre prestação de serviços: R$ %.2f%n", impostoServicos);
        System.out.printf("Imposto sobre ganho de capital: R$ %.2f%n", impostoGanhoCapital);
        System.out.printf("Imposto bruto: R$ %.2f%n", impostoBruto);
        System.out.printf("Abatimento: R$ %.2f%n", abatimento);
        System.out.printf("Imposto líquido devido: R$ %.2f%n", impostoLiquido);

        scanner.close();
    }

    // Método para calcular o imposto sobre o salário
    private static double calcularImpostoSalario(double rendaAnualSalario) {
        double rendaMensal = rendaAnualSalario / 12;

        if (rendaMensal < 3000) {
            return rendaAnualSalario * IMPOSTO_SALARIO_FAIXA1;
        } else if (rendaMensal < 5000) {
            return rendaAnualSalario * IMPOSTO_SALARIO_FAIXA2;
        } else {
            return rendaAnualSalario * IMPOSTO_SALARIO_FAIXA3;
        }
    }
}
