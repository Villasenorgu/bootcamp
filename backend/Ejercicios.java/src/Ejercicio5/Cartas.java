package Ejercicio5;

public class Cartas {
	private String valor;
	private String palo;
	private int puntuacion;
	private boolean bocaArriba = true;

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
		if(this.estaBocaArriba()) {
			return this.getValor() + " de " + this.getPalo();
		}else {
			return "Carta boca abajo";
		}
		
	}
	
	public boolean estaBocaArriba() {
		return bocaArriba;
	}
	
	public void voltearBocaAbajo() {
		this.bocaArriba = false;
	}
	
	public void voltearBocaArriba() {
		this.bocaArriba = true;
	}

}
