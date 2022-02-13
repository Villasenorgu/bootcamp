package Ajedrez;

import java.awt.Event;

public class Juego {
		
	private static Tablero elTablero = new Tablero();
	private Color elTurno = Color.BLANCO ;
	private boolean partidaActiva = false;
	
	public void Promocion(Object Pieza, PromocionEventArgs evento) {
		
	}
	
	public static Tablero getTablero() {
		return Juego.elTablero;	
	}
	
	public Color getTurno() {
		return elTurno;
	}
	public void inicializar() {
		partidaActiva = true;
		Pieza[][] piezas;
		piezas = elTablero.getPiezas();
		elTablero.setPieza(1,1,new Torre(Color.BLANCO)); 
		elTablero.setPieza(2,1,new Caballo(Color.BLANCO)); 
		elTablero.setPieza(3,1,new Alfil(Color.BLANCO)); 
		elTablero.setPieza(4,1,new Reina(Color.BLANCO)); 
		elTablero.setPieza(5,1,new Rey(Color.BLANCO)); 
		elTablero.setPieza(6,1,new Alfil(Color.BLANCO)); 
		elTablero.setPieza(7,1,new Caballo(Color.BLANCO)); 
		elTablero.setPieza(8,1,new Torre(Color.BLANCO)); 
		for(int i = 1; i < 9 ; i++) {
			elTablero.setPieza(i,2,new Peon(Color.BLANCO)); 
			elTablero.setPieza(i,7,new Peon(Color.NEGRO));
		}
		elTablero.setPieza(1,8,new Torre(Color.NEGRO)); 
		elTablero.setPieza(2,8,new Caballo(Color.NEGRO)); 
		elTablero.setPieza(3,8,new Alfil(Color.NEGRO)); 
		elTablero.setPieza(4,8,new Reina(Color.NEGRO)); 
		elTablero.setPieza(5,8,new Rey(Color.NEGRO)); 
		elTablero.setPieza(6,8,new Alfil(Color.NEGRO)); 
		elTablero.setPieza(7,8,new Caballo(Color.NEGRO)); 
		elTablero.setPieza(8,8,new Torre(Color.NEGRO)); 
		
	}
	
	public void Jugada(String jugada) {
		if(partidaActiva) {
			Movimiento movimiento = new Movimiento(jugada);
			Mover(movimiento);
		}else {
			throw new IllegalArgumentException("Partida no activa");
		}
	}
	
	private void Mover(Movimiento movimiento) {
		if( Juego.elTablero.getPieza(movimiento.getPosIni()).getElColor().toString() == getTurno().toString()) {
		elTablero.Mover(movimiento);
		CambiaTurno();
		}else {
			throw new IllegalArgumentException("Color de la Pieza no válido, juega jugador: "+getTurno().toString());
		}
	}
	
	private void CambiaTurno() {
		if(elTurno == Color.BLANCO)
			elTurno = Color.NEGRO;
		else elTurno = Color.BLANCO;
	}
	
	private void PromocionaPeon(Object Pieza, PromocionEventArgs evento) {
		
	}
	
	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.inicializar();
		juego.partidaActiva = true;
		Juego.elTablero.Clone(Juego.getTablero());
		juego.Jugada("b1c3");
		juego.Jugada("c7c6");
		juego.Jugada("c3d5");
		juego.Jugada("c6d5");
		juego.Jugada("h2h3");
		juego.Jugada("b7b6");
		juego.Jugada("h3h4");
		juego.Jugada("c8a6");
		juego.Jugada("h1h3");
		juego.Jugada("d7d6");
		juego.Jugada("h3g3");
		juego.Jugada("d8d7");
		juego.Jugada("g3f3");
		juego.Jugada("e8d8");
		
	}

}
