package Ajedrez;

public class Alfil extends Pieza {

	public Alfil(Color color) {
		super(color);
		
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.EsDiagonal()) {
			if ((tablero.hayPieza(movimiento.getPosFin()) && !tablero.HayPiezasEntre(movimiento) && tablero.getPieza(movimiento.getPosFin()).getElColor().toString() != this.getElColor().toString())) {
				return true;
			}else if(!tablero.hayPieza(movimiento.getPosFin()) && !tablero.HayPiezasEntre(movimiento)){
				return true;
			}
		}
		return false;
	}

}
