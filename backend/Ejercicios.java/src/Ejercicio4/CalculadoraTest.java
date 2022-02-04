package Ejercicio4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {
	
	Calculadora calc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calc = new Calculadora();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMain() {
		
	}

	@Test
	void testDecodificar() throws Exception {
		assertEquals("3+",calc.decodificar("3+2*5=")[0]);
		assertEquals("2*",calc.decodificar("3+2*5=")[1]);
		assertEquals("5=",calc.decodificar("3+2*5=")[2]); 
		String[] a = {"3+","2*","5="};
		assertEquals(a[0],calc.decodificar("3+2*5=")[0]);
		assertEquals(a[1],calc.decodificar("3+2*5=")[1]);
		assertEquals(a[2],calc.decodificar("3+2*5=")[2]);
		assertEquals("hola",calc.decodificar("aaa%aaaa")[0]);
		
	}

	@Test
	void testParametrizar() {
		String[] a = {"3+","2*","5="};
		assertEquals(25.0,calc.parametrizar(a));
	}

	
	@Test
	void testCalcula() {
		assertEquals(5.0,(calc.Calcula(3.0,'+',2.0)));
		assertEquals(-1.0,(calc.Calcula(3.0,'-',2.0)));
		assertEquals(6.0,(calc.Calcula(2.0,'*',3.0)));
		assertEquals(1.5,(calc.Calcula(2.0,'/',3.0)));
		assertEquals(3.0,(calc.Calcula(2.0,'=',3.0)));
	}


	@Test
	void testSuma() {
		assertEquals(5.0,(calc.suma(3.0,2.0)));
	}

	@Test
	void testResta() {
		assertEquals(1.0,(calc.resta(3.0,2.0)));
	}

	@Test
	void testProducto() {
		assertEquals(6.0,(calc.producto(3.0,2.0)));
	}

	@Test
	void testDivision() {
		assertEquals(3.0,1.0,3.0);
		assertEquals(2.5,2.0, 5.0);
		assertEquals(-2.333333333333333, -3,7.0);
		//assertEquals(Double.POSITIVE_INFINITY,0.0, 2.0);
		
	}
	@ParameterizedTest
	@CsvSource({ "3.0,3.0,1", "5.0,2.0, 2.5", "7.0, -3,-2,333333333333333" })
	void testWithCsvSource(double operando1, double operando2, double resultado) {

	}
	

}
