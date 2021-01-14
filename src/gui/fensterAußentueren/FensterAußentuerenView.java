/**
 * 
 */
package gui.fensterAuﬂentueren;

import gui.basis.BasisView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu 
 * den Fenster- und Auﬂent¸renvarianten bereitstellt.
 */
public class FensterAuﬂentuerenView extends BasisView {
	
	// das Control-Objekt des Fenster- und Auﬂent¸ren-Fensters
	private FensterAuﬂentuerenControl fensterAuﬂentuerenControl;
		
	//---Anfang Attribute der grafischen Oberflaeche---
	private Label lblEGTuerTerasse   	    	= new Label("Schiebet¸r zur Terasse");
	private Label lblTuerDachTerasse   	    	= new Label("Schiebet¸r zur Dachterasse");
	private Label lblEinbruchschutz   	    	= new Label("Erhˆhter Einbruchsschutz an der Haust¸r");
	private Label lblVorEgRollaeden   	    	= new Label("Vorbereitung der elektr. EG-Roll‰den");
	private Label lblVorOgRollaeden   	    	= new Label("Vorbereitung der elektr. OG-Roll‰den");
	private Label lblVorDgRollaeden  	    	= new Label("Vorbereitung der elektr. DG-Roll‰den");
	private Label lblEgRollaeden   	    	= new Label("Elektrische Roll‰den f¸r das EG");
	private Label lblOgRollaeden   	    	= new Label("Elektrische Roll‰den f¸r das EG");
	private Label lblDgRollaeden   	    	= new Label("Elektrische Roll‰den f¸r das EG");
    private TextField preisEGTuerTerasse 		= new TextField();
    private TextField preisTuerDachTerasse 		= new TextField();
    private TextField preisEinbruchschutz 		= new TextField();
    private TextField preisVorEgRollaeden 		= new TextField();
    private TextField preisVorOgRollaeden 		= new TextField();
    private TextField preisVorDgRollaeden 		= new TextField();
    private TextField preisEgRollaeden 		= new TextField();
    private TextField preisOgRollaeden 		= new TextField();
    private TextField preisDgRollaeden 		= new TextField();
    private Label lblEGTuerTerasseW‰hrung 		= new Label("Euro");
    private Label lblTuerDachTerasseW‰hrung 		= new Label("Euro");
    private Label lblEinbruchschutzW‰hrung 		= new Label("Euro");
    private Label lblVorEgRollaedenW‰hrung 		= new Label("Euro");
    private Label lblVorOgRollaedenW‰hrung 		= new Label("Euro");
    private Label lblVorDgRollaedenW‰hrung 		= new Label("Euro");
    private Label lblEgRollaedenW‰hrung 		= new Label("Euro");
    private Label lblOgRollaedenW‰hrung 		= new Label("Euro");
    private Label lblDgRollaedenW‰hrung 		= new Label("Euro");
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
     * erzeugt ein FensterAuﬂentuerenView-Objekt, belegt das zugehoerige Control
     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
     * @param fensterAuﬂentuerenControl GrundrissControl, enthaelt das zugehoerige Control
     * @param fensterAuﬂentuerenStage Stage, enthaelt das Stage-Objekt fuer diese View
     */
	public FensterAuﬂentuerenView(FensterAuﬂentuerenControl fensterAuﬂentuerenControl, Stage fensterAuﬂentuerenStage) {
		super(fensterAuﬂentuerenStage);
		this.fensterAuﬂentuerenControl = fensterAuﬂentuerenControl;
		fensterAuﬂentuerenStage.setTitle("Sonderw¸nsche zu Fenstern und Auﬂent¸ren");
		
		this.initKomponenten();
		this.leseFensterAuﬂentuerenSonderwuensche();
		
	}
	
	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten(){
    	super.initKomponenten(); 
       	super.getLblSonderwunsch().setText("Fenster und T¸ren");
       	
       	super.getGridPaneSonderwunsch().add(lblEGTuerTerasse, 0, 1);
    	super.getGridPaneSonderwunsch().add(preisEGTuerTerasse, 1, 1);
    	preisEGTuerTerasse.setText("590");
    	preisEGTuerTerasse.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEGTuerTerasseW‰hrung, 2, 1);
    	super.getGridPaneSonderwunsch().add(chckBxEGTuerTerasse, 3, 1);
    	
    	super.getGridPaneSonderwunsch().add(lblTuerDachTerasse, 0, 2);
    	super.getGridPaneSonderwunsch().add(preisTuerDachTerasse, 1, 2);
    	preisTuerDachTerasse.setText("590");
    	preisTuerDachTerasse.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerDachTerasseW‰hrung, 2, 2);
    	super.getGridPaneSonderwunsch().add(chckBxTuerDachTerasse, 3, 2);
    	
    	super.getGridPaneSonderwunsch().add(lblEinbruchschutz, 0, 3);
    	super.getGridPaneSonderwunsch().add(preisEinbruchschutz, 1, 3);
    	preisEinbruchschutz.setText("690");
    	preisEinbruchschutz.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEinbruchschutzW‰hrung, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckBxEinbruchschutz, 3, 3);
    	
    	super.getGridPaneSonderwunsch().add(lblVorEgRollaeden, 0, 4);
    	super.getGridPaneSonderwunsch().add(preisVorEgRollaeden, 1, 4);
    	preisVorEgRollaeden.setText("190");
    	preisVorEgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorEgRollaedenW‰hrung, 2, 4);
    	super.getGridPaneSonderwunsch().add(chckBxVorEgRollaeden, 3, 4);
    	
    	super.getGridPaneSonderwunsch().add(lblVorOgRollaeden, 0, 5);
    	super.getGridPaneSonderwunsch().add(preisVorOgRollaeden, 1, 5);
    	preisVorOgRollaeden.setText("190");
    	preisVorOgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorOgRollaedenW‰hrung, 2, 5);
    	super.getGridPaneSonderwunsch().add(chckBxVorOgRollaeden, 3, 5);
    	
    	super.getGridPaneSonderwunsch().add(lblVorDgRollaeden, 0, 6);
    	super.getGridPaneSonderwunsch().add(preisVorDgRollaeden, 1, 6);
    	preisVorDgRollaeden.setText("190");
    	preisVorDgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorDgRollaedenW‰hrung, 2, 6);
    	super.getGridPaneSonderwunsch().add(chckBxVorDgRollaeden, 3, 6);
    	
    	super.getGridPaneSonderwunsch().add(lblEgRollaeden, 0, 7);
    	super.getGridPaneSonderwunsch().add(preisEgRollaeden, 1, 7);
    	preisEgRollaeden.setText("990");
    	preisEgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEgRollaedenW‰hrung, 2, 7);
    	super.getGridPaneSonderwunsch().add(chckBxEgRollaeden, 3, 7);
    	
    	super.getGridPaneSonderwunsch().add(lblOgRollaeden, 0, 8);
    	super.getGridPaneSonderwunsch().add(preisOgRollaeden, 1, 8);
    	preisOgRollaeden.setText("990");
    	preisOgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblOgRollaedenW‰hrung, 2, 8);
    	super.getGridPaneSonderwunsch().add(chckBxOgRollaeden, 3, 8);
    	
    	super.getGridPaneSonderwunsch().add(lblDgRollaeden, 0, 9);
    	super.getGridPaneSonderwunsch().add(preisDgRollaeden, 1, 9);
    	preisDgRollaeden.setText("990");
    	preisDgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblDgRollaedenW‰hrung, 2, 9);
    	super.getGridPaneSonderwunsch().add(chckBxDgRollaeden, 3, 9);
	}
	
	/**
	 * macht das FensterAuﬂentuerenView-Objekt sichtbar.
	 */
	public void oeffneFensterAuﬂentuerenView(){ 
		super.oeffneBasisView();
	}
	
	private void leseFensterAuﬂentuerenSonderwuensche(){
    	this.fensterAuﬂentuerenControl.leseFensterAuﬂentuerenSonderwuensche();
	}
	
	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
	protected void berechneUndZeigePreisSonderwuensche() {
		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann der Preis berechnet.
		
		int preisFensterAuﬂentueren = 0;
		
		int[] ausgewaehlteSw = new int[50];
		
		if (chckBxEGTuerTerasse.isSelected()) {
			ausgewaehlteSw[31] = 1;
			preisFensterAuﬂentueren += 590;
		}
		else ausgewaehlteSw[31] = 0;
		
		if (chckBxTuerDachTerasse.isSelected()) {
			ausgewaehlteSw[32] = 1;
			preisFensterAuﬂentueren += 590;
		}
		else ausgewaehlteSw[32] = 0;
		
		if (chckBxEinbruchschutz.isSelected()) {
			ausgewaehlteSw[33] = 1;
			preisFensterAuﬂentueren += 690;
		}
		else ausgewaehlteSw[33] = 0;
		
		if (chckBxVorEgRollaeden.isSelected()) {
			ausgewaehlteSw[34] = 1;
			preisFensterAuﬂentueren += 190;
		}
		else ausgewaehlteSw[34] = 0;
		
		if (chckBxVorOgRollaeden.isSelected()) {
			ausgewaehlteSw[35] = 1;
			preisFensterAuﬂentueren += 190;
		}
		else ausgewaehlteSw[35] = 0;
		
		if (chckBxVorDgRollaeden.isSelected()) {
			ausgewaehlteSw[36] = 1;
			preisFensterAuﬂentueren += 190;
		}
		else ausgewaehlteSw[36] = 0;
		
		if (chckBxEgRollaeden.isSelected()) {
			ausgewaehlteSw[37] = 1;
			preisFensterAuﬂentueren += 990;
		}
		else ausgewaehlteSw[37] = 0;
		
		if (chckBxOgRollaeden.isSelected()) {
			ausgewaehlteSw[38] = 1;
			preisFensterAuﬂentueren += 990;
		}
		else ausgewaehlteSw[38] = 0;
		
		if (chckBxDgRollaeden.isSelected()) {
			ausgewaehlteSw[39] = 1;
			preisFensterAuﬂentueren += 990;
		}
		else ausgewaehlteSw[39] = 0;
		
		
		
		
		if (this.fensterAuﬂentuerenControl.pruefeKonstellationSonderwuensche(ausgewaehlteSw)) { 
			//System.out.println("Es findet noch keine Konstellations¸berpr¸fung statt");
			System.out.println("alle Angaben sind korrekt");
			System.out.println("Gesamtpreis der Fenster und Auﬂentueren :\t" + preisFensterAuﬂentueren);
		}
		else System.out.println("Fehler in den Angaben");
	}

	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
	protected void speichereSonderwuensche() {
		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.

	}

}
