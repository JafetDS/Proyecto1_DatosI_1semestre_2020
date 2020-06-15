/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import gato.LogicaGato;
import gato.LogicaGato;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class gatoFXMLController implements Initializable  { 
    private LogicaGato logica;
    private String Winner;


    @FXML
    private AnchorPane anchorPane;
    public GridPane Grid;

    public gatoFXMLController() {
    }
    

    @FXML
    public void Prueba(ActionEvent e) {
        logica= new LogicaGato("Juan", "Luis");
        logica.GenerateButons(Grid);
/*
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(logica.getWinner()==null) {

                    System.out.println("Papas");
                }
            }
        });
        thread2.start();
        this.Winner = logica.getWinner();
        System.out.print(logica.getWinner());
        close();
       
*/
      
    }

    public void verGanador(){
      
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println("Papas");
                }
            }
        });


        
    }
    public String getWinner(){
        return this.Winner;

        
    }
    
    public void close(){
        Stage stage=(Stage)this.anchorPane.getScene().getWindow();
        stage.close();
    }

    
    public FXMLLoader getLoader() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("gatoFXML.fxml")); 
        return  loader;
       
    }
   
    public gatoFXMLController returnThis() throws IOException{
        gatoFXMLController pc = new gatoFXMLController();
                  
        FXMLLoader loader = pc.getLoader();
        Parent root = loader.load();
         
        pc = loader.getController();
        
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
              
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
        
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
        

    }    

    
    
}

