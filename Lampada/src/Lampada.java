import java.util.Scanner;

public class Lampada {

    private String marca;
    private int voltagem;
    private String tipo;
    private String modelo;
    private String cor;
    private double preco;
    private String garantia;
    private boolean ligada;






    public Lampada() {
        this.ligada = false; // Por padrão, começa desligada
    }



    public String getMarca() {
           return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }



    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public String getTipo() {
        return tipo;

    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public boolean isLigada() {
        return ligada;
    }


    public void ligar() {
        ligada = true;
        System.out.println("A lâmpada foi ligada:parabéns temos luz ");
    }

    public void desligar() {
        ligada = false;
        System.out.println("A lâmpada foi desligada.");
    }

    public void mostrarStatus() {
        if (ligada) {
               System.out.println("A lâmpada está ligada.");
        } else {
            System.out.println("A lâmpada está desligada.");
        }
    }

    public void mudarStatus() {
        if (ligada) {
            desligar();
        } else {
            ligar();
        }
    }


    public void inserirDados() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira a marca da lâmpada: ");
        this.marca = scanner.nextLine();

        System.out.print("Insira a voltagem da lâmpada: ");
        this.voltagem = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Insira o tipo da lâmpada: ");
        this.tipo = scanner.nextLine();

        System.out.print("Insira o modelo da lâmpada: ");

        this.modelo = scanner.nextLine();

        System.out.print("Insira a cor da lâmpada: ");
            this.cor = scanner.nextLine();

            System.out.print("Insira o preço da lâmpada: ");
        this.preco = scanner.nextDouble();
        scanner.nextLine();

                 System.out.print("Insira a garantia da lâmpada: ");
        this.garantia = scanner.nextLine();
    }
}
