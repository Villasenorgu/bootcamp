package Ajedrez;

public class Peon extends Pieza {

	public Peon(Color color) {
		super(color);
		
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (this.Avanza(movimiento)) {
			if ((!tablero.hayPieza(movimiento.getPosFin()))) {
				return true;
			}
		}else if(PuedeComer(movimiento, tablero)) {
			return true;
			}
		return false;
	}
	
	public void Promocion(Object pieza, PromocionEventArgs evento) {}
	
	private boolean Avanza(Movimiento movimiento) {
		if (((movimiento.getPosIni().getFila() == 2 && this.getElColor().toString() == Color.BLANCO.toString() && movimiento.SaltoVertical() == (1|2)) 
			|| movimiento.getPosIni().getFila() == 7 && this.getElColor().toString() == Color.BLANCO.toString() && movimiento.SaltoVertical() == (1|2))
				||( movimiento.SaltoVertical() == 1 && movimiento.SaltoHorizontal() == 0)) {
			return true;
		}	
		return false;
	}
	
	private boolean Iniciar(Posicion posicion) {
		return true;
	}
	
	private boolean PuedeComer(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if(movimiento.EsDiagonal() && movimiento.SaltoHorizontal() == 1 && tablero.hayPieza(movimiento.getPosFin()) && (tablero.getPieza(movimiento.getPosFin()).getElColor().toString() != this.getElColor().toString())) {
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
	
	@Override
	public void Mover(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if(esValido(movimiento, tablero)&&Avanza(movimiento)) {
			tablero.setPieza(movimiento.getPosFin(), this);			
		}
	}
	
	protected void onPromocion(PromocionEventArgs evento) {
		
	}
}
