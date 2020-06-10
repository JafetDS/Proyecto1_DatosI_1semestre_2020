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
 * 
 */
public class MatrizSimple<T> {
    private int rows;
    private int columns;
    private RowMatriz<T> Matriz;
    
    public MatrizSimple(int row,int columns){
        this.rows=row;
        this.columns=columns;
        this.Matriz=new RowMatriz<>(columns);
        
        Matrizbuild();
        
    }

    private void Matrizbuild(){
        RowMatriz<T> Aux=this.Matriz;    
        for(int i=1; i<rows; i++){
            Aux.setNext(new RowMatriz<>(columns));
        }
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the colums
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @param colums the colums to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * @return the Matriz
     */
    public RowMatriz<T> getMatriz() {
        return Matriz;
    }

    /**
     * @param Matriz the Matriz to set
     */
    public void setMatriz(RowMatriz<T> Matriz) {
        this.Matriz = Matriz;
    }
    
    public void setDato(T Dato,int row, int column){
        if (row>rows){
            System.out.print("Indice invalido");
        }
        else if(column>columns){
           System.out.print("Indice invalido"); 
        }
        else{
            RowMatriz<T> aux=this.Matriz;
            for(int i=0; i<row;i++){
                aux=aux.getNext();
            }
            aux.replaceDato(Dato, column);
            
        }
        
    }
}
