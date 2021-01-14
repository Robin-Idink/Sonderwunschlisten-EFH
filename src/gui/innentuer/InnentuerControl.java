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

	public int berechneMaxAnzahlTueren(int[] ausgewaehlteSw) {
		
		
		//Berechnung der maximalen Anzahl der möglichen Türen, basierend auf dem Grundriss und den ausgewählten Sonderwünschen
		int maxAnzahlTueren = 0;
		
		boolean dachgeschoss = true;
		
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
	
		
		return maxAnzahlTueren;
		
	}
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw) {
		/*
		wobei gilt:
		ausgewaehlteSw[41] = anzahlTuerKlarglas
		ausgewaehlteSw[42] = anzahlTuerMilchglas
		ausgewaehlteSw[43] = anzahlHolztuerGarage
		 */
		
		//Hier muss die Anzahl der eingegebenen Türen überprüft werden.
		//Unterschieden wird zwischen Keller, EG, OG und DG.
		
		boolean dachgeschoss = true;
		boolean result = true;
		//Prüfung der 4.x Sonderwünsche
		
		try {
			//Fehlermeldung falls die Summer der ausgewählten Türen in 4.1 und 4.2 die maximal Anzahl überschreitet
			if(ausgewaehlteSw[41]+ausgewaehlteSw[42] > berechneMaxAnzahlTueren(ausgewaehlteSw))
				throw new Exception("\n Die Anzahl der Ausgewählten Türen überschreitet die maximale Anzahl der möglichen Türen!");
			
			//Fehlermeldung falls 4.3 ausgewählt wird obwohl es kein Dachgeschoss gibt
			if(ausgewaehlteSw[43]==1)
				if(!dachgeschoss)
					throw new Exception("\n 4.3 kann nur ausgewählt werden wenn auch ein Dachgeschoss vorhanden ist!");
		
		}catch(Exception e) {
				result = false;
				System.out.println("Sonderwünsche sind nicht kompatibel!" + e.getMessage());

		}
		return result;
	}

}
