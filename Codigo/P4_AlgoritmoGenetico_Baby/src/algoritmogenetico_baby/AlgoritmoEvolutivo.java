/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico_baby;

import java.util.*;

/**
 *
 * @author anton
 */
public class AlgoritmoEvolutivo {
    int size;
    StringBuilder target;
    Poblacion pob;
    FitnessFunction ff;
    MecanismoSel seleccion;
    Random random = new Random();
    boolean criterioParo;
    
    AlgoritmoEvolutivo(int size, StringBuilder target){
        this.size = size;
        this.pob = null;
        this.target = target;
        criterioParo = false;
    }
    
    public void init(){
        pob = new Poblacion(size, target.length());
        pob.init();
        ff = new FitnessFunction(target);
        seleccion = new MecanismoSel();
    }
    
    public StringBuilder showPob(Boolean showAptitude, ArrayList<Individuo> poblacion ){

        int cant = 0;
        double aptitude;
        StringBuilder cad = new StringBuilder("");  
        
        if(poblacion.size()>1000){
            cant = 1000;
        }else{
            cant = poblacion.size();
        }
        
        if(showAptitude){  
            int spa = 0;
            if(target.length()<10)
                spa = 10 - target.length();
            
            for(int i=0 ; i<cant ; i++){
                aptitude = (double)ff.evaluate(poblacion.get(i));
                cad.append("\t" + poblacion.get(i).str());
                
                for(int j=0 ; j<spa ; j++)
                    cad.append(" ");
                
                cad.append("  --->  " + aptitude + "\n");
            }
        }else{
            for(int i=0 ; i<cant ; i++){
                cad.append("\t" + poblacion.get(i).str() + "\n"); 
            }
        }
        return cad;
    }
    
    public StringBuilder showInd(Boolean showAptitude, Individuo ind ){
        
        double aptitude;
        StringBuilder cad = new StringBuilder("");       
        
        if(showAptitude){
            //System.out.println(i+ " "+poblacion.get(i).str() + " --> " + aptitudes.get(i));
            int spa = 0;
            if(target.length()<10)
                spa = 10 - target.length();
    
            aptitude = (double)ff.evaluate(ind);
            cad.append("\t" + ind.str());
            
            for(int i=0 ; i<spa ; i++)
                cad.append(" ");
            
            cad.append("  --->  " + aptitude + "\n");
        }else{
            //System.out.println(poblacion.get(i).str());
            cad.append("\t" + ind.str() + "\n");
        }
        return cad;
    }
    
    public StringBuilder evolucion(boolean all){
        //1) Evaluar individuos
        //2) Seleccionar padres para cruza
        //3) Generar hijos (cruza)
        //5) Evaluar hijos
        //6) Seleccionar miembros de la siguiente poblacion
    
        // Implementacion
        
        //1) Evaluar individuos
        ArrayList<Individuo> poblacion = this.pob.poblacion;
        ArrayList<Double> aptitudes = new ArrayList<>();
        
        for(int i=0 ; i<size ; i++){
                aptitudes.add((double)ff.evaluate(poblacion.get(i)));
        }
        
        Individuo indMejor;
        StringBuilder cad = new StringBuilder("");
        StringBuilder pobTotal = new StringBuilder("");
        
        if(all){
            //Imprime poblacion entera
            pobTotal = showPob(true, poblacion);
        }else{
            //Mejor individuo de poblacion actual
            indMejor = mejorInd(poblacion, aptitudes);
            cad = showInd(true, indMejor);
        }
        
        //2) Seleccionar padres para cruza
        int k = poblacion.size()/2;
        
        if(k%2 == 1)
            k += 1;
           
        ArrayList<Integer> idx = seleccion.seleccionaTorneo(aptitudes,k);
        
        //3) Generar hijos (cruza)
        ArrayList<Individuo> descendencia = new ArrayList<>();
        
        for(int i=0 ; i<k-1 ; i+=2){
            int idxPapa = idx.get(i);
            int idxMama = idx.get(i+1);
            
            Individuo papa = poblacion.get(idxPapa);
            Individuo mama = poblacion.get(idxMama);
            
            Individuo hijos[] = papa.cruza(mama);
            
            descendencia.add(hijos[0]);
            descendencia.add(hijos[1]);
        }
        
        // 4) Mutar a algunos (5%)
        int totalMutar = (int)(Math.ceil(descendencia.size()*0.1));
        int idxMutar;
        
        for(int i=0 ; i<totalMutar ; i++){
            idxMutar = random.nextInt(descendencia.size());
            descendencia.get(idxMutar).mutar();
        }        
        
        //5) Evaluar hijos
        //6) Seleccionar miembros de la siguiente poblacion
        //Junto padres e hijos
        for(int i=0 ; i<descendencia.size() ; i++)
            poblacion.add(descendencia.get(i));
        
        //Calculo aptitudes de todos
        aptitudes.clear();
        for(int i=0 ; i<poblacion.size() ; i++){
                aptitudes.add((double)ff.evaluate(poblacion.get(i)));
        }
        
        //Creo la lista de individuos para la siguiente generacion
        ArrayList<Individuo> siguientePob = new ArrayList<>();
       
        //####### ELITISMO ######
        //El mejor pasa directamente a la siguiente poblacion
        indMejor = mejorInd(poblacion, aptitudes);
        siguientePob.add(indMejor);
        
        idx = seleccion.seleccionaTorneo(aptitudes,size);
        
        //# Creo la lista de individuos para la siguiente generacion
        for(int i=0 ; i<size-1; i++)
            siguientePob.add(poblacion.get(idx.get(i)));
        
        this.pob.poblacion = siguientePob;
        
        if(all){
            return pobTotal;
        }else{
            return cad;
        }
        
    }
       
    public Individuo mejorInd(ArrayList<Individuo> poblacion, ArrayList<Double> aptitudes){
        //Mejor individuo de poblacion
        double aptMax = Collections.max(aptitudes);
        int idxMejor = aptitudes.indexOf(aptMax);
        
        if(aptMax == target.length())
            criterioParo = true;
        
        return poblacion.get(idxMejor);
    }   
    
    
    
}
