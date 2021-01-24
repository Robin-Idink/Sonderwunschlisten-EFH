package gui.kunde;

import business.kunde.*;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.metal.MetalIconFactory;

/**
 * Klasse, welche das Grundfenster mit den Kundendaten bereitstellt.
 */
public class KundeView{
	
 
	// das Control-Objekt des Grundfensters mit den Kundendaten
	private KundeControl kundeControl;
	// das Model-Objekt des Grundfensters mit den Kundendaten
	private KundeModel kundeModel;

    //---Anfang Attribute der grafischen Oberflaeche---
	private BorderPane borderPane 		= new BorderPane();
	private GridPane gridPane 			= new GridPane();
	private Label lblKunde    	      	= new Label("Kunde");
    private Label lblNummerHaus     	= new Label("Plannummer des Hauses");
   
    private ComboBox<Integer> 
        cmbBxNummerHaus                 = new ComboBox<Integer>();
    private Label lblKundenNr			= new Label("Kundennummer");
    private Label lblVorname         	= new Label("Vorname");
    private Label lblNachname			= new Label("Nachname");
    private Label lblTelefon			= new Label("Telefonnummer");
    private Label lblEmail				= new Label("Emailadresse");
    private TextField txtVorname     	= new TextField();   
    private TextField txtNachname     	= new TextField();   
    private TextField txtTelefon    	= new TextField();   
    private TextField txtEmail	    	= new TextField();  
    private TextField txtKundenNr		= new TextField();
    private Button btnAnlegen	 	  	= new Button("Anlegen");
    private Button btnAendern 	      	= new Button("Aendern");
    private Button btnLoeschen 	 		= new Button("Loeschen");
    private Button btnSuche 	 		= new Button("Suche");
    private Button btnBilder 	 		= new Button("Bilder vom Haus");
    private MenuBar mnBar 			  	= new MenuBar();
    private Menu mnSonderwuensche    	= new Menu("Sonderwuensche");
    private MenuItem mnItmGrundriss  	= new MenuItem("Grundrissvarianten");
    private MenuItem mnItmInnentuer  	= new MenuItem("Innentuervarianten");
    private MenuItem mnItmFensterAussentueren = new MenuItem("Fenster und Aussentueren");
    //private MenuItem mnItmBilder = new MenuItem("Bilder vom Haus");
    //-------Ende Attribute der grafischen Oberflaeche-------
  
    /**
     * erzeugt ein KundeView-Objekt und initialisiert die Steuerelemente der Maske
     * @param kundeControl KundeControl, enthaelt das zugehoerige Control
     * @param primaryStage Stage, enthaelt das Stage-Objekt fuer diese View
     * @param kundeModel KundeModel, enthaelt das zugehoerige Model
    */
    public KundeView (KundeControl kundeControl, Stage primaryStage, 
    	KundeModel kundeModel){
        this.kundeControl = kundeControl;
        this.kundeModel = kundeModel;
        
        primaryStage.setTitle(this.kundeModel.getUeberschrift());	
	    Scene scene = new Scene(borderPane, 900, 600);
	    primaryStage.setScene(scene);
        primaryStage.show();

	    this.initKomponenten();
	    this.initListener();
    }

 
    /* initialisiert die Steuerelemente auf der Maske */
    private void initKomponenten(){
    	borderPane.setCenter(gridPane);
	    gridPane.setHgap(13);
	    gridPane.setVgap(13);
	    gridPane.setPadding(new Insets(25, 25, 25, 25));
	    gridPane.setGridLinesVisible(false);
       	
	    gridPane.add(lblKunde, 0, 1);
       	lblKunde.setMinSize(150, 40);
	    lblKunde.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	    gridPane.add(lblNummerHaus, 0, 2);
	    gridPane.add(cmbBxNummerHaus, 1, 2);
	    cmbBxNummerHaus.setMinSize(150,  25);
	    cmbBxNummerHaus.setItems(this.kundeModel.getPlannummern());
	   
	    gridPane.add(lblKundenNr, 0, 3);
	    gridPane.add(txtKundenNr, 1, 3);
	    gridPane.add(lblVorname, 0, 5);
	    gridPane.add(txtVorname, 1, 5);
	    gridPane.add(lblNachname, 0, 7);
	    gridPane.add(txtNachname, 1, 7);
	    gridPane.add(lblTelefon, 0, 9);
	    gridPane.add(txtTelefon, 1, 9);
	    gridPane.add(lblEmail, 0, 11);
	    gridPane.add(txtEmail, 1, 11);
	    
	    
	    //Textfields
	    
	    txtKundenNr.promptTextProperty().set("Kundennummer");
	    txtVorname.promptTextProperty().set("Vorname");
	    txtNachname.promptTextProperty().set("Nachname");
	    txtTelefon.promptTextProperty().set("Telefonnummer");
	    txtEmail.promptTextProperty().set("Email");
	    
	    
	    
	    // Buttons
	    gridPane.add(btnAnlegen, 0, 13);
	    btnAnlegen.setMinSize(150,  25);
	    gridPane.add(btnAendern, 1, 13);
	    btnAendern.setMinSize(150,  25);
	    gridPane.add(btnLoeschen, 2, 13);
	    btnLoeschen.setMinSize(150,  25);
	    gridPane.add(btnSuche, 3, 13);
	    btnSuche.setMinSize(150,  25);
	    gridPane.add(btnBilder, 4, 13);
	    btnBilder.setMinSize(150,  25);
	    // MenuBar und Menu
	    borderPane.setTop(mnBar);
	    mnBar.getMenus().add(mnSonderwuensche);
	    mnSonderwuensche.getItems().add(mnItmGrundriss);
	    mnSonderwuensche.getItems().add(mnItmInnentuer);
	    mnSonderwuensche.getItems().add(mnItmFensterAussentueren);
	    //mnSonderwuensche.getItems().add(mnItmBilder);
    }

    /* initialisiert die Listener zu den Steuerelementen auf der Maske */
    private void initListener(){
    	cmbBxNummerHaus.setOnAction(aEvent-> {
    			
    		 try {
				Kunde kunde = Kunde.kundeHolen(cmbBxNummerHaus.getValue());
				
				txtEmail.setText(kunde.getEmail());
				txtKundenNr.setText(kunde.getKundennummer());
				txtVorname.setText(kunde.getVorname());
				txtNachname.setText(kunde.getNachname());
				txtTelefon.setText(kunde.getTelefonnummer());
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 
     	});
       	btnAnlegen.setOnAction(aEvent-> {
       		
 	        legeKundenAn();
	    });
    	btnAendern.setOnAction(aEvent-> {
           	aendereKunden();
	    });
       	btnLoeschen.setOnAction(aEvent-> { 
           	loescheKunden();
	    });
       	btnSuche.setOnAction(aEvent-> { 
       		Kunde kunde = new Kunde();
            System.out.println("Voruebergehende Ausgabe der Kundendaten: (im KundeModel)");
       	    System.out.println("Vorname:" + kunde.getVorname());
    	   	System.out.println("Nachname:" + kunde.getNachname());
    	   	System.out.println("Email:" + kunde.getEmail());
    	   	System.out.println("Telefon:" + kunde.getTelefonnummer());
    	   
          
	    });
       
	    //1,6,7,14,15 und 24 haben kein Dachgeschoss
	    btnBilder.setOnAction(aEvent-> {
	    	//Zugriff auf Dachgeschoss Boolean ueber KundeModel.getInstance().getKunde().hatDachgeschoss()
	    	//Zugriff auf Sonderwuensche ueber KundeModel.getInstance().getKunde().getSonderwuensche()
	       	//Kunde dachgeschoss = new Kunde();
	    	try {
	    		KundeModel.getInstance().getKunde().getSonderwuensche();
				if((KundeModel.getInstance().getKunde().hatDachgeschoss())==true) {
					System.out.println("Hat DG");
					
					Icon icon = MetalIconFactory.getFileChooserHomeFolderIcon();
			        JFrame meinFrame = new JFrame("Haus hat ein Dachgeschoss");       
			        meinFrame.setSize(500,400);
			        meinFrame.add(new JLabel("Bild vom Haus mit Dachgeschoss",icon, JLabel.CENTER));
			        meinFrame.setVisible(true);
					
				} else {
					System.out.println("Hat kein DG");
					
					Icon icon = MetalIconFactory.getFileChooserHomeFolderIcon();
			        JFrame meinFrame = new JFrame("Haus hat kein Dachgeschoss");       
			        meinFrame.setSize(500,400);
			        meinFrame.add(new JLabel("Bild vom Haus ohne Dachgeschoss",icon, JLabel.CENTER));
			        meinFrame.setVisible(true);
					
				}
			} catch (Exception e) {
				System.out.println("Dachschaden");
				e.printStackTrace();
			}
	    	       	
	    });
		
  
      	mnItmGrundriss.setOnAction(aEvent-> {
 	        kundeControl.oeffneGrundrissControl(); 
	    });
      	
      	mnItmInnentuer.setOnAction(aEvent-> {
 	        kundeControl.oeffneInnentuerControl(); 
	    });
      	
      	mnItmFensterAussentueren.setOnAction(aEvent-> {
 	        kundeControl.oeffneFensterAussentuerenControl();
      	});
      	/*mnItmBilder.setOnAction(aEvent-> {
 	        kundeControl.oeffneBilderControl();
      	});*/
    
    }
    
    private void holeInfoDachgeschoss(){ 
    	// TODO 
    }
    
    private void leseKunden(){
    	// TODO
    }
    
    private void legeKundenAn(){
         Kunde kunde = new Kunde(); //Kunde nicht mehr null
         
         // Objekt kunde fuellen:
         
         kunde.setEmail(txtEmail.getText());
         kunde.setKundennummer(txtKundenNr.getText());
         kunde.setVorname(txtVorname.getText());
         kunde.setNachname(txtNachname.getText());
         kunde.setHausnummer(cmbBxNummerHaus.getValue()); //Änderungen von Ali wenn ich was falsch gemacht habe  sorry ^^  aber so gehts erstmal mit dem anlegen eines Kunden in der DB
         kunde.setTelefonnummer(txtTelefon.getText()); 
         //TODO Kundennummer hinzufuegen
         
         if(txtKundenNr.getText().isEmpty() || txtVorname.getText().isEmpty() || txtNachname.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtEmail.getText().isEmpty()) {
	        	Alert alert = new Alert(AlertType.ERROR);
	        	alert.setTitle("Error");
	        	alert.setHeaderText("Fehlende Informationen");
	        	alert.setContentText("Bitte fuellen Sie alle Felder aus");
	        	alert.showAndWait();
         }
         else {
        	 kundeControl.speichereKunden(kunde);
    	}
   	}
    
  	private void aendereKunden(){
      // TODO
   	    
   	}
    
   	
  		    
  	
  	    
  	   
  	   	private void loescheKunden(){
  	   	}
  	   	
  	   /** zeigt ein Fehlermeldungsfenster an
  	    * @param ueberschrift, Ueberschrift fuer das Fehlermeldungsfenster
  	    * @param meldung, String, welcher die Fehlermeldung enthaelt
  	    */
  	    public void zeigeFehlermeldung(String ueberschrift, String meldung){
  	        Alert alert = new Alert(AlertType.ERROR);
  	        alert.setTitle("Fehlermeldung");
  	        alert.setHeaderText(ueberschrift);
  	        alert.setContentText(meldung);
  	        alert.show();
  	    }
  	
}
