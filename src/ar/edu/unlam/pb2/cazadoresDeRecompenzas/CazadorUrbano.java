package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

public class CazadorUrbano extends Cazador {



	public CazadorUrbano(Integer experiencia) {
		super(experiencia);
	}

	@Override
	Boolean puedeCapturar(Profugo profugo) {
		if(this.experiencia > profugo.getInocencia()) {
			if(profugo.getNervioso()==false) {//si el profugo no es nervioso urbano lo captura 
				return this.capturados.add(profugo);
				//			}else {
				//				profugo.inocencia(null, experiencia);// aca iria la logica de profugo esto es momentaneo
				//			}
			}
			
		}
		return false;
	}




}
