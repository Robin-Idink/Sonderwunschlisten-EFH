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
 * den Fenster- und Au�ent�renvarianten bereitstellt.
 */
public class FensterAußentuerenView extends BasisView {
	
	// das Control-Objekt des Fenster- und Au�ent�ren-Fensters
	private FensterAußentuerenControl fensterAußentuerenControl;
		
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
     * erzeugt ein FensterAu�entuerenView-Objekt, belegt das zugehoerige Control
     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
     * @param fensterAu�entuerenControl GrundrissControl, enthaelt das zugehoerige Control
     * @param fensterAu�entuerenStage Stage, enthaelt das Stage-Objekt fuer diese View
     */
	public FensterAußentuerenView(FensterAußentuerenControl fensterAußentuerenControl, Stage fensterAußentuerenStage) {
		super(fensterAußentuerenStage);
		this.fensterAußentuerenControl = fensterAußentuerenControl;
		fensterAußentuerenStage.setTitle("Sonderwünsche zu Fenstern und Au�ent�ren");
		
		this.initKomponenten();
		this.leseFensterAußentuerenSonderwuensche();
		
	}
	
	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten(){
    	super.initKomponenten(); 
       	super.getLblSonderwunsch().setText("Fenster und T�ren");
       	
       	super.getGridPaneSonderwunsch().add(lblEGTuerTerasse, 0, 1);
    	super.getGridPaneSonderwunsch().add(preisEGTuerTerasse, 1, 1);
    	preisEGTuerTerasse.setText("590");
    	preisEGTuerTerasse.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEGTuerTerasseWährung, 2, 1);
    	super.getGridPaneSonderwunsch().add(chckBxEGTuerTerasse, 3, 1);
    	
    	super.getGridPaneSonderwunsch().add(lblTuerDachTerasse, 0, 2);
    	super.getGridPaneSonderwunsch().add(preisTuerDachTerasse, 1, 2);
    	preisTuerDachTerasse.setText("590");
    	preisTuerDachTerasse.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerDachTerasseWährung, 2, 2);
    	super.getGridPaneSonderwunsch().add(chckBxTuerDachTerasse, 3, 2);
    	
    	super.getGridPaneSonderwunsch().add(lblEinbruchschutz, 0, 3);
    	super.getGridPaneSonderwunsch().add(preisEinbruchschutz, 1, 3);
    	preisEinbruchschutz.setText("690");
    	preisEinbruchschutz.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEinbruchschutzWährung, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckBxEinbruchschutz, 3, 3);
    	
    	super.getGridPaneSonderwunsch().add(lblVorEgRollaeden, 0, 4);
    	super.getGridPaneSonderwunsch().add(preisVorEgRollaeden, 1, 4);
    	preisVorEgRollaeden.setText("190");
    	preisVorEgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorEgRollaedenWährung, 2, 4);
    	super.getGridPaneSonderwunsch().add(chckBxVorEgRollaeden, 3, 4);
    	
    	super.getGridPaneSonderwunsch().add(lblVorOgRollaeden, 0, 5);
    	super.getGridPaneSonderwunsch().add(preisVorOgRollaeden, 1, 5);
    	preisVorOgRollaeden.setText("190");
    	preisVorOgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorOgRollaedenWährung, 2, 5);
    	super.getGridPaneSonderwunsch().add(chckBxVorOgRollaeden, 3, 5);
    	
    	super.getGridPaneSonderwunsch().add(lblVorDgRollaeden, 0, 6);
    	super.getGridPaneSonderwunsch().add(preisVorDgRollaeden, 1, 6);
    	preisVorDgRollaeden.setText("190");
    	preisVorDgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorDgRollaedenWährung, 2, 6);
    	super.getGridPaneSonderwunsch().add(chckBxVorDgRollaeden, 3, 6);
    	
    	super.getGridPaneSonderwunsch().add(lblEgRollaeden, 0, 7);
    	super.getGridPaneSonderwunsch().add(preisEgRollaeden, 1, 7);
    	preisEgRollaeden.setText("990");
    	preisEgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEgRollaedenWährung, 2, 7);
    	super.getGridPaneSonderwunsch().add(chckBxEgRollaeden, 3, 7);
    	
    	super.getGridPaneSonderwunsch().add(lblOgRollaeden, 0, 8);
    	super.getGridPaneSonderwunsch().add(preisOgRollaeden, 1, 8);
    	preisOgRollaeden.setText("990");
    	preisOgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblOgRollaedenWährung, 2, 8);
    	super.getGridPaneSonderwunsch().add(chckBxOgRollaeden, 3, 8);
    	
    	super.getGridPaneSonderwunsch().add(lblDgRollaeden, 0, 9);
    	super.getGridPaneSonderwunsch().add(preisDgRollaeden, 1, 9);
    	preisDgRollaeden.setText("990");
    	preisDgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblDgRollaedenWährung, 2, 9);
    	super.getGridPaneSonderwunsch().add(chckBxDgRollaeden, 3, 9);
	}
	
	/**
	 * macht das FensterAu�entuerenView-Objekt sichtbar.
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
		
		int preisFensterAußentueren = 0;
		
		int[] ausgewaehlteSw = new int[50];
		
		if (chckBxEGTuerTerasse.isSelected()) {
			ausgewaehlteSw[31] = 1;
			preisFensterAußentueren += 590;
		}
		else ausgewaehlteSw[31] = 0;
		
		if (chckBxTuerDachTerasse.isSelected()) {
			ausgewaehlteSw[32] = 1;
			preisFensterAußentueren += 590;
		}
		else ausgewaehlteSw[32] = 0;
		
		if (chckBxEinbruchschutz.isSelected()) {
			ausgewaehlteSw[33] = 1;
			preisFensterAußentueren += 690;
		}
		else ausgewaehlteSw[33] = 0;
		
		if (chckBxVorEgRollaeden.isSelected()) {
			ausgewaehlteSw[34] = 1;
			preisFensterAußentueren += 190;
		}
		else ausgewaehlteSw[34] = 0;
		
		if (chckBxVorOgRollaeden.isSelected()) {
			ausgewaehlteSw[35] = 1;
			preisFensterAußentueren += 190;
		}
		else ausgewaehlteSw[35] = 0;
		
		if (chckBxVorDgRollaeden.isSelected()) {
			ausgewaehlteSw[36] = 1;
			preisFensterAußentueren += 190;
		}
		else ausgewaehlteSw[36] = 0;
		
		if (chckBxEgRollaeden.isSelected()) {
			ausgewaehlteSw[37] = 1;
			preisFensterAußentueren += 990;
		}
		else ausgewaehlteSw[37] = 0;
		
		if (chckBxOgRollaeden.isSelected()) {
			ausgewaehlteSw[38] = 1;
			preisFensterAußentueren += 990;
		}
		else ausgewaehlteSw[38] = 0;
		
		if (chckBxDgRollaeden.isSelected()) {
			ausgewaehlteSw[39] = 1;
			preisFensterAußentueren += 990;
		}
		else ausgewaehlteSw[39] = 0;
		
		
		
		
		if (this.fensterAußentuerenControl.pruefeKonstellationSonderwuensche(ausgewaehlteSw)) { 
			//System.out.println("Es findet noch keine Konstellationsüberprüfung statt");
			System.out.println("alle Angaben sind korrekt");
			System.out.println("Gesamtpreis der Fenster und Au�entueren :\t" + preisFensterAußentueren);
		}
		else System.out.println("Fehler in den Angaben");
	}

	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
	protected void speichereSonderwuensche() {
		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.

	}

}
