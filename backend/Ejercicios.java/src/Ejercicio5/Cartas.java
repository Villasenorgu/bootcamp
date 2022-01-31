package Ejercicio5;

public class Cartas {
	private String valor;
	private String palo;
	private int puntuacion;

	public Cartas(String valor, String palo, int puntuacion) {
		this.valor = valor;
		this.palo = palo;
		this.puntuacion = puntuacion;
	}

	public String getPalo() {
		return palo;
	}

	public String getValor() {
		return valor;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public String toString() {
		return this.getValor() + " de " + this.getPalo();
	}

}
