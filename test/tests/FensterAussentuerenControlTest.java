package tests;

import static org.junit.jupiter.api.Assertions.*;

// Testmodules
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// internal modules
import business.kunde.Kunde;
import business.kunde.KundeModel;
import gui.fensterAussentueren.FensterAussentuerenControl;

class FensterAussentuerenControlTest {

	// Definitionen von Abhaengigkeiten definiert am 03.12.2020
	// Initialisierung Sonderwuensche
	int[] sonderwuensche = new int[50];
	
	int[] sonderwuensche32 = sonderwuensche.clone();
	int[] sonderwuensche37with34 = sonderwuensche.clone();
	int[] sonderwuensche37without34 = sonderwuensche.clone();
	int[] sonderwuensche38with35 = sonderwuensche.clone();
	int[] sonderwuensche38without35 = sonderwuensche.clone();
	int[] sonderwuensche39with36 = sonderwuensche.clone();
	int[] sonderwuensche39without36 = sonderwuensche.clone();
	
	FensterAussentuerenControl testFensterAussentuerenControl = new FensterAussentuerenControl();
	
	Kunde kundeWithDG = new Kunde();
	Kunde kundeWithoutDG = new Kunde();
	
	KundeModel kundeModel = KundeModel.getInstance();
	
	void setKundeModel(Kunde kunde, KundeModel kundeModel) {
		try {
			kundeModel.speichereKunden(kunde);
		}
		catch(Exception e) {
			System.out.println("Something failed while using kundeModel.speichereKunden()");
		}
	}
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		
		// Kunde mit Dachgeschoss definieren
		kundeWithDG.setHausnummer(10);
		
		// Kunde ohne Dachgeschoss definieren
		kundeWithoutDG.setHausnummer(6);
		
		// 3.2
		sonderwuensche32[32] = 1;
		
		// 3.7 mit 3.4
		sonderwuensche37with34[37] = 1;
		sonderwuensche37with34[34] = 1;
		
		// 3.7 ohne 3.4
		sonderwuensche37without34[37] = 1;
		
		// 3.8 mit 3.5
		sonderwuensche38with35[38] = 1;
		sonderwuensche38with35[35] = 1;
		
		// 3.8 ohne 3.5
		sonderwuensche38without35[38] = 1;
		
		// 3.9 mit 3.6
		sonderwuensche39with36[39] = 1;
		sonderwuensche39with36[36] = 1;
		
		// 3.9 ohne 3.6
		sonderwuensche39without36[39] = 1;
		
	}	

	@Test
	void testPruefeKonstellationSonderwuensche() {

		// Test 3.2 mit DG
		setKundeModel(kundeWithDG, kundeModel);
		assertTrue(testFensterAussentuerenControl.pruefeKonstellationSonderwuensche(sonderwuensche32));
		// Test 3.2 ohne DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertFalse(testFensterAussentuerenControl.pruefeKonstellationSonderwuensche(sonderwuensche32));
		
		// Test 3.7 mit 3.4
		assertTrue(testFensterAussentuerenControl.pruefeKonstellationSonderwuensche(sonderwuensche37with34));
		// Test 3.7 ohne 3.4
		assertFalse(testFensterAussentuerenControl.pruefeKonstellationSonderwuensche(sonderwuensche37without34));
		
		// Test 3.8 mit 3.5
		assertTrue(testFensterAussentuerenControl.pruefeKonstellationSonderwuensche(sonderwuensche38with35));
		// Test 3.8 ohne 3.5
		assertFalse(testFensterAussentuerenControl.pruefeKonstellationSonderwuensche(sonderwuensche38without35));
		
		// Test 3.9 mit 3.6
		assertTrue(testFensterAussentuerenControl.pruefeKonstellationSonderwuensche(sonderwuensche39with36));
		// Test 3.9 ohne 3.6
		assertFalse(testFensterAussentuerenControl.pruefeKonstellationSonderwuensche(sonderwuensche39without36));			
	
	}

}
