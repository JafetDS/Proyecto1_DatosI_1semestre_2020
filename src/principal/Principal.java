/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Estructuras.ListaCircular;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Principal extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*
        
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        */
        PrincipalController juego = new PrincipalController();
        
        juego.showScene(stage);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        System.out.println(args.length);

        launch(args); 
        /*
        
        ListaCircular<Integer> ListaCirDo = new ListaCircular<>();

        
        ListaCirDo.addFirst(1);
        ListaCirDo.addFirst(6);
        ListaCirDo.addFirst(3);
        ListaCirDo.addFirst(8);
        ListaCirDo.addFirst(12);
        ListaCirDo.addFirst(16);
        ListaCirDo.addFirst(4);
        ListaCirDo.addFirst(5);
        ListaCirDo.remove(3);
        
        ListaCirDo.addLast(9);
        ListaCirDo.addPos(5,77);
        ListaCirDo.print();
      */
       
    }
   
    
}
