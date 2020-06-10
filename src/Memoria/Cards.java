package Memoria;

import Estructuras.ListaSimple;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private Image apple = new Image("file:images/apple.png");
    private Image pear = new Image("file:images/pear.png");
    private Image grape = new Image("file:images/grape.png");
    private Image banana = new Image("file:images/banana.png");
    private Image pineapple = new Image("file:images/pineapple.png");
    private Image watermelon = new Image("file:images/watermelon.png");

    private ListaSimple<Image> imagenesURL = new ListaSimple<>();

    public Cards() {
        this.imagenesURL = new ListaSimple<>();
        imagenesURL.addFirst(apple);
        imagenesURL.addFirst(pear);
        imagenesURL.addFirst(grape);
        imagenesURL.addFirst(banana);
        imagenesURL.addFirst(pineapple);
        imagenesURL.addFirst(watermelon);
    }

    public ListaSimple<Image> getImagenesURL() {
        return imagenesURL;
    }
}
