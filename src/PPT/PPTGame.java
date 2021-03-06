package PPT;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class PPTGame extends Application {

    private PPT image;
    private PPT image2;
    private boolean keypressed = true;
    private boolean keypressed2 = true;
    public GridPane root;
    public Scene ventana = new Scene(root = new GridPane());
    private ImageView vs = new ImageView(new Image("file:images/vs.png"));
    private Label tabla = new Label();
    private boolean play = false;
    private boolean playagain;


    @Override
    /**
     * Crea la ventana principal de juego, y toma las teclas de cada jugador, para luego compararlas
     */
    public void start(Stage stage) throws Exception {
        stage.setScene(ventana);
        root.setPrefSize(800,600);
        vs.setTranslateY(225);
        vs.setTranslateX(250);
        tabla.setText("0 - 0");
        tabla.setTranslateX(275);
        tabla.setTranslateY(353);
        tabla.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        root.getChildren().addAll(vs, tabla);

        Verifier juego = new Verifier();
        juego.empezarjuego(vs);

        ventana.setOnKeyPressed(e -> {
            play = juego.isPlay();
            if (e.getCode() == KeyCode.A && keypressed && play) {
                image = new PPT("rock", "file:images/piedra.png");
                image.getSetPicture().setTranslateX(50);
                image.getSetPicture().setTranslateY(225);
                root.getChildren().add(image.getSetPicture());
                keypressed = false;
            }
            if (e.getCode() == KeyCode.S && keypressed && play) {
                image = new PPT("paper", "file:images/papel.png");
                image.getSetPicture().setTranslateX(50);
                image.getSetPicture().setTranslateY(225);
                root.getChildren().add(image.getSetPicture());
                keypressed = false;
            }
            if (e.getCode() == KeyCode.W && keypressed && play) {
                image = new PPT("scissor", "file:images/tijera.png");
                image.getSetPicture().setTranslateX(50);
                image.getSetPicture().setTranslateY(225);
                root.getChildren().add(image.getSetPicture());
                keypressed = false;
            }
            if (e.getCode() == KeyCode.L && keypressed2 && play) {
                image2 = new PPT("rock", "file:images/piedra.png");
                image2.getSetPicture().setTranslateX(450);
                image2.getSetPicture().setTranslateY(225);
                root.getChildren().add(image2.getSetPicture());
                keypressed2 = false;
            }
            if (e.getCode() == KeyCode.K && keypressed2 && play) {
                image2 = new PPT("paper", "file:images/papel.png");
                image2.getSetPicture().setTranslateX(450);
                image2.getSetPicture().setTranslateY(225);
                root.getChildren().add(image2.getSetPicture());
                keypressed2 = false;
            }
            if (e.getCode() == KeyCode.I && keypressed2 && play) {
                image2 = new PPT("scissor", "file:images/tijera.png");
                image2.getSetPicture().setTranslateX(450);
                image2.getSetPicture().setTranslateY(225);
                root.getChildren().add(image2.getSetPicture());
                keypressed2 = false;
            }
            if (!keypressed && !keypressed2){
                //Analiza ambas opciones
                System.out.println("Analizando...");
                juego.opciones(image, image2, tabla);
                playagain = juego.playAgain();
                keypressed = playagain;
                keypressed2 = playagain;
                play = playagain;
                if (!playagain){
                    tabla.setText("0 - 0");
                }
                image = null;
                image2 = null;
            }
        });


        stage.show();


    }
    public static void main(String[] args){
        launch(args);
    }
}

