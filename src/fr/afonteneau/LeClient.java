package fr.afonteneau;

import java.util.Scanner;

public class LeClient {
	
public static void choix () {
	Scanner clavier = new Scanner(System.in);
	int choix;
	System.out.println("1 : Afficher le stock.");
	System.out.println("2 : Réserver un animal.");
	System.out.println("Que voulez-vous faire ? (1 ou 2)");
	choix = clavier.nextInt();
	clavier.reset();
	if (choix == 1){
		choixAfficher();
	} else if (choix == 2) {
		choixReserver();
	}
		
		
		
	}
	
	
	
	public static void choixAfficher () {
		
		
	}
	
	public static void choixReserver() {
		
		
	}

}
