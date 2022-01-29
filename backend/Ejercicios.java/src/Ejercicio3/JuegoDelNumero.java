package Ejercicio3;

import java.util.Random;

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

	public static void Jugada(int nRandom) {
		var respuesta = "";
		for (int intentos = 9; intentos >= 0; intentos--) {
			if (respuesta.equals("")) {
				respuesta = JOptionPane.showInputDialog("Intenta adivinarlo, introduce un n�mero:");
			}
			int numeroIntroducido = Integer.parseInt(respuesta);

			if (numeroIntroducido == nRandom) {
				JOptionPane.showMessageDialog(null, "Has acertado!!");
				break;
			} else {
				if ((numeroIntroducido != nRandom) && intentos == 0) {
					JOptionPane.showMessageDialog(null, "No has conseguido acertar el n�mero");
				} else if (numeroIntroducido > nRandom) {
					respuesta = JOptionPane
							.showInputDialog("El n�mero que buscas es mas peque�o.Te quedan " + intentos + " intentos");
				} else {
					respuesta = JOptionPane
							.showInputDialog("El n�mero que buscas es mas grande.Te quedan " + intentos + " intentos");
				}
			}
		}
	}
}
