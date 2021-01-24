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
	 * fuer die Sonderwuensche zu den Innentueren.
	 * 
	 * @param innentuerStage, Stage fuer das View-Objekt zu den Sonderwuenschen zu den Innentueren
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
		// TODO Zugriff auf Sonderwuensche ueber KundeModel.getInstance().getKunde().getSonderwuensche()
		// TODO Zugriff auf Dachgeschoss Boolean ueber KundeModel.getInstance().getKunde().hatDachgeschoss()	
		
		//Berechnung der maximalen Anzahl der moeglichen Tueren, basierend auf dem Grundriss und den ausgewaehlten Sonderwuenschen
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
		// TODO Zugriff auf Sonderwuensche ueber KundeModel.getInstance().getKunde().getSonderwuensche()
		// TODO Zugriff auf Dachgeschoss Boolean ueber KundeModel.getInstance().getKunde().hatDachgeschoss()	
		
		/*
		wobei gilt:
		ausgewaehlteSw[41] = anzahlTuerKlarglas
		ausgewaehlteSw[42] = anzahlTuerMilchglas
		ausgewaehlteSw[43] = anzahlHolztuerGarage
		 */
		
		//Hier muss die Anzahl der eingegebenen Tueren ueberprueft werden.
		//Unterschieden wird zwischen Keller, EG, OG und DG.
		
		boolean dachgeschoss = true;
		boolean result = true;
		//Pruefung der 4.x Sonderwuensche
		
		try {
			//Fehlermeldung falls die Summer der ausgewaehlten Tueren in 4.1 und 4.2 die maximal Anzahl ueberschreitet
			if(ausgewaehlteSw[41]+ausgewaehlteSw[42] > berechneMaxAnzahlTueren(ausgewaehlteSw))
				throw new Exception("\n Die Anzahl der Ausgewaehlten Tueren ueberschreitet die maximale Anzahl der moeglichen Tueren!");
			
			//Fehlermeldung falls 4.3 ausgewaehlt wird obwohl es kein Dachgeschoss gibt
			
			
			if(ausgewaehlteSw[43] > 0)
				if(ausgewaehlteSw[43]==1) {
					if(!dachgeschoss)
						throw new Exception("\n 4.3 kann nur ausgewaehlt werden wenn auch ein Dachgeschoss vorhanden ist!");
				}else {
					throw new Exception("\n Es kann nur maximal eine Garagentür ausgewählt werden");
				}
			
		}catch(Exception e) {
				result = false;
				System.out.println("Sonderwuensche sind nicht kompatibel!" + e.getMessage());

		}
		return result;
	}

}
