/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Estructuras.ListaCircular;
import principal.Jugador;

/**
 *
 * @author User
 */
public class eventPerderEstrella extends Evento {
    @Override
    public void start(Jugador turno,ListaCircular<Jugador> Jugadores){
        turno.resEstrellas(1);
        Jugador fortuna = Jugadores.getInfo(this.random(4));
        while(fortuna== turno){
            fortuna = Jugadores.getInfo(this.random(4));
        }
        fortuna.sumEstrellas(1);
    }
}
