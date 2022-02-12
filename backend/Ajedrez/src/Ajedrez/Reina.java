package Ajedrez;

public class Reina extends Pieza {

	public Reina(Color color) {
		super(color);
		
	}
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.EsHorizontal() || movimiento.EsVertical() || movimiento.EsDiagonal()) {
			if ((tablero.hayPieza(movimiento.getPosFin()) && tablero.getPieza(movimiento.getPosFin()).getElColor().toString() != tablero.getPieza(movimiento.getPosIni()).getElColor().toString())) {
				return true;
			}else if(!tablero.hayPieza(movimiento.getPosFin())){
				return true;
			}
		}
		return false;
	}

}
