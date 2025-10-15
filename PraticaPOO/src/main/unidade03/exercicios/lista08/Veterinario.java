package unidade03.exercicios.lista08;

/**
 * Representa um veterinário em uma clínica.
 */
public class Veterinario extends Pessoa {
	
	private String crmv;
	private String especialidade;
	private Veterinario supervisor;

	/**
	 * Cria um novo veterinário com os detalhes especificados.
	 * @param nome O nome do veterinário.
	 * @param crmv O número de registro no Conselho Regional de Medicina Veterinária (CRMV).
	 * @param especialidade A especialidade do veterinário.
	 */
	public Veterinario(String nome, String cpf, String crmv, String especialidade) {
		super(nome, cpf);
		this.crmv = crmv;
		this.especialidade = especialidade;
	}

	/**
	 * Obtém o número de registro no CRMV do veterinário.
	 * @return O número do CRMV.
	 */
	public String getCrmv() {
		return crmv;
	}

	/**
	 * Define o número de registro no CRMV do veterinário.
	 * @param crmv O novo número do CRMV.
	 */
	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	/**
	 * Obtém a especialidade do veterinário.
	 * @return A especialidade do veterinário.
	 */
	public String getEspecialidade() {
		return especialidade;
	}

	/**
	 * Define a especialidade do veterinário.
	 * @param especialidade A nova especialidade do veterinário.
	 */
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	/**
	 * Obtém o supervisor do veterinário.
	 * @return O veterinário supervisor, ou null se não houver supervisor.
	 */
	public Veterinario getSupervisor() {
		return supervisor;
	}

	/**
	 * Define o supervisor do veterinário.
	 * @param supervisor O novo veterinário supervisor.
	 */
	public void setSupervisor(Veterinario supervisor) {
		this.supervisor = supervisor;
	}
	
	/**
	 * Retorna uma string com os dados do veterinário.
	 * Inclui nome, CRMV, especialidade e o nome do supervisor, se houver.
	 * @return Uma string formatada com os dados do veterinário.
	 */
	public String retornaDados() {
		String dados = "Nome: " + getNome() + ", CRVM: " + crmv + ", Especialidade: " + especialidade;
	    if (supervisor != null) {
	        dados += ", Supervisor: " + supervisor.getNome();
	    }
	    return dados;
	}

	@Override
	public String getResumo() {
		return getNome() + " - " + crmv + " - " + especialidade;
	}
}
