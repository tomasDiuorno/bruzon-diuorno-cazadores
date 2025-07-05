package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

public class CazadorRural extends Cazador {

	public CazadorRural(Integer experiencia) {
		super(experiencia);

	}

	@Override
	Boolean puedeCapturar(Profugo profugo) throws NoPuedeSerNerviosoException {
		Boolean capturado = false;
		if (!profugo.getCoberturaLegal()) {
			if (this.experiencia > profugo.getInocencia()) {
				if (profugo.getNervioso() == true) {// si el profugo es nervioso lo captura
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
		try {
			profugo.setNervioso(true);
		} catch (NoPuedeSerNerviosoException e) {
			e.printStackTrace();
		}
	}

}