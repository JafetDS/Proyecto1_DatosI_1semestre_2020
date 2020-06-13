/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXeditor;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 *
 * @author User 

 */
public class FXeditor {
    
    public FXeditor(){

    }
    public void setElement(GridPane grid,int row,int column,Object object){
        GridEditor.setElement(grid, row, column, object);
    }
     public Node getElement(GridPane grid,int row,int column){
        return GridEditor.getElement(grid, row, column);
     }
}
