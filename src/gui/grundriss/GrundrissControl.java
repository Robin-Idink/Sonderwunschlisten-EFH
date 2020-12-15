package gui.grundriss;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Grundriss-Varianten
 * kontrolliert.
 */
public final class GrundrissControl {

	// das View-Objekt des Grundriss-Fensters
	private GrundrissView grundrissView;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum Fenster
	 * fuer die Sonderwuensche zum Grundriss.
	 * 
	 * @param grundrissStage, Stage fuer das View-Objekt zu den Sonderwuenschen zum
	 *                        Grundriss
	 */
	public GrundrissControl(KundeModel kundeModel) {
		Stage stageGrundriss = new Stage();
		stageGrundriss.initModality(Modality.APPLICATION_MODAL);
		this.grundrissView = new GrundrissView(this, stageGrundriss);
	}

	/**
	 * macht das GrundrissView-Objekt sichtbar.
	 */
	public void oeffneGrundrissView() {
		this.grundrissView.oeffneGrundrissView();
	}

	public void leseGrundrissSonderwuensche() {

	}

	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw) {
//      int hausnummer = KundeModel.getInstance().getKunde().getHausnummer());
//		int [] ohneDachgeschoss = {1,6,7,14,15,24};
//		for(nummer: ohneDachgeschoss) {
//			if(nummer == hausnummer)
//				dachgeschoss = false;
//		}
//		

		boolean result = false;
		
		boolean dachgeschoss = true;
		

		
		
		//Berechnung der maximalen Anzahl der möglichen Türen, basierend auf dem Grundriss und den ausgewählten Sonderwünschen
		int maxAnzahlTueren = 0;
		
		if(dachgeschoss)
			maxAnzahlTueren = maxAnzahlTueren+1;
			if(ausgewaehlteSw[24]==1 && ausgewaehlteSw[26]==1)
				maxAnzahlTueren = maxAnzahlTueren+2;
			else if(ausgewaehlteSw[24]==1 || ausgewaehlteSw[26]==1)
				maxAnzahlTueren = maxAnzahlTueren+1;
		else
			maxAnzahlTueren = maxAnzahlTueren+2;
			
		if(ausgewaehlteSw[22] == 1)
			maxAnzahlTueren = maxAnzahlTueren+1;
		
		if(ausgewaehlteSw[23] == 1)
			maxAnzahlTueren = maxAnzahlTueren+3;
		else
			maxAnzahlTueren = maxAnzahlTueren+4;
		

		//Überprüfung der Konstellation der Ausgewählten Sonderwünsche
		
		try {
			
			
			//Prüfung der 2.x Sonderwünsche
			
			for (int i = 21; i < 27; i++) {
				switch (i) {

				case 21:
					if(ausgewaehlteSw[21] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.1 ausgewählt!");
						break;
					}else {
						break;
					}

				case 22:
					if (ausgewaehlteSw[21] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.2 ausgewählt!");
						break;
					}else { 
						throw new Exception("\n2.2 kann nur ausgewählt werden wenn 2.1 auch ausgewählt wurde!");
					}

				case 23:
					if(ausgewaehlteSw[23] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.3 ausgewählt!");
						break;
					}else {
						break;
					}

				case 24:
					if (dachgeschoss && ausgewaehlteSw[24] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.4 ausgewählt!");
						break;
					}else { 
						break;
					}

				case 25:
					if (dachgeschoss && ausgewaehlteSw[25] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.5 ausgewählt!");
						break;
					}else { 
						break;
					}

				case 26:
					if (dachgeschoss && ausgewaehlteSw[24] == 1 && ausgewaehlteSw[26] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.6 ausgewählt!");
						break;
					}else { 
						throw new Exception("\n2.6 kann nur ausgewählt werden wenn 2.4 auch ausgewählt wurde!");

					}	
				}

			}

			//Prüfung der 3.x Sonderwünsche
			
			
			for (int i = 31; i < 40; i++) {
				System.out.println(i);
				switch (i) {

				case 31:
					if(ausgewaehlteSw[31] == 1) {
						result = true;
//						System.out.println("Sie haben SW 3.1 ausgewählt!");
						break;
					}else {
						break;
					}

				case 32:
					if (dachgeschoss && ausgewaehlteSw[32] == 1) {
						result = true;
//						System.out.println("Sie haben SW 3.2 ausgewählt!");
						break;
					}else { 
						break;
					}

				case 33:
					if(ausgewaehlteSw[33] == 1) {
						result = true;
//						System.out.println("Sie haben SW 3.3 ausgewählt!");
						break;
					}else {
						break;
					}

				case 34:
					if (dachgeschoss && ausgewaehlteSw[34] == 1) {
						result = true;
//						System.out.println("Sie haben SW 3.4 ausgewählt!");
						break;
					}else { 
						break;
					}

				case 35:
					if (dachgeschoss && ausgewaehlteSw[35] == 1) {
						result = true;
//						System.out.println("Sie haben SW 3.5 ausgewählt!");
						break;
					}else { 
						break;
					}

				case 36:
					if (dachgeschoss && ausgewaehlteSw[36] == 1) {
						result = true;
//						System.out.println("Sie haben SW 3.6 ausgewählt!");
						break;
					}else { 
						break;
					}

				case 37:
					if (ausgewaehlteSw[34] == 1 && ausgewaehlteSw[37] == 1) {
						result = true;
//						System.out.println("Sie haben SW 3.7 ausgewählt!");
						break;
					}else { 
						throw new Exception("\n2.6 kann nur ausgewählt werden wenn 3.4 auch ausgewählt wurde!");
					}

				case 38:
					if (ausgewaehlteSw[35] == 1 && ausgewaehlteSw[38] == 1) {
						result = true;
//						System.out.println("Sie haben SW 3.8 ausgewählt!");
						break;
					}else { 
						throw new Exception("\n2.6 kann nur ausgewählt werden wenn 3.5 auch ausgewählt wurde!");
					}

				case 39:
					if (ausgewaehlteSw[36] == 1 && ausgewaehlteSw[39] == 1) {
						result = true;
//						System.out.println("Sie haben SW 3.9 ausgewählt!");
						break;
					}else { 
						throw new Exception("\n2.6 kann nur ausgewählt werden wenn 3.6 auch ausgewählt wurde!");
					}
				}
			}
			
			//Prüfung der 4.x Sonderwünsche
			
			//Fehlermeldung falls die Summer der ausgewählten Türen in 4.1 und 4.2 die maximal Anzahl überschreitet
			if(ausgewaehlteSw[41]+ausgewaehlteSw[42] > maxAnzahlTueren)
				throw new Exception("\n Die Anzahl der Ausgewählten Türen überschreitet die maximale Anzahl der möglichen Türen!");
			
			//Fehlermeldung falls 4.3 ausgewählt wird obwohl es kein Dachgeschoss gibt
			if(ausgewaehlteSw[43]==1)
				if(!dachgeschoss)
					throw new Exception("\n 4.3 kann nur ausgewählt werden wenn auch ein Dachgeschoss vorhanden ist!");
			
			
		} catch (Exception e) {

			result = false;
			System.out.println("Sonderwünsche sind nicht kompatibel!" + e.getMessage());

		}

		return result;
	}
}
