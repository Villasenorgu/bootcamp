package Ejercicio5;

import java.util.ArrayList;
import java.util.Collections;

public class BarajaDeNaipes {
	
	static ArrayList<Cartas> barajaActual;
	
	public static void main(String[] args) {
		
		iniBaraja();
		barajar(barajaActual);
		
	}
	
	public static ArrayList<Cartas> iniBaraja() {
		final String[] Palo = { "Picas", "Diamantes", "Tréboles", "Corazónes"};		
		final String[] Valor = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		ArrayList<Cartas> Baraja = new ArrayList<Cartas>();
		
		
		//Crea la baraja
		for(int i = 0; i < Palo.length ; i++) {
			for(int j = 0; j < Valor.length ; j++) {
				Baraja.add(new Cartas(Valor[j],Palo[i]));
			}
		}
		
		//Muestra cada carta por consola
			System.out.println("Tamaño de la baraja: "+Baraja.size()+" cartas");
			System.out.println(Baraja.toString());	
			
			barajaActual = Baraja;
			return Baraja;
	}
	
	public static void barajar(ArrayList<Cartas> Baraja) {
		Collections.shuffle(Baraja);
        System.out.println("Aspecto depues de barajar: "+Baraja.toString());
	}
}
