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
				respuesta = JOptionPane.showInputDialog("Intenta adivinarlo, introduce un número:");
			}
			int numeroIntroducido = Integer.parseInt(respuesta);

			if (numeroIntroducido == nRandom) {
				JOptionPane.showMessageDialog(null, "Has acertado!!");
				break;
			} else {
				if ((numeroIntroducido != nRandom) && intentos == 0) {
					JOptionPane.showMessageDialog(null, "No has conseguido acertar el número");
				} else if (numeroIntroducido > nRandom) {
					if(intentos == 1) {
						respuesta = JOptionPane.showInputDialog("El número que buscas es mas pequeño.Te queda " + intentos + " intento");
					}else{
						respuesta = JOptionPane.showInputDialog("El número que buscas es mas pequeño.Te quedan " + intentos + " intentos");
					}
				} else {
					if(intentos == 1) {
						respuesta = JOptionPane.showInputDialog("El número que buscas es mas grande.Te queda " + intentos + " intento");	
					}else{
						respuesta = JOptionPane.showInputDialog("El número que buscas es mas grande.Te quedan " + intentos + " intentos");
					}
				}
			}
		}
	}
}
