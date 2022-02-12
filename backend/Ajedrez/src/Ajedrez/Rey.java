package Ajedrez;

public class Rey extends Pieza {
	public Rey(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.SaltoHorizontal() <= 1 && movimiento.SaltoVertical() <= 1) {
			if ((tablero.hayPieza(movimiento.getPosFin()) && tablero.getPieza(movimiento.getPosFin()).getElColor().toString() != tablero.getPieza(movimiento.getPosIni()).getElColor().toString())) {
				return true;
			}else if(!tablero.hayPieza(movimiento.getPosFin())){
				return true;
			}
		}
		return false;
	}

}
