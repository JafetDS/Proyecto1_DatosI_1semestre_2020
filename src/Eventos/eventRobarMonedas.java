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
public class eventRobarMonedas extends Evento{
    /**
     * El jugador que activa el evento selecciona a otro jugador para robarle una estrella
     * @param turno
     * @param Jugadores
     */
    @Override
    public void start(Jugador turno,ListaCircular<Jugador> Jugadores){
        Jugador victima = Jugadores.getInfo(this.random(4));
        while(victima==turno){
            victima = Jugadores.getInfo(this.random(4));
        }
        
        int monedas = this.random(8);
        victima.resMonedas(monedas);
        turno.sumMonedas(monedas);

    }
}
