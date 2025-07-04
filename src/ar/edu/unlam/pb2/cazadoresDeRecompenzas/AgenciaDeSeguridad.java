package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AgenciaDeSeguridad {

	private Set<Cazador> cazadores = new HashSet<>();

	public Profugo profugoMasHabilCapturado() {
		Integer maxHabilidad= 0;
		Profugo profugoMasHabil = null;
		for(Cazador cazador : cazadores) {
			for (Profugo profugo : cazador.getCapturados()) {
				if (profugo.getHabilidad()>maxHabilidad) {
					profugoMasHabil = profugo;
					maxHabilidad = profugo.getHabilidad();
				}
			}
		}
		return profugoMasHabil;
	}

	public void agregarCazador(Cazador cazador) {
		this.cazadores.add(cazador);
		
	}

	public Cazador cazadorConMasCapturas() {
		Integer maxCapturados= 0;
		Cazador cazadorConMasCapturas = null;
		for(Cazador cazador : cazadores) {
			if(cazador.getcantidadDeCapturados()>maxCapturados) {
					cazadorConMasCapturas = cazador;
					maxCapturados = cazador.getcantidadDeCapturados();
				}
			}
		return cazadorConMasCapturas;
	}

	public Map<Cazador, Set<Profugo>> capturasPorCazadores() {
		Map<Cazador, Set<Profugo>> resultado = new HashMap<Cazador, Set<Profugo>>(); 
		for(Cazador cazador : cazadores) {
			resultado.put(cazador, cazador.getCapturados());
			}
		return resultado;
	}

	
}