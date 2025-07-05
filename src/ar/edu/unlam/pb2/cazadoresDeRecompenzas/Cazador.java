package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Cazador {


    protected Integer experiencia;
    protected Set<Profugo> capturados = new HashSet<>();
    protected Set<Profugo> intimidados = new HashSet<>();
    protected Integer id;
	protected static Integer proximoId=1;
    
    public Cazador(Integer experiencia) {
    	this.experiencia = experiencia;
    	this.id = proximoId++;
    }
    
	abstract Boolean puedeCapturar(Profugo profugo) throws NoPuedeSerNerviosoException;
	
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

	public void capturarEnZona(Zona zona) throws NoPuedeSerNerviosoException {
		Set<Profugo> profugosZona = new HashSet<>(zona.getProfugos());
	    int cantidadCapturados = 0;
	    intimidados.clear(); 

	    for (Profugo profugo : profugosZona) {
	        if (puedeCapturar(profugo)) {
	            capturados.add(profugo);
	            zona.eliminarProfugo(profugo);
	            cantidadCapturados++;
	        } else {
	            intimidados.add(profugo);
	        }
	    }

	    sumarExperiencia(intimidados, cantidadCapturados);
	}
	
	protected void intimidar(Profugo profugo) throws NoPuedeSerNerviosoException {
	    Integer nuevaInocencia = Math.max(0, profugo.getInocencia() - 2);
	    profugo.setInocencia(nuevaInocencia);
	}

	public Integer getcantidadDeCapturados() {
		return this.capturados.size();
	}
	
	public Set<Profugo> getCapturados() {
		return capturados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cazador other = (Cazador) obj;
		return Objects.equals(id, other.id);
	}
	
	
}