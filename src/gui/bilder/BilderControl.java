package gui.bilder;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Bilder-Varianten
 * kontrolliert.
 */
public final class BilderControl {

	// das View-Objekt der Bilder vom Haus
	private BilderView bilderView;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt der Bilder
	 * fuer die Sonderwuensche zum Haus.
	 * 
	 * @param innentuerStage, Stage fuer das View-Objekt zu den Sonderwuenschen zu den Bildern
	 */
	public BilderControl(KundeModel kundeModel) {
		Stage stageBilder = new Stage();
		stageBilder.initModality(Modality.APPLICATION_MODAL);
    	this.bilderView = new BilderView(this, stageBilder);
	}
	
	public BilderControl() {

	}

	/**
	 * macht das BilderView-Objekt sichtbar.
	 */
	public void oeffneBilderView(){
		this.bilderView.oeffneBilderView();
	}

	public void leseBilderSonderwuensche() {
	}
	
	//Methode Auswahlentscheidung
	public void auswahlfunktionDG(int[] ausgewaehlteDG) {	
		boolean dachgeschoss;
		
		if(dachgeschoss = true) {
			//Auswahl 1: mit DG			
		}
			
		else {
			//Auswahl 2: ohne DG
		}
		
		return;
	}
	
}

