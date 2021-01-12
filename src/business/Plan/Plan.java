package business.Plan;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business.Haus.Haus;
import business.database.*;
import business.kunde.Kunde;

public class Plan {
	private Kunde kunde = null;
	private Haus haus = null;
	private String plannummer = null;

	public Plan(Kunde kunde, Haus haus) throws SQLException {
		this.kunde = kunde;
		this.haus = haus;
		this.plannummer  = haus.getHausnummer();
		//haus.inDatenbankSpeichern();
		//kunde.inDatenbankSpeichern();
	}

	public String getPlannummer() {
		return plannummer;
	}

	public void setPlannummer(String plannummer) {
		this.plannummer = plannummer;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public Haus getHaus() {
		return haus;
	}

	public void setHaus(Haus haus) {
		this.haus = haus;
	}

	public void speicherPlanInDatenbank() {
		Datenbank db = new Datenbank();
		Connection conn = db.connect();


		String query = "Insert into Plan (plannummer,kundennummer, hausnummer) Values ('"+ this.plannummer +"', '"  + kunde.getKundennummer() +"','"+ haus.getHausnummer() +"');";
		try (Statement statement = conn.createStatement()) {
			haus.inDatenbankSpeichern();
			kunde.inDatenbankSpeichern();
			statement.execute(query);
			conn.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

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

//
	public void getPlanById(String plannummer) {
		Datenbank db = new Datenbank();
		Connection conn = db.connect();

		String query = "Select * from Plan Where plannummer='" + plannummer + "'";
		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				this.kunde.setKundennummer(rs.getString("kundennummer"));
				this.haus.setHausnummer(rs.getString("hausnummer"));
				this.plannummer = plannummer;
			}
			rs.close();

			conn.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
