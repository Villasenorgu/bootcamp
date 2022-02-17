package Ajedrez;

public class Tablero {
	
	private Pieza[][] piezas = new Pieza[8][8];
	
	public Pieza getPieza(int columna, int fila) {
		if(esValido(columna)&&esValido(fila)) {
			if(this.piezas[columna-1][fila-1] != null)
				return this.piezas[columna-1][fila-1];		
			else {
				throw new IllegalArgumentException("No hay pieza");
			}
		}else {
			throw new IllegalArgumentException("Columna o fila no validos");
		}
		
	}
	public Pieza getPieza(Posicion posicion) {
		if(esValido(posicion.getColumna())&&esValido(posicion.getFila())) {
			if(this.piezas[posicion.getColumna()-1][posicion.getFila()-1] != null)
				return this.piezas[posicion.getColumna()-1][posicion.getFila()-1];
			else {
				throw new IllegalArgumentException("No hay pieza");
			}
		}else {
			throw new IllegalArgumentException("Columna o fila no validos");
		}
	}
	
	public void setPieza(int columna, int fila, Pieza pieza) {
		this.piezas[columna-1][fila-1] = pieza;	
		
	}
	public void setPieza(Posicion posicion, Pieza pieza) {
		this.piezas[posicion.getColumna()-1][posicion.getFila()-1] = pieza;	
	}
	
	private boolean esValido(int valido) {
		if(valido > 0 && valido <= 8)
			return true;
		else 
			return false;
	}
	
	public boolean hayPieza(int columna, int fila) {
		if(	this.piezas[columna-1][fila-1] != null)
			return true;
		else
			return false;
	}
	public boolean hayPieza(Posicion posicion) {
		if(this.piezas[posicion.getColumna()-1][posicion.getFila()-1] != null)
			return true;
		else
			return false;
	}
	public void QuitaPieza(int columna, int fila) {
		this.piezas[columna-1][fila-1] = null;
	}
	public void QuitaPieza(Posicion posicion) {
		this.piezas[posicion.getColumna()-1][posicion.getFila()-1] = null;
	}
	public void Mover(Movimiento movimiento) {
		this.getPieza(movimiento.getPosIni()).Mover(movimiento, this);
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
		
			for(int i = 1; !posNext.Equals(movimiento.getPosFin()) ; i++) {
				if(hayPieza(posNext)) {
					return true;
				}else {
					posNext = new Posicion(posNext.getColumna()+(movimiento.deltaColumna()),
							posNext.getFila()+(movimiento.deltaFila()));				
				}
			}return false;		
		}
		
	}
	
}
