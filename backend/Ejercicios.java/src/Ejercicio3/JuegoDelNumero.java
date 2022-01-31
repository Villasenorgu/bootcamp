package Ejercicio3;

public class JuegoDelNumero {

	public static void main(String[] args) {
		generarNumero nuevoNumero = new generarNumero();		
		jugada nuevaJugada = new jugada();
		
		int numeroSecreto = nuevoNumero.inicializar();
		nuevaJugada.jugar(numeroSecreto);
	}

}
