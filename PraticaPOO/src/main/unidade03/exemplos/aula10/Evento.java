package unidade03.exemplos.aula10;

public class Evento {

	private Veiculo veiculo;
	private String descricao;

	public Evento(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String retornaDados() {
		StringBuilder sb = new StringBuilder();
		sb.append(descricao)
				.append(" - ")
				.append(veiculo.getPlaca());

		return  sb.toString();
	}
}
