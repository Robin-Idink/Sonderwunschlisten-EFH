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
	
	public GrundrissControl() {
		
	}

	/**
	 * macht das GrundrissView-Objekt sichtbar.
	 */
	public void oeffneGrundrissView() {
		this.grundrissView.oeffneGrundrissView();
	}

	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw) {
		// TODO Zugriff auf Sonderwuensche über KundeModel.getInstance().getKunde().getSonderwuensche()
		// TODO Zugriff auf Dachgeschoss Boolean über KundeModel.getInstance().getKunde().hatDachgeschoss()		

		boolean result = false;
		
		boolean dachgeschoss = true;
	

		//�berpr�fung der Konstellation der Ausgew�hlten Sonderw�nsche
		
		try {
			
			
			//Pr�fung der 2.x Sonderw�nsche
			
			for (int i = 21; i < 27; i++) {
				switch (i) {

				case 21:
					if(ausgewaehlteSw[21] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.1 ausgew�hlt!");
						break;
					}else {
						break;
					}

				case 22:
					if (ausgewaehlteSw[21] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.2 ausgew�hlt!");
						break;
					}else { 
						throw new Exception("\n2.2 kann nur ausgew�hlt werden wenn 2.1 auch ausgew�hlt wurde!");
					}

				case 23:
					if(ausgewaehlteSw[23] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.3 ausgew�hlt!");
						break;
					}else {
						break;
					}

				case 24:
					if (dachgeschoss && ausgewaehlteSw[24] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.4 ausgew�hlt!");
						break;
					}else { 
						break;
					}

				case 25:
					if (dachgeschoss && ausgewaehlteSw[25] == 1) {
						result = true;
//						System.out.println("Sie haben SW 2.5 ausgew�hlt!");
						break;
					}else { 
						break;
					}

				case 26:
					if (ausgewaehlteSw[26] == 1) {
						if(dachgeschoss && ausgewaehlteSw[25] == 1){
							result = true;
							break;
						}else { 
							throw new Exception("\n2.6 kann nur ausgew�hlt werden wenn 2.5 auch ausgew�hlt wurde!");
						}
					}else {
						break;
						}

					}	
				}

			
		} catch (Exception e) {

			result = false;
			System.out.println("Sonderw�nsche sind nicht kompatibel!" + e.getMessage());

		}

		return result;
	}
}
