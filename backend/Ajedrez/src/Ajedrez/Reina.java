package Ajedrez;

public class Reina extends Pieza {

	public Reina(Color color) {
		super(color);
		
	}
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return true;
	}

}
