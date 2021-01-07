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
		return true;
	}

}
