package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zona {
	private String nombre;
	private Set<Profugo> profugos;

	public Zona(String nombre) {
		this.nombre = nombre;
		profugos = new HashSet<Profugo>();
	}

	public void agregarProfugo(Profugo profugo) {
		profugos.add(profugo);
	}

	public void eliminarProfugo(Profugo profugo) {
		// agregar exepcion por si el profugo no existe
		profugos.remove(profugo);
	}

	public List<Profugo> getProfugos() {
		List<Profugo> profugosEnZona = new ArrayList<Profugo>();

		for (Profugo p : this.profugos) {
			profugosEnZona.add(p);
		}
		return profugosEnZona;
	}
}
