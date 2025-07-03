package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfugoTest {

	@Test
	public void creoUnProfugoComunYRealizaEntrenamientoEnArtesMarcialesYDuplicaSuHabilidad() {
		Profugo profugoComun = new Profugo(50 ,30, false);
		profugoComun.entrenarArtesMarciales();
		Integer habilidadEsperada = 60;
		
		assertEquals(habilidadEsperada, profugoComun.getHabilidad());
	}
	
	@Test
	public void creoUnProfugoComunYRealizaEntrenamientoDeEliteYPasaANoEstarNervioso() {
		Profugo profugoComun = new Profugo(70 ,30, true);
		profugoComun.entrenarElite();
		
		assertFalse(profugoComun.getNervioso());
	}

	@Test
	public void creoUnProfugoComunYLeOtorgoProteccionLegal() {
		Profugo profugoComun = new Profugo(20 ,30, false);
		profugoComun.proteccionLegal();
		Integer inocenciaEsperado = 40;
		
		assertEquals(inocenciaEsperado, profugoComun.getInocencia());
		assertTrue(profugoComun.getCoberturaLegal());
	}
	
	@Test
	public void creoUnProfugoConHabilidadMayorA50YAlAplicarleEntrenamientoEnArtesMarcialesNoPasaDe100() {
		Profugo profugoComun = new Profugo(30 ,60, false);
		Integer habilidadEsperada = 100;
		profugoComun.entrenarArtesMarciales();
		
		assertEquals(habilidadEsperada, profugoComun.getHabilidad());
	}


}
