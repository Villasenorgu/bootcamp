package Ajedrez;

public class Torre extends Pieza {

	public Torre(Color color) {
		super(color);
		
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.EsVertical() | movimiento.EsHorizontal()) {
			if ((tablero.hayPieza(movimiento.getPosFin()) && tablero.getPieza(movimiento.getPosFin()).getElColor().toString() != this.getElColor().toString())) {
				return true;
			}else if(!tablero.hayPieza(movimiento.getPosFin()) && !tablero.HayPiezasEntre(movimiento)){
				return true;
			}
		}
		return false;
	}

}
