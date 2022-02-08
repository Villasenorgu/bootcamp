package Ejercicio5;

import java.util.ArrayList;

public class MazoDescartes{
	public MazoDescartes() {}
	
	private ArrayList<Cartas> mazoDescartes = new ArrayList<Cartas>();

	public ArrayList<Cartas> getMazoDescartes() {
		return mazoDescartes;
	}

	public void setMazoDescartes(ArrayList<Cartas> mazoDescartes) {
		this.mazoDescartes = mazoDescartes;
	}
	
	public ArrayList<Cartas> addCarta(Cartas Cartas) {
		mazoDescartes.add(Cartas);
		return mazoDescartes;
	}
	
	public String toString() {
		return " Mazo de descartes: " + this.getMazoDescartes();
	}
}
