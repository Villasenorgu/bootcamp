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
		if(piezas[posicion.getColumna()-1][posicion.getFila()-1] != null)
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
		if(!HayPiezasEntre(movimiento)) {
			if(hayPieza(movimiento.getPosIni())) {
				if(piezas[movimiento.getPosIni().getColumna()][movimiento.getPosIni().getFila()].esValido(movimiento, Tablero.this)) {			
					piezas[movimiento.getPosFin().getColumna()][movimiento.getPosFin().getFila()] = piezas[movimiento.getPosIni().getColumna()][movimiento.getPosIni().getFila()];
					piezas[movimiento.getPosIni().getColumna()][movimiento.getPosIni().getFila()] = null;
				}
			}
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
		int aumentoH;
		int aumentoV;
		for(int i = 1; i < Math.max(movimiento.SaltoHorizontal(),movimiento.SaltoVertical())-1; i++) {
			if(movimiento.SaltoHorizontal()>0) {
				aumentoH = movimiento.getPosIni().getColumna()+(i*movimiento.deltaColumna());
			}else aumentoH = 0;
			if(movimiento.SaltoHorizontal()>0) {
				aumentoV = movimiento.getPosIni().getFila()+(i*movimiento.deltaColumna());			
			}else aumentoV = 0;
			if(hayPieza(movimiento.getPosIni().getColumna()+aumentoH,movimiento.getPosIni().getFila()+aumentoV)) {
				return true;
			}
		}
		return false;
	}
}
