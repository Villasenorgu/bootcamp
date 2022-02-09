package Ajedrez;

public class Tablero {
	private Pieza[][] piezas = new Pieza[7][7];
	
	public Pieza Escaque(int columna, int fila) {
		if(piezas[columna-1][fila-1] != null)
			throw new IllegalArgumentException("No hay pieza");
		else {
			return piezas[columna-1][fila-1];
		}
	}
	public Pieza Escaque(Posicion posicion) {
		if(piezas[posicion.getColumna()][posicion.getFila()] != null)
			throw new IllegalArgumentException("No hay pieza");
		else {
		return piezas[posicion.getColumna()][posicion.getFila()];
		}
	}
	
	private boolean esValido(int valido) {
		if(valido > 0 && valido <= 8)
			return true;
		else 
			return false;
	}
	
	public boolean hayPieza(int columna, int fila) {
		if(	piezas[columna][fila] != null)
			return true;
		else
			return false;
	}
	public boolean hayPieza(Posicion posicion) {
		if(piezas[posicion.getColumna()][posicion.getFila()] != null)
			return true;
		else
			return false;
	}
	public void QuitaPieza(int columna, int fila) {
		piezas[columna][fila] = null;
	}
	public void QuitaPieza(Posicion posicion) {
		piezas[posicion.getColumna()][posicion.getFila()] = null;
	}
	public void Mover(Movimiento movimiento) {
		
		//Habria que comprobar si el movimiento es valido etc etc
		if(hayPieza(movimiento.getPosIni())) {
			piezas[movimiento.getPosFin().getColumna()][movimiento.getPosFin().getFila()] = piezas[movimiento.getPosIni().getColumna()][movimiento.getPosIni().getFila()];			
		}
	}
	public Object Clone(Tablero tablero) {
		return tablero = new Tablero();
	}
	public Color ColorEscaque(int columna, int fila) {
		if(piezas[columna-1][fila-1] != null)
			return piezas[columna-1][fila-1].getElColor();
		else
			throw new IllegalArgumentException("No hay pieza");
	}
	public boolean HayPiezasEntre(Movimiento movimiento) {
		return true;
	}
}
