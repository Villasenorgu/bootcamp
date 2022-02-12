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

//	@Test
//	void testEscaqueIntInt() {
//		assertEquals(new Rey(Color.BLANCO).getElColor(),tablero.Escaque(4, 1).getElColor());
//	}
//	
//	@Test
//	void testExceptionEscaqueIntInt() {
//		Exception exception = assertThrows(Exception.class , () -> {tablero.Escaque(5, 5);});
//		assertTrue(exception.getMessage().contains(exception.getMessage()));
//		Exception exception2 = assertThrows(Exception.class , () -> {tablero.Escaque(new Posicion(23,23));});
//		assertTrue(exception2.getMessage().contains(exception2.getMessage()));
//	}
//
//	@Test
//	void testEscaquePosicion() {
//		assertEquals(new Rey(Color.BLANCO).getElColor(),tablero.Escaque(new Posicion(4,1)).getElColor());
//	}

	@Test
	void testHayPiezaIntInt() {
		assertTrue(tablero.hayPieza(8,8));
	}
	
	@Test
	void testNoHayPiezaIntInt() {
		assertFalse(tablero.hayPieza(5,5));
	}

	@Test
	void testHayPiezaPosicion() {
		assertTrue(tablero.hayPieza(new Posicion(1,1)));
	}
	
	@Test
	void testNoHayPiezaPosicion() {
		assertFalse(tablero.hayPieza(new Posicion(5,5)));
	}

	@Test
	void testQuitaPiezaIntInt() {
		tablero.QuitaPieza(1, 1);
		assertFalse(tablero.hayPieza(1,1));
	}

	@Test
	void testQuitaPiezaPosicion() {
		tablero.QuitaPieza(new Posicion(1,1));
		assertFalse(tablero.hayPieza(1,1));
	}

	@Test
	void testMover() {
		
		tablero.Mover(new Movimiento("c7c6"));
		tablero.Mover(new Movimiento("b1c3"));
		tablero.Mover(new Movimiento("c3d5"));
		tablero.Mover(new Movimiento("c6d5"));
		
	}

	@Test
	void testClone() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testColorEscaque() {
		assertTrue(tablero.ColorEscaque(2, 2) == Color.BLANCO);
	}

	@Test
	void testNoHayPiezasEntre() {
		assertFalse(tablero.HayPiezasEntre(new Movimiento("b2b7")));
	}
	
	@Test
	void testHayPiezasEntre() {
		assertTrue(tablero.HayPiezasEntre(new Movimiento("b2b8")));
	}

}
