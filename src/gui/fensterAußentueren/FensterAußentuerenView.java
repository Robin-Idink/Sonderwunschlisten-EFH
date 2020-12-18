/**
 * 
 */
package gui.fensterAußentueren;

import gui.basis.BasisView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu 
 * den Fenster- und Außentürenvarianten bereitstellt.
 */
public class FensterAußentuerenView extends BasisView {
	
	// das Control-Objekt des Fenster- und Außentüren-Fensters
	private FensterAußentuerenControl fensterAußentuerenControl;
		
	//---Anfang Attribute der grafischen Oberflaeche---
	private Label lblEGTuerTerasse   	    	= new Label("Schiebetür zur Terasse");
	private Label lblTuerDachTerasse   	    	= new Label("Schiebetür zur Dachterasse");
	private Label lblEinbruchschutz   	    	= new Label("Erhöhter Einbruchsschutz an der Haustür");
	private Label lblVorEgRollaeden   	    	= new Label("Vorbereitung der elektr. EG-Rolläden");
	private Label lblVorOgRollaeden   	    	= new Label("Vorbereitung der elektr. OG-Rolläden");
	private Label lblVorDgRollaeden  	    	= new Label("Vorbereitung der elektr. DG-Rolläden");
	private Label lblEgRollaeden   	    	= new Label("Elektrische Rolläden für das EG");
	private Label lblOgRollaeden   	    	= new Label("Elektrische Rolläden für das EG");
	private Label lblDgRollaeden   	    	= new Label("Elektrische Rolläden für das EG");
    private TextField preisEGTuerTerasse 		= new TextField();
    private TextField preisTuerDachTerasse 		= new TextField();
    private TextField preisEinbruchschutz 		= new TextField();
    private TextField preisVorEgRollaeden 		= new TextField();
    private TextField preisVorOgRollaeden 		= new TextField();
    private TextField preisVorDgRollaeden 		= new TextField();
    private TextField preisEgRollaeden 		= new TextField();
    private TextField preisOgRollaeden 		= new TextField();
    private TextField preisDgRollaeden 		= new TextField();
    private Label lblEGTuerTerasseWährung 		= new Label("Euro");
    private Label lblTuerDachTerasseWährung 		= new Label("Euro");
    private Label lblEinbruchschutzWährung 		= new Label("Euro");
    private Label lblVorEgRollaedenWährung 		= new Label("Euro");
    private Label lblVorOgRollaedenWährung 		= new Label("Euro");
    private Label lblVorDgRollaedenWährung 		= new Label("Euro");
    private Label lblEgRollaedenWährung 		= new Label("Euro");
    private Label lblOgRollaedenWährung 		= new Label("Euro");
    private Label lblDgRollaedenWährung 		= new Label("Euro");
    private CheckBox chckBxEGTuerTerasse 		= new CheckBox();
    private CheckBox chckBxTuerDachTerasse 		= new CheckBox();
    private CheckBox chckBxEinbruchschutz		= new CheckBox();
    private CheckBox chckBxVorEgRollaeden		= new CheckBox();
    private CheckBox chckBxVorOgRollaeden 		= new CheckBox();
    private CheckBox chckBxVorDgRollaeden 		= new CheckBox();
    private CheckBox chckBxEgRollaeden 		= new CheckBox();
    private CheckBox chckBxOgRollaeden 		= new CheckBox();
    private CheckBox chckBxDgRollaeden 		= new CheckBox();
  //-------Ende Attribute der grafischen Oberflaeche-------
    
    
    /**
     * erzeugt ein FensterAußentuerenView-Objekt, belegt das zugehoerige Control
     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
     * @param fensterAußentuerenControl GrundrissControl, enthaelt das zugehoerige Control
     * @param fensterAußentuerenStage Stage, enthaelt das Stage-Objekt fuer diese View
     */
	public FensterAußentuerenView(FensterAußentuerenControl fensterAußentuerenControl, Stage fensterAußentuerenStage) {
		super(fensterAußentuerenStage);
		this.fensterAußentuerenControl = fensterAußentuerenControl;
		fensterAußentuerenStage.setTitle("Sonderwünsche zu Fenstern und Außentüren");
		
		this.initKomponenten();
		this.leseFensterAußentuerenSonderwuensche();
		
	}
	
	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten(){
    	super.initKomponenten(); 
       	super.getLblSonderwunsch().setText("Fenster und Türen");
       	
       	super.getGridPaneSonderwunsch().add(lblEGTuerTerasse, 0, 1);
    	super.getGridPaneSonderwunsch().add(preisEGTuerTerasse, 1, 1);
    	preisEGTuerTerasse.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEGTuerTerasseWährung, 2, 1);
    	super.getGridPaneSonderwunsch().add(chckBxEGTuerTerasse, 3, 1);
    	
    	super.getGridPaneSonderwunsch().add(lblTuerDachTerasse, 0, 2);
    	super.getGridPaneSonderwunsch().add(preisTuerDachTerasse, 1, 2);
    	preisTuerDachTerasse.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerDachTerasseWährung, 2, 2);
    	super.getGridPaneSonderwunsch().add(chckBxTuerDachTerasse, 3, 2);
    	
    	super.getGridPaneSonderwunsch().add(lblEinbruchschutz, 0, 3);
    	super.getGridPaneSonderwunsch().add(preisEinbruchschutz, 1, 3);
    	preisEinbruchschutz.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEinbruchschutzWährung, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckBxEinbruchschutz, 3, 3);
    	
    	super.getGridPaneSonderwunsch().add(lblVorEgRollaeden, 0, 4);
    	super.getGridPaneSonderwunsch().add(preisVorEgRollaeden, 1, 4);
    	preisVorEgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorEgRollaedenWährung, 2, 4);
    	super.getGridPaneSonderwunsch().add(chckBxVorEgRollaeden, 3, 4);
    	
    	super.getGridPaneSonderwunsch().add(lblVorOgRollaeden, 0, 5);
    	super.getGridPaneSonderwunsch().add(preisVorOgRollaeden, 1, 5);
    	preisVorOgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorOgRollaedenWährung, 2, 5);
    	super.getGridPaneSonderwunsch().add(chckBxVorOgRollaeden, 3, 5);
    	
    	super.getGridPaneSonderwunsch().add(lblVorDgRollaeden, 0, 6);
    	super.getGridPaneSonderwunsch().add(preisVorDgRollaeden, 1, 6);
    	preisVorDgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorDgRollaedenWährung, 2, 6);
    	super.getGridPaneSonderwunsch().add(chckBxVorDgRollaeden, 3, 6);
    	
    	super.getGridPaneSonderwunsch().add(lblEgRollaeden, 0, 7);
    	super.getGridPaneSonderwunsch().add(preisEgRollaeden, 1, 7);
    	preisEgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEgRollaedenWährung, 2, 7);
    	super.getGridPaneSonderwunsch().add(chckBxEgRollaeden, 3, 7);
    	
    	super.getGridPaneSonderwunsch().add(lblOgRollaeden, 0, 8);
    	super.getGridPaneSonderwunsch().add(preisOgRollaeden, 1, 8);
    	preisOgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblOgRollaedenWährung, 2, 8);
    	super.getGridPaneSonderwunsch().add(chckBxOgRollaeden, 3, 8);
    	
    	super.getGridPaneSonderwunsch().add(lblDgRollaeden, 0, 9);
    	super.getGridPaneSonderwunsch().add(preisDgRollaeden, 1, 9);
    	preisDgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblDgRollaedenWährung, 2, 9);
    	super.getGridPaneSonderwunsch().add(chckBxDgRollaeden, 3, 9);
	}
	
	/**
	 * macht das FensterAußentuerenView-Objekt sichtbar.
	 */
	public void oeffneFensterAußentuerenView(){ 
		super.oeffneBasisView();
	}
	
	private void leseFensterAußentuerenSonderwuensche(){
    	this.fensterAußentuerenControl.leseFensterAußentuerenSonderwuensche();
	}
	
	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
	protected void berechneUndZeigePreisSonderwuensche() {
		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann der Preis berechnet.
	}

	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
	protected void speichereSonderwuensche() {
		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.

	}

}
