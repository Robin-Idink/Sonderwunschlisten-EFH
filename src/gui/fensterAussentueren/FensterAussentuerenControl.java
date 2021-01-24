package gui.fensterAussentueren;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

public final class FensterAussentuerenControl {
	
	private FensterAussentuerenView fensterAussentuerenView;

	public FensterAussentuerenControl(KundeModel kundeModel) {
		Stage stageFensterAussentueren = new Stage();
		stageFensterAussentueren.initModality(Modality.APPLICATION_MODAL);
    	this.fensterAussentuerenView = new FensterAussentuerenView(this, stageFensterAussentueren);
		
	}
	
	public FensterAussentuerenControl() {
		
	}
	
	public void oeffneFensterAussentuerenView(){ 
		this.fensterAussentuerenView.oeffneFensterAussentuerenView();
	}
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		// TODO Zugriff auf Sonderwuensche ueber KundeModel.getInstance().getKunde().getSonderwuensche()
		// TODO Zugriff auf Dachgeschoss Boolean ueber KundeModel.getInstance().getKunde().hatDachgeschoss()	
		
		
		boolean result = false;
		
		boolean dachgeschoss = true;
		

		try {
			
			for (int i = 31; i < 40; i++) {
				switch (i) {

				case 31:
					if(ausgewaehlteSw[31] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.1 ausgewaehlt!");
						break;
					}else {
						break;
					}

				case 32:
					if (dachgeschoss && ausgewaehlteSw[32] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.2 ausgewaehlt!");
						break;
					}else { 
						break;
					}

				case 33:
					if(ausgewaehlteSw[33] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.3 ausgew�hlt!");
						break;
					}else {
						break;
					}

				case 34:
					if (dachgeschoss && ausgewaehlteSw[34] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.4 ausgew�hlt!");
						break;
					}else { 
						break;
					}

				case 35:
					if (dachgeschoss && ausgewaehlteSw[35] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.5 ausgew�hlt!");
						break;
					}else { 
						break;
					}

				case 36:
					if (dachgeschoss && ausgewaehlteSw[36] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.6 ausgew�hlt!");
						break;
					}else { 
						break;
					}

				case 37:
					if (ausgewaehlteSw[37] == 1) {
						if(ausgewaehlteSw[34] == 1){
							result = true;
							break;
						}else { 
							throw new Exception("\n3.7 kann nur ausgewaehlt werden wenn 3.4 auch ausgewaehlt wurde!");
						}
					}else {
						break;
					}
	

				case 38:
					if (ausgewaehlteSw[38] == 1) {
						if(ausgewaehlteSw[35] == 1){
							result = true;
							break;
						}else { 
							throw new Exception("\n3.8 kann nur ausgewaehlt werden wenn 3.5 auch ausgewaehlt wurde!");
						}
					}else {
						break;
					}
	
				case 39:
					if (ausgewaehlteSw[39] == 1) {
						if(ausgewaehlteSw[36] == 1){
							result = true;
							break;
						}else { 
							throw new Exception("\n3.9 kann nur ausgewaehlt werden wenn 3.6 auch ausgewaehlt wurde!");
						}
					}else {
						break;
					}
	
				}
			}
		} catch (Exception e) {

			result = false;
			System.out.println("Sonderwuensche sind nicht kompatibel!" + e.getMessage());

		}
		
		return result;
	}

}
