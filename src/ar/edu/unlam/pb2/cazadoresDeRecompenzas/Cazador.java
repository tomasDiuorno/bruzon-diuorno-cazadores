package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import java.util.HashSet;
import java.util.Set;

public abstract class Cazador {


    protected Integer experiencia;
    protected Set<Profugo> capturados = new HashSet<>();
	
    public Cazador(Integer experiencia) {
    	this.experiencia = experiencia;
    }
    
	abstract Boolean puedeCapturar(Profugo profugo);//cree clase profugo para los test, pero deberiamos cambiarlos a un tipo Profugo profugo.
	
	 

	 public Integer getCapturados() {
	        return this.capturados.size();
	    }
	 
	
	 
}