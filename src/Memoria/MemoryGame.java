package Memoria;

import Estructuras.ListaSimple;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

public class MemoryGame extends Application {

    private static final int NUM_OF_PAIRS = 6;
    private static final int NUM_PER_ROW = 4;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(900, 485);

        ListaSimple<Card> cards = new ListaSimple<>();

        ListaSimple<String> images =  getURLs();

        Verifier verifier = new Verifier().getVerifier(cards);

        char c = 'A';
        for (int i = 0; i < NUM_OF_PAIRS; i++) {
            Card card1 = new Card(String.valueOf(c), images.getInfo(i), verifier);
            Card card2 = new Card(String.valueOf(c), images.getInfo(i), verifier);
            cards.addFirst(card1);
            cards.addFirst(card2);
            c++;
        }

        cards.myShuffle();

        for (int i = 0; i < cards.getlen(); i++) {
            Card card = cards.getInfo(i);
            card.getImageView().setTranslateX(180 * (i % NUM_PER_ROW));
            card.getImageView().setTranslateY(160 * (i / NUM_PER_ROW));
            card.getBack().setTranslateX(180 * (i % NUM_PER_ROW));
            card.getBack().setTranslateY(160 * (i / NUM_PER_ROW));
            root.getChildren().addAll(card.getImageView(), card.getBack());
        }

        return root;
    }

    /**
     * public void close(String ) {
     * FadeTransition ft = new FadeTransition(Duration.seconds(0.5), label);
     * ft.setToValue(0);
     * ft.play();
     * }
     */


    @Override
    public void start(Stage Stage) throws Exception {
        Stage.setScene(new Scene(createContent()));
        Stage.show();

        /**Parent root = FXMLLoader.load(getClass().getResource("Memory.fxml"));

         Scene scene = new Scene(root);

         stage.setScene(scene);
         stage.show();*/
    }

    public ListaSimple<String> getURLs() {
        String apple = "file:images/apple.png";
        String pear = "file:images/pear.png";
        String grape = "file:images/grape.png";
        String banana = "file:images/banana.png";
        String pineapple = "file:images/pineapple.png";
        String watermelon = "file:images/watermelon.png";

        ListaSimple<String> URLs = new ListaSimple<>();
        URLs.addFirst(apple);
        URLs.addFirst(pear);
        URLs.addFirst(grape);
        URLs.addFirst(banana);
        URLs.addFirst(pineapple);
        URLs.addFirst(watermelon);

        return URLs;
    }
    public void start(){
        main(null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
