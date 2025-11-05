package provas.prova02;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEntrega {

	@Test
	@Order(1)
	public void testCorreios() {
		Entrega correios = new EntregaCorreios();
		assertEquals(9, correios.calcularPrazoEntrega(3));
		assertEquals(5.4, correios.calcularFrete(3));
	}

	@Test
	@Order(2)
	public void testMotoboy() {
		Entrega correios = new EntregaMotoboy();
		assertEquals(3, correios.calcularPrazoEntrega(3));
		assertEquals(7.5, correios.calcularFrete(3));
	}

	@Test
	@Order(3)
	public void testRetirada() {
		Entrega correios = new EntregaRetirada();
		assertEquals(0, correios.calcularPrazoEntrega(3));
		assertEquals(0, correios.calcularFrete(3));
	}
}
