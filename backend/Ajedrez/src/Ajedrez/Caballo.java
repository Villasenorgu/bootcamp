package Ajedrez;

public class Caballo extends Pieza {

	public Caballo(Color color) {
		super(color);
		
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if ((movimiento.SaltoHorizontal() == 2*movimiento.deltaFila() && movimiento.SaltoVertical() == 1*movimiento.deltaColumna())||(movimiento.SaltoHorizontal() == 1*movimiento.deltaFila() && movimiento.SaltoVertical() == 2*movimiento.deltaColumna())) {
			if ((tablero.hayPieza(movimiento.getPosFin()) && tablero.getPieza(movimiento.getPosFin()).getElColor().toString() != tablero.getPieza(movimiento.getPosIni()).getElColor().toString())) {
				return true;
			}else if(!tablero.hayPieza(movimiento.getPosFin())){
				return true;
			}
		}
		return false;
	}
}
