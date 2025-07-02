package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import java.util.ArrayList;
import java.util.List;

public class Zona {
	private String nombre;
	private List<Profugo>profugos; 
	
	public Zona(String nombre) {
		this.nombre = nombre;
		profugos = new ArrayList<Profugo>();
	}
}
