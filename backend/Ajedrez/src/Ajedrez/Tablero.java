package Ajedrez;

public class Tablero {
	
	private Pieza[][] piezas = new Pieza[8][8];
	
	public Pieza getPieza(int columna, int fila) {
		if(getPiezas()[columna-1][fila-1] != null)
			return getPiezas()[columna-1][fila-1];		
		else {
			throw new IllegalArgumentException("No hay pieza");
		}
	}
	public Pieza getPieza(Posicion posicion) {
		if(getPiezas()[posicion.getColumna()-1][posicion.getFila()-1] != null)
			return getPiezas()[posicion.getColumna()-1][posicion.getFila()-1];
		else {
			throw new IllegalArgumentException("No hay pieza");
		}
	}
	
	public void setPieza(int columna, int fila, Pieza pieza) {
		piezas[columna-1][fila-1] = pieza;	
		
	}
	public void setPieza(Posicion posicion, Pieza pieza) {
		getPiezas()[posicion.getColumna()-1][posicion.getFila()-1] = pieza;	
	}
	
	private boolean esValido(int valido) {
		if(valido > 0 && valido <= 8)
			return true;
		else 
			return false;
	}
	
	public boolean hayPieza(int columna, int fila) {
		if(	getPiezas()[columna-1][fila-1] != null)
			return true;
		else
			return false;
	}
	public boolean hayPieza(Posicion posicion) {
		if(getPiezas()[posicion.getColumna()-1][posicion.getFila()-1] != null)
			return true;
		else
			return false;
	}
	public void QuitaPieza(int columna, int fila) {
		getPiezas()[columna-1][fila-1] = null;
	}
	public void QuitaPieza(Posicion posicion) {
		getPiezas()[posicion.getColumna()-1][posicion.getFila()-1] = null;
	}
	public void Mover(Movimiento movimiento) {
		if(hayPieza(movimiento.getPosIni().getColumna(),movimiento.getPosIni().getFila()) && getPiezas()[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1].getClass() == Peon.class) {
			if(!HayPiezasEntre(movimiento)) {
				if(hayPieza(movimiento.getPosIni().getColumna(),movimiento.getPosIni().getFila())) {
					if(hayPieza(movimiento.getPosFin())) {
							getPiezas()[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1].Mover(movimiento, Juego.getTablero());
							QuitaPieza(movimiento.getPosIni());
					}else {
						piezas[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1].Mover(movimiento, Juego.getTablero());
						QuitaPieza(movimiento.getPosIni());
					}
				}
			}
		}
		if(hayPieza(movimiento.getPosIni().getColumna(),movimiento.getPosIni().getFila()) && getPiezas()[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1].getClass() == Caballo.class) {	
			if(getPiezas()[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1].esValido(movimiento, Juego.getTablero())) {
				if(hayPieza(movimiento.getPosFin())) {
					QuitaPieza(movimiento.getPosFin());
					setPieza(movimiento.getPosFin(), getPiezas()[movimiento.getPosFin().getColumna()-1][movimiento.getPosFin().getFila()-1]);
					QuitaPieza(movimiento.getPosIni());
				}else {
					setPieza(movimiento.getPosFin(), getPiezas()[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1]);
					QuitaPieza(movimiento.getPosIni());
				}
			}
		}
		if(hayPieza(movimiento.getPosIni().getColumna(),movimiento.getPosIni().getFila()) && !HayPiezasEntre(movimiento)) {	
			if(getPiezas()[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1].esValido(movimiento, Juego.getTablero())) {
				if(hayPieza(movimiento.getPosFin())) {
					QuitaPieza(movimiento.getPosFin());
					setPieza(movimiento.getPosFin(), getPiezas()[movimiento.getPosFin().getColumna()-1][movimiento.getPosFin().getFila()-1]);
					QuitaPieza(movimiento.getPosIni());
				}else {
					setPieza(movimiento.getPosFin(), getPiezas()[movimiento.getPosIni().getColumna()-1][movimiento.getPosIni().getFila()-1]);
					QuitaPieza(movimiento.getPosIni());
				}
			}
		}
	}
	public Object Clone(Tablero tablero) {
		return piezas.clone();
	}
	public Color ColorEscaque(int columna, int fila) {
		if(columna%2!=0 && fila%2!=0)
	        return Color.NEGRO;
	    return Color.BLANCO;
	}
	public boolean HayPiezasEntre(Movimiento movimiento) {
		if(hayPieza(movimiento.getPosIni().getColumna(), movimiento.getPosIni().getFila())){
			if(movimiento.EsDiagonal()) {
				for(int i = 1; i < Math.abs(movimiento.SaltoHorizontal()) ; i++ ) {
					if(hayPieza(movimiento.getPosIni().getColumna()+(i*movimiento.deltaColumna()), movimiento.getPosIni().getFila()+(i*movimiento.deltaFila()))) {
						return true;
					}
				}
			}
			if(movimiento.EsHorizontal()) {	
				for(int i = 1; i < Math.abs(movimiento.SaltoHorizontal()) ; i++ ) {
					if(hayPieza(movimiento.getPosIni().getColumna()+(i*movimiento.deltaColumna()), movimiento.getPosIni().getFila())) {
						return true;
					}
				}
			}
			if(movimiento.EsVertical()) {
				for(int i = 1; i < Math.abs(movimiento.SaltoVertical()) ; i++ ) {
					if(hayPieza(movimiento.getPosIni().getColumna(), movimiento.getPosIni().getFila()+(i*movimiento.deltaFila()))) {
						return true;
					}
				}
			}
		}		
		return false;
	}
	public Pieza[][] getPiezas() {
		return piezas;
	}
	public void setPiezas(Pieza[][] piezas) {
		this.piezas = piezas;
	}
}
