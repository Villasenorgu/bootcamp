package Ajedrez;

public class Posicion {
	private int laFila;
	private int laColumna;
	
	/**
	 * @return laFila de una posición
	 */
	public int getFila() {
		return laFila;
	}
	
	/**
	 * @return laColumna de una posición
	 */
	public int getColumna() {
		return laColumna;
	}
	
	public Posicion() {}

	/**
	 * Recibe una posicion en forma de enteros,la valida y la guarda
	 * @param columna Entero entre 1 y 8
	 * @param fila Entero entre 1 y 8
	 * @throws JuegoException 
	 */
	public Posicion(int columna, int fila) throws JuegoException {
		if(fila > 0 && fila < 9) {
			laFila = fila;
		} else {
			throw new JuegoException("Valor inesperado: " + fila + " .Requiere un valor entre 0 y 8");
		}
		if(columna > 0 && columna < 9) {
		laColumna = columna;
		} else {
			throw new JuegoException("Valor inesperado: " + columna + " .Requiere un valor entre 0 y 8");
		}
	}
	
	/**
	 * Recibe una posicion en formato internacional de ajedrez(Caracter(A-H), Caracter(1-8)),la valida, las transforma en enteros y la guarda
	 * @param columna Caracter entre A y H
	 * @param fila Caracter entre 1 y 8
	 * @throws JuegoException 
	 */
	public Posicion(char columna, char fila) throws JuegoException {
		if(Character.isLetter(columna) && !Character.isLetter(fila)) {
			columna = Character.toLowerCase(columna);
			
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
				throw new JuegoException("Valor inesperado: " + fila);
				
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
				throw new JuegoException("Valor inesperado: " + columna);
			}
		}else {
			throw new JuegoException("Ni fila ni columna pueden ser nulos");
		}
		
	}

	/**
	 * Comprueba si dos posiciones son iguales
	 * @param posicion Posicion con la que comparar
	 * @return True si ambas posiciones coinciden
	 */
	public boolean Equals(Posicion posicion) {
		if(posicion.laColumna == this.laColumna && posicion.laFila == this.laFila) {
			return true;
		} else {
			return false;
			}
	}
	
}
