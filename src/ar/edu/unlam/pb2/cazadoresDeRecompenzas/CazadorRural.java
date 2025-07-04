package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

public class CazadorRural extends Cazador {

	public CazadorRural(Integer experiencia) {
		super(experiencia);
		
	}

	@Override
	Boolean puedeCapturar(Profugo profugo) {
		if(this.experiencia > profugo.getInocencia()) {
			if(profugo.getNervioso()==true) {//si el profugo es nervioso  lo captura 
				return this.capturados.add(profugo);
			}
		}
		return false;
	}

	

}