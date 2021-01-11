package gui.fensterAuﬂentueren;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

public final class FensterAuﬂentuerenControl {
	
	private FensterAuﬂentuerenView fensterAuﬂentuerenView;

	public FensterAuﬂentuerenControl(KundeModel kundeModel) {
		Stage stageFensterAuﬂentueren = new Stage();
		stageFensterAuﬂentueren.initModality(Modality.APPLICATION_MODAL);
    	this.fensterAuﬂentuerenView = new FensterAuﬂentuerenView(this, stageFensterAuﬂentueren);
		
	}
	
	public FensterAuﬂentuerenControl() {
		
	}
	
	public void oeffneFensterAuﬂentuerenView(){ 
		this.fensterAuﬂentuerenView.oeffneFensterAuﬂentuerenView();
	}
	
	public void leseFensterAuﬂentuerenSonderwuensche(){
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		
		
		boolean result = false;
		
		boolean dachgeschoss = true;
		

		try {
			
			for (int i = 31; i < 40; i++) {
				switch (i) {

				case 31:
					if(ausgewaehlteSw[31] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.1 ausgew‰hlt!");
						break;
					}else {
						break;
					}

				case 32:
					if (dachgeschoss && ausgewaehlteSw[32] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.2 ausgew‰hlt!");
						break;
					}else { 
						break;
					}

				case 33:
					if(ausgewaehlteSw[33] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.3 ausgew‰hlt!");
						break;
					}else {
						break;
					}

				case 34:
					if (dachgeschoss && ausgewaehlteSw[34] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.4 ausgew‰hlt!");
						break;
					}else { 
						break;
					}

				case 35:
					if (dachgeschoss && ausgewaehlteSw[35] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.5 ausgew‰hlt!");
						break;
					}else { 
						break;
					}

				case 36:
					if (dachgeschoss && ausgewaehlteSw[36] == 1) {
						result = true;
//					System.out.println("Sie haben SW 3.6 ausgew‰hlt!");
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
							throw new Exception("\n3.7 kann nur ausgew‰hlt werden wenn 3.4 auch ausgew‰hlt wurde!");
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
							throw new Exception("\n3.8 kann nur ausgew‰hlt werden wenn 3.5 auch ausgew‰hlt wurde!");
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
							throw new Exception("\n3.9 kann nur ausgew‰hlt werden wenn 3.6 auch ausgew‰hlt wurde!");
						}
					}else {
						break;
					}
	
				}
			}
		} catch (Exception e) {

			result = false;
			System.out.println("Sonderw¸nsche sind nicht kompatibel!" + e.getMessage());

		}
		
		return result;
	}

}
