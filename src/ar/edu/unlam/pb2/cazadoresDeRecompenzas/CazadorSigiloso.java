package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

public class CazadorSigiloso extends Cazador {

	public CazadorSigiloso(Integer experiencia) {
		super(experiencia);

	}

	@Override
	Boolean puedeCapturar(Profugo profugo) throws NoPuedeSerNerviosoException {
		Boolean capturado = false;
		if (!profugo.getCoberturaLegal()) {
			if (this.experiencia > profugo.getInocencia()) {
				if (profugo.getHabilidad() < 50) {// si el profugo tiene menos de 50 de habilidad se captura
					capturado = this.capturados.add(profugo);
				} else {
					intimidar(profugo);
				}
			}
		}
		return capturado;
	}

	@Override
	protected void intimidar(Profugo profugo) throws NoPuedeSerNerviosoException {
		super.intimidar(profugo);
		Integer nuevaHabilidad = Math.max(0, profugo.getHabilidad() - 5);
		profugo.setHabilidad(nuevaHabilidad);
	}

}
