/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXeditor;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

/**
 *
 * @author User
 */
public class ButtonEditor {
    private Button button;
    
    public ButtonEditor(Button button){
        this.button=button;      
    }
    
    public ButtonEditor(){
        
    }
    
    public Button CreateButton(){
        Button button=new Button();
        return button;
    }
    
    public void setElement(Image image){
        
    }
    
    
    
    
}
