/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico_baby;

/**
 *
 * @author anton
 */
public class Probabilidad implements Comparable<Probabilidad> {
    
    private int idx;
    private double probabilidad;
    
    Probabilidad(int idx, double probabilidad){
        this.idx = idx;
        this.probabilidad = probabilidad;
    }
    
    public int getIdx(){
        return idx;
    }
    public double getProbabilidad(){
        return probabilidad;
    }
    
    //Metodo sobreescritos de la interfaz
    @Override
    public int compareTo( Probabilidad obj ){

        if(this.getProbabilidad() < obj.getProbabilidad()){
            return 1;
        }
        else if(this.getProbabilidad() > obj.getProbabilidad()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
