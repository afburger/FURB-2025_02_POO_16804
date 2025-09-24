package unidade01.exercicios.lista01.questao3;

public class Pessoa {

    double altura;
    double peso;

    double calcularImc() {
        return peso / (altura * altura);
    }
}
