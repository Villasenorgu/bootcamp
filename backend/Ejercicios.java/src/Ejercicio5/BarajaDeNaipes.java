package Ejercicio5;

import java.util.ArrayList;
import java.util.Collections;

public class BarajaDeNaipes {

	static ArrayList<Cartas> barajaActual= new ArrayList<Cartas>();;

	static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	public static void main(String[] args) {

		barajaActual = Baraja.iniBaraja();
		barajar(barajaActual);
		iniJugadores("Pepe", "Juan");
		System.out.println(jugadores);
		repartir(barajaActual, 2, jugadores);
		System.out.println(jugadores);
		comparar(barajaActual.get(0),barajaActual.get(1));

	}

	

	public static void barajar(ArrayList<Cartas> Baraja) {
		Collections.shuffle(Baraja);
		System.out.println("Aspecto despues de barajar: " + Baraja.toString());
	}

	public static void iniJugadores(String...nJugador) {
		for(String nJ:nJugador) {
		Jugador nj = new Jugador();
		nj.setNombre(nJ);
		System.out.println(nj.toString());
		jugadores.add(nj);
		}
	}

	public static void repartir(ArrayList<Cartas> Baraja, int cartasARepartir,ArrayList<Jugador> jugadores) {
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
		System.out.println("Baraja restante: "+barajaActual);
	}

	public static void comparar(Cartas carta1, Cartas carta2) {
		int c1 = carta1.getPuntuacion();
		int c2 = carta2.getPuntuacion();
		if(c1 == c2) {
			System.out.println(carta1.toString()+" tiene el mismo valor que "+carta2.toString());
		}else if(c1 < c2) {
			System.out.println(carta1.toString()+" tiene menos valor que "+carta2.toString());
		}else {
			System.out.println(carta1.toString()+" tiene mas valor que "+carta2.toString());
		}
		
	}
}
