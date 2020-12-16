package gui.innentuer;

import gui.basis.BasisView;
import gui.innentuer.InnentuerControl;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InnentuerView extends BasisView{

	
 	// das Control-Objekt des Innentuer-Fensters
	private InnentuerControl innentuerControl;

	//---Anfang Attribute der grafischen Oberflaeche---
	
	// F40 4.1) Mehrpreis für die Ausführung eines Glasausschnitts (Klarglas) in einer Innentür
    private Label lblTuerKlarglas
        = new Label("Mehrpreis für die Ausführung eines Glasausschnitts (Klarglas) in einer Innentür");
    private TextField txtPreisTuerKlarglas 	= new TextField();
    private Label lblTuerKlarglasEuro 	= new Label(",- Euro je Tür");
    private TextField chckTuerKlarglas 	= new TextField();

	// F40 4.2) Mehrpreis für die Ausführung eines Glasausschnitts (Milchglas) in einer Innentür
    private Label lblTuerMilchglas
        = new Label("Mehrpreis für die Ausführung eines Glasausschnitts (Milchglas) in einer Innentür");
    private TextField txtPreisTuerMilchglas 	= new TextField();
    private Label lblTuerMilchglasEuro	= new Label(",- Euro je Tür");
    private TextField chckTuerMilchglas	= new TextField();

	// F40 4.1) Innentür zur Garage als Holztür
    private Label lblHolztuerGarage
        = new Label("Innentür zur Garage als Holztür");
    private TextField txtPreisHolztuerGarage 	= new TextField();
    private Label lblHolztuerGarageEuro		= new Label(",- Euro je Tür");
    private TextField chckHolztuerGarage 	= new TextField();

    //-------Ende Attribute der grafischen Oberflaeche-------

    /**
     * erzeugt ein InnentuerView-Objekt, belegt das zugehoerige Control
     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
     * @param innentuerControl InnentuerControl, enthaelt das zugehoerige Control
     * @param innentuerStage Stage, enthaelt das Stage-Objekt fuer diese View
     */
    public InnentuerView (InnentuerControl innentuerControl, Stage innentuerStage){
    	super(innentuerStage);
        this.innentuerControl = innentuerControl;
        innentuerStage.setTitle("Sonderwünsche zu Innentuer-Varianten");

	    this.initKomponenten();
	    this.leseInnentuerSonderwuensche();
    }

    /* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten() {
		super.initKomponenten();
       	super.getLblSonderwunsch().setText("Innentür-Varianten");
       	// F40 4.1)
       	super.getGridPaneSonderwunsch().add(lblTuerKlarglas, 0, 1);
    	super.getGridPaneSonderwunsch().add(txtPreisTuerKlarglas, 1, 1);
    	txtPreisTuerKlarglas.setText("460");
    	txtPreisTuerKlarglas.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerKlarglasEuro, 2, 1);
    	super.getGridPaneSonderwunsch().add(chckTuerKlarglas, 3, 1);
       	// F40 4.2)
       	super.getGridPaneSonderwunsch().add(lblTuerMilchglas, 0, 2);
    	super.getGridPaneSonderwunsch().add(txtPreisTuerMilchglas, 1, 2);
    	txtPreisTuerMilchglas.setText("560");
    	txtPreisTuerMilchglas.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerMilchglasEuro, 2, 2);
    	super.getGridPaneSonderwunsch().add(chckTuerMilchglas, 3, 2);
    	// F40 4.3)
       	super.getGridPaneSonderwunsch().add(lblHolztuerGarage, 0, 3);
    	super.getGridPaneSonderwunsch().add(txtPreisHolztuerGarage, 1, 3);
    	txtPreisHolztuerGarage.setText("660");
    	txtPreisHolztuerGarage.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblHolztuerGarageEuro, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckHolztuerGarage, 3, 3);
	}

	 /**
	 * macht das Innentür-Objekt sichtbar.
	 */
	public void oeffneInnentuerView(){
		super.oeffneBasisView();
	}

    private void leseInnentuerSonderwuensche(){
    	
    	this.innentuerControl.leseInnentuerSonderwuensche();
    }

	@Override
	protected void berechneUndZeigePreisSonderwuensche() {

		// Es wird erst die Methode pruefeKonstellationSonderwuensche(a, b, c)
  		// aus dem Control aufgerufen, dann der Preis berechnet.
		
		int anzahlTuerKlarglas = Integer.parseInt(chckTuerKlarglas.getText());
		int anzahlTuerMilchglas = Integer.parseInt(chckTuerMilchglas.getText());
		int anzahlHolztuerGarage = Integer.parseInt(chckHolztuerGarage.getText());
		
		int preisInnentueren = 0;
		
		if (this.innentuerControl.pruefeKonstellationSonderwuensche(anzahlTuerKlarglas, anzahlTuerMilchglas, anzahlHolztuerGarage)) { 
			System.out.println("Es findet noch keine Konstellationsüberprüfung statt");
			System.out.println("alle Angaben bzgl. der Anzahl der Innentüren sind korrekt");
			preisInnentueren = anzahlTuerKlarglas * 460 + anzahlTuerMilchglas * 560 + anzahlHolztuerGarage * 660;
			System.out.println("Gesamtpreis der Innentüren :\t" + preisInnentueren);
		}
		else System.out.println("Fehler in den Anzahl Angaben der Innentüren");
		
		
	}


	@Override
	protected void speichereSonderwuensche() {
		// TODO Auto-generated method stub
	}
	
}
