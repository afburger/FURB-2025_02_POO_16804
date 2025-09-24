package provas.prova01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import provas.prova01.correcao.Consulta;
import provas.prova01.correcao.Hospital;
import provas.prova01.correcao.Medico;
import provas.prova01.correcao.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProvaTest {

	@Test
	void testarMetodosHospital() {
		Hospital hospital = new Hospital();
		Paciente p = new Paciente("Nome", "123456789", 25);
		Medico m = new Medico("Medico", "12345");
		LocalDate dataConsulta = LocalDate.of(2025, 9, 20);

		Consulta consulta = hospital.agendarConsulta(p, m, dataConsulta);
		Assertions.assertNotNull(consulta);

		hospital.cancelarConsulta(consulta);

		ArrayList<Consulta> consultas = hospital.getConsultas();
		Assertions.assertNotNull(consultas);

		ArrayList<Medico> medicos = hospital.getMedicos();
		Assertions.assertNotNull(medicos);

		ArrayList<Paciente> pacientes = hospital.getPacientes();
		Assertions.assertNotNull(pacientes);
	}

	@Test
	public void testarMetodosConsulta() {
		Paciente p = new Paciente("Nome", "123456789", 25);
		Medico m = new Medico("Medico", "12345");
		LocalDate d = LocalDate.of(2025, 9, 20);

		Consulta consulta = new Consulta(p, m, d);
		Assertions.assertNotNull(consulta);

		consulta.adicionarObservacao("Teste");
		Assertions.assertNotNull(consulta.exibirDados());
	}
}
