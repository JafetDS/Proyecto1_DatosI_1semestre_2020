package PiedraPapelTijera;

import Memoria.Verifier;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PPT{
    public PPT opciones = this;
    private String id;
    private String image;
    private Image picture;
    private ImageView setPicture;
    Verifier verifier;

    PPT(String id, String image, Verifier verifier){
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
