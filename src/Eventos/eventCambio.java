/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Estructuras.ListaCircular;
import Estructuras.Nodo;
import principal.Casilla;
import principal.Jugador;


public class eventCambio extends Evento{
    /**
     * Función para asignar 1 jugador al azar, para intercambiarlo con el jugador que activo el evento
     * @param turno
     * @param Jugadores
     */
    @Override
    public void start(Jugador turno,ListaCircular<Jugador> Jugadores){
        Jugador victima = Jugadores.getInfo(this.random(4));
        while(victima==turno){
            victima = Jugadores.getInfo(this.random(4));
        }
        
        Nodo<Casilla> aux = turno.getCasilla();
        aux.getData().setFichas(victima.getFichas());
        
        turno.setCasilla(victima.getCasilla());
        victima.setCasilla(aux);
        
        turno.setFichas(turno.getFichas());

    }
}
