package Ajedrez;

public abstract class Pieza{
	private Color elColor;

	public Color getElColor() {
		return elColor;
	}
	public Pieza(Color color){
		this.elColor = color;
	}
	protected abstract boolean esValido(Movimiento movimiento, Tablero tablero);
	public void Mover(Movimiento movimiento, Tablero tablero) {
		if(esValido(movimiento, tablero))
			tablero.Mover(movimiento);
		else
			throw new IllegalArgumentException("No es un movimiento valido");
	}
}
