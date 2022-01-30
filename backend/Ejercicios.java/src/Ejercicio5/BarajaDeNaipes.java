package Ejercicio5;

import java.util.ArrayList;
import java.util.Collections;

public class BarajaDeNaipes {

	static ArrayList<Cartas> barajaActual;
	static Jugador jugador1 = new Jugador();
	static Jugador jugador2 = new Jugador();

	public static void main(String[] args) {

		iniBaraja();
		barajar(barajaActual);
		iniJugadores("Pepe", "Juan");
		repartir(barajaActual, 2, jugador1, jugador2);

	}

	public static ArrayList<Cartas> iniBaraja() {
		final String[] Palo = { "Picas", "Diamantes", "Tréboles", "Corazones" };
		final String[] Valor = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		ArrayList<Cartas> Baraja = new ArrayList<Cartas>();

		// Crea la baraja (todas las combinaciones Palo Valor)
		for (int i = 0; i < Palo.length; i++) {
			for (int j = 0; j < Valor.length; j++) {
				Baraja.add(new Cartas(Valor[j], Palo[i]));
			}
		}

		// Muestra cada carta por consola
		System.out.println("Tamaño de la baraja: " + Baraja.size() + " cartas");
		System.out.println(Baraja.toString());

		// devuelve la baraja
		barajaActual = Baraja;
		return Baraja;
	}

	public static void barajar(ArrayList<Cartas> Baraja) {
		Collections.shuffle(Baraja);
		System.out.println("Aspecto despues de barajar: " + Baraja.toString());
	}

	public static void iniJugadores(String nJugador1, String nJugador2) {
		jugador1.setNombre(nJugador1);
		jugador2.setNombre(nJugador2);
		System.out.println(jugador1.toString());
		System.out.println(jugador2.toString());
	}

	public static void repartir(ArrayList<Cartas> Baraja, int cartasARepartir, Jugador jugador1, Jugador jugador2) {
		for (int i = 0; i < cartasARepartir; i++) {
			if (cartasARepartir <= Baraja.size()) {
				jugador1.addCarta(Baraja.get(0));
				Baraja.remove(0);
				jugador2.addCarta(Baraja.get(0));
				Baraja.remove(0);
				System.out.println(jugador1.toString());
				System.out.println(jugador2.toString());
			}
		}
	}
}
