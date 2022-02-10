package Ajedrez;

public class Tablero {
	
	private Pieza[][] piezas = new Pieza[8][8];
	
	public Tablero() {
		
		piezas[0][0] = new Torre(Color.BLANCO);
		piezas[1][0] = new Caballo(Color.BLANCO);
		piezas[2][0] = new Alfil(Color.BLANCO);
		piezas[3][0] = new Reina(Color.BLANCO);
		piezas[4][0] = new Rey(Color.BLANCO);
		piezas[5][0] = new Alfil(Color.BLANCO);
		piezas[6][0] = new Caballo(Color.BLANCO);
		piezas[7][0] = new Torre(Color.BLANCO);
		for(int i = 0; i < 8 ; i++) {
			piezas[i][1] = new Peon(Color.BLANCO);
			piezas[i][6] = new Peon(Color.NEGRO);
		}
		piezas[0][7] = new Torre(Color.NEGRO);
		piezas[1][7] = new Caballo(Color.NEGRO);
		piezas[2][7] = new Alfil(Color.NEGRO);
		piezas[3][7] = new Reina(Color.NEGRO);
		piezas[4][7] = new Rey(Color.NEGRO);
		piezas[5][7] = new Alfil(Color.NEGRO);
		piezas[6][7] = new Caballo(Color.NEGRO);
		piezas[7][7] = new Torre(Color.NEGRO);
	}
	
	public Pieza Escaque(int columna, int fila) {
		if(piezas[columna-1][fila-1] != null)
			return piezas[columna-1][fila-1];		
		else {
			throw new IllegalArgumentException("No hay pieza");
		}
	}
	public Pieza Escaque(Posicion posicion) {
		if(piezas[posicion.getColumna()-1][posicion.getFila()-1] != null)
			return piezas[posicion.getColumna()-1][posicion.getFila()-1];
		else {
			throw new IllegalArgumentException("No hay pieza");
		}
	}
	
	private boolean esValido(int valido) {
		if(valido > 0 && valido <= 8)
			return true;
		else 
			return false;
	}
	
	public boolean hayPieza(int columna, int fila) {
		if(	piezas[columna-1][fila-1] != null)
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
		piezas[columna-1][fila-1] = null;
	}
	public void QuitaPieza(Posicion posicion) {
		piezas[posicion.getColumna()-1][posicion.getFila()-1] = null;
	}
	public void Mover(Movimiento movimiento) {
		if(!HayPiezasEntre(movimiento)) {
			if(hayPieza(movimiento.getPosIni())) {
				if(piezas[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1].esValido(movimiento, Tablero.this)) {			
					piezas[movimiento.getPosFin().getColumna()-1][movimiento.getPosFin().getFila()-1] = piezas[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1];
					piezas[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1] = null;
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
