package PPT;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PPT {
    private String id;
    private String image;
    private Image picture;
    private ImageView setPicture;

    PPT(String id, String image){
        this.id = id;
        this.image = image;
        picture = new Image(image);
        setPicture = new ImageView(picture);

    }


    public String isId(){
        return id;
    }


    public ImageView getSetPicture(){
        return setPicture;
    }

}