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
     * 
     * @return retorna el ultimo nodo de la lista
     */

    public NodoListadoble<T> getTail() {
        return tail;
    }

    /**
     * Ingresa la cabeza de la lista
     * @return int len: Retorna el largo de la lista
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
    
     /**
     * Metodo para hacer un print de atras para adelante (invrtido) de los elementos dwe la lista 
     */
    public void pintinvr(){
        NodoListadoble<T> aux= this.tail;
        while(aux !=null){
            System.out.println(aux.getData());
            aux=aux.getPrevius();           
        }         
    }
    
    /**
     * Metodo para conseguir el nodo de una posición de la lista
     * @param pos
     * @return NodoListaDoble
     */
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
     * @return T
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
            temp.setNext(this.tail);
                     
        }
        len++;
        
    }
    
    /**
     * Metodo para eliminar el primer elemento 
     */
    private void removeFirst(){
        this.head=this.head.getNext();
        this.head.setPrevius(null);
        len--;
    }
    
    /**
     * Metodo para eliminar el ultimo elemento 
     */
    private void removeLast(){
        this.tail=this.tail.getPrevius();
        this.tail.setNext(null);
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
            this.removeFirst();
        }
        else if(pos==len-1){
            this.removeLast();
        }
       
        else if (pos>=len){
            System.out.println("indice inexistente");
        }
        else if (pos<(this.getLen())/2 ){
            NodoListadoble<T> aux=this.head;
            for (int cont=0;cont<pos; cont++){              
                aux= aux.getNext();
            }
            aux.getPrevius().setNext(aux.getNext());
            aux.getNext().setPrevius(aux.getPrevius());
            len--;
        }
        else if(pos>(this.getLen())/2 ){
          NodoListadoble<T> aux=this.head;  
          for (int cont=len-1;cont>pos; cont--){              
               aux= aux.getPrevius();
          }
          aux.getPrevius().setNext(aux.getNext());
          aux.getNext().setPrevius(aux.getPrevius());
          len--; 
        }
    }  

    
    
    
}
