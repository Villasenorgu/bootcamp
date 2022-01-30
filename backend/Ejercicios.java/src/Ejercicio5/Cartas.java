package Ejercicio5;

public class Cartas {
	private String valor;
	private String palo;
	private int puntuacion;

	public Cartas() {
	}

	public Cartas(String valor, String palo, int puntuacion) {
		this.valor = valor;
		this.palo = palo;
		this.puntuacion = puntuacion;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public void setValor(String valor) {
		this.valor = valor;
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
