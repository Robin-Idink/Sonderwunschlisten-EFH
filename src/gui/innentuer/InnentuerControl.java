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
	 * fuer die Sonderwuensche zu den Innent�ren.
	 * 
	 * @param innentuerStage, Stage fuer das View-Objekt zu den Sonderwuenschen zu den Innent�ren
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

	public int berechneMaxAnzahlTueren(int[] ausgewaehlteSw) {
		// TODO Zugriff auf Sonderwuensche über KundeModel.getInstance().getKunde().getSonderwuensche()
		// TODO Zugriff auf Dachgeschoss Boolean über KundeModel.getInstance().getKunde().hatDachgeschoss()	
		
		//Berechnung der maximalen Anzahl der m�glichen T�ren, basierend auf dem Grundriss und den ausgew�hlten Sonderw�nschen
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
		// TODO Zugriff auf Sonderwuensche über KundeModel.getInstance().getKunde().getSonderwuensche()
		// TODO Zugriff auf Dachgeschoss Boolean über KundeModel.getInstance().getKunde().hatDachgeschoss()	
		
		/*
		wobei gilt:
		ausgewaehlteSw[41] = anzahlTuerKlarglas
		ausgewaehlteSw[42] = anzahlTuerMilchglas
		ausgewaehlteSw[43] = anzahlHolztuerGarage
		 */
		
		//Hier muss die Anzahl der eingegebenen T�ren �berpr�ft werden.
		//Unterschieden wird zwischen Keller, EG, OG und DG.
		
		boolean dachgeschoss = true;
		boolean result = true;
		//Pr�fung der 4.x Sonderw�nsche
		
		try {
			//Fehlermeldung falls die Summer der ausgew�hlten T�ren in 4.1 und 4.2 die maximal Anzahl �berschreitet
			if(ausgewaehlteSw[41]+ausgewaehlteSw[42] > berechneMaxAnzahlTueren(ausgewaehlteSw))
				throw new Exception("\n Die Anzahl der Ausgew�hlten T�ren �berschreitet die maximale Anzahl der m�glichen T�ren!");
			
			//Fehlermeldung falls 4.3 ausgew�hlt wird obwohl es kein Dachgeschoss gibt
			if(ausgewaehlteSw[43]==1)
				if(!dachgeschoss)
					throw new Exception("\n 4.3 kann nur ausgew�hlt werden wenn auch ein Dachgeschoss vorhanden ist!");
		
		}catch(Exception e) {
				result = false;
				System.out.println("Sonderw�nsche sind nicht kompatibel!" + e.getMessage());

		}
		return result;
	}

}
