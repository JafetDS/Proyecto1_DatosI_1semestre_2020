package PPT;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import principal.PrincipalController;


public class PPTGame extends Application {
    private boolean keypressed;
    private boolean keypressed2;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PPT.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        ControllerPPT opcion =  new ControllerPPT();
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A && keypressed) {
                opcion.setChoose1(opcion.getPaper1());
                opcion.visibility(opcion.getImagen());
                keypressed = false;
                System.out.println("A key was pressed");
            }
            if (e.getCode() == KeyCode.S && keypressed) {
                //choose1 = paper1;
                keypressed = false;
                System.out.println("S key was pressed");
            }
            if (e.getCode() == KeyCode.W && keypressed) {
                //choose1 = scissor1;
                keypressed = false;
                System.out.println("W key was pressed");
            }
        });
    }

    public static void main(String[] args){
        launch(args);
    }
}
