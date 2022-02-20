package Ajedrez;

public abstract class Pieza{
	private Color elColor;

	public Color getElColor() {
		return elColor;
	}
	public Pieza(Color color){
		this.elColor = color;
	}
	protected abstract boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException;
	public void Mover(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if(esValido(movimiento, tablero)) {
			tablero.setPieza(movimiento.getPosFin(), this);
		}else
			throw new IllegalArgumentException("No es un movimiento valido");
	}
}
