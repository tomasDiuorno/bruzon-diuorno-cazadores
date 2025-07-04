package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import java.util.Objects;

public class Profugo {

	private Integer inocencia;
	private Integer habilidad;
	private Boolean nervioso;
	private Boolean coberturaLegal;
	private Integer id;
	private static Integer proximoId=1;
	
	public Profugo(Integer inocencia, Integer habilidad, Boolean nervioso) {
		this.inocencia = inocencia;
		this.habilidad = habilidad;
		this.nervioso = nervioso;
		this.coberturaLegal = false;
		this.id = proximoId++;
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

	public void setInocencia(Integer inocencia) {
		this.inocencia = inocencia;
	}

	public void setNervioso(Boolean nervioso) {
		this.nervioso = nervioso;
	}

	public void setHabilidad(Integer habilidad) {
		this.habilidad = habilidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profugo other = (Profugo) obj;
		return Objects.equals(id, other.id);
	}

	
}
