package Ejercicio3;

import javax.swing.JOptionPane;

public class respuestas {
	
	public static String primeraRespuesta() {
		 String respuesta = JOptionPane.showInputDialog("Intenta adivinarlo, introduce un n�mero:");
		 return respuesta;
	}
	public static void acertado() {
		 JOptionPane.showMessageDialog(null, "Has acertado!!");
	}
	
	public static void noConseguido() {
		JOptionPane.showMessageDialog(null, "No has conseguido acertar el n�mero");
	}
	
	public static String masPequeno(int intentos) {
		if(intentos == 1) {
			String respuesta = JOptionPane.showInputDialog("El n�mero que buscas es mas peque�o.Te queda " + intentos + " intento");
		return respuesta;
		}else {
			String respuesta = JOptionPane.showInputDialog("El n�mero que buscas es mas peque�o.Te quedan " + intentos + " intentos");
			return respuesta;
		}
	}
	
	public static String masGrande(int intentos) {
		if(intentos == 1) {
			String respuesta = JOptionPane.showInputDialog("El n�mero que buscas es mas grande.Te queda " + intentos + " intento");	
			return respuesta;
		}else {
			String respuesta = JOptionPane.showInputDialog("El n�mero que buscas es mas grande.Te quedan " + intentos + " intentos");
			return respuesta;
		}
	}
}
