package PiedraPapelTijera;

import Estructuras.ListaSimple;
import Memoria.Card;
import Memoria.Verifier;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PanelGame extends Application {

    public String tecla;
    public String tecla2;
    public boolean keypressed = false;
    public boolean keypressed2 = false;

    private Parent createContent() {

        Pane root = new Pane();
        root.setPrefSize(900, 485);

        ListaSimple<String> images =  getUrls();

        //Memoria.Verifier verifier = new Verifier().getVerifier(jugadas);

        if (true){//(tecla != "" && tecla2 != ""){
            colocar(root);
        }


        //}

        return root;

    }
    @Override
    public void start(Stage Stage) throws Exception {
        Stage.setScene(new Scene(createContent()));
        Stage.show();

    }
    public ListaSimple<String> getUrls(){
        String pierda ="file:images/piedra.png";
        String papel = "file:images/papel.png";
        String tijera = "file:images/tijera.png";

        ListaSimple<String> URLs = new ListaSimple<>();
        URLs.addFirst(pierda);
        URLs.addFirst(papel);
        URLs.addFirst(tijera);

        return URLs;
    }

    public void colocar(Pane root){
        root.setOnKeyPressed(e ->{
            if (e.getCode() == KeyCode.A && !keypressed){
                System.out.println("Key A was pressed, piedra");
                keypressed = true;
                tecla = "A";
            }
            if (e.getCode() == KeyCode.S && !keypressed){
                System.out.println("Key S was pressed, papel");
                keypressed = true;
                tecla = "S";
            }
            if (e.getCode() == KeyCode.W && !keypressed){
                System.out.println("Key W was pressed, tijera");
                keypressed = true;
                tecla = "W";
            }
            if (e.getCode() == KeyCode.L && !keypressed2){
                System.out.println("Key L was pressed, piedra2");
                keypressed2 = true;
                tecla2 = "L";
            }
            if (e.getCode() == KeyCode.K && !keypressed2){
                System.out.println("Key K was pressed, papel2");
                keypressed2 = true;
                tecla2 = "K";
            }
            if (e.getCode() == KeyCode.I && !keypressed2){
                System.out.println("Key I was pressed, tijera2");
                keypressed2 = true;
                tecla2 = "I";
            }
        });
    }
    public static void main(String[] args){
        launch(args);
    }
}
