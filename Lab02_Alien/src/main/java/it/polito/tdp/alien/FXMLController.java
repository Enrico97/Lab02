package it.polito.tdp.alien;

import it.polito.tdp.alien.model.*;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private alienDictionary dizionario = new alienDictionary();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserisci;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtTraduzione;

    @FXML
    private Button btnClear;

    @FXML
    void doReset(ActionEvent event) {
    	txtInserisci.clear();
    	txtTraduzione.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    		String alien="";
    		String traduzione="";
    		String parola [] = txtInserisci.getText().toLowerCase().split(" ");
    		for (String s : parola) {
    			if (s.compareTo("")!=0 && alien.compareTo("")==0) 
    				alien = s;
    			else if (s.compareTo("")!=0 && alien.compareTo("")!=0) 
    				traduzione = s;
    				}
    		if (traduzione.compareTo("")!=0) {
    			try {
    				dizionario.addWord(alien, traduzione);
    				txtTraduzione.setText("Parole aggiunte al dizionario");
    		}
    			catch (InvalidParameterException e) {
    				txtTraduzione.setText("Le parole devono contenere solo lettere");
    				txtInserisci.clear();
    				return;
    			}
    		}
    		if (traduzione.compareTo("")==0) {
    			traduzione=dizionario.translateWord(alien);
    			if(traduzione==null)
    				traduzione="La parola non è presente nel dizionario";
    			txtTraduzione.setText(traduzione);
    		}
    		txtInserisci.clear();
    }

    @FXML
    void initialize() {
        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
