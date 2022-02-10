package Ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {

	Movimiento movimiento = new Movimiento("B1C2");
	Movimiento mDiagonal = new Movimiento("c3b2");
	Movimiento mHorizontal = new Movimiento("a1f1");
	Movimiento mVertical = new Movimiento("a1a6");
	Movimiento mHorizontalN = new Movimiento("f1a1");
	Movimiento mVerticalN = new Movimiento("a6a1");
	
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
	void testExceptionMovimientoConMismasPosiciones() throws Exception{
		Exception exception = assertThrows(Exception.class , () -> {new Movimiento("a1a1");});
		assertTrue(exception.getMessage().contains(exception.getMessage()));
	}
	
	@Test
	void testGetPosIni() {
		assertTrue(this.movimiento.getPosIni().Equals(new Movimiento("b1c2").getPosIni()));
	}

	@Test
	void testEsVertical() {
		 assertEquals(true, mVertical.EsVertical());
	}

	@Test
	void testEsHorizontal() {
		assertEquals(true, mHorizontal.EsHorizontal());
	}

	@Test
	void testEsDiagonal() {
		assertEquals(true, mDiagonal.EsDiagonal());
	}

	@Test
	void testSaltoVertical() {
		assertEquals(5, mVertical.SaltoVertical());
	}

	@Test
	void testSaltoHorizontal() {
		assertEquals(0, mHorizontal.SaltoVertical());
	}

	@Test
	void testDeltaFila() {
		assertEquals(-1, mHorizontalN.deltaFila());
	}

	@Test
	void testDeltaColumna() {
		assertEquals(-1, mVerticalN.deltaColumna());
	}

}
