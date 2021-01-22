package business.kunde;

import java.sql.*;

import business.database.Datenbank;

public class Kunde {

	private int hausnummer;
	private int[] sonderwuensche;
	private String vorname;
	private String nachname;
	private String telefonnummer;
	private String email;
	private String kundennummer;

	// Standartkonstruktor
	public Kunde() {

	}

	public Kunde(String kundennummer, String vorname, String nachname, String telefonnummer, String email,
			String hausnummer) {
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

	public int getHausnummer() {
		return this.hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}
	
	public int[] getSonderwuensche() {
		return this.sonderwuensche;
	}
	
	
	// TODO Methode zum Laden der Sonderwuensche bei Aufruf des Kunden
	
	public void setSonderwuensche(int[] sonderwuensche) {
		this.sonderwuensche = sonderwuensche;
	}
	
	
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

	
	public void inDatenbankSpeichern() throws Exception {
		Connection conn = new Datenbank().connect();

		if (hausnummer > 24 || hausnummer < 1) {
			throw new Exception("Bitte wähle eine Hausnummer zwischen 1 und 24");
		}

		String query = "INSERT INTO Kunde (kundennummer,vorname,nachname,email,telefonnummer) VALUES ('"
				+ this.kundennummer + "','" + this.vorname + "','" + this.nachname + "','" + this.email + "','"
				+ this.telefonnummer + "');";
		
		String query2 = "Insert INTO Plan values ("+this.hausnummer+","+this.kundennummer+","+this.hausnummer+")";

		try (Statement statment = conn.createStatement()) {
			// statment.executeQuery(query);
			statment.execute(query);
			statment.execute(query2);

			conn.close();

		} catch (SQLException ex) {
			System.out.println("Fehler beim anlegen eines Kunden");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
	
	// TODO Methode speichereSonderwuensche()

	public boolean hatDachgeschoss() throws Exception {

		Datenbank db = new Datenbank();
		Connection conn = db.connect();
		boolean hatDachgeschoss = false;
		String query = "Select * from Haus where `hausnummer`=" + this.hausnummer + " ;";
		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				hatDachgeschoss = rs.getBoolean("mitDachgeschoss?");
			}
			rs.close();
			conn.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return hatDachgeschoss;
	}
	
	
	// Diese Methode ist etwas fragwürdig aber ich haue sie trotzdem mal rein ^^
	public static void LoeschePlanById(String plannummer) {
		Datenbank db = new Datenbank();
		Connection conn = db.connect();
		String query = "Delete From 'Plan' Where plannummer='" + plannummer + "'";

		try (Statement statement = conn.createStatement()) {
			statement.execute(query);
			conn.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
