/**
 * 
 */
package gui.fensterAussentueren;

import gui.basis.BasisView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu 
 * den Fenster- und Aussentuerenvarianten bereitstellt.
 */
public class FensterAussentuerenView extends BasisView {
	
	// das Control-Objekt des Fenster- und Aussentueren-Fensters
	private FensterAussentuerenControl fensterAussentuerenControl;
		
	//---Anfang Attribute der grafischen Oberflaeche---
	private Label lblEGTuerTerasse   	    	= new Label("Schiebetuer zur Terasse");
	private Label lblTuerDachTerasse   	    	= new Label("Schiebetuer zur Dachterasse");
	private Label lblEinbruchschutz   	    	= new Label("Erhoehter Einbruchsschutz an der Haustuer");
	private Label lblVorEgRollaeden   	    	= new Label("Vorbereitung der elektr. EG-Rollaeden");
	private Label lblVorOgRollaeden   	    	= new Label("Vorbereitung der elektr. OG-Rollaeden");
	private Label lblVorDgRollaeden  	    	= new Label("Vorbereitung der elektr. DG-Rollaeden");
	private Label lblEgRollaeden   	    	= new Label("Elektrische Rollaeden fuer das EG");
	private Label lblOgRollaeden   	    	= new Label("Elektrische Rollaeden fuer das OG");
	private Label lblDgRollaeden   	    	= new Label("Elektrische Rollaeden fuer das DG");
    private TextField preisEGTuerTerasse 		= new TextField();
    private TextField preisTuerDachTerasse 		= new TextField();
    private TextField preisEinbruchschutz 		= new TextField();
    private TextField preisVorEgRollaeden 		= new TextField();
    private TextField preisVorOgRollaeden 		= new TextField();
    private TextField preisVorDgRollaeden 		= new TextField();
    private TextField preisEgRollaeden 		= new TextField();
    private TextField preisOgRollaeden 		= new TextField();
    private TextField preisDgRollaeden 		= new TextField();
    private Label lblEGTuerTerasseWaehrung 		= new Label("Euro");
    private Label lblTuerDachTerasseWaehrung 		= new Label("Euro");
    private Label lblEinbruchschutzWaehrung 		= new Label("Euro");
    private Label lblVorEgRollaedenWaehrung 		= new Label("Euro");
    private Label lblVorOgRollaedenWaehrung 		= new Label("Euro");
    private Label lblVorDgRollaedenWaehrung 		= new Label("Euro");
    private Label lblEgRollaedenWaehrung 		= new Label("Euro");
    private Label lblOgRollaedenWaehrung 		= new Label("Euro");
    private Label lblDgRollaedenWaehrung 		= new Label("Euro");
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
     * @param fensterAussentuerenControl GrundrissControl, enthaelt das zugehoerige Control
     * @param fensterAussentuerenStage Stage, enthaelt das Stage-Objekt fuer diese View
     */
	public FensterAussentuerenView(FensterAussentuerenControl fensterAussentuerenControl, Stage fensterAussentuerenStage) {
		super(fensterAussentuerenStage);
		this.fensterAussentuerenControl = fensterAussentuerenControl;
		fensterAussentuerenStage.setTitle("Sonderwuensche zu Fenstern und Aussentueren");
		
		this.initKomponenten();
		
	}
	
	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten(){
    	super.initKomponenten(); 
       	super.getLblSonderwunsch().setText("Fenster und Tueren");
       	
       	super.getGridPaneSonderwunsch().add(lblEGTuerTerasse, 0, 1);
    	super.getGridPaneSonderwunsch().add(preisEGTuerTerasse, 1, 1);
    	preisEGTuerTerasse.setText("590");
    	preisEGTuerTerasse.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEGTuerTerasseWaehrung, 2, 1);
    	super.getGridPaneSonderwunsch().add(chckBxEGTuerTerasse, 3, 1);
    	
    	super.getGridPaneSonderwunsch().add(lblTuerDachTerasse, 0, 2);
    	super.getGridPaneSonderwunsch().add(preisTuerDachTerasse, 1, 2);
    	preisTuerDachTerasse.setText("590");
    	preisTuerDachTerasse.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerDachTerasseWaehrung, 2, 2);
    	super.getGridPaneSonderwunsch().add(chckBxTuerDachTerasse, 3, 2);
    	
    	super.getGridPaneSonderwunsch().add(lblEinbruchschutz, 0, 3);
    	super.getGridPaneSonderwunsch().add(preisEinbruchschutz, 1, 3);
    	preisEinbruchschutz.setText("690");
    	preisEinbruchschutz.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEinbruchschutzWaehrung, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckBxEinbruchschutz, 3, 3);
    	
    	super.getGridPaneSonderwunsch().add(lblVorEgRollaeden, 0, 4);
    	super.getGridPaneSonderwunsch().add(preisVorEgRollaeden, 1, 4);
    	preisVorEgRollaeden.setText("190");
    	preisVorEgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorEgRollaedenWaehrung, 2, 4);
    	super.getGridPaneSonderwunsch().add(chckBxVorEgRollaeden, 3, 4);
    	
    	super.getGridPaneSonderwunsch().add(lblVorOgRollaeden, 0, 5);
    	super.getGridPaneSonderwunsch().add(preisVorOgRollaeden, 1, 5);
    	preisVorOgRollaeden.setText("190");
    	preisVorOgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorOgRollaedenWaehrung, 2, 5);
    	super.getGridPaneSonderwunsch().add(chckBxVorOgRollaeden, 3, 5);
    	
    	super.getGridPaneSonderwunsch().add(lblVorDgRollaeden, 0, 6);
    	super.getGridPaneSonderwunsch().add(preisVorDgRollaeden, 1, 6);
    	preisVorDgRollaeden.setText("190");
    	preisVorDgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblVorDgRollaedenWaehrung, 2, 6);
    	super.getGridPaneSonderwunsch().add(chckBxVorDgRollaeden, 3, 6);
    	
    	super.getGridPaneSonderwunsch().add(lblEgRollaeden, 0, 7);
    	super.getGridPaneSonderwunsch().add(preisEgRollaeden, 1, 7);
    	preisEgRollaeden.setText("990");
    	preisEgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblEgRollaedenWaehrung, 2, 7);
    	super.getGridPaneSonderwunsch().add(chckBxEgRollaeden, 3, 7);
    	
    	super.getGridPaneSonderwunsch().add(lblOgRollaeden, 0, 8);
    	super.getGridPaneSonderwunsch().add(preisOgRollaeden, 1, 8);
    	preisOgRollaeden.setText("990");
    	preisOgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblOgRollaedenWaehrung, 2, 8);
    	super.getGridPaneSonderwunsch().add(chckBxOgRollaeden, 3, 8);
    	
    	super.getGridPaneSonderwunsch().add(lblDgRollaeden, 0, 9);
    	super.getGridPaneSonderwunsch().add(preisDgRollaeden, 1, 9);
    	preisDgRollaeden.setText("990");
    	preisDgRollaeden.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblDgRollaedenWaehrung, 2, 9);
    	super.getGridPaneSonderwunsch().add(chckBxDgRollaeden, 3, 9);
	}
	
	/**
	 * macht das FensterAussentuerenView-Objekt sichtbar.
	 */
	public void oeffneFensterAussentuerenView(){ 
		super.oeffneBasisView();
	}
	
	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
	protected void berechneUndZeigePreisSonderwuensche() {
		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann der Preis berechnet.
		
		
		// TODO Zugriff auf Sonderwuensche ueber KundeModel.getInstance().getKunde().getSonderwuensche()
		// TODO Zugriff auf Dachgeschoss Boolean ueber KundeModel.getInstance().getKunde().hatDachgeschoss()	
		
		
		int preisFensterAussentueren = 0;
		
		int[] ausgewaehlteSw = new int[50];
		
		if (chckBxEGTuerTerasse.isSelected()) {
			ausgewaehlteSw[31] = 1;
			preisFensterAussentueren += 590;
		}
		else ausgewaehlteSw[31] = 0;
		
		if (chckBxTuerDachTerasse.isSelected()) {
			ausgewaehlteSw[32] = 1;
			preisFensterAussentueren += 590;
		}
		else ausgewaehlteSw[32] = 0;
		
		if (chckBxEinbruchschutz.isSelected()) {
			ausgewaehlteSw[33] = 1;
			preisFensterAussentueren += 690;
		}
		else ausgewaehlteSw[33] = 0;
		
		if (chckBxVorEgRollaeden.isSelected()) {
			ausgewaehlteSw[34] = 1;
			preisFensterAussentueren += 190;
		}
		else ausgewaehlteSw[34] = 0;
		
		if (chckBxVorOgRollaeden.isSelected()) {
			ausgewaehlteSw[35] = 1;
			preisFensterAussentueren += 190;
		}
		else ausgewaehlteSw[35] = 0;
		
		if (chckBxVorDgRollaeden.isSelected()) {
			ausgewaehlteSw[36] = 1;
			preisFensterAussentueren += 190;
		}
		else ausgewaehlteSw[36] = 0;
		
		if (chckBxEgRollaeden.isSelected()) {
			ausgewaehlteSw[37] = 1;
			preisFensterAussentueren += 990;
		}
		else ausgewaehlteSw[37] = 0;
		
		if (chckBxOgRollaeden.isSelected()) {
			ausgewaehlteSw[38] = 1;
			preisFensterAussentueren += 990;
		}
		else ausgewaehlteSw[38] = 0;
		
		if (chckBxDgRollaeden.isSelected()) {
			ausgewaehlteSw[39] = 1;
			preisFensterAussentueren += 990;
		}
		else ausgewaehlteSw[39] = 0;
		
		
		
		
		if (this.fensterAussentuerenControl.pruefeKonstellationSonderwuensche(ausgewaehlteSw)) { 
			//System.out.println("Es findet noch keine Konstellationsueberpruefung statt");
			System.out.println("alle Angaben sind korrekt");
			System.out.println("Gesamtpreis der Fenster und Aussentueren :\t" + preisFensterAussentueren);
		}
		else System.out.println("Fehler in den Angaben");
	}

	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
	protected void speichereSonderwuensche() {
		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
		
		// Speichern ueber Methode KundeModel.getInstance().getKunde().speichereSonderwuensche()
		
  		// TODO

	}

}
