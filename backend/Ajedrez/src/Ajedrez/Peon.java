package Ajedrez;

public class Peon extends Pieza {

	public Peon(Color color) {
		super(color);
		
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (this.Avanza(movimiento)) {
			if ((!tablero.hayPieza(movimiento.getPosFin()))) {
				return true;
			}
			else if(this.PuedeComer(movimiento, tablero)) {
			return true;
			}
		}return false;
	}
	
	public void Promocion(Object pieza, PromocionEventArgs evento) {}
	
	private boolean Avanza(Movimiento movimiento) {
		if ((movimiento.SaltoHorizontal() == 0 && movimiento.SaltoVertical() == 1*movimiento.deltaColumna())) {
			return true;
		}	
		return false;
	}
	
	private boolean Iniciar(Posicion posicion) {
		return true;
	}
	
	private boolean PuedeComer(Movimiento movimiento, Tablero tablero) {
		if(movimiento.EsDiagonal() && movimiento.SaltoHorizontal() == 1*movimiento.deltaFila() && tablero.hayPieza(movimiento.getPosFin()) && (tablero.Escaque(movimiento.getPosFin()).getElColor() != this.getElColor())) {
			return true;
			}
		return false;
	}
	
	private boolean NecesitaPromocion(Posicion posicion) {
		if(this.getElColor() == Color.BLANCO) {
			if(posicion.getColumna() == 8) {
				return true;
			}
		}else {
			if(posicion.getColumna() == 1) {
				return true;
			}
		}
		return false;
	}
	
	public void Mover(Movimiento movimiento, Tablero tablero) {
		
	}
	
	protected void onPromocion(PromocionEventArgs evento) {
		
	}
}
