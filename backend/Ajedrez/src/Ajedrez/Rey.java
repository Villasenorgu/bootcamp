package Ajedrez;

public class Rey extends Pieza {
	public Rey(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.SaltoHorizaontal() <= 1 && movimiento.SaltoVertical() <= 1) {
			if ((tablero.hayPieza(movimiento.getPosFin())
					&& tablero.Escaque(movimiento.getPosFin()).getElColor() != this.getElColor())
					|| !tablero.hayPieza(movimiento.getPosFin())) {
				return true;
			}
		}
		return false;
	}

}
