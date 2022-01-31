package Ejercicio3;

import java.util.Random;

import javax.swing.JOptionPane;

public class JuegoDelNumero {

	public static void main(String[] args) {

		final int numeroSecreto = generarNumero.inicializar();
		jugada.jugar(numeroSecreto);
	}

}
