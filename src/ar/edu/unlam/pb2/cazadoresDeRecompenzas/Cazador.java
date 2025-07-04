package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import java.util.HashSet;
import java.util.Set;

public abstract class Cazador {


    protected Integer experiencia;
    protected Set<Profugo> capturados = new HashSet<>();
    protected Set<Profugo> intimidados = new HashSet<>();
    
    public Cazador(Integer experiencia) {
    	this.experiencia = experiencia;
    }
    
	abstract Boolean puedeCapturar(Profugo profugo);
	
	public void sumarExperiencia(Set<Profugo> intimidados, Integer cantidadCapturados) {
		Integer minHabilidad = 100;

	    for (Profugo p : intimidados) {
	        if (p.getHabilidad() < minHabilidad) {
	            minHabilidad = p.getHabilidad();
	        }
	    }

	    if (intimidados.isEmpty()) {
	        minHabilidad = 0;
	    }

	    this.experiencia += minHabilidad + (2 * cantidadCapturados);
	}

	public void capturarEnZona(Zona zona) {
		Set<Profugo> profugosZona = new HashSet<>(zona.getProfugos());
	    int cantidadCapturados = 0;
	    intimidados.clear(); 

	    for (Profugo profugo : profugosZona) {
	        if (puedeCapturar(profugo)) {
	            capturados.add(profugo);
	            zona.eliminarProfugo(profugo);
	            cantidadCapturados++;
	        } else {
	            intimidar(profugo);
	            intimidados.add(profugo);
	        }
	    }

	    sumarExperiencia(intimidados, cantidadCapturados);
	}
	
	protected void intimidar(Profugo profugo) {
	    Integer nuevaInocencia = Math.max(0, profugo.getInocencia() - 2);
	    profugo.setInocencia(nuevaInocencia);
	}

	public Integer getCapturados() {
		return this.capturados.size();
	}
	
}