/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author User
 * @param <T>
 */
public class NodoListasimple<T> {
 
    
  
    private T data;    
    private NodoListasimple<T> next;
    
    /**
     * Constructor del Nodo vacio
     */
    public NodoListasimple(){
        next=null;        
    }
    /**
     * Método del constructor del Nodo con un dato
     * @param data
     */
    public NodoListasimple(T data){
        this.next=null;
        this.data=data;
    }
    /**
     * Método para obtener el dato almacenado en el Nodo
     * @return 
     */
    public T getData(){
        return this.data; 
       
    }
    /**
     * Método para establecer el nodo siguiente 
     * @param Next 
     */
    
    public void setNext(NodoListasimple<T> Next){
            this.next= Next;
           
    }
     /**
     * @return next
     */

    public NodoListasimple<T> getNext() {
        return next;
    }
    
  

    
    
}
