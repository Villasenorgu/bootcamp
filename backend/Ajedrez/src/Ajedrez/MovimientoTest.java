package Ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {

	Movimiento movimiento = new Movimiento("B1C2");
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetPosIni() {
		assertTrue(this.movimiento.getPosIni().Equals(new Movimiento("b1c2").getPosIni()));
	}
	
	@Test
	void testGetPosFin() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testMovimiento() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testEsVertical() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testEsHorizontal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testEsDiagonal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSaltoVertical() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSaltoHorizaontal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeltaFila() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeltaColumna() {
		fail("Not yet implemented"); // TODO
	}

}
