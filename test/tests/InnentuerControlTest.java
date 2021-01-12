package tests;

import static org.junit.jupiter.api.Assertions.*;

// Testmodules
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// internal modules
import business.kunde.Kunde;
import business.kunde.KundeModel;
import gui.innentuer.InnentuerControl;

class InnentuerControlTest {
	// Definitionen von Abhängigkeiten definiert am 03.12.2020
	// Initialisierung Sonderwuensche
	int[] sonderwuensche = new int[50];
	
	int[] sonderwuensche43 = sonderwuensche.clone();

	// der Binärcode steht für gewählt (0) und nicht gewählt (1) für folgende Reihenfolge:
	// Dachgeschoss vorhanden, 2.2, 2.3, 2.4, 2.6
	int[] sonderwuensche10100 = sonderwuensche.clone();
	int[] sonderwuensche00100 = sonderwuensche.clone();
	int[] sonderwuensche00000 = sonderwuensche.clone();
	int[] sonderwuensche01000 = sonderwuensche.clone();
	int[] sonderwuensche11011 = sonderwuensche.clone();	
	
	// Sonderwunsch mit zu viel gewünschten Türen
	int[] sonderwuenscheYZ = sonderwuensche00100.clone();
	
	// Sonderwunsch mit Anzahl gewünschter Türen im Rahmen
	int[] sonderwuenscheyz = sonderwuensche00100.clone();
	
	// Sonderwunsch mit Anzahl Türen y kleiner 0
	int[] sonderwuensche41y = sonderwuensche.clone();
	
	// Sonderwunsch mit Anzahl Türen 7 kleiner 0
	int[] sonderwuensche42z = sonderwuensche.clone();
	
	InnentuerControl testInnentuerControl = new InnentuerControl();
	
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
		// 4.3
		sonderwuensche43[43] = 1;
		
		// Kunde mit Dachgeschoss definieren
		kundeWithDG.setHausnummer(10);
		
		// Kunde ohne Dachgeschoss definieren
		kundeWithoutDG.setHausnummer(6);
		
		// Äquivalenzklassen für die Anzahl maximal möglicher Türen für die verschiedenen Sonderwünsche
		// 4 Türen (mit DG)
		sonderwuensche10100[23] = 1;
		
		// 5 Türen
		sonderwuensche00100[23] = 1;
		
		// 6 Türen
		// sonderwuensche00000
		
		// 7 Türen
		sonderwuensche01000[22] = 1;
		
		// 8 Türen (mit DG)
		sonderwuensche11011[22] = 1;
		sonderwuensche11011[24] = 1;
		sonderwuensche11011[26] = 1;
		
		
		// Sonderwunsch mit zu viel gewünschten Türen
		sonderwuenscheYZ[41] = 3;
		sonderwuenscheYZ[42] = 3;
		
		
		// Sonderwunsch mit Anzahl gewünschter Türen im Rahmen
		sonderwuenscheyz[41] = 2;
		sonderwuenscheyz[42] = 2;
		
		// Sonderwunsch mit Anzahl Türen y kleiner 0
		sonderwuensche41y[41] = -1;		
		
		// Sonderwunsch mit Anzahl Türen 7 kleiner 0
		sonderwuensche42z[42] = -1;
		
		
	}
	
	@Test
	void testberechneMaxAnzahlTueren() {
		// 4 Türen mit DG
		setKundeModel(kundeWithDG, kundeModel);
		assertEquals(4, testInnentuerControl.berechneMaxAnzahlTueren(sonderwuensche10100));
		
		// 5 Türen ohne DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertEquals(5, testInnentuerControl.berechneMaxAnzahlTueren(sonderwuensche00100));
		
		// 6 Türen ohne DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertEquals(6, testInnentuerControl.berechneMaxAnzahlTueren(sonderwuensche00000));
		
		// 7 Türen ohne DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertEquals(7, testInnentuerControl.berechneMaxAnzahlTueren(sonderwuensche01000));
		
		// 8 Türen mit DG
		setKundeModel(kundeWithDG, kundeModel);
		assertEquals(8, testInnentuerControl.berechneMaxAnzahlTueren(sonderwuensche11011));
	}
	
	@Test
	void testPruefeKonstellationSonderwuensche() {
		
		// Tests Abschnitt 4
		// Äquivalenzklassen: 
		// Negativer Wert
		assertFalse(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuensche41y));
		assertFalse(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuensche42z));
		
		// Maximal mögliche Anzahl Türen überschritten (x < y + z)
		assertFalse(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuenscheYZ));
		// Maximal mögliche Anzahl Türen eingehalten (x <= y + z)
		assertTrue(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuenscheyz));
		
		
		// Test 4.3 mit DG
		setKundeModel(kundeWithDG, kundeModel);
		assertTrue(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuensche43));
		// Test 4.3 ohne DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertFalse(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuensche43));
				
		
		fail("Not yet implemented");
	}

}
