package Ejercicio3;

import javax.swing.JOptionPane;

public class respuestas {
	
	public static String primeraRespuesta() {
		 String respuesta = JOptionPane.showInputDialog("Intenta adivinarlo, introduce un número:");
		 return respuesta;
	}
	public static void acertado() {
		 JOptionPane.showMessageDialog(null, "Has acertado!!");
	}
	
	public static void noConseguido() {
		JOptionPane.showMessageDialog(null, "No has conseguido acertar el número");
	}
	
	public static String masPequeno(int intentos) {
		if(intentos == 1) {
			String respuesta = JOptionPane.showInputDialog("El número que buscas es mas pequeño.Te queda " + intentos + " intento");
		return respuesta;
		}else {
			String respuesta = JOptionPane.showInputDialog("El número que buscas es mas pequeño.Te quedan " + intentos + " intentos");
			return respuesta;
		}
	}
	
	public static String masGrande(int intentos) {
		if(intentos == 1) {
			String respuesta = JOptionPane.showInputDialog("El número que buscas es mas grande.Te queda " + intentos + " intento");	
			return respuesta;
		}else {
			String respuesta = JOptionPane.showInputDialog("El número que buscas es mas grande.Te quedan " + intentos + " intentos");
			return respuesta;
		}
	}
}
