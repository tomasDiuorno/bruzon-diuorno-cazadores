package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

public class Profugo {

	private Integer inocencia;
	private Integer habilidad;
	private Boolean nervioso;
	private Boolean coberturaLegal;

	public Profugo(Integer inocencia, Integer habilidad, Boolean nervioso) {
		this.inocencia = inocencia;
		this.habilidad = habilidad;
		this.nervioso = nervioso;
		this.coberturaLegal = false;
	}

	public void entrenarArtesMarciales() {
		final Integer habilidadMax = 100;
		if((this.habilidad * 2) > habilidadMax) {
			this.habilidad = habilidadMax;
		}else {
			this.habilidad *= 2;
		}
	}

	public void entrenarElite() {
		this.nervioso = false;
	}

	public void proteccionLegal() {
		if(this.inocencia < 40) {
			this.inocencia = 40;
			this.coberturaLegal  = true;
		}
	}

	public Integer getInocencia() {
		return inocencia;
	}

	public Integer getHabilidad() {
		return habilidad;
	}

	public Boolean getNervioso() {
		return nervioso;
	}

	public Boolean getCoberturaLegal() {
		return coberturaLegal;
	}

}
