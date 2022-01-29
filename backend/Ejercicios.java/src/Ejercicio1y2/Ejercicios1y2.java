package Ejercicio1y2;

import java.util.Random;
import java.util.Scanner;

public class Ejercicios1y2 {

	public static void main(String[] args) {
		// Ejercicio1();
		Ejercicio2();

	}

	public static void Ejercicio1() {
		var rnd = new Random();
		int num = rnd.nextInt(100);
		System.out.println("Numero Secreto:" + num);

		for (int intentos = 10; intentos > 0; intentos--) {
			System.out.println("Intenta adivinarlo, introduce un número:");
			Scanner teclado = new Scanner(System.in);
			var cad = teclado.nextLine();
			int numeroIntroducido = Integer.parseInt(cad);

			if (numeroIntroducido == num) {
				System.out.println("Has acertado!!");
			} else {
				if (numeroIntroducido > num)
					System.out.println("El número que buscas es mas pequeño.");
				else
					System.out.println("El número que buscas es mas grande.");
			}
			if (intentos == 1) {
				System.out.println("No has conseguido acertar el número");
			}

		}

	}

	public static void Ejercicio2() {
		// "3+4+3,4-7*1="
		System.out.println("Introduce una cadena de números y operadores");
		Scanner teclado = new Scanner(System.in);
		String cad = teclado.nextLine();

		// Separacion de elementos a partir de operadores
		cad = cad.replaceAll("\\+", " \\+ ");
		cad = cad.replaceAll("\\-", " \\- ");
		cad = cad.replaceAll("\\*", " \\* ");
		cad = cad.replaceAll("\\=", " \\= ");
		cad = cad.replaceAll("\\/", " \\/ ");
		cad = cad.replaceAll(",", ".");
		// System.out.println(cad + " ");
		String[] cad2 = cad.split(" ");
		// Mostrar numeros + operadores por linea
		for (int i = 0; i < cad2.length; i += 2) {
			System.out.println(cad2[i] + " " + cad2[i + 1]);
		}

		// Calculo de * y / (Prioridad)
		for (int i = 0; i < cad2.length; i++) {
			if (cad2[i].equals("*")) {
				int producto = (int) (Double.parseDouble(cad2[i - 1]) * Double.parseDouble(cad2[i + 1]));
				cad2[i - 1] = Integer.toString(producto);
				cad2[i] = ";";
				cad2[i + 1] = "a";
			} else if (cad2[i].equals("/")) {
				int producto = (int) (Double.parseDouble(cad2[i - 1]) / Double.parseDouble(cad2[i + 1]));
				cad2[i - 1] = Integer.toString(producto);
				cad2[i] = ";";
				cad2[i + 1] = "a";
			}
		}

		// Calculo de + y -
		Double resultado = Double.parseDouble(cad2[0]);
		int contOperador = 1;
		for (int i = 2; i < cad2.length - 1; i += 2) {
			try {
				if (cad2[contOperador].equals("+")) {
					resultado += Double.parseDouble(cad2[i]);
				}
				if (cad2[contOperador].equals("-")) {
					resultado -= Double.parseDouble(cad2[i]);
				}
				
				contOperador += 2;
			} catch (Exception e) {
				System.out.println("El valor no es un double");
				break;
			}

		}
		System.out.println(resultado);

	}
}