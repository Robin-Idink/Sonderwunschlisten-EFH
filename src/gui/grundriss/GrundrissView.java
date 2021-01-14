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
    = new Label("Wand zur Abtrennung der Küche von dem Essbereich");
	private Label lblTuerWandKueche    	     
	= new Label("Tür in der Wand zwischen Küche und Essbereich");
	private Label lblGroßesZimmer    	     
	= new Label("Großes Zimmer anstatt zwei kleinen");
	private Label lblTreppenraum    	     
	= new Label("abgetrennter Treppenraum");
	private Label lblVorrichtungBadDachgeschoss    	     
	= new Label("Vorrichtung eines Bades im DG");
	private Label lblAusführungBadDachgeschoss   	     
	= new Label("Ausführung eines Bades im DG");
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
        grundrissStage.setTitle("Sonderwünsche zu Grundriss-Varianten");
                
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
    	
    	super.getGridPaneSonderwunsch().add(lblGroßesZimmer, 0, 3);
    	super.getGridPaneSonderwunsch().add(txtPreisGroßesZimmer, 1, 3);
    	txtPreisGroßesZimmer.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblGroßesZimmerEuro, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckBxGroßesZimmer, 3, 3);
    	
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
    	
    	super.getGridPaneSonderwunsch().add(lblAusführungBadDachgeschoss, 0, 6);
    	super.getGridPaneSonderwunsch().add(txtPreisAusführungBadDachgeschoss, 1, 6);
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
  			System.out.println("Danke für Ihre Auswahl!");
  			//Hier würden eigentlich die ausgewählten Sonderwünsche zusammengerechnet werden. Aktuell gibt es aber nur einen.
  			//Sobald die anderen Sonderwünsche verfügbar sind, wird das hier hinzugefügt. 
  			//Iteration über ein Array mit Referenzen auf die ausgewählten Preisboxen
  		else
  			System.out.println("Fehler");
  	}
  	
   	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
  	protected void speichereSonderwuensche(){
 		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
  	}
  	
 	
 }


