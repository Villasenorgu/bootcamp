package Ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableroTest {
	
	Tablero tablero = new Tablero();
	
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
	void testEscaqueIntInt() {
		Pieza[][] piezas = new Pieza[8][8];
		piezas[4][0] = new Rey(Color.BLANCO);
		assertEquals(new Rey(Color.BLANCO).getElColor(),tablero.Escaque(4, 1).getElColor());
	}
	
	@Test
	void testExceptionEscaqueIntInt() {
		Exception exception = assertThrows(Exception.class , () -> {tablero.Escaque(5, 5);});
		assertTrue(exception.getMessage().contains(exception.getMessage()));
	}

	@Test
	void testEscaquePosicion() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testHayPiezaIntInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testHayPiezaPosicion() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testQuitaPiezaIntInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testQuitaPiezaPosicion() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testMover() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testClone() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testColorEscaque() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testHayPiezasEntre() {
		fail("Not yet implemented"); // TODO
	}

}
