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
public class ListaDoble<T>{
    private NodoListadoble<T> head;
    private NodoListadoble<T> tail;
    private int len;

    public ListaDoble() {
        this.head = null;
        this.tail=null;
        this.len = 0;
    }
    /**
     * retorna la cabeza de la lista
     * @return head
     */
    public NodoListadoble<T> getHead() {
        return head;
    }
    /**
     * Ingresa la cabeza de la lista
     * @param head 
     */

    public int getLen() {
        return len;
    }


    
     /**
     * Metodo para hacer un print de los elementos dwe la lista 
     */
    public void print(){
        NodoListadoble<T> aux= head;
        while(aux !=null){
            System.out.println(aux.getData());
            aux=aux.getNext();
            
        }
    
    }
    public NodoListadoble<T> getNodo(int pos){
        NodoListadoble<T> aux=this.head;
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
        NodoListadoble<T> aux=this.head;
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
     * Metodo para agregar un dato al inicio de la lista
     * @param dato 
     */
    public void addFirst(T dato){
        if (this.head==null){
            this.head= new NodoListadoble(dato); 
            this.head.setNext(this.tail);
            this.tail.setPrevius(this.head);
        }
        else{
            NodoListadoble<T> temp= this.head;
            this.head= new NodoListadoble(dato);
            this.head.setNext(temp);
            temp.setPrevius(this.head);
        }
        len++;
    }
    /**
     * Metodo para agregar un dato al final de la Lista
     * @param dato 
     */
    public void addLast(T dato){
        if (this.len==0){
           this.tail=new NodoListadoble(dato);
           this.tail.setPrevius(this.head);
           this.head.setNext(this.tail);
          
        }
        else{
            NodoListadoble<T> temp =this.tail;
            this.tail= new NodoListadoble(dato);
            this.tail.setPrevius(temp);
                     
        }
        len++;
        
    }
    
    /**
     * Metodo para eliminar el primer elemento 
     */
    private void removeFirst(){
        this.head=this.head.getNext();
        len--;
    }
    
    /**
     * Metodo para eliminar el ultimo elemento 
     */
    private void removeLast(){
        this.tail=this.tail.getPrevius();
        len--;
    }
    
    public void addPos(int i,T dato){
        
        if (i==0){
           addFirst(dato);
           return;
        }
        if (i>this.len){
            System.out.println("El indice excede el largo de la lista"); 
            return;
        }
        if (i==this.len){
            this.addLast(dato);
            return;
        }
        int pos = 1;
        NodoListadoble<T> aux=this.head;
        while(pos<i){
            aux=aux.getNext();
            pos++;
        }
        NodoListadoble<T> temp=aux.getNext();
        aux.setNext(new NodoListadoble(dato));
        aux.getNext().setNext(temp);
        aux.getNext().setPrevius(aux);
        temp.setPrevius(aux.getNext());
        

        len++;
    
    }
        /**
     * Metodo para eliminar un elemento en una posicion dada
     * @param pos 
     */
    public void remove(int pos){
        if (pos==0){
            removeFirst();
        }
       
        if (pos>=len){
            System.out.println("indice inexistente");
            return;
        }
        int cont=1;
        if (pos<(this.getLen())/2 ){
            NodoListadoble<T> aux=this.head;
            while (cont<pos){
                cont++;
                aux= aux.getNext();
            }
            aux.setNext(aux.getNext().getNext());
            len--;
        }
    }  

    
    
    
}
