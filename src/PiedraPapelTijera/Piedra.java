package PiedraPapelTijera;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Piedra {
    public Piedra opciones = this;
    private String id;
    private String image;
    private Image picture;
    private ImageView setPicture;


    Piedra(String id, String image){
        this.id = id;
        this.image = image;
        picture = new Image(image);
        setPicture = new ImageView(picture);


    }
    public String getId(){
        return id;
    }

    public ImageView getSetPicture(){
        return setPicture;
    }

}
