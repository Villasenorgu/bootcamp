package Ajedrez;

public class Tablero {
	private Pieza[][] piezas = new Pieza[8][8];
	
	public Pieza Escaque(int columna, int fila) {
		int i = 0;
		return piezas[i][i];
	}
	public Pieza Escaque(Posicion posicion) {
		int i = 0;
		return piezas[i][i];
	}
	
	private boolean esValido(int valido) {
		return true;
	}
	
	public boolean hayPieza(int columna, int fila) {
		return true;
	}
	public boolean hayPieza(Posicion posicion) {
		return true;
	}
	public void QuitaPieza(int columa, int fila) {
		
	}
	public void QuitaPieza(Posicion posicion) {
			
	}
	public void Mover(Movimiento movimiento) {
		
	}
	public Object Clone(Tablero tablero) {
		return tablero = new Tablero();
	}
	public Color ColorEscaque(int columna, int fila) {
		return Color.BLANCO;
	}
	public boolean HayPiezasEntre(Movimiento movimiento) {
		return true;
	}
}
