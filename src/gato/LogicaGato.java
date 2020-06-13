/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import Estructuras.ListaSimple;
import Estructuras.MatrizSimple;
import Estructuras.RowMatriz;
import FXeditor.FXeditor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 *
 * @author User
 */
public class LogicaGato {
    private FXeditor editor= new FXeditor();
    
    private MatrizSimple<Button> matriz = new MatrizSimple<>(3,3);
    
    private String Player1;
    private String Player2;
    private String turn; 
   
    private ListaSimple<Integer> filas = new ListaSimple<>();
    private ListaSimple<Integer> columnas = new ListaSimple<>();
    private ListaSimple<Integer> diagonales = new ListaSimple<>();
    
    private Image image1=new Image("file:src/MultimediaGato/equis.png");
    private Image image2=new Image("file:src/MultimediaGato/check.png");
    
    public String Winner = "none";

    
    
    public LogicaGato(String Player1, String Player2) {
        this.Player1 = Player1;
        this.Player2 = Player2;
        this.turn = Player1;

        initializeLists();
     
    }
    
    private void initializeLists(){
        for (int i = 0 ; i<6; i++){
            this.filas.addFirst(0);
            this.columnas.addFirst(0);
            this.diagonales.addFirst(0);      
        }
    }
    
    public void GenerateButons(GridPane Pane){ 
        for (int i=0 ; i<3; i++){
            for (int j=0 ; j<3; j++){
                int i2=i;
                int j2=j;
                Button but = new Button();
                but.setPrefSize(180, 160);
                but.setOnAction(e->precionarBotton(e , i2 , j2));
                but.setStyle("-fx-background-color: blue");
                //this.matriz.setDato(but, i2, j2);
              //  editor.setElement(Pane, i, j, but);
                Pane.add(but, j, i);
            }
        }            
    }
    
    
    
    
    public void precionarBotton(ActionEvent e, int row , int column){

        Button but = (Button)e.getSource();
        but.setStyle("-fx-background-color: blue");
        System.out.println(this.matriz.getDato(row, column));
        
           
        putImage(but);
        verificar(row, column);
        

         
    }
 
    

    
    private void putImage(Button button){
        if(this.turn.equals(this.Player1)){
            button.setGraphic(new ImageView(this.image1));
            this.turn = this.Player2;
        }else{
            button.setGraphic(new ImageView(this.image2));
            this.turn = this.Player1;
        }
    }
    
    private void verificar (int row , int column){
        int extra = 0;
        if (this.Player2.equals(this.turn)){
            extra += 3;
        }
        
        int dato =this.filas.getInfo(row+extra)+1;
        if (dato == 3){
            System.out.print("win"+turn+"fila"+Integer.toString(row));
            this.Winner = this.turn;
            return;
        }this.filas.replaceDato(dato, row+extra);
        
        
        dato = this.columnas.getInfo(column+extra)+1;
        if (dato == 3){
            System.out.print("win "+turn+" columna "+Integer.toString(column));    
            this.Winner = this.turn;
            return;
        }this.columnas.replaceDato(dato, column+extra);
        
        if (row-column == 0){
            dato = this.diagonales.getInfo(row-column+extra)+1;
            if (dato == 3){
                System.out.print("win"+turn+"diagonal"+Integer.toString(row-column));  
                this.Winner = this.turn;
                return;
            }this.diagonales.replaceDato(dato,row-column+extra);     
        }
        
        if (row+column == 2){
            dato = this.diagonales.getInfo(row+column+extra)+1;
            if (dato == 3){
                System.out.print("win"+turn+"diagonal"+Integer.toString(row+column));  
                this.Winner = this.turn;
                return;
            }this.diagonales.replaceDato(dato,row+column+extra);     
        }

    } 

    public String getWinner() {
        return Winner;
    }
    

    
    

   
    
    
    
    
    
}
