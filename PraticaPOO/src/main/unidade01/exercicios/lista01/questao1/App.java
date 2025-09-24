package unidade01.exercicios.lista01.questao1;

public class App {

    public static void main(String[] args) {
        Pessoa marta = new Pessoa();

        marta.altura = 1.75;
        marta.peso = 78;

        double imc = marta.calcularImc();

        System.out.println("O IMC calculado é de: " + imc);
    }
}
