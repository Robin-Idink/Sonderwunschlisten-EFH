package business.Haus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business.database.*;;

public class Haus {
	
	private boolean hatDachgeschoss;
	private String hausnummer;
	
	public Haus() {
		
	}
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
	
	
	
	

	
	
	public  void getHausById(String hausnummer) {
		Datenbank db = new Datenbank();
		Connection conn = db.connect();

		String query = "Select * from Haus where hausnummer='"+hausnummer+"'";
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
	
	public static boolean hatDachgeschoss(int hausnummer) throws Exception {
		
		if(hausnummer > 24 || hausnummer < 1) {
			throw new Exception("Bitte wähle eine Hausnummer zwischen 1 und 24");
		}
		
		Datenbank db = new Datenbank();
		Connection conn = db.connect();
		boolean hatDachgeschoss = false;
		String query = "Select * from Haus where `hausnummer`="+hausnummer+" ;";
		try (Statement statement = conn.createStatement()) {
			ResultSet rs=statement.executeQuery(query);  
			
		while(rs.next()) { 
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
   


}
