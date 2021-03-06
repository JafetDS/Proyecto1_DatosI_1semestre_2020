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
public class NodoListadoble<T> extends Nodo<T>{
    private T data;    
    private Nodo<T> next;
    private Nodo<T> previus;
    
    /**
     * Constructor del Nodo vacio
     */
    public NodoListadoble(){
        next=null;        
    }
    /**
     * Método del constructor del Nodo con un dato
     * @param data
     */
    public NodoListadoble(T data){
        this.next=null;
        this.data=data;
    }
    /**
     * Método para obtener el dato almacenado en el Nodo
     * @return 
     */
    @Override
    public T getData(){
        return this.data; 
       
    }
    /**
     * Insertar dato en un nodo;
     * @param data 
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * remplaza un Dato en el nodo y devuelve el dato anterior
     * @param data
     * @return pData
     */
    public T replaceData(T data){
        T pData=this.getData();
        this.data = data;
        return pData;
    }
    /**
     * Metodo para obtener el siguiente nodo
     * @return next
     * 
     */

    @Override
    public Nodo<T> getNext() {
        return next;
    }
    
    
    /**
     * Método para establecer el nodo siguiente 
     * @param Next 
     */
    
    @Override
    public void setNext(Nodo<T> Next){
            this.next= Next;
           
    }
    /**
     * devuelve el nodo anterior
     * @return previus
     */
    public Nodo<T> getPrevius() {
        return previus;
    }
     /**
     * Inserta un nodo previo
     * @param previus
     */

    @Override
    public void setPrevius(Nodo<T> previus) {
        this.previus = previus;
    }
    
    
}
