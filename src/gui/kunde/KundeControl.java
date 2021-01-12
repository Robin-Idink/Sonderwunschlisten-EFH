package gui.kunde;

import java.sql.SQLException;
import business.kunde.Kunde;
import business.kunde.KundeModel;
import gui.fensterAu�entueren.FensterAu�entuerenControl;
import gui.grundriss.GrundrissControl;
import gui.innentuer.InnentuerControl;
import javafx.stage.Stage;

/**
 * Klasse, welche das Grundfenster mit den Kundendaten kontrolliert.
 */
public class KundeControl {
       
    // das View-Objekt des Grundfensters mit den Kundendaten
	private KundeView kundeView;
    // das Model-Objekt des Grundfensters mit den Kundendaten
    private KundeModel kundeModel;
    /* das GrundrissControl-Objekt fuer die Sonderwuensche
       zum Grundriss zu dem Kunden */
    private GrundrissControl grundrissControl;
    private InnentuerControl innentuerControl;
    private FensterAußentuerenControl fensterAußentuerenControl;
    
    /**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum 
	 * Grundfenster mit den Kundendaten.
	 * @param primaryStage, Stage fuer das View-Objekt zu dem Grundfenster mit den Kundendaten
	 */
    public KundeControl(Stage primaryStage) { 
        this.kundeModel = KundeModel.getInstance(); 
        this.kundeView = new KundeView(this, primaryStage, kundeModel);
    }
    
    /*
     * erstellt, falls nicht vorhanden, ein Grundriss-Control-Objekt.
     * Das GrundrissView wird sichtbar gemacht.
     */
    public void oeffneGrundrissControl(){
    	if (this.grundrissControl == null){
    		this.grundrissControl = new GrundrissControl(kundeModel);
      	}
    	this.grundrissControl.oeffneGrundrissView();
    }
    
    
    public void oeffneInnentuerControl(){
    	if (this.innentuerControl == null){
    		this.innentuerControl = new InnentuerControl(kundeModel);
      	}
    	this.innentuerControl.oeffneInnentuerView();
    }
    
    
    public void oeffneFensterAußentuerenControl(){
    	if (this.fensterAußentuerenControl == null){
    		this.fensterAußentuerenControl = new FensterAußentuerenControl(kundeModel);
      	}
    	this.fensterAußentuerenControl.oeffneFensterAußentuerenView();
    }
    
    
	/**
	 * speichert ein Kunde-Objekt in die Datenbank
	 * @param kunde, Kunde-Objekt, welches zu speichern ist
	 */
    public void speichereKunden(Kunde kunde){
      	try{
    		kundeModel.speichereKunden(kunde);
    	}
    	catch(SQLException exc){
    		exc.printStackTrace();
    		this.kundeView.zeigeFehlermeldung("SQLException",
                "Fehler beim Speichern in die Datenbank");
    	}
    	catch(Exception exc){
    		exc.printStackTrace();
    		this.kundeView.zeigeFehlermeldung("Exception",
                "Unbekannter Fehler");
    	}
    }
}
