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
	private Label lblGro�esZimmer    	     
	= new Label("Gro�es Zimmer anstatt zwei kleinen");
	private Label lblTreppenraum    	     
	= new Label("abgetrennter Treppenraum");
	private Label lblVorrichtungBadDachgeschoss    	     
	= new Label("Vorrichtung eines Bades im DG");
	private Label lblAusf�hrungBadDachgeschoss   	     
	= new Label("Ausf�hrung eines Bades im DG");
	private TextField txtPreisWandKueche 	= new TextField();
	private TextField txtPreisTuerWandKueche 	= new TextField();
	private TextField txtPreisGro�esZimmer 	= new TextField();
	private TextField txtPreisTreppenraum 	= new TextField();
	private TextField txtPreisVorrichtungBadDachgeschoss 	= new TextField();
	private TextField txtPreisAusf�hrungBadDachgeschoss 	= new TextField();
	private Label lblWandKuecheEuro 		= new Label("Euro");
	private Label lblTuerWandKuecheEuro 		= new Label("Euro");
	private Label lblGro�esZimmerEuro 		= new Label("Euro");
	private Label lblTreppenraumEuro 		= new Label("Euro");
	private Label lblVorrichtungBadDachgeschossEuro 		= new Label("Euro");
	private Label lblAusf�hrungBadDachgeschossEuro 		= new Label("Euro");
	private CheckBox chckBxWandKueche 		= new CheckBox();
	private CheckBox chckBxTuerWandKueche 		= new CheckBox();
	private CheckBox chckBxGro�esZimmer 		= new CheckBox();
	private CheckBox chckBxTreppenraum 		= new CheckBox();
	private CheckBox chckBxVorrichtungBadDachgeschoss 		= new CheckBox();
	private CheckBox chckBxAusf�hrungBadDachgeschoss 		= new CheckBox();
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
	    this.leseGrundrissSonderwuensche();
    }
  
    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten(){
    	super.initKomponenten(); 
       	super.getLblSonderwunsch().setText("Grundriss-Varianten");
       	
       	super.getGridPaneSonderwunsch().add(lblWandKueche, 0, 1);
    	super.getGridPaneSonderwunsch().add(txtPreisWandKueche, 1, 1);
    	txtPreisWandKueche.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblWandKuecheEuro, 2, 1);
    	super.getGridPaneSonderwunsch().add(chckBxWandKueche, 3, 1);
    	
    	super.getGridPaneSonderwunsch().add(lblTuerWandKueche, 0, 2);
    	super.getGridPaneSonderwunsch().add(txtPreisTuerWandKueche, 1, 2);
    	txtPreisTuerWandKueche.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerWandKuecheEuro, 2, 2);
    	super.getGridPaneSonderwunsch().add(chckBxTuerWandKueche, 3, 2);
    	
    	super.getGridPaneSonderwunsch().add(lblGro�esZimmer, 0, 3);
    	super.getGridPaneSonderwunsch().add(txtPreisGro�esZimmer, 1, 3);
    	txtPreisGro�esZimmer.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblGro�esZimmerEuro, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckBxGro�esZimmer, 3, 3);
    	
    	super.getGridPaneSonderwunsch().add(lblTreppenraum, 0, 4);
    	super.getGridPaneSonderwunsch().add(txtPreisTreppenraum, 1, 4);
    	txtPreisTreppenraum.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTreppenraumEuro, 2, 4);
    	super.getGridPaneSonderwunsch().add(chckBxTreppenraum, 3, 4);
    	
    	super.getGridPaneSonderwunsch().add(lblVorrichtungBadDachgeschoss, 0, 5);
    	super.getGridPaneSonderwunsch().add(txtPreisVorrichtungBadDachgeschoss, 1, 5);
    	txtPreisVorrichtungBadDachgeschoss.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorrichtungBadDachgeschossEuro, 2, 5);
    	super.getGridPaneSonderwunsch().add(chckBxVorrichtungBadDachgeschoss, 3, 5);
    	
    	super.getGridPaneSonderwunsch().add(lblAusf�hrungBadDachgeschoss, 0, 6);
    	super.getGridPaneSonderwunsch().add(txtPreisAusf�hrungBadDachgeschoss, 1, 6);
    	txtPreisAusf�hrungBadDachgeschoss.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblAusf�hrungBadDachgeschossEuro, 2, 6);
    	super.getGridPaneSonderwunsch().add(chckBxAusf�hrungBadDachgeschoss, 3, 6);
    }  
    
    /**
	 * macht das GrundrissView-Objekt sichtbar.
	 */
	public void oeffneGrundrissView(){ 
		super.oeffneBasisView();
	}
    
    private void leseGrundrissSonderwuensche(){
    	
    	this.grundrissControl.leseGrundrissSonderwuensche();
    }
    
 	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
  	protected void berechneUndZeigePreisSonderwuensche(){
  		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann der Preis berechnet.
  		
  		
  		//Provisorisches Array, da noch nicht bekannt ist wie die Sonderwunsch-Auswahl gespeichert wird
  		int[] ausgewaehlteSw = new int[50];

  		if(this.grundrissControl.pruefeKonstellationSonderwuensche(ausgewaehlteSw))
  			System.out.println("Danke f�r Ihre Auswahl!");
  			//Hier w�rden eigentlich die ausgew�hlten Sonderw�nsche zusammengerechnet werden. Aktuell gibt es aber nur einen.
  			//Sobald die anderen Sonderw�nsche verf�gbar sind, wird das hier hinzugef�gt. 
  			//Iteration �ber ein Array mit Referenzen auf die ausgew�hlten Preisboxen
  		else
  			System.out.println("Fehler");
  	}
  	
   	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
  	protected void speichereSonderwuensche(){
 		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
  	}
  	
 	
 }


