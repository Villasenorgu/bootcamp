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
	 * @throws JuegoException 
	 */
	public void setPosIni(Posicion posIni) throws JuegoException {
		if(posIni != null)
			this.PosIni = posIni;
		else
			throw new JuegoException("Posicion inicial nula");
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
	 * @throws JuegoException 
	 */
	public void setPosFin(Posicion posFin) throws JuegoException {
		if(posFin != null)
		this.PosFin = posFin;
		else
			throw new JuegoException("Posicion final nula");
	}

	/**
	 * Valida dos posiciones distintas y guarda un movimiento
	 * @param movimiento String en formato internacional de ajedrez (A1B1)
	 * @throws JuegoException 
	 */
	public Movimiento(String movimiento) throws JuegoException{
		if(movimiento.length() == 4) {
			this.PosIni = new Posicion(movimiento.charAt(0),movimiento.charAt(1));
			this.PosFin = new Posicion(movimiento.charAt(2),movimiento.charAt(3));
			if(!this.PosIni.Equals(this.PosFin)) {
			}else {
				throw new JuegoException("Las Posiciones no pueden ser la misma para un movimiento");
			}
		}else {
			throw new JuegoException("El movimiento debe ser en nomenclatura internacional A1B2");
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
		if ( SaltoVertical() == SaltoHorizontal()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @return Devuelve Entero con el numero de posiciones de diferencia en un movimiento Vertical en valor absoluto
	 */
	public int SaltoVertical() {
		return Math.abs(PosFin.getFila()-PosIni.getFila());
	}
	/**
	 * @return Devuelve Entero con el numero de posiciones de diferencia en un movimiento Horizontal en valor absoluto
	 */
	public int SaltoHorizontal() {
		return Math.abs(PosFin.getColumna()-PosIni.getColumna());
	}

	/**
	 * @return Aplicado a un movimiento devuelve 0 si la Fila no cambia, 1 si la Fila inicial es mayor que la final y -1 si es menor
	 */
	public int deltaFila() {
		if(PosIni.getFila() == PosFin.getFila()){
			return 0;
		}else if(PosFin.getFila() > PosIni.getFila()){
			return 1;
		}else {
			return -1;
		}
	}

	/**
	 * @return Aplicado a un movimiento devuelve 0 si la Columna no cambia, 1 si la Columna inicial es mayor que la final y -1 si es menor
	 */
	public int deltaColumna() {
		if(PosIni.getColumna() == PosFin.getColumna()){
			return 0;
		}else if(PosFin.getColumna() > PosIni.getColumna()){
			return 1;
		}else {
			return -1;
		}
	}
}
