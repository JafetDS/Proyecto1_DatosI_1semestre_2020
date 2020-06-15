/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Estructuras.Nodo;
import Estructuras.NodoListasimple;
import static java.lang.Thread.sleep;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author User
 */
public class Jugador {
    private String Nombre;
    private Integer Estrellas;
    private Integer Monedas;
    private HBox fichas;
    private Button fichaB;
    private Nodo<Casilla> Casilla;
    private PrincipalController Tablero;
    private boolean direccion;
    
    public Jugador(String nombre){
        this.Casilla= new Nodo<Casilla>(); 
        this.fichaB= new Button(nombre);
        this.fichas = new HBox();
        this.fichas.getChildren().add(this.fichaB);
        this.Estrellas=0;
        this.Monedas=0;
        
    }

   
    
    
    
    public void setFicha(Button but){
        this.fichaB = but;
    }
    
    public Button getFicha(){
        return this.fichaB;
    }

    public HBox getFichas() {
        return fichas;
    }

    public void setFichas(HBox fichas) {
        this.fichas = fichas;
    }
    
    
    
    public void sumEstrellas(Integer num){
        this.Estrellas+=num;
    }
    
    public void resEstrellas(Integer num){
        this.Estrellas-=num;
    }
    
    public void sumMonedas(Integer num){
        this.Monedas+=num;
    }
    
    public void resMonedas(Integer num){
        this.Monedas-=num;
    }
    
    public void setCasilla(Nodo<Casilla> casilla){
        this.Casilla = casilla;       
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public PrincipalController getTablero() {
        return Tablero;
    }

    public void setTablero(PrincipalController Tablero) {
        this.Tablero = Tablero;
    }

    public boolean getDireccion() {
        return direccion;
    }

    public void setDireccion(boolean direccion) {
        this.direccion = direccion;
    }

    public void retroseder() throws InterruptedException{
        avanzar(53);
    }
    
    public Nodo<Casilla> getCasilla(){
        return this.Casilla;
    }
    
    public void avanzar(int pos) throws InterruptedException{
        if (this.getDireccion()){
            avanzarInv(pos);
        }else{
            avanzar2(pos);
        }
    }
    
    public void avanzarInv(int pos) throws InterruptedException{
        for (int i=0; i<pos; i++){
            this.Casilla = this.Casilla.getPrevius();
             if (this.Casilla.getData().isStar()){
                this.sumEstrellas(1);
                this.Casilla.getData().setStar(false);
            }
            if(this.Casilla.getPrevius()==null){
                avanzar2(i);
                break;
            }
            
          //  Thread.sleep(4000);
        }
        if(this.Casilla.getData().isDesvio()){
            this.Casilla = this.Casilla.getData().getFase();
        }
       // this.setDireccion(this.Casilla.getData().isInvert());
       
        this.Casilla.getData().setFichas(fichas);
        actionCasilla();
        

    }

    public Integer getEstrellas() {
        return Estrellas;
    }

    public void setEstrellas(Integer Estrellas) {
        this.Estrellas = Estrellas;
    }

    public Integer getMonedas() {
        return Monedas;
    }

    public void setMonedas(Integer Monedas) {
        this.Monedas = Monedas;
    }

    public Button getFichaB() {
        return fichaB;
    }

    public void setFichaB(Button fichaB) {
        this.fichaB = fichaB;
    }
    
    
    public void avanzar2(int pos) throws InterruptedException{
        for (int i=0; i<pos; i++){
            this.Casilla = this.Casilla.getNext();
            if (this.Casilla.getData().isStar()){
                this.sumEstrellas(1);
                this.Casilla.getData().setStar(false);
            }
          //  Thread.sleep(4000);
        }
        if(this.Casilla.getData().isDesvio()){
            this.Casilla = this.Casilla.getData().getFase();
        }
        this.setDireccion(this.Casilla.getData().isInvert());
        this.Casilla.getData().setFichas(fichas);
        actionCasilla();
    }
    
    public boolean getDecision(){
        return true;
    }
    
    
    public void actionCasilla(){
        String color = this.Casilla.getData().getColor();
        switch (color) {
          case "Green":
            this.sumMonedas(5);
            break;
          case "Red":
            this.resMonedas(3);
            break;
          case "Yellow":
            Evento();
            break;
        }
        
    }
 
    public void Evento(){
        this.Tablero.evento();
    }
    
    
}
