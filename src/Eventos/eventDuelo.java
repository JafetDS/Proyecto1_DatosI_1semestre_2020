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
public class eventDuelo extends Evento {
    /**
     * Función para escoger 1 jugador al azar y ponerlo en Duelo con el jugador que activo el evento
     * @param turno
     * @param Jugadores
     */
    @Override
    public void start(Jugador turno,ListaCircular<Jugador> Jugadores){
        int num1=0;
        int num2=0;
        while(num1==num2){
            num1=this.random(4);
            num2 = this.random(4);
        }
       // PPT(Jugadores.getInfo(num1),Juagadores.getInfo(num2));
    }
    
}
