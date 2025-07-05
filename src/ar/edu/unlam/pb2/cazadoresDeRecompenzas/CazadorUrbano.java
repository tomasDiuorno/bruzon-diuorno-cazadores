package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

public class CazadorUrbano extends Cazador {

	public CazadorUrbano(Integer experiencia) {
		super(experiencia);
	}

	@Override
	Boolean puedeCapturar(Profugo profugo) throws NoPuedeSerNerviosoException {
		Boolean capturado = false;
		if (!profugo.getCoberturaLegal()) {
			if (this.experiencia > profugo.getInocencia()) {
				if (profugo.getNervioso() == false) {
					capturado = this.capturados.add(profugo);
				}
			} else {
				this.intimidar(profugo);
			}
		}
		return capturado;
	}

	@Override
	protected void intimidar(Profugo profugo) throws NoPuedeSerNerviosoException {
		super.intimidar(profugo);
		profugo.setNervioso(false);
	}

}
