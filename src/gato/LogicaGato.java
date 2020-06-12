/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import Estructuras.MatrizSimple;
import Estructuras.RowMatriz;
import FXeditor.FXeditor;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author User
 */
public class LogicaGato {
    /**private  MatrizSimple<Integer> Matriz;
    
    public LogicaGato(){
        this.Matriz = new MatrizSimple<>(3,3);
    }
    
    public void Rellenar(){
        
        
    }
    
    public void GenerateButons(GridPane Pane){
        
        FXeditor editor= new FXeditor();
        
        //_______Rellena la Matriz de ceros____________________________________________
        RowMatriz<Integer> aux=Matriz.getMatriz();
        while(aux!=null){
          aux.rellenar(0);
          aux=aux.getNext();
        } 
        //_______Crea los Botones En el pane_______________________________________________
        
        
        
        
        
        
    }
    private void precionarBotton(ActionEvent e,int row,int column){
        
    }
    
    
    
    
    */
}
