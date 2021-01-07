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
	// represents definitions of dependencies from 03.12.2020
	// initialize Sonderwuensche
	int[] sonderwuensche = new int[50];
	
	int[] sonderwuensche43 = sonderwuensche.clone();
	
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
		
		// create customer with Dachgeschoss
		kundeWithDG.setHausnummer(10);
		
		// create customer without Dachgeschoss
		kundeWithoutDG.setHausnummer(6);
		
		
	}

	@Test
	void testPruefeKonstellationSonderwuensche() {
		// TODO add a check if DG or no DG

		// Test 4.3 with DG#
		setKundeModel(kundeWithDG, kundeModel);
		assertTrue(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuensche43));
		// Test 4.3 without DG
		setKundeModel(kundeWithoutDG, kundeModel);
		assertFalse(testInnentuerControl.pruefeKonstellationSonderwuensche(sonderwuensche43));
				
		
		fail("Not yet implemented");
	}

}
