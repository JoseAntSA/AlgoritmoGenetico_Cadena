/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico_baby;

import java.util.Random;

/**
 *
 * @author anton
 */
public class Individuo {
    
    public StringBuilder alfabeto, cromosoma;
    public int tam;
    public Random random = new Random();
    
    Individuo(int tam){
        this.alfabeto = new StringBuilder ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890°!/#$%&/()=?¡¨*][]_:;,.-{}+¿/<>'´ ");
        this.cromosoma = new StringBuilder(tam);
        this.tam = tam;
    }
    
    public void init(){
        int idxChar;
                
        for(int i=0 ; i<tam ; i++){
            idxChar = random.nextInt(alfabeto.length());
            cromosoma.append(alfabeto.charAt(idxChar));
        }
        
    }
    
    public Individuo[] cruza(Individuo mother){
        StringBuilder padre = this.cromosoma;
        StringBuilder madre = mother.cromosoma;
        
        int idx = tam/2;
        
        Individuo hijo1 = new Individuo(tam); 
        Individuo hijo2 = new Individuo(tam);
    
        hijo1.cromosoma.append(padre.substring(0, idx));
        hijo1.cromosoma.append(madre.substring(idx, tam));
        
        hijo2.cromosoma.append(madre.substring(0, idx));
        hijo2.cromosoma.append(padre.substring(idx, tam));
        
        Individuo[] arr = new Individuo[2];
        arr[0] = hijo1;
        arr[1] = hijo2;
        
        return arr;
    } 
    
    public void mutar(){
        int idx = random.nextInt(cromosoma.length());
        int idxChar = random.nextInt(alfabeto.length());
        char cambiar = alfabeto.charAt(idxChar);
        
        this.cromosoma.setCharAt(idx,cambiar);
        
    }
    public StringBuilder str(){ 
        return cromosoma;
    }
    
    
    
    
    
    
}
