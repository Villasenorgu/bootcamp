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


	public Posicion(int fila, int columna) {
		laFila = fila;
		laColumna = columna;
	}
	
	public Posicion(char fila, char columna) {
		
		fila = Character.toLowerCase(fila);
		columna = Character.toLowerCase(columna);	
		switch (fila) {
		case 'a': {laFila =  1; break;}
		case 'b': {laFila =  2; break;}
		case 'c': {laFila =  3; break;}
		case 'd': {laFila =  4; break;}
		case 'e': {laFila =  5; break;}
		case 'f': {laFila =  6; break;}
		case 'g': {laFila =  7; break;}
		case 'h': {laFila =  8; break;}
		default:
			throw new IllegalArgumentException("Unexpected value: " + fila);
			
		}
		
		switch(columna) {
		case 'a': {laColumna =  1; break;}
		case 'b': {laColumna =  2; break;}
		case 'c': {laColumna =  3; break;}
		case 'd': {laColumna =  4; break;}
		case 'e': {laColumna =  5; break;}
		case 'f': {laColumna =  6; break;}
		case 'g': {laColumna =  7; break;}
		case 'h': {laColumna =  8; break;}
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
