package Ajedrez;

public abstract class Pieza {
	private Color elColor;

	public Color getElColor() {
		return elColor;
	}

	public void setElColor(Color elColor) {
		this.elColor = elColor;
	}
	public Pieza(Color color){
		
	}
	protected abstract boolean esValido(Movimiento movimiento, Tablero tablero);
	public void Mover(Movimiento movimiento, Tablero tablero) {}
}
