package Ajedrez;

public class Movimiento extends Posicion{
	private Posicion PosIni;
	private Posicion PosFin;
	
	/**
	 * @return La posicion inicial de un movimiento como Posicion
	 */
	public Posicion getPosIni() {
		return PosIni;
	}

	/**
	 * Establece una posicion inicial para un movimiento
	 * @param posIni Una posicion
	 */
	public void setPosIni(Posicion posIni) {
		this.PosIni = posIni;
	}

	/**
	 * @return La posicion final de un movimiento como Posicion
	 */
	public Posicion getPosFin() {
		return PosFin;
	}
	/**
	 * Establece una posicion final para un movimiento
	 * @param posFin Una posicion
	 */
	public void setPosFin(Posicion posFin) {
		this.PosFin = posFin;
	}

	/**
	 * Valida dos posiciones distintas y guarda un movimiento
	 * @param movimiento String en formato internacional de ajedrez (A1B1)
	 */
	public Movimiento(String movimiento){
		if(movimiento.length() == 4) {
			this.PosIni = new Posicion(movimiento.charAt(0),movimiento.charAt(1));
			this.PosFin = new Posicion(movimiento.charAt(2),movimiento.charAt(3));
			if(!this.PosIni.Equals(this.PosFin)) {
			}else {
				throw new IllegalArgumentException("Las Posiciones no pueden ser la misma para un movimiento");
			}
		}else {
			throw new IllegalArgumentException("El movimiento debe ser en nomenclatura internacional A1B2");
		}
	}
	
	/**
	 * @return Devuelve True si el movimiento es vertical, False si no lo es
	 */
	public boolean EsVertical() {
		if(PosIni.getFila() != PosFin.getFila() && PosIni.getColumna() == PosFin.getColumna()) {
			return true;
		}else {return false;}
	}
	/**
	 * @return Devuelve True si el movimiento es horizontal, False si no lo es
	 */
	public boolean EsHorizontal() {
		if(PosIni.getFila() == PosFin.getFila() && PosIni.getColumna() != PosFin.getColumna()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @return Devuelve True si el movimiento es diagonal, False si no lo es
	 */
	public boolean EsDiagonal() {
		if (!EsHorizontal() && !EsVertical()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @return Devuelve Entero con el numero de posiciones de diferencia en un movimiento Vertical y su dirección(+ o-)
	 */
	public int SaltoVertical() {
		return PosFin.getFila()-PosIni.getFila();
	}
	/**
	 * @return Devuelve Entero con el numero de posiciones de diferencia en un movimiento Horizontal y su dirección(+ o-)
	 */
	public int SaltoHorizontal() {
		return PosFin.getColumna()-PosIni.getColumna();
	}
	/**
	 * @return Devuelve Entero 1 si la direccion del movimiento Horizontal es positiva y -1 si no lo es
	 */
	public int deltaFila() {
		if(SaltoHorizontal() == Math.abs(SaltoHorizontal())) {
			return 1;
		}else {
			return -1;
		}
	}
	/**
	 * @return Devuelve Entero 1 si la direccion del movimiento Vertical es positiva y -1 si no lo es
	 */
	public int deltaColumna() {
		if(SaltoVertical() == Math.abs(SaltoVertical())) {
			return 1;
		}else {
			return -1;
		}
	}
}
