package Ejercicio5;

import java.util.ArrayList;

public class CartasEnMesa {
	public CartasEnMesa() {}
	
	private ArrayList<Cartas> mesa = new ArrayList<Cartas>();
	

	public ArrayList<Cartas> getCartasEnMesa() {
		return mesa;
	}

	
	public ArrayList<Cartas> addCarta(Cartas Cartas) {
		mesa.add(Cartas);
		return mesa;
	}
	
	public String toString() {
		return " Cartas en Mesa: " +this.getCartasEnMesa();

	}
}
