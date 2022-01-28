package Ejercicio1;

import java.util.Random;
import java.util.Scanner;

public class Ejercicios1y2 {

	public static void main(String[] args) {
		//Ejercicio1();
		Ejercicio2();
		
	}
	public static void Ejercicio1(){
		var rnd = new Random();
		int num = rnd.nextInt(100);  
		//System.out.println("Numero Secreto:" + num);
		
		
		for(int intentos = 10; intentos > 0; intentos++) {
			System.out.println("Intenta adivinarlo, introduce un número:");
			Scanner teclado = new Scanner(System.in);
			var cad = teclado.nextLine();
			int numeroIntroducido = Integer.parseInt(cad);
			
			if(numeroIntroducido == num) {
				System.out.println("Has acertado!!");
			}else {
				if(numeroIntroducido>num)
					System.out.println("El número que buscas es mas pequeño.");
				else 
					System.out.println("El número que buscas es mas grande.");								
			}
			
		}
		
	}

	public static void Ejercicio2(){
		//"3+4+3,4-7*1="
		System.out.println("Introduce una cadena de números y operadores");
		Scanner teclado = new Scanner(System.in);
		var cad = teclado.nextLine();
		String[] cad2 = cad.split("");
		
		cad = cad.replaceAll("\\+", " \\+\n");
		cad = cad.replaceAll("\\-", " \\-\n");
		cad = cad.replaceAll("\\*", " \\*\n");
		cad = cad.replaceAll("\\=", " \\=\n");
		System.out.println(cad + " ");
// 		for(int i = 0; i < cad2.length ; i++) {
// 			cad.replaceAll("\\+", "\\+\n");
// 			cad.replaceAll("\\-", "\\-\n");
// 			cad.replaceAll("\\*", "\\*\n");
// 			cad.replaceAll("\\-", "\\=\n");
// 			
//			cad2[i].toString();
//				System.out.println(cad2[i] + " ");
//
//		}
		      
		
	}
}