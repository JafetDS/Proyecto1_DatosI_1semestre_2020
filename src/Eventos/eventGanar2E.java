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
public class eventGanar2E extends Evento {
    @Override
    public void start(Jugador turno,ListaCircular<Jugador> Jugadores){
        turno.sumEstrellas(2);
    }
    
}
