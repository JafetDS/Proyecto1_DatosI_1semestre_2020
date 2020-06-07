/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXeditor;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author User
 */
public class GridEditor {
  //  public GridEditor(){
        
    //}
    
    public static void setElement(GridPane grid,int row,int column,Object object){
        grid.add((Node) object, column, row);
        
    }    
    
}
