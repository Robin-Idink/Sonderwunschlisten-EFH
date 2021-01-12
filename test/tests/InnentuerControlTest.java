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
	// Definitionen von Abh�ngigkeiten definiert am 03.12.2020
	// Initialisierung Sonderwuensche
	int[] sonderwuensche = new int[50];
	
	int[] sonderwuensche43 = sonderwuensche.clone();

	// der Bin�rcode steht f�r gew�hlt (0) und nicht gew�hlt (1) f�r folgende Reihenfolge:
	// Dachgeschoss vorhanden, 2.2, 2.3, 2.4, 2.6
	int[] sonderwuensche10100 = sonderwuensche.clone();
	int[] sonderwuensche00100 = sonderwuensche.clone();
	int[] sonderwuensche00000 = sonderwuensche.clone();
	int[] sonderwuensche01000 = sonderwuensche.clone();
	int[] sonderwuensche11011 = sonderwuensche.clone();	
	
	// Sonderwunsch mit zu viel gew�nschten T�ren
	int[] sonderwuenscheYZ = sonderwuensche00100.clone();
	
	// Sonderwunsch mit Anzahl gew�nschter T�ren im Rahmen
	int[] sonderwuenscheyz = sonderwuensche00100.clone();
	
	// Sonderwunsch mit Anzahl T�ren y kleiner 0
	int[] sonderwuensche41y = sonderwuensche.clone();
	
	// Sonderwunsch mit Anzahl T�ren 7 kleiner 0
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
		
		// �quivalenzklassen f�r die Anzahl maximal m�glicher T�ren f�r die verschiedenen Sonderw�nsche
		// 4 T�ren (mit DG)
		sonderwuensche10100[23] = 1;
		
		// 5 T�ren
		sonderwuensche00100[23] = 1;
		
		// 6 T�ren
		// sonderwuensche00000
		
		// 7 T�ren
		sonderwuensche01000[22] = 1;
		
		// 8 T�ren (mit DG)
		sonderwuensche11011[22] = 1;
		sonderwuensche11011[24] = 1;
		sonderwuensche11011[26] = 1;
		
		
		// Sonderwunsch mit zu viel gew�nschten T�ren
		sonderwuenscheYZ[41] = 3;
		sonderwuenscheYZ[42] = 3;
		
		
		// Sonderwunsch mit Anzahl gew�nschter T�ren im Rahmen
		sonderwuenscheyz[41] = 2;
		sonderwuenscheyz[42] = 2;
		
		// Sonderwunsch mit Anzahl T�ren y kleiner 0
		sonderwuensche41y[41] = -1;		
		
		// Sonderwunsch mit Anzahl T�ren 7 kleiner 0
		sonderwuensche42z[42] = -1;
		
		
	}
	
	@Test
	void testberechneMaxAnzahlTueren() {
		// 4 T�ren mit DG
		setKundeModel(kundeWithDG, kundeModel);
		assertEquals(4, testInnentuerControl.berechneMaxAnzahlTueren(sonderwuensche10100));
		
		// 5 T�ren ohne DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertEquals(5, testInnentuerControl.berechneMaxAnzahlTueren(sonderwuensche00100));
		
		// 6 T�ren ohne DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertEquals(6, testInnentuerControl.berechneMaxAnzahlTueren(sonderwuensche00000));
		
		// 7 T�ren ohne DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertEquals(7, testInnentuerControl.berechneMaxAnzahlTueren(sonderwuensche01000));
		
		// 8 T�ren mit DG
		setKundeModel(kundeWithDG, kundeModel);
		assertEquals(8, testInnentuerControl.berechneMaxAnzahlTueren(sonderwuensche11011));
	}
	
	@Test
	void testPruefeKonstellationSonderwuensche() {
		
		// Tests Abschnitt 4
		// �quivalenzklassen: 
		// Negativer Wert
		assertFalse(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuensche41y));
		assertFalse(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuensche42z));
		
		// Maximal m�gliche Anzahl T�ren �berschritten (x < y + z)
		assertFalse(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuenscheYZ));
		// Maximal m�gliche Anzahl T�ren eingehalten (x <= y + z)
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
