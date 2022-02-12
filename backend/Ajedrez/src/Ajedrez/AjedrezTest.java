package Ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AjedrezTest {

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
	void testPromocion() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetTablero() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetTurno() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testInicializar() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testJugada() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testMain() {
		Juego juego = new Juego();
		juego.inicializar();
		juego.Jugada("c7c6");
		juego.Jugada("b1c3");
		juego.Jugada("c3d5");
		juego.Jugada("c6d5");
		juego.Jugada("b7b6");
	}

}
