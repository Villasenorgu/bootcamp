package Ajedrez;

public class Posicion {
	private int laFila;
	private int laColumna;
	
	public int getFila() {
		return laFila;
	}
	
	public int getColumna() {
		return laColumna;
	}
	
	public Posicion() {}

	public Posicion(int columna, int fila) {
		if(fila > 0 && fila < 9) {
			laFila = fila;
		} else {
			throw new IllegalArgumentException("Valor inesperado: " + fila + " .Requiere un valor entre 0 y 8");
		}
		if(columna > 0 && columna < 9) {
		laColumna = columna;
		} else {
			throw new IllegalArgumentException("Valor inesperado: " + columna + " .Requiere un valor entre 0 y 8");
		}
	}
	
	public Posicion(char columna, char fila) {
		
		fila = Character.toLowerCase(fila);
		columna = Character.toLowerCase(columna);
		
		switch (fila) {
		case 'a': {fila =  1; break;}
		case 'b': {fila =  2; break;}
		case 'c': {fila =  3; break;}
		case 'd': {fila =  4; break;}
		case 'e': {fila =  5; break;}
		case 'f': {fila =  6; break;}
		case 'g': {fila =  7; break;}
		case 'h': {fila =  8; break;}
		default:
			throw new IllegalArgumentException("Unexpected value: " + fila);
			
		}
		
		switch(columna) {
		case 'a': {columna =  1; break;}
		case 'b': {columna =  2; break;}
		case 'c': {columna =  3; break;}
		case 'd': {columna =  4; break;}
		case 'e': {columna =  5; break;}
		case 'f': {columna =  6; break;}
		case 'g': {columna =  7; break;}
		case 'h': {columna =  8; break;}
		default:
			throw new IllegalArgumentException("Unexpected value: " + columna);
		}
		
	}
	
	public boolean Equals(Posicion posicion) {
		if(posicion.laColumna == this.laColumna && posicion.laFila == this.laFila) {
			return true;
		} else {
			return false;
			}
	}
	
}
