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
public class eventRobarEstrella extends Evento{
    @Override
    public void start(Jugador turno,ListaCircular<Jugador> Jugadores){
        Jugador victima = Jugadores.getInfo(this.random(4));
        while(victima==turno){
            victima = Jugadores.getInfo(this.random(4));
        }
        
     
        victima.resMonedas(1);
        turno.sumMonedas(1);

    }
}
