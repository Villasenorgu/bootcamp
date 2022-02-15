package Ajedrez;

public class Tablero {
	
	private Pieza[][] piezas = new Pieza[8][8];
	
	public Pieza getPieza(int columna, int fila) {
		if(piezas[columna-1][fila-1] != null)
			return piezas[columna-1][fila-1];		
		else {
			throw new IllegalArgumentException("No hay pieza");
		}
	}
	public Pieza getPieza(Posicion posicion) {
		if(piezas[posicion.getColumna()-1][posicion.getFila()-1] != null)
			return piezas[posicion.getColumna()-1][posicion.getFila()-1];
		else {
			throw new IllegalArgumentException("No hay pieza");
		}
	}
	
	public void setPieza(int columna, int fila, Pieza pieza) {
		piezas[columna-1][fila-1] = pieza;	
		
	}
	public void setPieza(Posicion posicion, Pieza pieza) {
		piezas[posicion.getColumna()-1][posicion.getFila()-1] = pieza;	
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
							piezas[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1].Mover(movimiento, this);
							QuitaPieza(movimiento.getPosIni());
	}
	
	@Override
	public Object clone() {
		Tablero tablero = new Tablero();
		tablero.piezas = piezas.clone();
		return tablero;
	}
	public Color ColorEscaque(int columna, int fila) {
		if(columna%2!=0 && fila%2!=0)
	        return Color.NEGRO;
		else
			return Color.BLANCO;
	}
	public boolean HayPiezasEntre(Movimiento movimiento) {
		if((!movimiento.EsDiagonal() && !movimiento.EsVertical() && !movimiento.EsHorizontal()) && !hayPieza(movimiento.getPosIni())) {
			throw new IllegalArgumentException("No es un movimiento valido");
		}else {
		Posicion posNext = new Posicion(movimiento.getPosIni().getColumna()+movimiento.deltaColumna(),
				movimiento.getPosIni().getFila()+movimiento.deltaFila());
		
			for(int i = 1; !posNext.equals(movimiento.getPosFin()) ; i++) {
				if(hayPieza(posNext.getColumna()+(movimiento.deltaColumna()*i),posNext.getFila()+(movimiento.deltaFila()*i))) {
					return true;
				}else {
					posNext = new Posicion(movimiento.getColumna()+(movimiento.deltaColumna()*i),movimiento.getFila()+(movimiento.deltaFila()*i));
				}
			}return false;		
		}
		
	}
	
}
