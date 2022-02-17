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
	void testHayPiezaIntInt() {
		tablero.setPieza(new Posicion(8,8), new Torre(Color.NEGRO));
		assertTrue(tablero.hayPieza(8,8));
	}
	
	@Test
	void testNoHayPiezaIntInt() {
		assertFalse(tablero.hayPieza(5,5));
	}

	@Test
	void testHayPiezaPosicion() {
		tablero.setPieza(new Posicion(1,1), new Torre(Color.NEGRO));
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
		Juego juego = new Juego();
		juego.getTablero();
		juego.inicializar();
		
		juego.Jugada("b1c3");		
		juego.Jugada("c7c6");
		juego.Jugada("c3d5");
		juego.Jugada("c6d5");
		juego.Jugada("h2h3");
		juego.Jugada("b7b6");
		juego.Jugada("h3h4");
		juego.Jugada("c8a6");
		juego.Jugada("h1h3");
		juego.Jugada("d7d6");
		juego.Jugada("h3g3");
		juego.Jugada("d8d7");
		juego.Jugada("g3f3");
		juego.Jugada("e8d8");
		juego.Jugada("g2g4");
		
		
	}


	@Test
	void testColorEscaque() {
		assertEquals(Color.NEGRO.toString(),tablero.ColorEscaque(1, 1).toString());
		assertEquals(Color.BLANCO.toString(),tablero.ColorEscaque(1, 2).toString());
	}

	@Test
	void testNoHayPiezasEntre() {
		assertFalse(tablero.HayPiezasEntre(new Movimiento("b2b7")));
	}
	
	@Test
	void testHayPiezasEntre() {
		tablero.setPieza(new Posicion(2,6), new Torre(Color.BLANCO));
		tablero.setPieza(new Posicion(2,2), new Torre(Color.BLANCO));
		assertTrue(tablero.HayPiezasEntre(new Movimiento("b2b8")));
	}
	
}
