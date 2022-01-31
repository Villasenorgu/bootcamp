package Ejercicio4;

public class Calculadora {

	public static void main(String[] args) {
		String cad = "3+4+3,4-7*2=";
		String[] cad2 = decodificar(cad);
		parametrizar(cad2);
	}

	public static String[] decodificar(String cad) {
		cad = cad.replaceAll("\\+", "\\+ ");
		cad = cad.replaceAll("\\-", "\\- ");
		cad = cad.replaceAll("\\*", "\\* ");
		cad = cad.replaceAll("\\=", "\\= ");
		cad = cad.replaceAll("\\/", "\\/ ");
		cad = cad.replaceAll(",", ".");

		String[] cad2 = cad.split(" ");
		// Mostrar numeros + operadores por linea
		for (int i = 0; i < cad2.length; i++) {
			System.out.println(cad2[i]);
		}
		return cad2;
	}

	public static void parametrizar(String[] cad2) {
		double dato = suma(Double.parseDouble(cad2[0].substring(0, cad2[0].length() - 1)), 0.0);
		char operador = cad2[0].charAt(cad2[0].length() - 1);

		for (int i = 1; i < cad2.length; i++) {
			double primerOperando = dato;
			dato = Calcula(Double.parseDouble(cad2[i].substring(0, cad2[i].length() - 1)), operador, dato);
			char operadorAnterior = operador;
			operador = cad2[i].charAt(cad2[i].length() - 1);
			System.out.println(primerOperando + " " + operadorAnterior + " " + " "
					+ Double.parseDouble(cad2[i].substring(0, cad2[i].length() - 1)) + " = " + dato);
		}

	}

	public static double Calcula(double dato, char operador, double resultadoAnterior) {
		if (operador == ('+')) {
			return suma(resultadoAnterior, dato);
		} else if (operador == ('-')) {
			return resta(resultadoAnterior, dato);
		} else if (operador == ('*')) {
			return producto(resultadoAnterior, dato);
		} else if (operador == ('/')) {
			return division(resultadoAnterior, dato);
		} else {
			return resultadoAnterior;
		}
	}

	public static double suma(double num1, double num2) {
		return num1 + num2;
	}

	public static double resta(double num1, double num2) {
		return num1 - num2;
	}

	public static double producto(double num1, double num2) {
		return num1 * num2;
	}

	public static double division(double num1, double num2) {
		return num1 / num2;
	}

}
