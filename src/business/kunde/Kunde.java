package business.kunde;

import java.sql.*;

import business.database.Datenbank;

public class Kunde {

	private int hausnummer;
	private int[] sonderwuensche = new int [50];
	private String vorname;
	private String nachname;
	private String telefonnummer;
	private String email;
	private String kundennummer;

	// Standartkonstruktor
	public Kunde() {

	}

	public Kunde(String kundennummer, String vorname, String nachname, String telefonnummer, String email,
			int hausnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefonnummer = telefonnummer;
		this.email = email;
		this.kundennummer = kundennummer;
		this.hausnummer =  hausnummer;
		try {
			this.sonderwuenscheHolen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	// Statische Methode um Informationen eines Kunden zu veraendern
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
			throw new Exception("Bitte waehle eine Hausnummer zwischen 1 und 24");
		}

		String query = "INSERT INTO Kunde (kundennummer,vorname,nachname,email,telefonnummer) VALUES ('"
				+ this.kundennummer + "','" + this.vorname + "','" + this.nachname + "','" + this.email + "','"
				+ this.telefonnummer + "');";

		String query2 = "Insert INTO Plan values (" + this.hausnummer + "," + this.kundennummer + "," + this.hausnummer
				+ ")";

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

	// Get Kunde von Datenbank, mithilfe der Plan oder hausnummer da diese die
	// gleichen sind

	public static Kunde kundeHolen(int hausnummer) throws Exception {
		Connection conn = new Datenbank().connect();

		if (hausnummer > 24 || hausnummer < 1) {
			throw new Exception("Bitte waehle eine Hausnummer zwischen 1 und 24");
		}

		String kundennummer = "", vorname = "", nachname = "", email = "", telefonnummer = "";

		String query = "Select p.kundennummer, k.vorname, k.nachname, k.email, k.telefonnummer from Plan p\r\n"
				+ "        inner Join Haus h\r\n" + "        on p.hausnummer = h.hausnummer\r\n"
				+ "        inner join Kunde k\r\n" + "        on k.kundennummer = p.kundennummer\r\n"
				+ "        where p.plannummer =" + hausnummer;

		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				kundennummer = rs.getString("kundennummer");
				vorname = rs.getString("vorname");
				nachname = rs.getString("nachname");
				email = rs.getString("email");
				telefonnummer = rs.getNString("email");
				
			}
			rs.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		
		return new Kunde(kundennummer, vorname, nachname, email, telefonnummer, hausnummer);

	}

	// Hole Sonderwünsche aus DB für den Kunden und schreibe sie in Sonderwunsch
	// array

	public void sonderwuenscheHolen() throws Exception {
		Connection conn = new Datenbank().connect();
		String query = "Select * from Sonderwünsche where hausnummer ="+ this.hausnummer;

		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				int SFAID = rs.getInt("SFAID");
				int SIID = rs.getInt("SIID");
				int SGVID = rs.getInt("SGVID");
				
				this.sonderwuensche[SFAID] = 1;
				this.sonderwuensche[SIID] = 1;
				this.sonderwuensche[SIID + 3] = rs.getInt("anzahl");
				this.sonderwuensche[SGVID] = 1;
				

			}
			rs.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		System.out.println(this.hausnummer);
		for(int i=0 ; i< this.sonderwuensche.length; i++) {
			System.out.println(i + " : " + this.sonderwuensche[i]); //asjdnjlasndalsjn
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

	// Diese Methode ist etwas fragwuerdig aber ich haue sie trotzdem mal rein ^^
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
