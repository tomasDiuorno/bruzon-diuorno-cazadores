package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfugoTest {

	@Test
	public void creoUnProfugoComunYRealizaEntrenamientoEnArtesMarcialesYDuplicaSuHabilidad()
			throws HabilidadInvalidaException {
		Profugo profugoComun = new Profugo(50, 30, false);
		profugoComun.entrenarArtesMarciales();
		Integer habilidadEsperada = 60;

		assertEquals(habilidadEsperada, profugoComun.getHabilidad());
	}

	@Test
	public void creoUnProfugoComunYRealizaEntrenamientoDeEliteYPasaANoEstarNervioso()
			throws HabilidadInvalidaException {
		Profugo profugoComun = new Profugo(70, 30, true);
		profugoComun.entrenarElite();

		assertFalse(profugoComun.getNervioso());
	}

	@Test
	public void creoUnProfugoComunYLeOtorgoProteccionLegal() throws HabilidadInvalidaException {
		Profugo profugoComun = new Profugo(20, 30, false);
		profugoComun.proteccionLegal();
		Integer inocenciaEsperado = 40;

		assertEquals(inocenciaEsperado, profugoComun.getInocencia());
		assertTrue(profugoComun.getCoberturaLegal());
	}

	@Test
	public void creoUnProfugoConHabilidadMayorA50YAlAplicarleEntrenamientoEnArtesMarcialesNoPasaDe100()
			throws HabilidadInvalidaException {
		Profugo profugoComun = new Profugo(30, 60, false);
		Integer habilidadEsperada = 100;
		profugoComun.entrenarArtesMarciales();

		assertEquals(habilidadEsperada, profugoComun.getHabilidad());
	}

	@Test(expected = HabilidadInvalidaException.class)
	public void creoUnProfugoConHabilidadMayorA100YMeArrojaUnaExcepcion() throws HabilidadInvalidaException {
		Profugo profugoComun = new Profugo(30, 101, false);
		assertEquals(Integer.valueOf(101), profugoComun.getHabilidad());
	}

	@Test(expected = HabilidadInvalidaException.class)
	public void creoUnProfugoConHabilidadMayorOIgualA0YMeArrojaUnaExcepcion() throws HabilidadInvalidaException {
		Profugo profugoComun = new Profugo(30, -10, false);
		Profugo profugoComun2 = new Profugo(30, 0, false);
		profugoComun.getHabilidad();
		profugoComun2.getHabilidad();
		assertEquals(Integer.valueOf(-10), profugoComun.getHabilidad());
		assertEquals(Integer.valueOf(0), profugoComun.getHabilidad());
	}
}
