package Ajedrez;

public class Movimiento extends Posicion{
	private Posicion PosIni;
	private Posicion PosFin;
	
	public Posicion getPosIni() {
		return PosIni;
	}

	public void setPosIni(Posicion posIni) {
		this.PosIni = posIni;
	}

	public Posicion getPosFin() {
		return PosFin;
	}

	public void setPosFin(Posicion posFin) {
		this.PosFin = posFin;
	}

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
	
	public boolean EsVertical() {
		if(PosIni.getColumna() == PosFin.getColumna() && PosIni.getFila() != PosFin.getFila()) {
			return true;
		}else {return false;}
	}
	public boolean EsHorizontal() {
		if(PosIni.getColumna() != PosFin.getColumna() && PosIni.getFila() == PosFin.getFila()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean EsDiagonal() {
		if(EsHorizontal() == EsVertical()) {
			return true;
		}else {
			return false;
		}
	}
	public int SaltoVertical() {
		return PosFin.getFila()-PosIni.getFila();
	}
	public int SaltoHorizontal() {
		return PosFin.getColumna()-PosIni.getColumna();
	}
	public int deltaFila() {
		if(SaltoVertical() != Math.abs(SaltoVertical())) {
			return 1;
		}else {
			return -1;
		}
	}
	public int deltaColumna() {
		if(SaltoHorizontal() != Math.abs(SaltoHorizontal())) {
			return 1;
		}else {
			return -1;
		}
	}
}
