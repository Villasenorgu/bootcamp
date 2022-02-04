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
	void testDecodificar()  {
 
		String[] a = {"3+","2*","5="};
		try {
			assertArrayEquals(a,calc.decodificar("3+2*5="));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testExceptionDecodificar() throws Exception{
		Exception exception = assertThrows(Exception.class , () -> {calc.decodificar("aaaaaaaa"); });
		assertTrue("La cadena introducida no contiene operadores".contains(exception.getMessage()));
	}

	@Test
	void testParametrizar() {
		String[] a = {"3+","2*","5="};
		assertEquals(25.0,calc.parametrizar(a));
	}

	
	@Test
	void testCalculaSuma() {
		assertEquals(5.0,(calc.Calcula(3.0,'+',2.0)));

	}
	@Test
	void testCalculaResta() {
		assertEquals(-1.0,(calc.Calcula(3.0,'-',2.0)));
	}
	void testCalculaProducto() {
		assertEquals(6.0,(calc.Calcula(2.0,'*',3.0)));
		
	}
	void testCalculaDivision() {
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
