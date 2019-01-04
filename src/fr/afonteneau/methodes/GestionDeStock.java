package fr.afonteneau.methodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import fr.afonteneau.sqltables.Animal;

public class GestionDeStock {

	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/the_animal_shop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
	public static final String DATABASE_LOGIN = "root";
	public static final String DATABASE_SECRET = "activ";

	public static final void ajouterAnimal() {

		Scanner clavier = new Scanner(System.in);
		String utilisateur;
		int utilisateurInt;
		boolean isRunning = true;

		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "INSERT INTO Animal ( Species, Name, Gender, Age, Sale, Price) VALUES (?,?,?,?,?,?)";
			PreparedStatement preparateur = connexion.prepareStatement(requete);

			while (isRunning == true) {
				System.out.println("Voulez-vous ajouter un animal ? ");
				utilisateur = clavier.nextLine();
				clavier.reset();

				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {

					// ======= Espece =======
					System.out.println("Indiquez l'espèce de l'animal : ");
					utilisateur = clavier.nextLine();
					preparateur.setString(1, utilisateur);
					clavier.reset();
					// =========== Nom ========
					System.out.println("Indiquez le nom de l'animal : ");
					utilisateur = clavier.nextLine();
					preparateur.setString(2, utilisateur);
					clavier.reset();
					// ======= Gender ======
					System.out.println("Indiquez le genre de l'animal : ");
					utilisateur = clavier.nextLine();
					preparateur.setString(3, utilisateur);
					clavier.reset();
					// ====== Age =======
					System.out.println("Indiquez l'âge de l'animal : ");
					utilisateurInt = clavier.nextInt();
					preparateur.setInt(4, utilisateurInt);
					clavier.reset();
					// ====== Sale ======
					preparateur.setString(5, "available");
					// ====== Price =====
					System.out.println("Indiquez le prix de l'animal (99 999 max) : ");
					utilisateurInt = clavier.nextInt();
					preparateur.setInt(6, utilisateurInt);
					clavier.reset();
					System.out.println("Votre animal a été ajouté correctement.");
					preparateur.execute();
					Afficher.afficherStock();
					clavier.nextLine();
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

	public static final void supprimerAnimal() {
		Scanner clavierString = new Scanner(System.in);
		Scanner clavierInt = new Scanner(System.in);
		String utilisateur;
		int modification;
		boolean isRunning = true;

		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "DELETE FROM Animal WHERE Id = ?";
			PreparedStatement preparateur = connexion.prepareStatement(requete);

			while (isRunning == true) {
				System.out.println("Voulez-vous supprimer un animal ? OUI/NON ");
				utilisateur = clavierString.nextLine();
				clavierString.reset();
				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {
					System.out.println("Indiquez l'ID de l'animal que vous voulez supprimer.");
					modification = clavierInt.nextInt();
					clavierInt.reset();
					preparateur.setInt(1, modification);
					preparateur.execute();
					System.out.println();
					System.out.println("Votre animal a bien été supprimé.");
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

	public static void modifierSpecies() {
		Scanner clavierString = new Scanner(System.in);
		Scanner clavierInt = new Scanner(System.in);
		String utilisateur;
		int modification;
		boolean isRunning = true;

		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "UPDATE Animal SET Species = ? WHERE Id = ?";
			PreparedStatement preparateur = connexion.prepareStatement(requete);

			while (isRunning == true) {
				System.out.println("Voulez-vous modifier l'espèce d'un animal ? OUI/NON ");
				utilisateur = clavierString.nextLine();
				clavierString.reset();
				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {
					System.out.println("Indiquez l'ID de l'animal que vous voulez modifier.");
					modification = clavierInt.nextInt();
					clavierInt.reset();
					preparateur.setInt(2, modification);
					System.out.println("Indiquez la nouvelle espèce : ");
					utilisateur = clavierString.nextLine();
					preparateur.setString(1, utilisateur);
					preparateur.execute();
					System.out.println();
					System.out.println("Votre animal a bien été modifié.");
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

	public static void modifierName() {
		Scanner clavierString = new Scanner(System.in);
		Scanner clavierInt = new Scanner(System.in);
		String utilisateur;
		int modification;
		boolean isRunning = true;

		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "UPDATE Animal SET Name = ? WHERE Id = ?";
			PreparedStatement preparateur = connexion.prepareStatement(requete);

			while (isRunning == true) {
				System.out.println("Voulez-vous modifier le nom d'un animal ? OUI/NON ");
				utilisateur = clavierString.nextLine();
				clavierString.reset();
				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {
					System.out.println("Indiquez l'ID de l'animal que vous voulez modifier.");
					modification = clavierInt.nextInt();
					clavierInt.reset();
					preparateur.setInt(2, modification);
					System.out.println("Indiquez le nouveau nom : ");
					utilisateur = clavierString.nextLine();
					preparateur.setString(1, utilisateur);
					preparateur.execute();
					System.out.println();
					System.out.println("Votre animal a bien été modifié.");
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

	public static void modifierGender() {
		Scanner clavierString = new Scanner(System.in);
		Scanner clavierInt = new Scanner(System.in);
		String utilisateur;
		int modification;
		boolean isRunning = true;

		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "UPDATE Animal SET Gender = ? WHERE Id = ?";
			PreparedStatement preparateur = connexion.prepareStatement(requete);

			while (isRunning == true) {
				System.out.println("Voulez-vous modifier le genre d'un animal ? OUI/NON ");
				utilisateur = clavierString.nextLine();
				clavierString.reset();
				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {
					System.out.println("Indiquez l'ID de l'animal que vous voulez modifier.");
					modification = clavierInt.nextInt();
					clavierInt.reset();
					preparateur.setInt(2, modification);
					System.out.println("Indiquez le nouveau genre : ");
					utilisateur = clavierString.nextLine();
					preparateur.setString(1, utilisateur);
					preparateur.execute();
					System.out.println();
					System.out.println("Votre animal a bien été modifié.");
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

	public static void modifierAge() {
		Scanner clavierString = new Scanner(System.in);
		Scanner clavierInt = new Scanner(System.in);
		String utilisateur;
		int modification;
		boolean isRunning = true;

		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "UPDATE Animal SET Age = ? WHERE Id = ?";
			PreparedStatement preparateur = connexion.prepareStatement(requete);

			while (isRunning == true) {
				System.out.println("Voulez-vous modifier l'âge d'un animal ? OUI/NON ");
				utilisateur = clavierString.nextLine();
				clavierString.reset();
				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {
					System.out.println("Indiquez l'ID de l'animal que vous voulez modifier.");
					modification = clavierInt.nextInt();
					clavierInt.reset();
					preparateur.setInt(2, modification);
					System.out.println("Indiquez le nouvel âge : ");
					modification = clavierInt.nextInt();
					preparateur.setInt(1, modification);
					preparateur.execute();
					System.out.println();
					System.out.println("Votre animal a bien été modifié.");
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

	public static void modifierSale() {
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
				System.out.println("Voulez-vous modifier le statut de vente d'un animal ? OUI/NON ");
				utilisateur = clavierString.nextLine();
				clavierString.reset();
				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {
					System.out.println("Indiquez l'ID de l'animal que vous voulez modifier.");
					modification = clavierInt.nextInt();
					clavierInt.reset();
					preparateur.setInt(2, modification);
					System.out.println("Indiquez le nouveau statut de vente : ");
					utilisateur = clavierString.nextLine();
					preparateur.setString(1, utilisateur);
					preparateur.execute();
					System.out.println();
					System.out.println("Votre animal a bien été modifié.");
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

	public static void modifierPrice() {
		Scanner clavierString = new Scanner(System.in);
		Scanner clavierInt = new Scanner(System.in);
		String utilisateur;
		int modification;
		boolean isRunning = true;

		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "UPDATE Animal SET Price = ? WHERE Id = ?";
			PreparedStatement preparateur = connexion.prepareStatement(requete);

			while (isRunning == true) {
				System.out.println("Voulez-vous modifier le prix d'un animal ? OUI/NON ");
				utilisateur = clavierString.nextLine();
				clavierString.reset();
				if (utilisateur.equalsIgnoreCase("oui") || utilisateur.charAt(0) == 'O'
						|| utilisateur.charAt(0) == 'o') {
					System.out.println("Indiquez l'ID de l'animal que vous voulez modifier.");
					modification = clavierInt.nextInt();
					clavierInt.reset();
					preparateur.setInt(2, modification);
					System.out.println("Indiquez le nouveau prix : ");
					modification = clavierInt.nextInt();
					preparateur.setInt(1, modification);
					preparateur.execute();
					System.out.println();
					System.out.println("Votre animal a bien été modifié.");
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
