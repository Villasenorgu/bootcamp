package Ejercicio5;

import java.util.ArrayList;

public class Jugador {
	private String nombre = new String();
	private ArrayList<Cartas> Mano = new ArrayList<Cartas>();

	public Jugador() {

	}

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMano(ArrayList<Cartas> Mano) {
		this.Mano = Mano;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Cartas> getMano() {
		return Mano;
	}

	public String toString() {
		return "Nombre Jugador: " + this.getNombre() + " Mano: " + this.getMano();
	}

	public ArrayList<Cartas> addCarta(Cartas Cartas) {
		Mano.add(Cartas);
		return Mano;
	}

}
