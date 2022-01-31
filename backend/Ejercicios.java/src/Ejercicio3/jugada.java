package Ejercicio3;

import javax.swing.JOptionPane;

public class jugada {

	public static void jugar(int nRandom) {
		var respuesta = "";
		for (int intentos = 9; intentos >= 0; intentos--) {
			if (respuesta.equals("")) {
				respuesta = respuestas.primeraRespuesta();
			}
			int numeroIntroducido = Integer.parseInt(respuesta);

			if (numeroIntroducido == nRandom) {
				respuestas.acertado();
				break;
			} else {
				if ((numeroIntroducido != nRandom) && intentos == 0) {
					respuestas.noConseguido();
				} else if (numeroIntroducido > nRandom) {
					if (intentos == 1) {
						respuesta = respuestas.masPequeno(intentos);
					} else {
						respuesta = respuestas.masPequeno(intentos);
					}
				} else {
					if (intentos == 1) {
						respuesta = respuestas.masGrande(intentos);
					} else {
						respuesta = respuestas.masGrande(intentos);
					}
				}
			}
		}
	}
}
