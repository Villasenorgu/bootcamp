package Ajedrez;

public class Movimiento {
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

	public Movimiento(String movimiento) {
		
	}
	
	public boolean EsVertical() {
		return true;
	}
	public boolean EsHorizontal() {
		return true;
	}
	public boolean EsDiagonal() {
		return true;
	}
	public int SaltoVertical() {
		return 1;
	}
	public int SaltoHorizaontal() {
		return 1;
	}
	public int deltaFila() {
		return 1;
	}
	public int deltaColumna() {
		return 1;
	}
}
