package gui.fensterAußentueren;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

public final class FensterAußentuerenControl {
	
	private FensterAußentuerenView fensterAußentuerenView;

	public FensterAußentuerenControl(KundeModel kundeModel) {
		Stage stageFensterAußentueren = new Stage();
		stageFensterAußentueren.initModality(Modality.APPLICATION_MODAL);
    	this.fensterAußentuerenView = new FensterAußentuerenView(this, stageFensterAußentueren);
		
	}
	
	public FensterAußentuerenControl() {
		
	}
	
	public void oeffneFensterAußentuerenView(){ 
		this.fensterAußentuerenView.oeffneFensterAußentuerenView();
	}
	
	public void leseFensterAußentuerenSonderwuensche(){
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		return true;
	}

}
