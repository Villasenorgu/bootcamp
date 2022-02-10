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
		if(Character.isLetter(columna) && !Character.isLetter(fila)) {
			fila = Character.toLowerCase(fila);
			
			switch (fila) {
			case '1': {laFila =  1; break;}
			case '2': {laFila =  2; break;}
			case '3': {laFila =  3; break;}
			case '4': {laFila =  4; break;}
			case '5': {laFila =  5; break;}
			case '6': {laFila =  6; break;}
			case '7': {laFila =  7; break;}
			case '8': {laFila =  8; break;}
			default:
				throw new IllegalArgumentException("Valor inesperado: " + fila);
				
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
				throw new IllegalArgumentException("Valor inesperado: " + columna);
			}
		}else {
			throw new IllegalArgumentException("Ni fila ni columna pueden ser nulos");
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
