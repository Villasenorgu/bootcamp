package Ejercicio5;

import java.util.ArrayList;

public class Jugador{
	private String nombre = new String();
	private ArrayList<Cartas> Mano = new ArrayList<Cartas>();
	private boolean ciega = false;

	public Jugador() {

	}

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param Mano Crea una Mano dado un conjunto de cartas como ArrayList<Cartas>
	 */
	public void setMano(ArrayList<Cartas> Mano) {
		this.Mano = Mano;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Cartas> getMano() {
		return Mano;
	}
	
	public boolean getCiega() {
		return ciega;
	}
	
	public void setCiega(boolean ciega) {
		this.ciega = ciega;
	}

	public String toString() {
		return "Nombre Jugador: " + this.getNombre() + " Mano: " + this.getMano();
	}

	/**
	 * @param Cartas
	 * @return dada una carta(Cartas) la añade a la mano de un jugador y devuelve
	 *         una Arraylist<Cartas> como Mano
	 */
	public ArrayList<Cartas> addCarta(Cartas Cartas) {
		Mano.add(Cartas);
		return Mano;
	}

}
