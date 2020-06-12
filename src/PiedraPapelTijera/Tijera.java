package PiedraPapelTijera;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tijera {
    public Tijera opciones = this;
    private String id;
    private String image;
    private Image picture;
    private ImageView setPicture;


    Tijera(String id, String image){
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
