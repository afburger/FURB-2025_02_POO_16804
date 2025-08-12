package unidade01.exercicios.lista01.questao4;

public class Pessoa {

    double altura;
    double peso;
    String nome;

    double calcularImc() {
        return peso / (altura * altura);
    }

    void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
        System.out.println("IMC: " + calcularImc());
        System.out.println("#######################");
    }
}
