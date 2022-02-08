package Ajedrez;

public class Movimiento extends Posicion{
	private Posicion posIni;
	private Posicion PosFin;
	
	
	public Posicion getPosIni() {
		return posIni;
	}

	public void setPosIni(Posicion posIni) {
		this.posIni = posIni;
	}

	public Posicion getPosFin() {
		return PosFin;
	}

	public void setPosFin(Posicion posFin) {
		PosFin = posFin;
	}

	public Movimiento(String movimiento){
		if(movimiento.length() == 4) {
			var columnaIni = movimiento.charAt(0);
			var filaIni = movimiento.charAt(1);
			posIni = new Posicion(columnaIni,filaIni);
			var columnaFin = movimiento.charAt(2);
			var filaFin = movimiento.charAt(3);
			posIni = new Posicion(columnaFin,filaFin);
		}else {
			throw new IllegalArgumentException("El movimiento debe ser en nomenclatura internacionar A1B2");
		}
	}
	
	public boolean EsVertical() {
		if(posIni.getColumna() == PosFin.getColumna() && posIni.getFila() != PosFin.getFila()) {
			return true;
		}else {return false;}
	}
	public boolean EsHorizontal() {
		if(posIni.getColumna() != PosFin.getColumna() && posIni.getFila() == PosFin.getFila()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean EsDiagonal() {
		if(Math.abs(posIni.getColumna()-PosFin.getColumna()) == Math.abs(posIni.getFila()-PosFin.getFila())) {
			return true;
		}else {
			return false;
		}
	}
	public int SaltoVertical() {
		return posIni.getColumna()-PosFin.getColumna();
	}
	public int SaltoHorizaontal() {
		return posIni.getColumna()-PosFin.getColumna();
	}
	public int deltaFila() {
		if(SaltoVertical() == Math.abs(SaltoVertical())) {
			return 1;
		}else {
			return -1;
		}
	}
	public int deltaColumna() {
		if(SaltoHorizaontal() == Math.abs(SaltoHorizaontal())) {
			return 1;
		}else {
			return -1;
		}
	}
}
