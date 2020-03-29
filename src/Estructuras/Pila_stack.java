/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author User
 * @param T
 */
public class Pila_stack<T>{
    private NodoListasimple<T> head;

    public Pila_stack(NodoListasimple<T> head) {
        this.head = head;
    }

    public NodoListasimple<T> peek() {
        return head;
    }

    public void push(T dato) {
        NodoListasimple<T> aux= this.head;
        this.head = new NodoListasimple<T>(dato);
        this.head.setNext(aux);
    }
    
    public NodoListasimple<T> pop() {
      NodoListasimple<T> aux= this.head;
      this.head=this.head.getNext();
      return aux;
    }
    
}
