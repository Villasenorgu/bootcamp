package Ejercicio5;

public class Cartas {
	private String valor;
	private String palo;
	
	public Cartas() {}
	
	public Cartas(String valor, String palo) {
		this.valor = valor;
		this.palo = palo;
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
	
	@Override
	public String toString() {
		return this.getValor() + " de " + this.getPalo();
	}
}
