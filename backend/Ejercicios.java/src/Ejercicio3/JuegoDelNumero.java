package Ejercicio3;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class JuegoDelNumero {
	
	public static void main() {
		
		inicializar();
		
	}
	
	public static void inicializar() {
		var rnd = new Random();
		int num = rnd.nextInt(100);
		System.out.println("Numero Secreto:" + num);		
		Jugada(num);
	}
	
	public static String Jugada(int nRandom) {
		
		for (int intentos = 10; intentos > 0; intentos--) {
			//JOptionPane.showInputDialog("Intenta adivinarlo, introduce un número:");
			System.out.println("Intenta adivinarlo, introduce un número:");
			Scanner teclado = new Scanner(System.in);
			var cad = teclado.nextLine();
			int numeroIntroducido = Integer.parseInt(cad);

			if (numeroIntroducido == nRandom) {
				System.out.println("Has acertado!!");
			} else {
				if (numeroIntroducido > nRandom)
					System.out.println("El número que buscas es mas pequeño.Te quedan "+ intentos +" intentos");
				else
					System.out.println("El número que buscas es mas grande.Te quedan "+ intentos +" intentos");
			}
			if (intentos == 1) {
				return "No has conseguido acertar el número";
			}

		}

		return "Has acertado";
	}
}
