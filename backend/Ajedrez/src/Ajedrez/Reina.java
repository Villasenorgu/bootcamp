package Ajedrez;

public class Reina extends Pieza {

	public Reina(Color color) {
		super(color);
		
	}
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if ((movimiento.EsHorizontal() || movimiento.EsVertical() || movimiento.EsDiagonal()) && !tablero.HayPiezasEntre(movimiento)) {
				return true;
			}		
		return false;
	}

}
