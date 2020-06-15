/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Estructuras.Nodo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author User
 */
public class Casilla {
    
   private String color;
   private Pane pane;
   private Image image;
   private boolean Ocupada;
   private Jugador jugador;
   private boolean desvio;
   private Nodo<Casilla> fase;
   private boolean invert;
   private boolean Star;


  
   

    public Casilla(Image image) {
        this.image = image;
        this.pane = new Pane();
        Construir_Casilla();
    }
    
    public Casilla(String color) {
        this.color= color;
        this.pane = new Pane();
        Construir_Casilla();
    }
    
    public Casilla(Image image,String color) {
        this.image = image;
        this.color= color;
        this.pane = new Pane();
        Construir_Casilla();
    }
   
    
    public boolean isStar() {
        return Star;
    }

    public void setStar(boolean Star) {
        this.Star = Star;
    }
   
    private void Construir_Casilla(){
     //  this.pane.setPrefSize(180, 160);
        if ("Blue".equals(this.color)){
            this.pane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            this.pane.setStyle("-fx-border-color: Black" );
        }
        else if("Red".equals(this.color)){
            this.pane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            this.pane.setStyle("-fx-border-color: Black" );
        }
        else if("Green".equals(this.color)){
            this.pane.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            this.pane.setStyle("-fx-border-color: Black" );
        }
        
        else{
            this.pane.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            this.pane.setStyle("-fx-border-color: Black" );
        }
    }
   
    public Pane getPane(){
        return this.pane;
    }
   
    public void setFicha(Button ficha){
        this.pane.getChildren().add(ficha);
    }
   
    public void deleteFicha(Button ficha){
        this.pane.getChildren().remove(ficha);
    }
    
    public void setFichas(HBox hbox){
        this.pane.getChildren().add(hbox);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isOcupada() {
        return Ocupada;
    }

    public void setOcupada(boolean Ocupada) {
        this.Ocupada = Ocupada;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean isDesvio() {
        return desvio;
    }

    public void setDesvio(boolean desvio) {
        this.desvio = desvio;
    }

    public Nodo<Casilla> getFase() {
        return fase;
    }

    public void setFase(Nodo<Casilla> fase) {
        this.fase = fase;
    }

    public boolean isInvert() {
        return invert;
    }

    public void setInvert(boolean invert) {
        this.invert = invert;
    }
    
    
    
    
    
    
    
    
}
   
   

   
   
    

