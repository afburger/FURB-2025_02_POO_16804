package unidade01.exemplos.aula03;

public class AppPessoa {

    public static void main(String[] args) {
        Pessoa joao = new Pessoa();
        joao.setNome("João");

        Pessoa maria = new Pessoa();
        maria.setNome("Maria");

        Pessoa amigo = joao;

        joao = null;

        System.out.println(maria.getNome());
    }
}
