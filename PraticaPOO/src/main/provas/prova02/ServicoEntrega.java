package provas.prova02;

public abstract class ServicoEntrega implements Entrega {

	private String nomeServico;

	public String getNomeServico() {
		return nomeServico;
	}

	public abstract double getTempoEntrega();

	public abstract double getValor();

	@Override
	public double calcularFrete(double distancia) {
		return distancia * getValor();
	}

	@Override
	public int calcularPrazoEntrega(double distancia) {
		return (int) (distancia * getTempoEntrega());
	}
}
