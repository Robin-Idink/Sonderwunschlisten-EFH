package tests;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.kunde.*;
import business.database.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class KundeTest {
	static Kunde kundenDaten;
	static Kunde kundenDatenLesen;
	static Connection conn;
	
	@Before
	public void setUp() throws Exception {
			conn = new Datenbank().connect(); 
			kundenDaten = new Kunde("666", "Anlegen", "Mustermann", "0123456789", "max.mustermann@mail.com", 6);
	}
		
	@After
	public void tearDown() throws Exception {
		conn.close();
	}

	//Daten anlegen
	@Test
	public void canCreateDB() throws Exception {
		kundenDaten.inDatenbankSpeichern();
	
		assertEquals("666" , kundenDaten.getKundennummer());
		assertEquals("Anlegen" , kundenDaten.getVorname());
		assertEquals("Mustermann" , kundenDaten.getNachname());
		assertEquals("0123456789" , kundenDaten.getTelefonnummer());
		assertEquals("max.mustermann@mail.com" , kundenDaten.getEmail());
		assertEquals(6 , kundenDaten.getHausnummer());
		
		Kunde.LoescheKundeByKundennummer("666");
	}
	
	//Daten lesen
	@Test
	public void canReadDB() throws Exception {
		kundenDaten.inDatenbankSpeichern();
		
		try {
			Kunde kundenDatenLesen = Kunde.kundeHolen(6);
						
			assertEquals(kundenDaten.getKundennummer(), kundenDatenLesen.getKundennummer());
			assertEquals(kundenDaten.getVorname(), kundenDatenLesen.getVorname());
			assertEquals(kundenDaten.getNachname(), kundenDatenLesen.getNachname());
			assertEquals(kundenDaten.getTelefonnummer(), kundenDatenLesen.getTelefonnummer());
			assertEquals(kundenDaten.getEmail(), kundenDatenLesen.getEmail());
		    assertEquals(kundenDaten.getHausnummer(), kundenDatenLesen.getHausnummer());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Kunde.LoescheKundeByKundennummer("666");
	}
	
	
	//Daten ändern
	@Test
	public void canUpdateDB() throws Exception {
		kundenDaten.inDatenbankSpeichern();

		String updateVorname = "UPDATE Kunde SET vorname='Geaendert' WHERE kundennummer="+kundenDaten.getKundennummer()+";";
		String updateNachname = "UPDATE Kunde SET Nachname='Musterfrau' WHERE kundennummer="+kundenDaten.getKundennummer()+";";
		String updateTelefonnummer = "UPDATE Kunde SET telefonnummer='00000000' WHERE kundennummer="+kundenDaten.getKundennummer()+";";
		String updateEmail = "UPDATE Kunde SET email='geaendert.musterfrau@mail.com' WHERE kundennummer="+kundenDaten.getKundennummer()+";";
	
		try (Statement statement = conn.createStatement()) {
			statement.execute(updateVorname);
			statement.execute(updateNachname);
			statement.execute(updateTelefonnummer);
			statement.execute(updateEmail);

		} 
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		try {
			Kunde kundenDatenLesen = Kunde.kundeHolen(6);
									
			assertEquals("Geaendert", kundenDatenLesen.getVorname());
			assertEquals("Musterfrau", kundenDatenLesen.getNachname());
			assertEquals("00000000", kundenDatenLesen.getTelefonnummer());
			assertEquals("geaendert.musterfrau@mail.com", kundenDatenLesen.getEmail());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Kunde.LoescheKundeByKundennummer("666");
	}
	
	//Daten löschen
	@Test
	public void canDeletefromDB() throws Exception {
		kundenDaten.inDatenbankSpeichern();
		Kunde.LoescheKundeByKundennummer("666");
		Kunde kundenDatenLesen = Kunde.kundeHolen(6);
		
		assertNotSame(kundenDaten.getKundennummer(), kundenDatenLesen.getKundennummer());
		assertNotSame(kundenDaten.getVorname(), kundenDatenLesen.getVorname());
		assertNotSame(kundenDaten.getNachname(), kundenDatenLesen.getNachname());
		assertNotSame(kundenDaten.getTelefonnummer(), kundenDatenLesen.getTelefonnummer());
		assertNotSame(kundenDaten.getEmail(), kundenDatenLesen.getEmail());
		assertNotSame(String.valueOf(kundenDaten.getHausnummer()), kundenDatenLesen.getHausnummer());
		
		
	}
}


