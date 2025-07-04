package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

public class CazadorSigiloso extends Cazador {

	public CazadorSigiloso(Integer experiencia) {
		super(experiencia);
		// TODO Auto-generated constructor stub
	}

	@Override
	Boolean puedeCapturar(Profugo profugo) {
		if (this.experiencia > profugo.getInocencia()) {
			if (profugo.getHabilidad() < 50) {// si el profugo tiene menos de 50 de habilidad se captura
				return this.capturados.add(profugo);
			}
		}
		return false;
	}

	@Override
	void intimidar(Profugo profugo) {
		Integer nuevaHabilidad = Math.max(0, profugo.getHabilidad() - 5);
	    Integer nuevaInocencia = Math.max(0, profugo.getInocencia() - 2);
	    profugo.setInocencia(nuevaInocencia);
	    profugo.reducirHabilidad(nuevaHabilidad);
	}

}
