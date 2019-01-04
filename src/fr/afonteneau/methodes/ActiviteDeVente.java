package fr.afonteneau.methodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ActiviteDeVente {
	
	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/the_animal_shop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
	public static final String DATABASE_LOGIN = "root";
	public static final String DATABASE_SECRET = "activ";
	
	public static void reserver () {
		Scanner clavierString = new Scanner(System.in);
		Scanner clavierInt = new Scanner(System.in);
		String utilisateur;
		int modification;
		boolean isRunning = true;

		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "UPDATE Animal SET Sale = ? WHERE Id = ?";
			PreparedStatement preparateur = connexion.prepareStatement(requete);

			while (isRunning == true) {
				System.out.println("Voulez-vous réserver un animal ? OUI/NON ");
				utilisateur = clavierString.nextLine();
				clavierString.reset();
				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {
					System.out.println("Indiquez l'ID de l'animal que vous voulez réserver.");
					modification = clavierInt.nextInt();
					clavierInt.reset();
					preparateur.setInt(2, modification);
					preparateur.setString(1, "reserved");
					preparateur.execute();
					System.out.println();
					System.out.println("Votre animal a bien été réservé.");
					Afficher.afficherStock();

				} else if (utilisateur.equalsIgnoreCase("non") || utilisateur.charAt(0) == 'N'
						|| utilisateur.charAt(0) == 'n') {
					System.out.println("Retour au menu principal.");
					isRunning = false;
				}
			}

			preparateur.close();
			connexion.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public static void annulerReservation () {
		Scanner clavierString = new Scanner(System.in);
		Scanner clavierInt = new Scanner(System.in);
		String utilisateur;
		int modification;
		boolean isRunning = true;

		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "UPDATE Animal SET Sale = ? WHERE Id = ?";
			PreparedStatement preparateur = connexion.prepareStatement(requete);

			while (isRunning == true) {
				System.out.println("Voulez-vous annuler la réservation un animal ? OUI/NON ");
				utilisateur = clavierString.nextLine();
				clavierString.reset();
				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {
					System.out.println("Indiquez l'ID de l'animal dont vous voulez annuler la réservation.");
					modification = clavierInt.nextInt();
					clavierInt.reset();
					preparateur.setInt(2, modification);
					preparateur.setString(1, "available");
					preparateur.execute();
					System.out.println();
					System.out.println("Votre animal est de nouveau disponible.");
					Afficher.afficherStock();

				} else if (utilisateur.equalsIgnoreCase("non") || utilisateur.charAt(0) == 'N'
						|| utilisateur.charAt(0) == 'n') {
					System.out.println("Retour au menu principal.");
					isRunning = false;
				}
			}

			preparateur.close();
			connexion.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void vendre () {
		Scanner clavierString = new Scanner(System.in);
		Scanner clavierInt = new Scanner(System.in);
		String utilisateur;
		int modification;
		boolean isRunning = true;

		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "UPDATE Animal SET Sale = ? WHERE Id = ?";
			PreparedStatement preparateur = connexion.prepareStatement(requete);

			while (isRunning == true) {
				System.out.println("Voulez-vous vendre un animal ? OUI/NON ");
				utilisateur = clavierString.nextLine();
				clavierString.reset();
				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {
					System.out.println("Indiquez l'ID de l'animal que vous voulez vendre.");
					modification = clavierInt.nextInt();
					clavierInt.reset();
					preparateur.setInt(2, modification);
					preparateur.setString(1, "sold");
					preparateur.execute();
					System.out.println();
					System.out.println("Votre animal est vendu.");
					Afficher.afficherStock();

				} else if (utilisateur.equalsIgnoreCase("non") || utilisateur.charAt(0) == 'N'
						|| utilisateur.charAt(0) == 'n') {
					System.out.println("Retour au menu principal.");
					isRunning = false;
				}
			}

			preparateur.close();
			connexion.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
