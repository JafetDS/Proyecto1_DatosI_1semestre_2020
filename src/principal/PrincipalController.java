/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;



import gato.gatoFXMLController;
import gato.Prueba3Controller;
import com.sun.javafx.tk.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class PrincipalController implements Initializable {

   // private PruebaController pc ;
    private String info;
    @FXML
    private Label label;
    private Button button;
    private AnchorPane anchorPane;

    /**
    public PrincipalController() throws IOException {
        this.parent = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
    }
    *
     * @param event
     * @throws java.io.IOException */
    
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        gatoFXMLController pc = new gatoFXMLController();
        pc = pc.returnThis();
       
    

    }
    
    public void Print(){
        this.info= "wine";
        
    }
    
    public Parent getRoot() throws IOException{
       return  FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
    }

    public void setInfo(String info) {
        this.info = info;
    }



    

    @Override
    public void initialize (URL url, ResourceBundle rb){
    
    }

 
    
}
    
    
    

