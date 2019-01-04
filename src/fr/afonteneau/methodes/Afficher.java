package fr.afonteneau.methodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Afficher {

	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/the_animal_shop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
	public static final String DATABASE_LOGIN = "root";
	public static final String DATABASE_SECRET = "activ";

	public static final void afficherStock() {
		// Design pattern factory
		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "SELECT * FROM Animal";
			Statement executeur = connexion.createStatement();
			ResultSet resultat = executeur.executeQuery(requete);

			while (resultat.next()) {
				System.out.println(resultat.getString("Id") + " - " + resultat.getString("Species") + " - "
						+ resultat.getString("Name") + " - " + resultat.getString("Gender") + " - "
						+ resultat.getString("Age") + " - " + resultat.getString("Sale") + " - "
						+ resultat.getString("Price"));
			}
			resultat.close();
			executeur.close();
			connexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void trierSpecies() {
		// Design pattern factory
		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "SELECT * FROM Animal ORDER BY Species";
			Statement executeur = connexion.createStatement();
			ResultSet resultat = executeur.executeQuery(requete);

			while (resultat.next()) {
				System.out.println(resultat.getString("Id") + " - " + resultat.getString("Species") + " - "
						+ resultat.getString("Name") + " - " + resultat.getString("Gender") + " - "
						+ resultat.getString("Age") + " - " + resultat.getString("Sale") + " - "
						+ resultat.getString("Price"));
			}
			resultat.close();
			executeur.close();
			connexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void trierName() {
		// Design pattern factory
		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "SELECT * FROM Animal ORDER BY Name";
			Statement executeur = connexion.createStatement();
			ResultSet resultat = executeur.executeQuery(requete);

			while (resultat.next()) {
				System.out.println(resultat.getString("Id") + " - " + resultat.getString("Species") + " - "
						+ resultat.getString("Name") + " - " + resultat.getString("Gender") + " - "
						+ resultat.getString("Age") + " - " + resultat.getString("Sale") + " - "
						+ resultat.getString("Price"));
			}
			resultat.close();
			executeur.close();
			connexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void trierGender() {
		// Design pattern factory
		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "SELECT * FROM Animal ORDER BY Gender";
			Statement executeur = connexion.createStatement();
			ResultSet resultat = executeur.executeQuery(requete);

			while (resultat.next()) {
				System.out.println(resultat.getString("Id") + " - " + resultat.getString("Species") + " - "
						+ resultat.getString("Name") + " - " + resultat.getString("Gender") + " - "
						+ resultat.getString("Age") + " - " + resultat.getString("Sale") + " - "
						+ resultat.getString("Price"));
			}
			resultat.close();
			executeur.close();
			connexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void trierAge() {
		// Design pattern factory
		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "SELECT * FROM Animal ORDER BY Age";
			Statement executeur = connexion.createStatement();
			ResultSet resultat = executeur.executeQuery(requete);

			while (resultat.next()) {
				System.out.println(resultat.getString("Id") + " - " + resultat.getString("Species") + " - "
						+ resultat.getString("Name") + " - " + resultat.getString("Gender") + " - "
						+ resultat.getString("Age") + " - " + resultat.getString("Sale") + " - "
						+ resultat.getString("Price"));
			}
			resultat.close();
			executeur.close();
			connexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void trierSale() {
		// Design pattern factory
		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "SELECT * FROM Animal ORDER BY Sale";
			Statement executeur = connexion.createStatement();
			ResultSet resultat = executeur.executeQuery(requete);

			while (resultat.next()) {
				System.out.println(resultat.getString("Id") + " - " + resultat.getString("Species") + " - "
						+ resultat.getString("Name") + " - " + resultat.getString("Gender") + " - "
						+ resultat.getString("Age") + " - " + resultat.getString("Sale") + " - "
						+ resultat.getString("Price"));
			}
			resultat.close();
			executeur.close();
			connexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void trierPrice() {
		// Design pattern factory
		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "SELECT * FROM Animal ORDER BY Price";
			Statement executeur = connexion.createStatement();
			ResultSet resultat = executeur.executeQuery(requete);

			while (resultat.next()) {
				System.out.println(resultat.getString("Id") + " - " + resultat.getString("Species") + " - "
						+ resultat.getString("Name") + " - " + resultat.getString("Gender") + " - "
						+ resultat.getString("Age") + " - " + resultat.getString("Sale") + " - "
						+ resultat.getString("Price"));
			}
			resultat.close();
			executeur.close();
			connexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
