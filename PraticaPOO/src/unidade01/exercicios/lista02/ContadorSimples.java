package unidade01.exercicios.lista02;

public class ContadorSimples {

    int valor;

    void incrementar() {
        valor++;
    }

    void decrementar() {
        valor--;
    }

    void zerar() {
        valor = 0;
    }

    int obterValor() {
        return valor;
    }

    void exibirEstado() {
        System.out.println("Contador está em: " + valor);
    }
}
