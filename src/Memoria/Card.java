package Memoria;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Card {
    private Card card = this;
    private String id;
    private String image;
    private Image photo;
    private ImageView imageView;
    private boolean visible;
    Verifier verifier;
    private ImageView back = new ImageView(new Image("file:images/back.png"));

    /**
     * Crea el contructor de las cartas para el memoria
     * @param id
     * @param image
     * @param verifier
     */
    Card(String id, String image, Verifier verifier){
        this.id = id;
        this.verifier = verifier;
        this.image = image;
        photo = new Image(this.image);
        imageView = new ImageView(photo);
        visible = false;
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            // Informs that it has been pressed. Passes to observer (this)
            back.setVisible(false);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (!visible){
                        verifier.new_click(card);
                    }
                }
            }));
            timeline.play();

        });
    }

    public String getId(){
        return id;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public boolean getVisible(){
        return visible;
    }

    /**
     * Hace las imagenes seleccionadas no visibles
     */
    public void makeNotVisible(){
        back.setVisible(true);
        visible = false;
    }

    public ImageView getBack(){
        return back;
    }

    /**
     * HAce las imagenes seleccionadas visibles
     */
    public void makeVisible(){
        visible = true;
        back.setVisible(false);
        System.out.println("Made card: " + id + ", visible");
    }
}