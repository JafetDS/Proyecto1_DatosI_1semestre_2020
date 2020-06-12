package PPT;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPPT implements Initializable {
    @FXML
    private ImageView choose1;
    private ImageView choose2;
    private ImageView rock1;
    private ImageView rock2;
    private ImageView paper1;
    private ImageView paper2;
    private ImageView scissor1;
    private ImageView scissor2;
    private ImageView imagen = new ImageView();

    ControllerPPT(){

    }

    public void visibility(ImageView opcion){
        choose1 = opcion;
        choose1.setVisible(true);
    }

    public ImageView getRock1() {
        return rock1;
    }

    public ImageView getRock2() {
        return rock2;
    }

    public ImageView getPaper1() {
        return paper1;
    }

    public ImageView getPaper2() {
        return paper2;
    }

    public ImageView getScissor1() {
        return scissor1;
    }

    public ImageView getScissor2() {
        return scissor2;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setChoose1(ImageView choose1) {
        this.choose1 = choose1;
    }

    public void setChoose2(ImageView choose2) {
        this.choose2 = choose2;
    }

    public void fight(ActionEvent event){
        rock1.setVisible(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
