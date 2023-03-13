/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico_baby;

import java.util.ArrayList;

/**
 *
 * @author anton
 */
public class Poblacion {
    
    public int size, tam;
    public ArrayList<Individuo> poblacion;
    
    Poblacion(int size, int tam){
        this.size = size;
        this.tam = tam;
    }
    
    public void init(){
        poblacion = new ArrayList<>();
        for(int i=0 ; i<size ; i++){
            Individuo ind = new Individuo(tam);
            ind.init();
            poblacion.add(ind);
        }
        
        //this.poblacion = poblacion;
    }
    
}
