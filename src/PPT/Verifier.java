package PPT;

import Estructuras.ListaSimple;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public class Verifier {
    public boolean play = false;
    public boolean playagain = true;
    private int victorias1 = 0;
    private int victorias2 = 0;

    /**
     * Constructor del verificador
     */
    Verifier(){
    }

    /**
     * Hace una secuencia de mensajes, para que luego los jugadores seleccionen su jugada
     * @param vs
     */
    public void empezarjuego(ImageView vs) {
        ListaSimple<String> mensajes = new ListaSimple<>();

        //Añade los mensajes de inicio de juego
        mensajes.addFirst("3");
        mensajes.addFirst("2");
        mensajes.addFirst("1");
        mensajes.addFirst("y Tijera");
        mensajes.addFirst("Papel");
        mensajes.addFirst("Piedra");

        vs.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            // Empieza el juego apretando en la imagen de VS

            //Da los mensajes de inicio de juego para poder jugar
            for (int i = 0; i < mensajes.getlen() && playagain; i++){
                System.out.println(mensajes.getInfo(i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            setPlay(true);

        });
    }


    /**
     * Compara la opcion de cada jugador y define un ganador de cada ronda, o partida
     * @param opcion1
     * @param opcion2
     * @param tabla
     */
    public void opciones(PPT opcion1, PPT opcion2, Label tabla){
        if (victorias2 == 2){
            System.out.println("Jugador 2 es el ganador");
        }
        if (victorias1 == 2){
            System.out.println("Jugador 1 es el ganador");
        }
        if (opcion1.isId() == opcion2.isId()){
            System.out.println("Es un empate");
        }
        if (opcion1.isId() == "rock"){
            if (opcion2.isId() == "paper"){
                System.out.println("Jugador 2 gano la ronda");
                victorias2 += 1;
            }
            if (opcion2.isId() == "scissor"){
                System.out.println("Jugador 1 gano la ronda");
                victorias1 += 1;
            }
        }
        if (opcion1.isId() == "paper"){
            if (opcion2.isId() == "scissor"){
                System.out.println("Jugador 2 gano la ronda");
                victorias2 += 1;
            }
            if (opcion2.isId() == "rock"){
                System.out.println("Jugador 1 gano la ronda");
                victorias1 += 1;
            }
        }
        if (opcion1.isId() == "scissor"){
            if (opcion2.isId() == "rock"){
                System.out.println("Jugador 2 gano la ronda");
                victorias2 += 1;
            }
            if (opcion2.isId() == "paper"){
                System.out.println("Jugador 1 gano la ronda");
                victorias1 += 1;
            }
        }
        tabla.setText(victorias1 + " - " + victorias2);

    }

    /**
     * Verifica cuantas rondas se han jugado, para asi definir cuantas rondas quedan o si ya el juego termino
     * @return
     */
    public boolean playAgain(){
        if (victorias1 < 2 && victorias2 < 2){
            play = false;
            System.out.println("Siguiente ronda");
            return true;
        }
        else{
            playagain = false;
            System.out.println("Termino el juego");
            victorias1 = 0;
            victorias2 = 0;
            return false;
        }
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }


}
