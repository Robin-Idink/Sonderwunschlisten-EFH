package gui.bilder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import javax.swing.*;

import gui.basis.BasisView;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BilderView extends BasisView{
	
	
 	// das Control-Objekt der Bilder vom Haus
	private BilderControl bilderControl;

	//---Anfang Attribute der grafischen Oberflaeche---
	private GridPane gridPane 			= new GridPane();
	
	// F100 
    private Button btnAuswahly 	= new Button("Haus mit Dachgeschoss");
    private Button btnAuswahln 	= new Button("Haus ohne Dachgeschoss");
    
    //-------Ende Attribute der grafischen Oberflaeche-------

    /**
     * erzeugt ein BilderView-Objekt, belegt das zugehoerige Control
     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
     * @param BilderControl BilderControl, enthaelt das zugehoerige Control
     * @param bilderStage Stage, enthaelt das Stage-Objekt fuer diese View
     */
    public BilderView (BilderControl bilderControl, Stage bilderStage){
    	super(bilderStage);
        this.bilderControl = bilderControl;
        bilderStage.setTitle("Sonderwünsche zu Bilder vom Haus");

	    this.initKomponenten();
	    this.leseBilderSonderwuensche();
	   
	  
	    
    }

    /* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten() {
		super.initKomponenten();
       	super.getLblSonderwunsch().setText("Bilder-Varianten");
       	super.getGridPaneSonderwunsch().add(btnAuswahly, 0, 1);
    	super.getGridPaneSonderwunsch().add(btnAuswahln, 1, 1);
    	
    	btnAuswahly.setOnAction(aEvent-> {
    	//Pfad anpassen: (Sonderwunschlisten-EFH/src/gui/bilder/dg.jpg)
    	ImageIcon icon = new ImageIcon("C:\\Users\\Yessica_Yo\\eclipse-workspace\\Sonderwunschliste\\src\\gui\\bilder\\dg.jpg");
    	System.out.println(icon);
    	JOptionPane.showMessageDialog(null, "Ihre Auswahl", 
    	    		"Haus mit Dachgeschoss", JOptionPane.OK_CANCEL_OPTION, icon);
    		
	    });
    	
    	btnAuswahln.setOnAction(aEvent-> {
    		ImageIcon icon = new ImageIcon("C:\\Users\\Yessica_Yo\\eclipse-workspace\\Sonderwunschliste\\src\\gui\\bilder\\ohneDG.jpg");
        	System.out.println(icon);
        	JOptionPane.showMessageDialog(null, "Auswahl", 
        	    		"Haus ohne Dachgeschoss", JOptionPane.OK_CANCEL_OPTION, icon);
        		
	    });
	}
    

	
	/*protected void initListener(){
       	btnAuswahly.setOnAction(aEvent-> {
       		System.out.println("mit");
	    });
    	btnAuswahln.setOnAction(aEvent-> {
           	System.out.println("ohne");
	    });
	}*/

	


	 /**
	 * macht das Bilder-Objekt sichtbar.
	 */
	public void oeffneBilderView(){
		super.oeffneBasisView();
	}
	
	private void leseBilderSonderwuensche(){
    	
    	this.bilderControl.leseBilderSonderwuensche();
    }

	@Override
	protected void berechneUndZeigePreisSonderwuensche() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void speichereSonderwuensche() {
		// TODO Auto-generated method stub
		
	}


	
}
