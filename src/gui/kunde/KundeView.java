package gui.kunde;

import business.kunde.*;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

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
    private Button btnAendern 	      	= new Button("�ndern");
    private Button btnLoeschen 	 		= new Button("L�schen");
    private MenuBar mnBar 			  	= new MenuBar();
    private Menu mnSonderwuensche    	= new Menu("Sonderw�nsche");
    private MenuItem mnItmGrundriss  	= new MenuItem("Grundrissvarianten");
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
	    Scene scene = new Scene(borderPane, 550, 500);
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
	    // MenuBar und Menu
	    borderPane.setTop(mnBar);
	    mnBar.getMenus().add(mnSonderwuensche);
	    mnSonderwuensche.getItems().add(mnItmGrundriss);
    }

    /* initialisiert die Listener zu den Steuerelementen auf de Maske */
    private void initListener(){
    	cmbBxNummerHaus.setOnAction(aEvent-> {
    		 holeInfoDachgeschoss();  
    		 leseKunden();
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
      	mnItmGrundriss.setOnAction(aEvent-> {
 	        kundeControl.oeffneGrundrissControl(); 
	    });
    }
    
    private void holeInfoDachgeschoss(){ 
    }
    
    private void leseKunden(){
    }
    
    private void legeKundenAn(){
         Kunde kunde = new Kunde(); //Kunde nicht mehr null
         
         // Objekt kunde fuellen:
         
         kunde.setEmail(txtEmail.getText());
         kunde.setVorname(txtVorname.getText());
         kunde.setNachname(txtNachname.getText());
         //kunde.setHausnummer(txtHausnummer.getText());
         kunde.setTelefonnummer(txtTelefon.getText());
         
         if(txtKundenNr.getText().isEmpty() || txtVorname.getText().isEmpty() || txtNachname.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtEmail.getText().isEmpty()) {
	        	Alert alert = new Alert(AlertType.ERROR);
	        	alert.setTitle("Error");
	        	alert.setHeaderText("Fehlende Informationen");
	        	alert.setContentText("Bitte f�llen Sie alle Felder aus");
	        	alert.showAndWait();
         }
         else {
        	 kundeControl.speichereKunden(kunde);
    	}
   	}
    
  	private void aendereKunden(){
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


