package Ajedrez;

public class Reina extends Pieza {

	public Reina(Color color) {
		super(color);
		
	}
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.EsHorizontal() || movimiento.EsVertical() || movimiento.EsDiagonal()) {
			if ((tablero.hayPieza(movimiento.getPosFin()) && tablero.Escaque(movimiento.getPosFin()).getElColor() != this.getElColor())) {
				return true;
			}
		}
		return false;
	}

}
