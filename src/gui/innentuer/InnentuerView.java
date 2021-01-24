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
	
	// F40 4.1) Mehrpreis fuer die Ausfuehrung eines Glasausschnitts (Klarglas) in einer Innentuer
    private Label lblTuerKlarglas
        = new Label("Mehrpreis fuer die Ausfuehrung eines Glasausschnitts (Klarglas) in einer Innentuer");
    private TextField txtPreisTuerKlarglas 	= new TextField();
    private Label lblTuerKlarglasEuro 	= new Label(",- Euro je Tuer");
    private TextField chckTuerKlarglas 	= new TextField();

	// F40 4.2) Mehrpreis fuer die Ausfuehrung eines Glasausschnitts (Milchglas) in einer Innentuer
    private Label lblTuerMilchglas
        = new Label("Mehrpreis fuer die Ausfuehrung eines Glasausschnitts (Milchglas) in einer Innentuer");
    private TextField txtPreisTuerMilchglas 	= new TextField();
    private Label lblTuerMilchglasEuro	= new Label(",- Euro je Tuer");
    private TextField chckTuerMilchglas	= new TextField();

	// F40 4.1) Innentuer zur Garage als Holztuer
    private Label lblHolztuerGarage
        = new Label("Innentuer zur Garage als Holztuer");
    private TextField txtPreisHolztuerGarage 	= new TextField();
    private Label lblHolztuerGarageEuro		= new Label(",- Euro je Tuer");
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
        innentuerStage.setTitle("Sonderwuensche zu Innentuer-Varianten");

	    this.initKomponenten();
    }

    /* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten() {
		super.initKomponenten();
       	super.getLblSonderwunsch().setText("Innentuer-Varianten");
       	// F40 4.1)
       	super.getGridPaneSonderwunsch().add(lblTuerKlarglas, 0, 1);
    	super.getGridPaneSonderwunsch().add(txtPreisTuerKlarglas, 1, 1);
    	txtPreisTuerKlarglas.setText("460");
    	txtPreisTuerKlarglas.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerKlarglasEuro, 2, 1);
    	chckTuerKlarglas.setText("0");
    	super.getGridPaneSonderwunsch().add(chckTuerKlarglas, 3, 1);
       	// F40 4.2)
       	super.getGridPaneSonderwunsch().add(lblTuerMilchglas, 0, 2);
    	super.getGridPaneSonderwunsch().add(txtPreisTuerMilchglas, 1, 2);
    	txtPreisTuerMilchglas.setText("560");
    	txtPreisTuerMilchglas.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblTuerMilchglasEuro, 2, 2);
    	chckTuerMilchglas.setText("0");
    	super.getGridPaneSonderwunsch().add(chckTuerMilchglas, 3, 2);
    	// F40 4.3)
       	super.getGridPaneSonderwunsch().add(lblHolztuerGarage, 0, 3);
    	super.getGridPaneSonderwunsch().add(txtPreisHolztuerGarage, 1, 3);
    	txtPreisHolztuerGarage.setText("660");
    	txtPreisHolztuerGarage.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblHolztuerGarageEuro, 2, 3);
    	chckHolztuerGarage.setText("0");
    	super.getGridPaneSonderwunsch().add(chckHolztuerGarage, 3, 3);
	}

	 /**
	 * macht das Innentuer-Objekt sichtbar.
	 */
	public void oeffneInnentuerView(){
		super.oeffneBasisView();
	}

	@Override
	protected void berechneUndZeigePreisSonderwuensche() {

		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[])
  		// aus dem Control aufgerufen, dann der Preis berechnet.
		
		// TODO Zugriff auf Sonderwuensche über KundeModel.getInstance().getKunde().getSonderwuensche()
		// TODO Zugriff auf Dachgeschoss Boolean über KundeModel.getInstance().getKunde().hatDachgeschoss()	
		
		
		int anzahlTuerKlarglas = Integer.parseInt(chckTuerKlarglas.getText());
		int anzahlTuerMilchglas = Integer.parseInt(chckTuerMilchglas.getText());
		int anzahlHolztuerGarage = Integer.parseInt(chckHolztuerGarage.getText());
		int[] ausgewaehlteSw = new int[50];
		ausgewaehlteSw[41] = anzahlTuerKlarglas;
		ausgewaehlteSw[42] = anzahlTuerMilchglas;
		ausgewaehlteSw[43] = anzahlHolztuerGarage;
		
		int preisInnentueren = 0;
		preisInnentueren = anzahlTuerKlarglas * 460 + anzahlTuerMilchglas * 560 + anzahlHolztuerGarage * 660;
		
		if (this.innentuerControl.pruefeKonstellationSonderwuensche(ausgewaehlteSw)) { 
			System.out.println("alle Angaben bzgl. der Anzahl der Innentueren sind korrekt");
			System.out.println("Gesamtpreis der Innentueren :\t" + preisInnentueren);
		}
		else System.out.println("Fehler in den Anzahl Angaben der Innentueren");
		
		
	}


	@Override
	protected void speichereSonderwuensche() {
 		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
		
		// Speichern über Methode KundeModel.getInstance().getKunde().speichereSonderwuensche()
		
  		// TODO
	}
	
}
