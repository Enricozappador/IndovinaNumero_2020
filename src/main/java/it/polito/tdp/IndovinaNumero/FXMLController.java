package it.polito.tdp.IndovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	private final int nmax =100; 
	private final int tmax = 10; 
	private int segreto ; 
	private int tentativifatti; 
	private boolean ingame = false; 
	
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
    	this.segreto = (int)(Math.random() * nmax)+1; 
    	
    	
    this.tentativifatti = 0; 
    this.ingame = true; 
    
    tentativolayout.setDisable(false);
    resulttxt.clear();
    rimastitxt.setText(Integer.toString(tmax));
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
    	
    	this.tentativifatti++; 
    	
    	
    	if(tent == this.segreto) {
    		resulttxt.appendText("Complimenti, hai vinto! Hai utilizzato "+this.tentativifatti+" tentativi!");
    		tentativolayout.setDisable(true);
    		this.ingame=false;
    		return; 
    	}
    	if(tentativifatti == tmax){
    		resulttxt.appendText("Hai perso!! Il numero segreto era: "+ this.segreto);
    		tentativolayout.setDisable(true);
    		this.ingame=false;
    		return;
    		}
    	if(tent<this.segreto) {
    		resulttxt.appendText("Tentativo troppo basso!! \n");
    	}
    	else {
    		resulttxt.appendText("Tentativo troppo alto!! \n");
    	}
    	
    	rimastitxt.setText(Integer.toString(tmax - tentativifatti));
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
}
