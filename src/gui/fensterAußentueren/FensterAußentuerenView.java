/**
 * 
 */
package gui.fensterAu�entueren;

import gui.basis.BasisView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu 
 * den Fenster- und Au�ent�renvarianten bereitstellt.
 */
public class FensterAu�entuerenView extends BasisView {
	
	// das Control-Objekt des Fenster- und Au�ent�ren-Fensters
	private FensterAu�entuerenControl fensterAu�entuerenControl;
		
	//---Anfang Attribute der grafischen Oberflaeche---
	private Label lblEGTuerTerasse   	    	= new Label("Schiebet�r zur Terasse");
	private Label lblTuerDachTerasse   	    	= new Label("Schiebet�r zur Dachterasse");
	private Label lblEinbruchschutz   	    	= new Label("Erh�hter Einbruchsschutz an der Haust�r");
	private Label lblVorEgRollaeden   	    	= new Label("Vorbereitung der elektr. EG-Roll�den");
	private Label lblVorOgRollaeden   	    	= new Label("Vorbereitung der elektr. OG-Roll�den");
	private Label lblVorDgRollaeden  	    	= new Label("Vorbereitung der elektr. DG-Roll�den");
	private Label lblEgRollaeden   	    	= new Label("Elektrische Roll�den f�r das EG");
	private Label lblOgRollaeden   	    	= new Label("Elektrische Roll�den f�r das EG");
	private Label lblDgRollaeden   	    	= new Label("Elektrische Roll�den f�r das EG");
    private TextField preisEGTuerTerasse 		= new TextField();
    private TextField preisTuerDachTerasse 		= new TextField();
    private TextField preisEinbruchschutz 		= new TextField();
    private TextField preisVorEgRollaeden 		= new TextField();
    private TextField preisVorOgRollaeden 		= new TextField();
    private TextField preisVorDgRollaeden 		= new TextField();
    private TextField preisEgRollaeden 		= new TextField();
    private TextField preisOgRollaeden 		= new TextField();
    private TextField preisDgRollaeden 		= new TextField();
    private Label lblEGTuerTerasseW�hrung 		= new Label("Euro");
    private Label lblTuerDachTerasseW�hrung 		= new Label("Euro");
    private Label lblEinbruchschutzW�hrung 		= new Label("Euro");
    private Label lblVorEgRollaedenW�hrung 		= new Label("Euro");
    private Label lblVorOgRollaedenW�hrung 		= new Label("Euro");
    private Label lblVorDgRollaedenW�hrung 		= new Label("Euro");
    private Label lblEgRollaedenW�hrung 		= new Label("Euro");
    private Label lblOgRollaedenW�hrung 		= new Label("Euro");
    private Label lblDgRollaedenW�hrung 		= new Label("Euro");
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
     * erzeugt ein FensterAu�entuerenView-Objekt, belegt das zugehoerige Control
     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
     * @param fensterAu�entuerenControl GrundrissControl, enthaelt das zugehoerige Control
     * @param fensterAu�entuerenStage Stage, enthaelt das Stage-Objekt fuer diese View
     */
	public FensterAu�entuerenView(FensterAu�entuerenControl fensterAu�entuerenControl, Stage fensterAu�entuerenStage) {
		super(fensterAu�entuerenStage);
		this.fensterAu�entuerenControl = fensterAu�entuerenControl;
		fensterAu�entuerenStage.setTitle("Sonderw�nsche zu Fenstern und Au�ent�ren");
		
		this.initKomponenten();
		this.leseFensterAu�entuerenSonderwuensche();
		
	}
	
	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten(){
    	super.initKomponenten(); 
       	super.getLblSonderwunsch().setText("Fenster und T�ren");
       	
       	super.getGridPaneSonderwunsch().add(lblEGTuerTerasse, 0, 1);
    	super.getGridPaneSonderwunsch().add(preisEGTuerTerasse, 1, 1);
    	preisEGTuerTerasse.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEGTuerTerasseW�hrung, 2, 1);
    	super.getGridPaneSonderwunsch().add(chckBxEGTuerTerasse, 3, 1);
    	
    	super.getGridPaneSonderwunsch().add(lblTuerDachTerasse, 0, 2);
    	super.getGridPaneSonderwunsch().add(preisTuerDachTerasse, 1, 2);
    	preisTuerDachTerasse.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerDachTerasseW�hrung, 2, 2);
    	super.getGridPaneSonderwunsch().add(chckBxTuerDachTerasse, 3, 2);
    	
    	super.getGridPaneSonderwunsch().add(lblEinbruchschutz, 0, 3);
    	super.getGridPaneSonderwunsch().add(preisEinbruchschutz, 1, 3);
    	preisEinbruchschutz.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEinbruchschutzW�hrung, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckBxEinbruchschutz, 3, 3);
    	
    	super.getGridPaneSonderwunsch().add(lblVorEgRollaeden, 0, 4);
    	super.getGridPaneSonderwunsch().add(preisVorEgRollaeden, 1, 4);
    	preisVorEgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorEgRollaedenW�hrung, 2, 4);
    	super.getGridPaneSonderwunsch().add(chckBxVorEgRollaeden, 3, 4);
    	
    	super.getGridPaneSonderwunsch().add(lblVorOgRollaeden, 0, 5);
    	super.getGridPaneSonderwunsch().add(preisVorOgRollaeden, 1, 5);
    	preisVorOgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorOgRollaedenW�hrung, 2, 5);
    	super.getGridPaneSonderwunsch().add(chckBxVorOgRollaeden, 3, 5);
    	
    	super.getGridPaneSonderwunsch().add(lblVorDgRollaeden, 0, 6);
    	super.getGridPaneSonderwunsch().add(preisVorDgRollaeden, 1, 6);
    	preisVorDgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorDgRollaedenW�hrung, 2, 6);
    	super.getGridPaneSonderwunsch().add(chckBxVorDgRollaeden, 3, 6);
    	
    	super.getGridPaneSonderwunsch().add(lblEgRollaeden, 0, 7);
    	super.getGridPaneSonderwunsch().add(preisEgRollaeden, 1, 7);
    	preisEgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEgRollaedenW�hrung, 2, 7);
    	super.getGridPaneSonderwunsch().add(chckBxEgRollaeden, 3, 7);
    	
    	super.getGridPaneSonderwunsch().add(lblOgRollaeden, 0, 8);
    	super.getGridPaneSonderwunsch().add(preisOgRollaeden, 1, 8);
    	preisOgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblOgRollaedenW�hrung, 2, 8);
    	super.getGridPaneSonderwunsch().add(chckBxOgRollaeden, 3, 8);
    	
    	super.getGridPaneSonderwunsch().add(lblDgRollaeden, 0, 9);
    	super.getGridPaneSonderwunsch().add(preisDgRollaeden, 1, 9);
    	preisDgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblDgRollaedenW�hrung, 2, 9);
    	super.getGridPaneSonderwunsch().add(chckBxDgRollaeden, 3, 9);
	}
	
	/**
	 * macht das FensterAu�entuerenView-Objekt sichtbar.
	 */
	public void oeffneFensterAu�entuerenView(){ 
		super.oeffneBasisView();
	}
	
	private void leseFensterAu�entuerenSonderwuensche(){
    	this.fensterAu�entuerenControl.leseFensterAu�entuerenSonderwuensche();
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
