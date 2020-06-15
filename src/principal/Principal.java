/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;


import Estructuras.ListaCircular;
import Estructuras.ListaDoble;
import Estructuras.ListaSimple;
import Estructuras.Nodo;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
       

        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));

        Scene scene = new Scene(root);
        


        stage.setScene(scene);
        stage.show();
       

}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
     

 

      
     

        launch(args); 

    /*
        ListaDoble<Jugador> Jugadores = new ListaDoble<>();

        
        
        Jugador jug1 = new Jugador("Juan");
        System.out.println(jug1);
        System.out.println();
        Jugador jug2 = new Jugador("Pepe");
        Jugador jug3 = new Jugador("Luis");
        Jugador jug4 = new Jugador("Luis");
        
        Jugadores.addLast(jug1);
        Jugadores.addLast(jug2);
        Jugadores.addLast(jug3);
        Jugadores.addLast(jug4);
        
        System.out.println(Jugadores.getTail().getData());
        System.out.println();
        
        
        Nodo<Jugador> aux = Jugadores.getTail();
        
        
        while(aux!=null){
            System.out.println(aux.getData());
            aux= aux.getPrevius();
        }
            System.out.println("Termino");
        
     ///   Jugadores.print();
   
     */  
    }
  
    
}
