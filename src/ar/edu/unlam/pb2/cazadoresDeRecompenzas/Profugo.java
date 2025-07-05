package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import java.util.Objects;

public class Profugo {

	private Integer inocencia;
	private Integer habilidad;
	private Boolean nervioso;
	private Boolean coberturaLegal;
	private Integer id;
	private Boolean poseeEntrenamientoElite;
	private static Integer proximoId = 1;

	public Profugo(Integer inocencia, Integer habilidad, Boolean nervioso) throws HabilidadInvalidaException {
		this.inocencia = inocencia;
		if (habilidad < 0 || habilidad > 100) {
			throw new HabilidadInvalidaException("La habilidad ingresada no es valida.");
		} else {
			this.habilidad = habilidad;
		}
		this.nervioso = nervioso;
		this.coberturaLegal = false;
		this.poseeEntrenamientoElite = false;
		this.id = proximoId++;
	}

	public void entrenarArtesMarciales() {
		final Integer habilidadMax = 100;
		if ((this.habilidad * 2) > habilidadMax) {
			this.habilidad = habilidadMax;
		} else {
			this.habilidad *= 2;
		}
	}

	public void entrenarElite() {
		this.nervioso = false;
		this.poseeEntrenamientoElite = true;
	}

	public void proteccionLegal() {
		if (this.inocencia < 40) {
			this.inocencia = 40;
			this.coberturaLegal = true;
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

	public void setNervioso(Boolean nervioso) throws NoPuedeSerNerviosoException {
		if (this.poseeEntrenamientoElite) {
			throw new NoPuedeSerNerviosoException("Un profugo con entrenamiento Elite no puede ser nervioso");
		}
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
