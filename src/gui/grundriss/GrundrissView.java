package gui.grundriss;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu 
 * den Grundrissvarianten bereitstellt.
 */
public class GrundrissView extends BasisView{
 
 	// das Control-Objekt des Grundriss-Fensters
	private GrundrissControl grundrissControl;
   
    //---Anfang Attribute der grafischen Oberflaeche---
	private Label lblWandKueche    	     
    = new Label("Wand zur Abtrennung der K�che von dem Essbereich");
	private Label lblTuerWandKueche    	     
	= new Label("T�r in der Wand zwischen K�che und Essbereich");
	private Label lblGroßesZimmer    	     
	= new Label("Gro�es Zimmer anstatt zwei kleinen");
	private Label lblTreppenraum    	     
	= new Label("abgetrennter Treppenraum");
	private Label lblVorrichtungBadDachgeschoss    	     
	= new Label("Vorrichtung eines Bades im DG");
	private Label lblAusführungBadDachgeschoss   	     
	= new Label("Ausf�hrung eines Bades im DG");
	private TextField txtPreisWandKueche 	= new TextField();
	private TextField txtPreisTuerWandKueche 	= new TextField();
	private TextField txtPreisGroßesZimmer 	= new TextField();
	private TextField txtPreisTreppenraum 	= new TextField();
	private TextField txtPreisVorrichtungBadDachgeschoss 	= new TextField();
	private TextField txtPreisAusführungBadDachgeschoss 	= new TextField();
	private Label lblWandKuecheEuro 		= new Label("Euro");
	private Label lblTuerWandKuecheEuro 		= new Label("Euro");
	private Label lblGroßesZimmerEuro 		= new Label("Euro");
	private Label lblTreppenraumEuro 		= new Label("Euro");
	private Label lblVorrichtungBadDachgeschossEuro 		= new Label("Euro");
	private Label lblAusführungBadDachgeschossEuro 		= new Label("Euro");
	private CheckBox chckBxWandKueche 		= new CheckBox();
	private CheckBox chckBxTuerWandKueche 		= new CheckBox();
	private CheckBox chckBxGroßesZimmer 		= new CheckBox();
	private CheckBox chckBxTreppenraum 		= new CheckBox();
	private CheckBox chckBxVorrichtungBadDachgeschoss 		= new CheckBox();
	private CheckBox chckBxAusführungBadDachgeschoss 		= new CheckBox();
    //-------Ende Attribute der grafischen Oberflaeche-------
  
    /**
     * erzeugt ein GrundrissView-Objekt, belegt das zugehoerige Control
     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
     * @param grundrissControl GrundrissControl, enthaelt das zugehoerige Control
     * @param grundrissStage Stage, enthaelt das Stage-Objekt fuer diese View
     */
    public GrundrissView (GrundrissControl grundrissControl, Stage grundrissStage){
    	super(grundrissStage);
        this.grundrissControl = grundrissControl;
        grundrissStage.setTitle("Sonderw�nsche zu Grundriss-Varianten");
                
	    this.initKomponenten();
    }
  
    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten(){
    	super.initKomponenten(); 
       	super.getLblSonderwunsch().setText("Grundriss-Varianten");
       	
       	super.getGridPaneSonderwunsch().add(lblWandKueche, 0, 1);
    	super.getGridPaneSonderwunsch().add(txtPreisWandKueche, 1, 1);
    	txtPreisWandKueche.setText("300");
    	txtPreisWandKueche.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblWandKuecheEuro, 2, 1);
    	super.getGridPaneSonderwunsch().add(chckBxWandKueche, 3, 1);
    	
    	super.getGridPaneSonderwunsch().add(lblTuerWandKueche, 0, 2);
    	super.getGridPaneSonderwunsch().add(txtPreisTuerWandKueche, 1, 2);
    	txtPreisTuerWandKueche.setText("300");
    	txtPreisTuerWandKueche.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerWandKuecheEuro, 2, 2);
    	super.getGridPaneSonderwunsch().add(chckBxTuerWandKueche, 3, 2);
    	
    	super.getGridPaneSonderwunsch().add(lblGroßesZimmer, 0, 3);
    	super.getGridPaneSonderwunsch().add(txtPreisGroßesZimmer, 1, 3);
    	txtPreisGroßesZimmer.setText("0");
    	txtPreisGroßesZimmer.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblGroßesZimmerEuro, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckBxGroßesZimmer, 3, 3);
    	
    	super.getGridPaneSonderwunsch().add(lblTreppenraum, 0, 4);
    	super.getGridPaneSonderwunsch().add(txtPreisTreppenraum, 1, 4);
    	txtPreisTreppenraum.setText("890");
    	txtPreisTreppenraum.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTreppenraumEuro, 2, 4);
    	super.getGridPaneSonderwunsch().add(chckBxTreppenraum, 3, 4);
    	
    	super.getGridPaneSonderwunsch().add(lblVorrichtungBadDachgeschoss, 0, 5);
    	super.getGridPaneSonderwunsch().add(txtPreisVorrichtungBadDachgeschoss, 1, 5);
    	txtPreisVorrichtungBadDachgeschoss.setText("990");
    	txtPreisVorrichtungBadDachgeschoss.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorrichtungBadDachgeschossEuro, 2, 5);
    	super.getGridPaneSonderwunsch().add(chckBxVorrichtungBadDachgeschoss, 3, 5);
    	
    	super.getGridPaneSonderwunsch().add(lblAusführungBadDachgeschoss, 0, 6);
    	super.getGridPaneSonderwunsch().add(txtPreisAusführungBadDachgeschoss, 1, 6);
    	txtPreisAusführungBadDachgeschoss.setText("8.990");
    	txtPreisAusführungBadDachgeschoss.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblAusführungBadDachgeschossEuro, 2, 6);
    	super.getGridPaneSonderwunsch().add(chckBxAusführungBadDachgeschoss, 3, 6);
    }  
    
    /**
	 * macht das GrundrissView-Objekt sichtbar.
	 */
	public void oeffneGrundrissView(){ 
		super.oeffneBasisView();
	}
    
 	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
  	protected void berechneUndZeigePreisSonderwuensche(){
  		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann der Preis berechnet.
  		
		// TODO Zugriff auf Sonderwuensche über KundeModel.getInstance().getKunde().getSonderwuensche()
		// TODO Zugriff auf Dachgeschoss Boolean über KundeModel.getInstance().getKunde().hatDachgeschoss()	
  		
  		int preisGrundriss = 0;
		
		int[] ausgewaehlteSw = new int[50];
		
		if (chckBxWandKueche.isSelected()) {
			ausgewaehlteSw[21] = 1;
			preisGrundriss += 300;
		}
		else ausgewaehlteSw[21] = 0;
		
		if (chckBxTuerWandKueche.isSelected()) {
			ausgewaehlteSw[22] = 1;
			preisGrundriss += 300;
		}
		else ausgewaehlteSw[22] = 0;
		
		if (chckBxGroßesZimmer.isSelected()) {
			ausgewaehlteSw[23] = 1;
			preisGrundriss += 0;
		}
		else ausgewaehlteSw[23] = 0;
		
		if (chckBxTreppenraum.isSelected()) {
			ausgewaehlteSw[24] = 1;
			preisGrundriss += 890;
		}
		else ausgewaehlteSw[24] = 0;
		
		if (chckBxVorrichtungBadDachgeschoss.isSelected()) {
			ausgewaehlteSw[25] = 1;
			preisGrundriss += 990;
		}
		else ausgewaehlteSw[25] = 0;
		
		if (chckBxAusführungBadDachgeschoss.isSelected()) {
			ausgewaehlteSw[26] = 1;
			preisGrundriss += 8990;
		}
		else ausgewaehlteSw[26] = 0;
		
		

  		if(this.grundrissControl.pruefeKonstellationSonderwuensche(ausgewaehlteSw)) {
  			System.out.println("alle Angaben sind korrekt");
  			System.out.println("Gesamtpreis des Grundrisses :\t" + preisGrundriss);
  		}
  		else
  			System.out.println("Fehler in den Angaben");
  	}
  	
   	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
  	protected void speichereSonderwuensche(){
 		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.

		// Speichern über Methode KundeModel.getInstance().getKunde().speichereSonderwuensche()
  		
  		// TODO
  	}
  	
 	
 }


