package provas.prova01;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import provas.prova01.correcao.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProvaTest {

	/**
	 * 0,25
	 */
	@Test
	@Order(1)
	void testClassePaciente() {
		Paciente paciente = new Paciente("Nome", "CPF", 18);
		assertNotNull(paciente.getNome());
		assertNotNull(paciente.getCpf());
		assertEquals(18, paciente.getIdade());
		assertNotNull(paciente.exibirDados());
	}

	/**
	 * 0,25
	 */
	@Test
	@Order(2)
	void testClasseMedico() {
		Medico medico = new Medico("NOME", "CRM");
		assertNotNull(medico.getNome());
		assertNotNull(medico.getCrm());
		assertNotNull(medico.exibirDados());
	}

	/**
	 * 0,25
	 */
	@Test
	@Order(3)
	void testClasseEndereco() {
		Endereco endereco = new Endereco("Antonio da Veiga", 140, "Blumenau");
		assertNotNull(endereco.getRua());
		assertEquals(140, endereco.getNumero());
		assertNotNull(endereco.getCidade());
	}

	/**
	 * 0,25
	 */
	@Test
	@Order(4)
	void testClasseConsulta() {
		Paciente paciente = new Paciente("Nome", "CPF", 18);
		Medico medico = new Medico("NOME", "CRM");

		Consulta consulta = new Consulta(paciente, medico, LocalDate.now());
		consulta.adicionarObservacao("Teste");

		assertNotNull(consulta.exibirDados());

	}

	/**
	 * 1,00
	 */
	@Test
	@Order(5)
	void testClasseHospital() {
		Paciente paciente = new Paciente("Nome", "CPF", 18);
		Medico medico = new Medico("NOME", "CRM");
		Endereco endereco = new Endereco("Antonio da Veiga", 140, "Blumenau");

		Hospital hospital = new Hospital();
		hospital.setEndereco(endereco);

		Consulta consulta = hospital.agendarConsulta(paciente, medico, LocalDate.now());
		assertNotNull(consulta);
		hospital.listarConsultas();
		hospital.cancelarConsulta(consulta);

		assertNotNull(hospital.getConsultas());
		assertNotNull(hospital.getMedicos());
		assertNotNull(hospital.getPacientes());
	}

	/**
	 * 0,50
	 */
	@Test
	@Order(6)
	void testMetodosObrigatorios() {
		Paciente paciente = new Paciente("Nome", "CPF", 18);
		Medico medico = new Medico("NOME", "CRM");

		Hospital hospital = new Hospital();

		Consulta consulta = hospital.agendarConsulta(paciente, medico, LocalDate.now());
		assertNotNull(consulta);

		hospital.listarConsultas();

		consulta.adicionarObservacao("Obs");
	}

	/**
	 * 0,50
	 */
	@Test
	@Order(7)
	void testValidacoesObrigatorias() {
		assertThrows(IllegalArgumentException.class, () -> new Medico("NOME", null));
		assertThrows(IllegalArgumentException.class, () -> new Paciente("NOME", null, 18));
		assertThrows(IllegalArgumentException.class, () -> new Paciente("NOME", "CPF", -5));
	}

}
