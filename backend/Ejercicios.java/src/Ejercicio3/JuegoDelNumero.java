package Ejercicio3;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class JuegoDelNumero {
	
	public static void main(String[] args) {
		
		inicializar();
		
	}
	
	public static void inicializar() {
		var rnd = new Random();
		int num = rnd.nextInt(100);
		System.out.println("Numero Secreto:" + num);		
		Jugada(num);
	}
	
	public static String Jugada(int nRandom) {
		
		for (int intentos = 9; intentos >= 0; intentos--) {
			//JOptionPane.showInputDialog("Intenta adivinarlo, introduce un n�mero:");
			System.out.println("Intenta adivinarlo, introduce un n�mero:");
			Scanner teclado = new Scanner(System.in);
			var cad = teclado.nextLine();
			int numeroIntroducido = Integer.parseInt(cad);

			if (numeroIntroducido == nRandom) {
				System.out.println("Has acertado!!");
				break;
			} else {
				if((numeroIntroducido != nRandom) && intentos == 0) {					
				System.out.println("No has conseguido acertar el n�mero");
				return "No has conseguido acertar el n�mero";
				}else if (numeroIntroducido > nRandom) {					
					System.out.println("El n�mero que buscas es mas peque�o.Te quedan "+ intentos +" intentos");
				}
				else {
					System.out.println("El n�mero que buscas es mas grande.Te quedan "+ intentos +" intentos");
				}
			}

		}

		return "Has acertado";
	}
}
