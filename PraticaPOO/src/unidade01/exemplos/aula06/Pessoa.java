package unidade01.exemplos.aula06;

public class Pessoa {

    private double peso;
    private String nome;
    private double altura;

    // Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter
    public String getNome() {
        return nome;
    }

    // Setter de forma "incorreta" não segue o padrão
    public void setAltura(double alturaPessoa) {
        altura = alturaPessoa;
    }

    public void setPeso(double peso) {
        if (peso < 0) {
            System.out.println("Peso inválido");
        } else {
            this.peso = peso;
        }
    }

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
