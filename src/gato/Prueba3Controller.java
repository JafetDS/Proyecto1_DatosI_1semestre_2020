/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Prueba3Controller implements Initializable {
    private String Maria;
    @FXML 
    private AnchorPane anchorPane;
    private Button prueba;
    private Button setM;



    public Prueba3Controller() {
      
    }
    
    

    
    public String getMaria() {
        return Maria;
    }
    @FXML
    public void setMaria(ActionEvent event) {
        this.Maria = "Maria";
    }
    
    @FXML
    public void close(ActionEvent event){
        Stage stage=(Stage)this.anchorPane.getScene().getWindow();
        stage.close();
    }

    public FXMLLoader getLoader() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Prueba3.fxml"));

        
        
       return  loader;
       
    }
   
    public Prueba3Controller returnThis() throws IOException{
        Prueba3Controller pc = new Prueba3Controller();
        
            
        FXMLLoader loader = pc.getLoader();
        Parent root = loader.load();
  
        
        pc = loader.getController();
        
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        
        
        stage.initModality(Modality.APPLICATION_MODAL);
        
      //  stage.initOwner(((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        
    
    //    Event.fireEvent(this, new DialogEvent(this, DialogEvent.DIALOG_SHOWN));
        
        stage.showAndWait();
        
        return pc;
        
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
