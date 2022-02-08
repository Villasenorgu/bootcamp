package Ajedrez;

public class Peon extends Pieza {

	public Peon(Color color) {
		super(color);
		
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return true;
	}
	
	public void Promocion(Object pieza, PromocionEventArgs evento) {}
	
	private boolean Avanza(Movimiento movimiento) {
		return true;
	}
	
	private boolean Iniciar(Posicion posicion) {
		return true;
	}
	
	private boolean PuedeComer(Movimiento movimiento, Tablero tablero) {
		return true;
	}
	
	private boolean NecesitaPromocion(Posicion posicion) {
		return true;
	}
	
	public void Mover(Movimiento movimiento, Tablero tablero) {
		
	}
	
	protected void onPromocion(PromocionEventArgs evento) {
		
	}
}
