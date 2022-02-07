package Ejercicio5;

import java.util.ArrayList;

public class Baraja {

	public Baraja() {

	}

	/**
	 * @return Baraja Devueve una baraja de poker en forma de ArrayList<Cartas>
	 */
	public ArrayList<Cartas> iniBaraja() {
		enum Valor {
			AS(13), DOS(1), TRES(2), CUATRO(3), CINCO(4), SEIS(5), SIETE(6), OCHO(7), NUEVE(8), DIEZ(9), J(10), Q(11),
			K(12);
			
			private int puntuacion;
			private Valor(int puntuacion) {
				this.puntuacion = puntuacion;
			}
			public int getPuntuacion() {
				return this.puntuacion;
			}

			
			public static Valor getEnum(int value) {
				switch (value) {
				case 1: return Valor.AS;
				case 2: return Valor.DOS;
				case 3: return Valor.TRES;
				case 4: return Valor.CUATRO;
				case 5: return Valor.CINCO;
				case 6: return Valor.SEIS;
				case 7: return Valor.SIETE;
				case 8: return Valor.OCHO;
				case 9: return Valor.NUEVE;
				case 10: return Valor.DIEZ;
				case 11: return Valor.J;
				case 12: return Valor.Q;
				case 13: return Valor.K;
				default:
					throw new IllegalArgumentException("Unexpected value: " + value);
				}
			}
			
			
		};
		

		final String[] Palo = { "Picas", "Diamantes", "Tréboles", "Corazones" };
		ArrayList<Cartas> Baraja = new ArrayList<Cartas>();

		// Crea la baraja (todas las combinaciones Palo Valor,junto a la puntuacion)
		for (int i = 0; i < Palo.length; i++) {
			for (int j = 0; j < Valor.values().length; j++) {
				Baraja.add(new Cartas(Valor.getEnum(j+1).toString(), Palo[i], Valor.getEnum(j+1).getPuntuacion()));
			}
		}

		// Muestra cada carta por consola
		System.out.println("Tamaño de la baraja: " + Baraja.size() + " cartas");
		System.out.println(Baraja.toString());

		// devuelve la baraja
		return Baraja;
	}

	public ArrayList<Cartas> iniBarajaEspanola() {
		enum Valor {
			UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), SOTA(8), CABALLO(9), REY(10);
			
			private int puntuacion;
			private Valor(int puntuacion) {
				this.puntuacion = puntuacion;
			}
			public int getPuntuacion() {
				return this.puntuacion;
			}

			
			public static Valor getEnum(int value) {
				switch (value) {
				case 1: return Valor.UNO;
				case 2: return Valor.DOS;
				case 3: return Valor.TRES;
				case 4: return Valor.CUATRO;
				case 5: return Valor.CINCO;
				case 6: return Valor.SEIS;
				case 7: return Valor.SIETE;
				case 8: return Valor.SOTA;
				case 9: return Valor.CABALLO;
				case 10: return Valor.REY;
				default:
					throw new IllegalArgumentException("Unexpected value: " + value);
				}
			}
			
			
		};
		
		final String[] Palo = { "Espadas", "Oros", "Bastos", "Copas" };
//		final String[] Valor = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "Sota", "Caballo", "Rey" };
		ArrayList<Cartas> Baraja = new ArrayList<Cartas>();

		// Crea la baraja (todas las combinaciones Palo Valor)
		for (int i = 0; i < Palo.length; i++) {
			for (int j = 0; j < Valor.values().length; j++) {
				Baraja.add(new Cartas(Valor.getEnum(j+1).toString(), Palo[i], Valor.getEnum(j+1).getPuntuacion()));
			}
		}

		// Muestra cada carta por consola
		System.out.println("Tamaño de la baraja: " + Baraja.size() + " cartas");
		System.out.println(Baraja.toString());

		// devuelve la baraja
		return Baraja;
	}
}
