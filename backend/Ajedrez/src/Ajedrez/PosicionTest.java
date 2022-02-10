package Ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PosicionTest {
	
	Posicion posicion = new Posicion(2,1);
	char x;
	char y;
	Posicion posicionConChar = new Posicion('a','7');
	
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
	void testGetFila() {
		assertEquals(1, posicion.getFila() );
	}
	
	@Test
	void testGetFilaChar() {
		assertEquals(7, posicionConChar.getFila() );
	}

	@Test
	void testGetColumna() {
		assertEquals(2, posicion.getColumna() );
	}
	
	@Test
	void testGetColumnaChar() {
		assertEquals(1, posicionConChar.getColumna() );
	}
	
	@Test
	void testExceptionPosicion() throws Exception{
		Exception exception = assertThrows(Exception.class , () -> {new Posicion(-1,0);});
		assertTrue(exception.getMessage().contains("Valor inesperado"));
	}
	
	@Test
	void testExceptionPosicionChar() throws Exception{
		Exception exception = assertThrows(Exception.class , () -> {new Posicion('a','z');});
		assertTrue(exception.getMessage().contains(exception.getMessage()));
	}
	
	@Test
	void testExceptionPosicionNula() throws Exception{
		Exception exception = assertThrows(Exception.class , () -> {new Posicion(x,y);});
		assertTrue(exception.getMessage().contains(exception.getMessage()));
	}

	@Test
	void testEquals() {
		assertEquals(true,posicion.Equals(new Posicion(2,1)));
	}
	
	@Test
	void testEqualsFalse() {
		assertEquals(false,posicion.Equals(new Posicion(2,2)));
	}
}
