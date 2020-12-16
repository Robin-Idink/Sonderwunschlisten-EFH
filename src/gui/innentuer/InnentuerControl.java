package gui.innentuer;

import business.kunde.KundeModel;
import gui.innentuer.InnentuerView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InnentuerControl {

	private InnentuerView innentuerView;

	public InnentuerControl(KundeModel kundeModel) {
		Stage stageInnentuer = new Stage();
		stageInnentuer.initModality(Modality.APPLICATION_MODAL);
    	this.innentuerView = new InnentuerView(this, stageInnentuer);
	}

	/**
	 * macht das Innentuer-Objekt sichtbar.
	 */

	public void oeffneInnentuerView(){
		this.innentuerView.oeffneInnentuerView();
	}

	public void leseInnentuerSonderwuensche() {
	}

	public void oeffneInnentuerControl() {
	}

}
