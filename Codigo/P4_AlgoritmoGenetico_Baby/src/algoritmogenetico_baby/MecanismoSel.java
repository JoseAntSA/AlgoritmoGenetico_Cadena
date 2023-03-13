/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico_baby;

import static java.lang.Math.exp;
import java.util.*;

/**
 *
 * @author anton
 */
public class MecanismoSel {
    
    public ArrayList<Integer> seleccionaTorneo(ArrayList<Double> aptitudes, int k){
        
        ArrayList<Integer> seleccionados = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();
        
        //Darle chance a los feos (aptitud + 0.01)
        for(int i=0 ; i<aptitudes.size() ; i++){
            aptitudes.set(i, aptitudes.get(i) + 0.01f);
            indices.add(i);
        }
        
        int cont = 0;
        
        while(cont<k){
            Collections.shuffle(indices);
            for(int i=0 ; i<k ; i+=2){
                if( aptitudes.get(indices.get(i)) > aptitudes.get(indices.get(i+1)) )
                    seleccionados.add(indices.get(i));
                
                else if( aptitudes.get(indices.get(i)) < aptitudes.get(indices.get(i+1)) )
                    seleccionados.add(indices.get(i+1));
                
                else{
                    ArrayList<Integer> igual = new ArrayList<>();
                    igual.add(indices.get(i));
                    igual.add(indices.get(i+1));
                    Collections.shuffle(igual);
                    seleccionados.add(igual.get(0));
                }
                cont++;
                if(cont==k)
                    return seleccionados;
            }
            
        }
        return seleccionados;
    }
    
    public ArrayList<Integer> seleccionaRuleta(ArrayList<Double> aptitudes, int k){
        
        ArrayList<Integer> seleccionados = new ArrayList<>();
        double denom = 0.0f;
        
        //Darle chance a los feos (aptitud + 0.01)
        for(double aptitud : aptitudes){
            aptitud = aptitud + 0.01f;
            denom += aptitud;
        }
        
        ArrayList<Double> probabilidades = new ArrayList<>();
        
        for(int i=0 ; i<aptitudes.size() ; i++){
            probabilidades.add(aptitudes.get(i)/denom);
        }
         
        Random random = new Random();
        int idx = 0;
        double giro = 0.0f;
        double sum = 0.0f;
            
        for(int i=0 ; i<k ; i++){
            giro = random.nextDouble();
            sum = 0.0f;
            for(idx=0 ; idx<aptitudes.size() ; idx++){
                if(sum <= giro)
                    break;
                sum += probabilidades.get(idx); 
            }
            //idx -= 1;
            seleccionados.add(idx);
        }
        
        return seleccionados;
    }
}