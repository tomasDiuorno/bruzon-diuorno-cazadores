package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

public class CazadorUrbano extends Cazador {



	public CazadorUrbano(Integer experiencia) {
		super(experiencia);
	}

	@Override
	Boolean puedeCapturar(Profugo profugo) {
		if(this.experiencia > profugo.getInocencia()) {
			if(profugo.getNervioso()==false) {
				return this.capturados.add(profugo);
						}
			}
		return false;
	}

	@Override
	protected void intimidar(Profugo profugo) {
	    super.intimidar(profugo);
	    profugo.setNervioso(false);
	}


}
