package unidade01.exercicios.lista02;

public class AppPessoa {

    public static void main(String[] args) {
        Pessoa joao = new Pessoa();  // Linha 1
        joao.nome = "João";          // Linha 2

        Pessoa maria = new Pessoa(); // Linha 3
        maria.nome = "Maria";        // Linha 4

        Pessoa amigo = joao;         // Linha 5

        joao = null;                 // Linha 6

        System.out.println(maria.nome);
    }
}
