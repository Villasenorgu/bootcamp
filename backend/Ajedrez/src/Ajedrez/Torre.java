package Ajedrez;

public class Torre extends Pieza {

	public Torre(Color color) {
		super(color);
		
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.EsVertical() | movimiento.EsHorizontal()) {
			if ((tablero.hayPieza(movimiento.getPosFin()) && tablero.getPieza(movimiento.getPosFin()).getElColor() != this.getElColor())) {
				return true;
			}
		}
		return false;
	}

}
