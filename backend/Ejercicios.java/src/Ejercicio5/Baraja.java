package Ejercicio5;

import java.util.ArrayList;

public class Baraja {

	public Baraja() {

	}

	/**
	 * @return Baraja
	 * Devueve una baraja de poker en forma de ArrayList<Cartas> 
	 */
	public static ArrayList<Cartas> iniBaraja() {
		final String[] Palo = { "Picas", "Diamantes", "Tréboles", "Corazones" };
		final String[] Valor = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		ArrayList<Cartas> Baraja = new ArrayList<Cartas>();

		// Crea la baraja (todas las combinaciones Palo Valor)
		for (int i = 0; i < Palo.length; i++) {
			for (int j = 0; j < Valor.length; j++) {
				Baraja.add(new Cartas(Valor[j], Palo[i], j + 1));
			}
		}

		// Muestra cada carta por consola
		System.out.println("Tamaño de la baraja: " + Baraja.size() + " cartas");
		System.out.println(Baraja.toString());

		// devuelve la baraja
		return Baraja;
	}
	
	public static ArrayList<Cartas> iniBarajaEspanola() {
		final String[] Palo = { "Espadas", "Oros", "Bastos", "Copas" };
		final String[] Valor = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "Sota", "Caballo", "Rey" };
		ArrayList<Cartas> Baraja = new ArrayList<Cartas>();

		// Crea la baraja (todas las combinaciones Palo Valor)
		for (int i = 0; i < Palo.length; i++) {
			for (int j = 0; j < Valor.length; j++) {
				Baraja.add(new Cartas(Valor[j], Palo[i], j + 1));
			}
		}

		// Muestra cada carta por consola
		System.out.println("Tamaño de la baraja: " + Baraja.size() + " cartas");
		System.out.println(Baraja.toString());

		// devuelve la baraja
		return Baraja;
	}
}
