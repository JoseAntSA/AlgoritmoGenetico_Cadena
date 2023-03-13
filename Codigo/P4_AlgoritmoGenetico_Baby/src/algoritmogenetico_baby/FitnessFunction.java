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
public class FitnessFunction {
    
    StringBuilder target;
    
    FitnessFunction(StringBuilder target){
        this.target = target;
    }
    
    public int evaluate(Individuo ind){
        StringBuilder intento = ind.cromosoma;
        int ctr = 0;
        
        for(int i=0 ; i<ind.tam ; i++){
            if(intento.charAt(i) == target.charAt(i))
                ctr++;
        }
        return ctr;
            
    }
}
