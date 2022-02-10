package Ajedrez;

import java.awt.Event;

public class Juego {
	
	private Tablero elTablero;
	private Color elTurno = Color.BLANCO ;
	private boolean partidaActiva = false;
	
	public void Promocion(Object Pieza, PromocionEventArgs evento) {
		
	}
	
	public Tablero getTablero() {
		return this.elTablero;
	}
	
	public Color getTurno() {
		return elTurno;
	}
	public void inicializar() {
		partidaActiva = true;
	};
	
	public void Jugada(String jugada) {
		Movimiento movimiento = new Movimiento(jugada);
		Mover(movimiento);
	}
	
	private void Mover(Movimiento movimiento) {
		this.elTablero.Mover(movimiento);
	}
	
	private void CambiaTurno() {
		if(elTurno == Color.BLANCO)
			elTurno = Color.NEGRO;
		else elTurno = Color.BLANCO;
	}
	
	private void PromocionaPeon(Object Pieza, PromocionEventArgs evento) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
