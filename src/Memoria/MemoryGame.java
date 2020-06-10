package Memoria;

import Estructuras.ListaSimple;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.management.StringValueExp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jdk.internal.net.http.common.Utils.close;

public class MemoryGame extends Application {

    private static final int NUM_OF_PAIRS = 6;
    private static final int NUM_PER_ROW = 4;

    private Tile selected = null;
    private int clickCount = 2;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(900, 485);

        Cards cartas = new Cards();
        ListaSimple<Image> imagenes = cartas.getImagenesURL();

        char c = 'A';
        ListaSimple<Label> labels = new ListaSimple<>();
        for (int i = 0; i < NUM_OF_PAIRS; i++) {
            labels.addFirst(new Label(String.valueOf(c), new ImageView(imagenes.getInfo(i))));
            labels.addFirst(new Label(String.valueOf(c), new ImageView(imagenes.getInfo(i))));
            c++;
        }

        labels.MySuffle();

        for (int i = 0; i < labels.getlen(); i++) {
            Label label = labels.getInfo(i);
            label.setTranslateX(180 * (i % NUM_PER_ROW));
            label.setTranslateY(160 * (i / NUM_PER_ROW));
            root.getChildren().add(label);
        }

        return root;
    }

    @Override
    public void start(Stage Stage) throws Exception {
        Stage.setScene(new Scene(createContent()));
        Stage.show();

    }

    private class Tile extends StackPane {
        private Text text = new Text();

        public Tile(String value) {

            Rectangle border = new Rectangle(180, 160);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            text.setText(value);
            text.setFont(Font.font(30));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(this::handleMouseClick);
            close();
        }

        public void handleMouseClick(MouseEvent event) {
            if (isOpen() || clickCount == 0)
                return;

            clickCount--;

            if (selected == null) {
                selected = this;
                open(() -> {
                });
            } else {
                open(() -> {
                    if (!hasSameValue(selected)) {
                        selected.close();
                        this.close();
                    }

                    selected = null;
                    clickCount = 2;
                });
            }
        }

        public boolean isOpen() {
            return text.getOpacity() == 1;
        }

        public void open(Runnable action) {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(1);
            ft.setOnFinished(e -> action.run());
            ft.play();
        }

        public void close() {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(0);
            ft.play();
        }

        public boolean hasSameValue(Tile other) {
            return text.getText().equals(other.text.getText());
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
