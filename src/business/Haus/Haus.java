package business.Haus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business.database.*;;

public class Haus {
	
	private boolean hatDachgeschoss;
	private String hausnummer;
	
	
	public Haus( String hausnummer,boolean hatDachgeschoss) {
		this.hausnummer = hausnummer;
		this.hatDachgeschoss = hatDachgeschoss;
	}
	
	
	public boolean isHatDachgeschoss() {
		return hatDachgeschoss;
	}

	public void setHatDachgeschoss(boolean hatDachgeschoss) {
		this.hatDachgeschoss = hatDachgeschoss;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}
	
	
	
	
	public void inDatenbankSpeichern() throws SQLException {
		Connection conn = new Datenbank().connect();
		int dg ;
		if(this.hatDachgeschoss==true)
			dg =1;
		else
			dg=0;

		String query = "INSERT INTO Haus (`hausnummer`,`mitDachgeschoss?`) VALUES (" + this.hausnummer + "," + dg + ");";
		
			
		try (Statement statment = conn.createStatement()) {
			// statment.executeQuery(query);
			statment.execute(query);
			conn.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
	}
	
	
	public void getHausById(String hausnummer) {
		Datenbank db = new Datenbank();
		Connection conn = db.connect();

		String query = "Select * from Plan Where hausnummer='"+hausnummer+"'";
		try (Statement statement = conn.createStatement()) {
			ResultSet rs=statement.executeQuery(query);  
			
			while(rs.next())  {
				this.hausnummer=rs.getString("kundennummer");
				this.hatDachgeschoss=rs.getBoolean("mitDachgeschoss?");
				
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
