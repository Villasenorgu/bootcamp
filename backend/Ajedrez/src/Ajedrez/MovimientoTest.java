package Ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MovimientoTest {
	
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
	void testGetPosIni() throws JuegoException{
		Movimiento movimiento = new Movimiento("B1C2");		
		assertTrue(movimiento.getPosIni().Equals(new Movimiento("b1c2").getPosIni()));
	}

	@Test
	void testEsVertical() throws JuegoException {

		Movimiento mVertical = new Movimiento("a1a8");
		 assertTrue(mVertical.EsVertical());
	}

	@Test
	void testEsHorizontal() throws JuegoException {
		
		Movimiento mHorizontal = new Movimiento("b2g2");
		assertEquals(true, mHorizontal.EsHorizontal());
	}

	@Test
	void testEsDiagonal() throws JuegoException {
		Movimiento mDiagonal = new Movimiento("c3b2");
		assertEquals(true, mDiagonal.EsDiagonal());
	}
	
	@Test
	void testNoEsDiagonal() throws JuegoException {
		Movimiento mVertical = new Movimiento("a1a8");
		assertEquals(false, mVertical.EsDiagonal());
	}

	@Test
	void testSaltoVertical() throws JuegoException {
		Movimiento mVertical = new Movimiento("a1a8");
		assertEquals(7, mVertical.SaltoVertical());
	}

	@Test
	void testSaltoHorizontal() throws JuegoException {
		Movimiento mHorizontal = new Movimiento("b2g2");
		assertEquals(0, mHorizontal.SaltoVertical());
	}

	@Test
	void testDeltaFila() throws JuegoException {
		Movimiento mHorizontal = new Movimiento("b2g2");
		assertEquals(0, mHorizontal.deltaFila());
	}

	@Test
	void testDeltaColumna() throws JuegoException {
		Movimiento mVertical = new Movimiento("a1a8");
		assertEquals(0, mVertical.deltaColumna());
	}

}
