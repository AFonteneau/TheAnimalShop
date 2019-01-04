package fr.afonteneau;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import fr.afonteneau.methodes.ActiviteDeVente;
import fr.afonteneau.methodes.Afficher;
import fr.afonteneau.methodes.GestionDeStock;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner clavier = new Scanner(System.in);
		String identite;
		System.out.println("Identifiez-vous ? (Client/Admin)");
		identite = clavier.nextLine();
		clavier.reset();
		if (identite.equalsIgnoreCase("Client")){
			LeClient.choix();
		} else if (identite.equalsIgnoreCase("Admin")) {
			LaBoutique.choix();
		}
	
	}
	
	public static void Menu() {
		
	}
	
	public static void Retour() {
		
	}
}
