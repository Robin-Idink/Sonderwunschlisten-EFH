package gui.fensterAu�entueren;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

public final class FensterAu�entuerenControl {
	
	private FensterAu�entuerenView fensterAu�entuerenView;

	public FensterAu�entuerenControl(KundeModel kundeModel) {
		Stage stageFensterAu�entueren = new Stage();
		stageFensterAu�entueren.initModality(Modality.APPLICATION_MODAL);
    	this.fensterAu�entuerenView = new FensterAu�entuerenView(this, stageFensterAu�entueren);
		
	}
	
	public FensterAu�entuerenControl() {
		
	}
	
	public void oeffneFensterAu�entuerenView(){ 
		this.fensterAu�entuerenView.oeffneFensterAu�entuerenView();
	}
	
	public void leseFensterAu�entuerenSonderwuensche(){
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		return true;
	}

}
