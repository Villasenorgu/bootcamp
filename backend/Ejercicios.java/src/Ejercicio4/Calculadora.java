package Ejercicio4;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

public class Calculadora {

	public static void main(String[] args) throws Exception {
		
		Calculadora app = new Calculadora();
		
		String cad = app.LeerArchivo();
		String[] cad2 = app.decodificar(cad);
		double resultado = app.parametrizar(cad2);
		app.EscribirResultado(cad2,resultado);
		
	}

	public String LeerArchivo() {
		try {
		      File archivo = new File("C:\\curso\\backend\\Ejercicios.java\\src\\Ejercicio4\\Archivo.txt");
		      Scanner lector = new Scanner(archivo);
		      while (lector.hasNextLine()) {
		    	return lector.nextLine().toString();
		      }
		      lector.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return "error";
		    }
		return "";
	}
	
	
	public void EscribirResultado(String[] cad2,double resultado) throws IOException {
		try {
	      File archivo = new File("C:\\curso\\backend\\Ejercicios.java\\src\\Ejercicio4\\Salida.txt");
	      BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
	      for (int i = 0; i < cad2.length; i++) {
				writer.write(cad2[i]);
				writer.newLine();
			}
	      writer.write("--------------");
	      writer.newLine();
	      writer.write(String.valueOf(resultado));
	      writer.newLine();
	      writer.close();
		}catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public String[] decodificar(String cad) throws Exception {
		
			cad = cad.replaceAll("\\+", "\\+ ");
			cad = cad.replaceAll("\\-", "\\- ");
			cad = cad.replaceAll("\\*", "\\* ");
			cad = cad.replaceAll("\\=", "\\= ");
			cad = cad.replaceAll("\\/", "\\/ ");
			cad = cad.replaceAll(",", ".");

		String[] cad2 = cad.split(" ");
		System.out.println(cad);
		
		try {
			if(cad2[1] == null) {
			}
		} catch (Exception e) {
			throw new Exception("La cadena introducida no contiene operadores");
		}
		
		// Mostrar numeros + operadores por linea
		for (int i = 0; i < cad2.length; i++) {
			System.out.println(cad2[i]);
		}
		return cad2;
	}

	public double parametrizar(String[] cad2) {
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
		return dato;

	}

	public double Calcula(double dato, char operador, double resultadoAnterior) {
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

	public double suma(double num1, double num2) {
		return num1 + num2;
	}

	public double resta(double num1, double num2) {
		return num1 - num2;
	}

	public double producto(double num1, double num2) {
		return num1 * num2;
	}

	public double division(double num1, double num2) {
		return num1 / num2;
	}

}
