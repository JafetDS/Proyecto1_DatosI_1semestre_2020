/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import Estructuras.MatrizSimple;
import Estructuras.NodoListasimple;
import FXeditor.FXeditor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
//Icons made by <a href="https://www.flaticon.com/authors/xnimrodx" title="xnimrodx">xnimrodx</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a>
/**
 *"C:/UNIVERSIDAD/Datos1_I2020/Proyecto1_DatosI_1semestre_2020/Gato/src/MultimediaGato/equis.png"
 * @author User
 */
public class gatoFXMLController implements Initializable { 
    
    @FXML
    private GridPane Grid;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws FileNotFoundException {
        System.out.println("You clicked me!");
    

        Image image=new Image("file:src/MultimediaGato/equis.png");
       

        ImageView imageview=new ImageView(image);
        FXeditor Editor=new FXeditor();
        Editor.setElement(Grid, 0, 0, imageview);
        
        
        
      
    }
        
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       MatrizSimple<Button> matriz=new MatrizSimple<>(3,3);
    }    
    
}
