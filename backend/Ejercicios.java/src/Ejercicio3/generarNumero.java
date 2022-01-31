package Ejercicio3;

import java.util.Random;

public class generarNumero {

	public int inicializar() {
		var rnd = new Random();
		int num = rnd.nextInt(100);
		System.out.println("Numero Secreto:" + num);

		return num;

	}

}
