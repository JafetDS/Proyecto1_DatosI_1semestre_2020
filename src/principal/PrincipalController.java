/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;



import Estructuras.ListaCircular;
import Estructuras.ListaCircularDoble;
import Estructuras.ListaDoble;
import Estructuras.ListaSimple;
import Estructuras.NodoListasimple;
import Estructuras.Pila_stack;
import Eventos.Evento;
import Eventos.eventCambio;
import Eventos.eventDuelo;
import Eventos.eventGanar2E;
import Eventos.eventGanar5E;
import Eventos.eventPerderEstrella;
import Eventos.eventRegalarMonedas;
import Eventos.eventRobarEstrella;
import Eventos.eventRobarMonedas;
import Eventos.eventTeletransporte;
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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class PrincipalController implements Initializable {
    
    private Pila_stack<Evento> pilaEventos;
   // private PruebaController pc ;
    private ListaSimple<String> Colors;
    private ListaCircular<Casilla> caminoPrincipal;
    private ListaCircular<Jugador> Jugadores;
  
    private ListaSimple<Casilla>FaseA; 
    private ListaSimple<Casilla>FaseB;  
    private ListaDoble<Casilla> FaseC;
    private ListaCircularDoble<Casilla> FaseD;

    private NodoListasimple<Jugador> Turno;
    
    private String info;
    private Image image = new Image("file:src/MultimediaGato/check.png",50,50,false,true);
    private Image image1 = new Image("file:src/MultimediaGato/check.png",50,50,false,true);
    private Image image2 = new Image("file:src/MultimediaGato/equis.png",50,50,false,true);
    private Image image3 = new Image("file:src/MultimediaGato/equis.png",50,50,false,true);
    private Image image4 = new Image("file:src/MultimediaGato/equis.png",50,50,false,true);
    @FXML
    private Label label;
    private Button button;
    private AnchorPane anchorPane;
    private Button dados;
   
    public GridPane Tablero;
    
    
    
    public PrincipalController(){
        this.caminoPrincipal = new ListaCircular<>();
        
        this.Jugadores = new ListaCircular<>();
        this.FaseA = new ListaSimple<>();
        this.FaseB = new ListaSimple<>();
        this.FaseC = new ListaDoble<>();
        this.FaseD = new ListaCircularDoble<>();
        this.Colors = new ListaSimple<>();
        this.pilaEventos = new Pila_stack<>();
    }
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

        //gatoFXMLController pc = new gatoFXMLController();
        //pc = pc.returnThis();
        
        

        
        
        Button but = new Button();
        Button but2 = new Button();
        Button but3 = new Button();
        Button but4 = new Button();
        Button but5 = new Button();
        but5.setStyle("-fx-background-color: blue");
        HBox hbox = new HBox();
        hbox.getChildren().add(but);
        hbox.getChildren().add(but2);
        hbox.getChildren().add(but3);
        hbox.getChildren().add(but4);
        Casilla casilla = new Casilla (image);
        
        casilla.getPane().getChildren().add(hbox);
        casilla.getPane().getChildren().add(but5);
        this.Tablero.add(casilla.getPane(), 14, 14);
        
        
        
        Jugador jug1 = new Jugador("Juan");
        Jugador jug2 = new Jugador("Pepe");
        Jugador jug3 = new Jugador("Luis");
        Jugador jug4 = new Jugador("Solis");
        
        this.Jugadores.addLast(jug1);
        this.Jugadores.addLast(jug2);
        this.Jugadores.addLast(jug3);
        this.Jugadores.addLast(jug4);
        
        
        
        
        this.caminoPrincipal.addLast(casilla);
        
        jug1.setCasilla(this.caminoPrincipal.getHead());
        jug2.setCasilla(this.caminoPrincipal.getHead());
        jug3.setCasilla(this.caminoPrincipal.getHead());
        jug4.setCasilla(this.caminoPrincipal.getHead());
        
        
        
        this.Turno = this.Jugadores.getHead();
        
        
        
        
        
        
        
        generateTablero();
        
        graficarCaminoA();
        graficarCaminoB();
        graficarCaminoC();
        graficarCaminoD();
        setTransitionNode();
        generateColors();
        
        generatePila();
        
    //    Tablero.add(casilla, 0, 0);
        /*
        
        pane.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
        HBox hbox = new HBox();
        hbox.getChildren().add(but);
        hbox.getChildren().remove(but);
        pane.getChildren().add(hbox);
**/
    }
    private int random(int n){
        return (int)(Math.random() * ((n - 1) + 1)) + 1;
    }
    
    @FXML
    private void getDados(ActionEvent e) throws InterruptedException{
            
	int num1 = (int)(Math.random() * ((6 - 1) + 1)) + 1;
        int num2 = (int)(Math.random() * ((6 - 1) + 1)) + 1;
        
        System.out.println(num1);
        System.out.println(num2);
        
        this.Turno.getData().avanzar(num2+num1);
        //this.Turno.getData().avanzar(4);
        this.Turno = this.Turno.getNext();
    }
        
    
    public void evento(){
        
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

    
///_________________________________________________________Grapic____________________________________________________________________________________________________
   private void generatePila(){
       for(int i = 0 ; i<10 ;i++){
           this.pilaEventos.push(new eventDuelo());
           this.pilaEventos.push( new eventRobarMonedas());
           this.pilaEventos.push( new eventTeletransporte());
       }
       
       for (int i =0 ; i<3 ;i++){
           this.pilaEventos.push(new eventGanar2E());
           this.pilaEventos.push(new eventRobarEstrella());
       }
       
       for (int i =0 ;i<5 ;i++){
           this.pilaEventos.push(new eventRegalarMonedas());
           this.pilaEventos.push( new eventPerderEstrella());
           this.pilaEventos.push( new eventCambio());
       }
       this.pilaEventos.push(new eventGanar5E());
       
   }
    
    
    
    
    private void generateColors(){
        for(int i=0 ; i<3 ; i++){
            for(int j = 0 ; j<3 ; j++){
                this.Colors.addFirst("Green");
                this.Colors.addFirst("Red");
                this.Colors.addFirst("Blue");
            }
            this.Colors.addFirst("Yellow");   
        }
    } 
    private void graficarCaminoA(){
        for(int i = 13; i>5; i--){
            Casilla casilla = new Casilla (image1,this.Colors.getInfo(random(30)));
            Tablero.add(casilla.getPane(), 2, i);
            this.FaseA.addLast(casilla);
        }
        
        Casilla casilla = new Casilla (image1,this.Colors.getInfo(random(30)));
        Tablero.add(casilla.getPane(), 1, 6);
        this.FaseA.addLast(casilla);
        
        
    }
    
    private void  graficarCaminoB(){
        for(int i = 1; i<5;i++){
            Casilla casilla = new Casilla (image2,"Yellow");
            Tablero.add(casilla.getPane(), 2, i);
            this.FaseB.addLast(casilla);
        }
        
        for(int i = 3; i<6;i++){
            Casilla casilla = new Casilla (image2,"Yellow");
            Tablero.add(casilla.getPane(), i, 4);
            this.FaseB.addLast(casilla);
        }
        
        for(int i = 4; i>0;i--){
            Casilla casilla = new Casilla (image2,"Yellow");
            Tablero.add(casilla.getPane(), 6, i);
            this.FaseB.addLast(casilla);
        }
    }
    
    private void graficarCaminoC(){
        
        for(int i = 13 ; i!=9 ; i--){
            Casilla casilla = new Casilla (image3,this.Colors.getInfo(random(30)));
            Tablero.add(casilla.getPane(), 9, i);
            this.FaseC.addLast(casilla);
        }
        
        for(int i = 10 ; i<14 ; i++){
            Casilla casilla = new Casilla (image3,this.Colors.getInfo(random(30)));
            Tablero.add(casilla.getPane(), i, 10);
            this.FaseC.addLast(casilla);
        }
        
    }
    
    
    private void graficarCaminoD(){
        for(int i = 3; i<8; i++){
            Casilla casilla = new Casilla (image4,this.Colors.getInfo(random(30)));
            Tablero.add(casilla.getPane(), 8, i);
            this.FaseD.addLast(casilla);
        }
        
        for (int i= 9; i<12;i++){
            Casilla casilla = new Casilla (image4,"Yellow");
            Tablero.add(casilla.getPane(), i, 7);
            this.FaseD.addLast(casilla);
        }
        
                
        for (int i= 7; i>2;i--){
            Casilla casilla = new Casilla (image4,"Yellow");
            Tablero.add(casilla.getPane(), 12, i);
            this.FaseD.addLast(casilla);
        }
        
        for (int i= 11; i>8;i--){
            Casilla casilla = new Casilla (image4,"Yellow");
            Tablero.add(casilla.getPane(), i, 3);
            this.FaseD.addLast(casilla);
        }
            
    }
    private void generateTablero(){
        for (int i = 13 ; i!=-1; i--) {
            Casilla casilla = new Casilla (image,this.Colors.getInfo(random(30)));
            Tablero.add(casilla.getPane(), i, 14);
            this.caminoPrincipal.addLast(casilla);
        }
        
        for (int i = 13; i!=-1; i-- ){
            Casilla casilla = new Casilla (image,this.Colors.getInfo(random(30)));
            Tablero.add(casilla.getPane(), 0, i);
             this.caminoPrincipal.addLast(casilla);
        }
        
        for (int i= 1; i<15 ; i++){
            Casilla casilla = new Casilla (image,this.Colors.getInfo(random(30)));
            Tablero.add(casilla.getPane(), i, 0);
            this.caminoPrincipal.addLast(casilla);
        }
        
        for (int i= 1; i<14 ; i++){
            Casilla casilla = new Casilla (image,this.Colors.getInfo(random(30)));
            Tablero.add(casilla.getPane(), 14, i);
            this.caminoPrincipal.addLast(casilla);
        }
        
    }
    
    
    private void setTransitionNode(){
        this.caminoPrincipal.getNodo(5).getData().setDesvio(true);
        this.caminoPrincipal.getNodo(5).getData().setFase(this.FaseC.getHead());
        
        this.caminoPrincipal.getNodo(52).getData().setDesvio(true);
        this.caminoPrincipal.getNodo(52).getData().setFase(this.FaseC.getTail());
        
        this.FaseC.getTail().setNext(this.caminoPrincipal.getNodo(52));
        this.FaseC.getHead().setPrevius(this.caminoPrincipal.getNodo(5));
        this.FaseC.getTail().getData().setInvert(true);
        
        //____________________________________________
        
        this.caminoPrincipal.getNodo(12).getData().setDesvio(true);
        this.caminoPrincipal.getNodo(12).getData().setFase(this.FaseA.getHead());
        
        this.FaseA.getLast().setNext(this.caminoPrincipal.getNodo(22));
        
        
        //___________________________________________________________________________________
        
        this.caminoPrincipal.getNodo(30).getData().setDesvio(true);
        this.caminoPrincipal.getNodo(30).getData().setFase(this.FaseB.getHead());
        
        this.FaseB.getLast().setNext(this.caminoPrincipal.getNodo(34));
        
        //___________________________________________________________________________________
        
        this.caminoPrincipal.getNodo(45).getData().setDesvio(true);
        this.caminoPrincipal.getNodo(45).getData().setFase(this.FaseD.getHead());
        
        this.FaseD.getNodo(8).getData().setDesvio(true);
        this.FaseD.getNodo(8).getData().setFase(this.caminoPrincipal.getNodo(46));
        
        
        
        
    }
    
    
    
    
    
    
    
    @Override
    public void initialize (URL url, ResourceBundle rb){
    
    }

 
    
}
    
    
    

