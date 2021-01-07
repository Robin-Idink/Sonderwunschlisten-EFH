package gui.innentuer;

import business.kunde.KundeModel;
import gui.innentuer.InnentuerView;
import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Grundriss-Varianten
 * kontrolliert.
 */
public final class InnentuerControl {

	// das View-Objekt des Innentuer-Fensters
	private InnentuerView innentuerView;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum Fenster
	 * fuer die Sonderwuensche zu den Innentüren.
	 * 
	 * @param innentuerStage, Stage fuer das View-Objekt zu den Sonderwuenschen zu den Innentüren
	 */
	public InnentuerControl(KundeModel kundeModel) {
		Stage stageInnentuer = new Stage();
		stageInnentuer.initModality(Modality.APPLICATION_MODAL);
    	this.innentuerView = new InnentuerView(this, stageInnentuer);
	}
	
	public InnentuerControl() {

	}

	/**
	 * macht das InnentuerView-Objekt sichtbar.
	 */
	public void oeffneInnentuerView(){
		this.innentuerView.oeffneInnentuerView();
	}

	public void leseInnentuerSonderwuensche() {
	}


	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw) {
		/*
		wobei gilt:
		ausgewaehlteSw[0] = anzahlTuerKlarglas
		ausgewaehlteSw[1] = anzahlTuerMilchglas
		ausgewaehlteSw[2] = anzahlHolztuerGarage
		 */
		
		//Hier muss die Anzahl der eingegebenen Türen überprüft werden.
		//Unterschieden wird zwischen Keller, EG, OG und DG.
		
		
		return true;
	}

}
