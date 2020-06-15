/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Estructuras.ListaCircular;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.Jugador;

/**
 *
 * @author User
 */
public class eventTeletransporte extends Evento{
        @Override
        public void start(Jugador turno,ListaCircular<Jugador> Jugadores){
            try {
                turno.avanzar(this.random(50));
            } catch (InterruptedException ex) {
                Logger.getLogger(eventTeletransporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
