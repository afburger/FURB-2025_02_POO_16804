package provas.prova01;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();

		Endereco end = new Endereco("Antonio da Veiga", 140, "Blumenau");
		hospital.setEndereco(end);

		Medico m1 = new Medico("Medico1", "123");
		Medico m2 = new Medico("Medico2", "456");
		Medico m3 = new Medico("Medico3", "789");

		Paciente p1 = new Paciente("Paciente1", "123", 25);
		Paciente p2 = new Paciente("Paciente2", "456", 26);
		Paciente p3 = new Paciente("Paciente3", "987", 27);
		Paciente p4 = new Paciente("Paciente4", "456", 30);
		Paciente p5 = new Paciente("Paciente5", "589", 35);


		Consulta c1 = hospital.agendarConsulta(p1, m1, LocalDate.now());
		hospital.agendarConsulta(p2, m2, LocalDate.of(2025, 10, 15));

		hospital.agendarConsulta(p3, m3, LocalDate.of(2025, 11, 15));

		hospital.listarConsultas();

		hospital.cancelarConsulta(c1);

		System.out.println("#########################");

		hospital.listarConsultas();

	}
}
