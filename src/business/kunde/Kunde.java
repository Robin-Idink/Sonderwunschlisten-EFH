package business.kunde;

import java.sql.*;

import business.database.Datenbank;

public class Kunde {

	// private int hausnummer;
	private String vorname;
	private String nachname;
	private String telefonnummer;
	private String email;
	private String kundennummer;

	// Standartkonstruktor
	public Kunde() {

	}

	public Kunde(String kundennummer, String vorname, String nachname, String telefonnummer, String email) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefonnummer = telefonnummer;
		this.email = email;
		this.kundennummer = kundennummer;
	}

	/*
	 * public int getHausnummer() { return hausnummer; }
	 * 
	 * public void setHausnummer(int hausnummer) { this.hausnummer = hausnummer; }
	 */
	
	// TODO Methode für Abfrage ob Dachgeschoss vorhanden ist

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setKundennummer(String kundennummer) {
		this.kundennummer = kundennummer;
	}

	public String getKundennummer() {
		return this.kundennummer;
	}

	// Statische Methode um Informationen eines Kunden zu verändern
	public static void updateKundeInDatenbank(int kundennummer, String type, String value) throws SQLException {
		Connection conn = new Datenbank().connect();

		String query = "UPDATE Kunde SET " + type + " = \"" + value + "\" WHERE kundennummer=" + kundennummer + ";";
		try (Statement statement = conn.createStatement()) {
			statement.execute(query);

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		conn.close();
	}

	public void inDatenbankSpeichern() throws SQLException {
		Connection conn = new Datenbank().connect();

		String query = "INSERT INTO Kunde (kundennummer,vorname,nachname,email,telefonnummer) VALUES ('" + this.kundennummer +"','"  + this.vorname + "','"
				+ this.nachname + "','" + this.email + "','" + this.telefonnummer + "');";

		try (Statement statment = conn.createStatement()) {
			// statment.executeQuery(query);
			statment.execute(query);

			conn.close();

		} catch (SQLException ex) {
			System.out.println("Fehler beim anlegen eines Kunden");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
