// Main.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Atleta> atletas = new ArrayList<>();

        System.out.print("Quantos atletas deseja cadastrar? ");
        int n = lerInteiroPositivo(scanner);

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome do atleta: ");
            String nome = scanner.nextLine();

            char sexo = lerSexo(scanner);

            System.out.print("Digite a altura do atleta (em metros): ");
            double altura = lerDoublePositivo(scanner);

            System.out.print("Digite o peso do atleta (em kg): ");
            double peso = lerDoublePositivo(scanner);

            atletas.add(new Atleta(nome, sexo, altura, peso));
        }

        gerarRelatorio(atletas);
    }

    private static int lerInteiroPositivo(Scanner scanner) {
        int valor;
        while (true) {
            try {
                valor = Integer.parseInt(scanner.nextLine());
                if (valor > 0) {
                    return valor;
                } else {
                    System.out.print("Por favor, insira um valor positivo: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Insira um número inteiro positivo: ");
            }
        }
    }

    private static double lerDoublePositivo(Scanner scanner) {
        double valor;
        while (true) {
            try {
                valor = Double.parseDouble(scanner.nextLine());
                if (valor > 0) {
                    return valor;
                } else {
                    System.out.print("Por favor, insira um valor positivo: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Insira um número decimal positivo: ");
            }
        }
    }

    private static char lerSexo(Scanner scanner) {
        char sexo;
        while (true) {
            System.out.print("Digite o sexo do atleta (M/F): ");
            sexo = scanner.nextLine().trim().toUpperCase().charAt(0);
            if (sexo == 'M' || sexo == 'F') {
                return sexo;
            } else {
                System.out.println("Entrada inválida. Por favor, digite 'M' para masculino ou 'F' para feminino.");
            }
        }
    }

    private static void gerarRelatorio(List<Atleta> atletas) {
        double pesoTotal = 0;
        Atleta atletaMaisAlto = null;
        int totalHomens = 0;
        double alturaTotalMulheres = 0;
        int totalMulheres = 0;

        for (Atleta atleta : atletas) {
            pesoTotal += atleta.getPeso();

            if (atletaMaisAlto == null || atleta.getAltura() > atletaMaisAlto.getAltura()) {
                atletaMaisAlto = atleta;
            }

            if (atleta.getSexo() == 'M') {
                totalHomens++;
            } else {
                alturaTotalMulheres += atleta.getAltura();
                totalMulheres++;
            }
        }

        double pesoMedio = pesoTotal / atletas.size();
        double porcentagemHomens = ((double) totalHomens / atletas.size()) * 100;

        System.out.println("\nRelatório:");
        System.out.printf("Peso médio dos atletas: %.2f kg%n", pesoMedio);
        System.out.println("Nome do atleta mais alto: " + (atletaMaisAlto != null ? atletaMaisAlto.getNome() : "Nenhum atleta cadastrado"));
        System.out.printf("Porcentagem de homens: %.2f%%%n", porcentagemHomens);

        if (totalMulheres > 0) {
            double alturaMediaMulheres = alturaTotalMulheres / totalMulheres;
            System.out.printf("Altura média das mulheres: %.2f m%n", alturaMediaMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas.");
        }
    }
}
