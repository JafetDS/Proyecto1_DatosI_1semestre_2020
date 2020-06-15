package Memoria;

import Estructuras.ListaSimple;
import javafx.application.Platform;
import javax.swing.*;

public class Verifier {
    Verifier verifier = null;
    ListaSimple<Card> pairs = new ListaSimple<>();
    ListaSimple<Card> cards = new ListaSimple<>();

    /**
     * Constructor del verificador
     */
    Verifier(){
    }

    /**
     * Obtine el verificador para añadirlo a cada carta
     * @param cards
     * @return
     */
    public Verifier getVerifier(ListaSimple<Card> cards){
        if (verifier == null){
            verifier = new Verifier();
            verifier.cards = cards;
        }
        return verifier;
    }

    /**
     * Verifica si se hizo click encima de cada imagen y compara si son las mismas imagenes
     * @param card
     */
    public void new_click(Card card) {
        pairs.addFirst(card);
        System.out.println("Added a new card.");
        if (pairs.getlen() == 2){
            System.out.println("Comparing...");
            Card card1 = pairs.getInfo(0);
            Card card2 = pairs.getInfo(1);
            System.out.println(card1.getBack().isVisible());
            System.out.println("Got cards.");
            if (card1.getId().equals(card2.getId())){
                System.out.println("id1: " + card1.getId() + ", id2: " + card2.getId());
                card1.makeVisible();
                card2.makeVisible();
                if (isGameOver()){
                    JOptionPane.showMessageDialog(null, "The game has ended", "InfoBox: " + "GameOver", JOptionPane.INFORMATION_MESSAGE);
                    Platform.exit();
                    System.exit(0);
                }
            }
            else {
                card1.makeNotVisible();
                card2.makeNotVisible();
            }
            pairs.deleteAll();
        }
    }

    /**
     * Finaliza el juego
     * @return
     */
    private boolean isGameOver(){
        for (int i = 0; i < cards.getlen(); i++) {
            if (!cards.getInfo(i).getVisible()){
                return false;
            }
        }
        return true;
    }
}
