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
public class eventRegalarMonedas extends Evento {
    
    @Override
    public void start(Jugador turno,ListaCircular<Jugador> Jugadores){
        int num1=this.random(4);
        for (int i =0 ; i<Jugadores.getlen(); i++){
            if(Jugadores.getInfo(i)!=turno){
              Jugadores.getInfo(i).sumMonedas(num1);
            }
        }
        
        turno.resMonedas(num1*(Jugadores.getlen()-1));
   
       // PPT(Jugadores.getInfo(num1),Juagadores.getInfo(num2));
    }
    
}
