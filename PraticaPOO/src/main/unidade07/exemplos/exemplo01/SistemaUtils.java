package unidade07.exemplos.exemplo01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SistemaUtils {

	private static  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static String formatarData(LocalDate data) {
		return data.format(formatter);
	}
}
