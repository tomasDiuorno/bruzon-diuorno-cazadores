package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import java.util.HashSet;
import java.util.Set;

public class Zona {
	private String nombre;
	private Set<Profugo>profugos; 
	
	public Zona(String nombre) {
		this.nombre = nombre;
		profugos = new HashSet<Profugo>();
	}
	
	public void agregarProfugo(Profugo profugo) {
		profugos.add(profugo);
	}
}
