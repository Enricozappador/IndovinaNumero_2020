package it.polito.tdp.IndovinaNumero;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;

import it.polito.tdp.IndovinaNumero.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	private Model model; 
	

	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button newbtn;

    @FXML
    private TextField rimastitxt;

    @FXML
    private HBox tentativolayout;

    @FXML
    private TextField tentativitxt;

    @FXML
    private Button trybtn;

    @FXML
    private TextArea resulttxt;

    @FXML
    void handlenewgame(ActionEvent event) {
    	this.model.nuovaParitita();
    
    tentativolayout.setDisable(false);
    resulttxt.clear();
    rimastitxt.setText(Integer.toString(this.model.getTmax()));
    }

    @FXML
    void handletry(ActionEvent event) {
    	String tentativo = tentativitxt.getText(); 
    	int tent; 
    	try {
    	tent = Integer.parseInt(tentativo); 
    	} 
    	catch(NumberFormatException e) {
    		resulttxt.appendText("Devi inserire un numero! \n");
    		return; 
    	}
    	int risultato= -1;
    	try {
    	    	 risultato = this.model.tentativo(tent);

    	
    	} 
    	catch (IllegalStateException se) {
    		resulttxt.appendText(se.getMessage());
    		return; 
    	} catch (InvalidParameterException pe){
    		resulttxt.appendText(pe.getMessage());
    		return; 
    		
    		    	}
    	
    	if(risultato == 0) {
    		resulttxt.appendText("Complimenti!! Hai vinto usando "+model.getTentativifatti() + " tentativi!");
    	}
    	else if(risultato == -1){
    		resulttxt.appendText("Tentativo troppo basso! \n");
    
    	}
    	
    	else {
    		resulttxt.appendText("Tentativo troppo basso! \n");
    	}
    	
    	rimastitxt.setText(Integer.toString(this.model.getTmax()-this.model.getTentativifatti()));
    	
    
    	}

    @FXML
    void initialize() {
        assert newbtn != null : "fx:id=\"newbtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert rimastitxt != null : "fx:id=\"rimastitxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tentativolayout != null : "fx:id=\"tentativolayout\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tentativitxt != null : "fx:id=\"tentativitxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert trybtn != null : "fx:id=\"trybtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert resulttxt != null : "fx:id=\"resulttxt\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model =new  Model(); 
    }
}
