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
public class ListaCircular<T>{
    private NodoListasimple<T> head;
    private int len;
   
    /**
     * Constructor de lista 
     *  
     */
    public ListaCircular(){
        head=null;
        len=0;        
    }
    
    /**
     * 
     * @return Retorna la cabeza de la Lista
     */

    public NodoListasimple<T> getHead() {
        return head;
    }
    
    /**
     * Método para obtener el largo de la lista
     * @return 
     */
    public int getlen(){
        return this.len;
    }

    /**
     * Metodo para hacer un print de los elementos dwe la lista 
     */
    public void print(){
        NodoListasimple<T> aux= head;
        while(aux !=null){
            System.out.println(aux.getData());
            aux=aux.getNext();
            
        }
    
    }
    public NodoListasimple<T> getNodo(int pos){
        NodoListasimple<T> aux=this.head;
        int cont=0;
        while(aux!=null){
            if(cont==pos){
                return aux;
            }
            aux=aux.getNext();
            cont++;
        }
    return null;
    }
   
    /**
     * Metodo para conseguir el valor de una posición de la lista
     * @param i
     * @return 
     */
    public T getInfo(int i){
        NodoListasimple<T> aux=this.head;
        int cont=0;
        while(aux!=null){
            if(cont==i){
                return aux.getData();
            }
            aux=aux.getNext();
            cont++;
        }
    return null;
    }
    /**
     * Metodo para agregar un espacio vacio al inicio de la lista
     */
 
    public void addFirst(){
        if (this.head==null){
            this.head= new NodoListasimple();

        }
        else{
            NodoListasimple<T> temp= this.head;
            this.head= new NodoListasimple();
            this.head.setNext(temp);
        }
        len++;
    }
    /**
     * Metodo para agregar un dato al inicio de la lista
     * @param dato 
     */
    public void addFirst(T dato){
        if (this.head==null){
            this.head= new NodoListasimple(dato);           
        }
        else{
            NodoListasimple<T> temp= this.head;
            this.head= new NodoListasimple(dato);
            this.head.setNext(temp);
        }
        len++;
    }
    
    
    
    public void addLast(T dato){
        NodoListasimple<T> aux= this.head;
        while(aux.getNext()!=this.head){
            aux=aux.getNext();
        }
        aux.setNext(new NodoListasimple(dato));
        aux=aux.getNext();
        aux.setNext(this.head);
        len++;
    }

    /**
     * Metodo para agregar un dato a una posicion dada de la lista
     * @param i 
     * @param dato 
     */

    public void addPos(int i,T dato){
        
        if (i==0){
           addFirst(dato);         
        }
        else if (this.len%i==0){
            addLast(dato);           
        }
        else{
            NodoListasimple<T> aux=this.head;
            for(int pos=1;pos<i;pos++){
                aux=aux.getNext();
            }
            NodoListasimple<T> temp=aux.getNext();
            aux.setNext(new NodoListasimple(dato));
            aux.getNext().setNext(temp);
            len++;
        }
    
    }
    /**
     * Metodo para buscar si un dato esta en la lista
     * @param dato
     * @return retorna un boolean segun si esta o no el dato
     */
    public boolean in(T dato){
        NodoListasimple<T> aux=head;
        while (aux != head){
            if (aux.getData().equals(dato)){
                System.out.println(aux.getData());
                return true;
            }
            aux=aux.getNext();  
        }
        return false;
    }
    /**
     * Metodo para eliminar el primer elemento 
     */
    public void removeFirst(){
        this.head=this.head.getNext();
        len--;
    }
    public void removeLast(){
        NodoListasimple<T> aux=this.head;
        while(aux.getNext()!=this.head){
            aux=aux .getNext();
        }
        aux.setNext(this.head);
        len--;
    }
    /**
     * Metodo para eliminar un elemento en una posicion dada
     * @param pos 
     */
    public void remove(int pos){
        if (pos==0){
            removeFirst();
        }
        else if (this.len%pos==0){
            removeLast();           
        }
        else{
            int cont=1;
            NodoListasimple<T> aux=this.head;
            while (cont<pos){
                cont++;
                aux= aux.getNext();
            }
            aux.setNext(aux.getNext().getNext());
            len--;
        }
    }  

}
