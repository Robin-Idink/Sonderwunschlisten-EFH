package tests;

import static org.junit.jupiter.api.Assertions.*;

// Testmodules
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// internal modules
import business.kunde.Kunde;
import business.kunde.KundeModel;
import gui.grundriss.GrundrissControl;

class GrundrissControlTest {
	// represents definitions of dependencies from 03.12.2020
	// initialize Sonderwuensche
	int[] sonderwuensche = new int[50];
	
	int[] sonderwuensche22with21 = sonderwuensche.clone();
	int[] sonderwuensche22without21 = sonderwuensche.clone();
	int[] sonderwuensche24 = sonderwuensche.clone();
	int[] sonderwuensche25 = sonderwuensche.clone();
	int[] sonderwuensche26with25 = sonderwuensche.clone();
	int[] sonderwuensche26without25 = sonderwuensche.clone();
	
	GrundrissControl testGrundrissControl = new GrundrissControl();
	
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
	
		// create customer with Dachgeschoss
		kundeWithDG.setHausnummer(10);
		
		// create customer without Dachgeschoss
		kundeWithoutDG.setHausnummer(6);
		
		// 2.2 with 2.1 
		sonderwuensche22with21[21] = 1;
		sonderwuensche22with21[22] = 1;
		
		// 2.2 without 2.1	
		sonderwuensche22without21[22] = 1;
		
		// 2.4
		sonderwuensche24[24] = 1;
		
		// 2.5
		sonderwuensche25[25] = 1;
		
		// 2.6 with 2.5
		sonderwuensche26with25[25] = 1;
		sonderwuensche26with25[26] = 1;
		
		// 2.6 without 2.5
		sonderwuensche26without25[26] = 1;		
		
	}

	/*** for debugging
	void printCurrentSwListe(int[] swListe, String name) {
		System.out.println(name + " wird jetzt ausgegeben");
		for (int i= 0 ; i < swListe.length; i++) {
			if (swListe[i] == 1) {
				String output = "Sonderwunsch an Index " + i + " hat den Wert " + swListe[i]; 
				System.out.println(output);	
			}
				
		}
	}
	
	***/
	
	@Test
	void testPruefeKonstellationSonderwuensche() {
		
		// printCurrentSwListe(sonderwuensche22with21, "sonderwuensche22with21");
		
		// printCurrentSwListe(sonderwuensche22without21, "sonderwuensche22without21");
		
		// Test 2.2 with 2.1
		assertTrue(testGrundrissControl.pruefeKonstellationSonderwuensche(sonderwuensche22with21));
		// Test 2.2 without 2.1
		assertFalse(testGrundrissControl.pruefeKonstellationSonderwuensche(sonderwuensche22without21));
		
		// System.out.println("2.2 getestet");
		
		// printCurrentSwListe(sonderwuensche24, "sonderwuensche24");
		
		// Test 2.4 with DG
		setKundeModel(kundeWithDG, kundeModel);
		assertTrue(testGrundrissControl.pruefeKonstellationSonderwuensche(sonderwuensche24));
		// Test 2.4 without DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertFalse(testGrundrissControl.pruefeKonstellationSonderwuensche(sonderwuensche24));
		
		// System.out.println("2.4 getestet");
		
		// printCurrentSwListe(sonderwuensche25, "sonderwuensche25");
		
		// Test 2.5 with DG
		setKundeModel(kundeWithDG, kundeModel);
		assertTrue(testGrundrissControl.pruefeKonstellationSonderwuensche(sonderwuensche25));
		// Test 2.5 without DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertFalse(testGrundrissControl.pruefeKonstellationSonderwuensche(sonderwuensche25));
		
		// System.out.println("2.5 getestet");
		
		// printCurrentSwListe(sonderwuensche26with25, "sonderwuensche26with25");
		// printCurrentSwListe(sonderwuensche26without25, "sonderwuensche26without25");
		
		// Test 2.6 with 2.5 and DG
		setKundeModel(kundeWithDG, kundeModel);
		assertTrue(testGrundrissControl.pruefeKonstellationSonderwuensche(sonderwuensche26with25));
		// Test 2.6 with 2.5 and without DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertFalse(testGrundrissControl.pruefeKonstellationSonderwuensche(sonderwuensche26with25));
		// Test 2.6 without 2.5 and without DG
		assertFalse(testGrundrissControl.pruefeKonstellationSonderwuensche(sonderwuensche26without25));
		
		// System.out.println("2.6 getestet");
	}

}
