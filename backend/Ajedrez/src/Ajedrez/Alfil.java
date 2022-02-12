package Ajedrez;

public class Alfil extends Pieza {

	public Alfil(Color color) {
		super(color);
		
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.EsDiagonal()) {
			if ((tablero.hayPieza(movimiento.getPosFin()) && tablero.getPieza(movimiento.getPosFin()).getElColor().toString() != tablero.getPieza(movimiento.getPosIni()).getElColor().toString())) {
				return true;
			}else if(!tablero.hayPieza(movimiento.getPosFin())){
				return true;
			}
		}
		return false;
	}

}
