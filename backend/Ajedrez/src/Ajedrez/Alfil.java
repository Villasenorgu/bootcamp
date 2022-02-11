package Ajedrez;

public class Alfil extends Pieza {

	public Alfil(Color color) {
		super(color);
		
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.EsDiagonal()) {
			if ((tablero.hayPieza(movimiento.getPosFin()) && tablero.Escaque(movimiento.getPosFin()).getElColor() != this.getElColor())) {
				return true;
			}
		}
		return false;
	}

}
