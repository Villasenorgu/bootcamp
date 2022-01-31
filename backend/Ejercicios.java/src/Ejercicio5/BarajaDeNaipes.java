package Ejercicio5;

import java.util.ArrayList;
import java.util.Collections;

public class BarajaDeNaipes {

	static ArrayList<Cartas> barajaActual = new ArrayList<Cartas>();

	static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	public static void main(String[] args) {

		barajaActual = Baraja.iniBaraja();
		//barajaActual = Baraja.iniBarajaEspanola();
		barajar(barajaActual);
		iniJugadores("Pepe", "Juan");
		repartir(barajaActual, 2, jugadores);
		System.out.println(jugadores);
		comparar(barajaActual.get(0), barajaActual.get(1));

	}
	
	/**
	 * @param Baraja
	 * Dado un arrayList<Cartas> reordena de forma aleatoria los elementos.
	 */
	public static void barajar(ArrayList<Cartas> Baraja) {
		Collections.shuffle(Baraja);
		System.out.println("Aspecto despues de barajar: " + Baraja.toString());
	}

	/**
	 * @param nJugador
	 * Dada una lista de al menos 1 String crea un jugador 
	 * a partir de cada uno de ellos y almacena ese String 
	 * como nombre.
	 */
	
	public static void iniJugadores(String... nJugador) {
		for (String nJ : nJugador) {
			Jugador nj = new Jugador();
			nj.setNombre(nJ);
			System.out.println(nj.toString());
			jugadores.add(nj);
		}
	}

	/**
	 * @param Baraja
	 * @param cartasARepartir
	 * @param jugadores
	 * A partir de un ArrayList<Cartas> , el numero de cartas
	 *  a repartir para cada jugador(int) y una lista
	 *  de jugadores(ArrayList<Jugador>)
	 *  reparte de forma alterna entre los jugadores el número 
	 *  de cartas enviado si hay cartas suficientes en el mazo.
	 * 
	 */
	public static void repartir(ArrayList<Cartas> Baraja, int cartasARepartir, ArrayList<Jugador> jugadores) {
		for (int i = 0; i < cartasARepartir; i++) {
			if (cartasARepartir <= Baraja.size()) {
				for (Jugador j : jugadores) {
					j.addCarta(Baraja.get(0));
					Baraja.remove(0);
					System.out.println(j.toString());
				}
			} else {
				System.out.println("No quedan cartas suficientes para repartir al total de jugadores");
			}
		}
		System.out.println("Baraja restante: " + barajaActual);
	}

	/**
	 * @param carta1
	 * @param carta2
	 * Dadas dos Cartas compara el valor individual de cada una
	 *  e indica cual es mayor o si son iguales.
	 */
	public static void comparar(Cartas carta1, Cartas carta2) {
		int c1 = carta1.getPuntuacion();
		int c2 = carta2.getPuntuacion();
		if (c1 == c2) {
			System.out.println(carta1.toString() + " tiene el mismo valor que " + carta2.toString());
		} else if (c1 < c2) {
			System.out.println(carta1.toString() + " tiene menos valor que " + carta2.toString());
		} else {
			System.out.println(carta1.toString() + " tiene mas valor que " + carta2.toString());
		}

	}
}
