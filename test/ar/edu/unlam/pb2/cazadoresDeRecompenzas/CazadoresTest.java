package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CazadoresTest {

	@Test
	public void queUnCazadorUrbanoPuedaCapturarUnProfugo()
			throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazador = new CazadorUrbano(60);
		Profugo profugo = new Profugo(34, 14, false);
		Boolean valorEsperado = true;
		Boolean valorObtenido = cazador.puedeCapturar(profugo);
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queAlCapturarUnProfugoSeRegistreEnCapturados()
			throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazador = new CazadorUrbano(60);
		Profugo profugo = new Profugo(34, 14, false);
		cazador.puedeCapturar(profugo);
		profugo.getNervioso();
		Integer valorEsperado = 1;
		Integer valorObtenido = cazador.getcantidadDeCapturados();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queUnCazadorRuralPuedaCapturarUnProfugo()
			throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazador = new CazadorRural(60);
		Profugo profugo = new Profugo(34, 14, false);
		Boolean valorEsperado = false;
		Boolean valorObtenido = cazador.puedeCapturar(profugo);
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queAlCapturarUnProfugoComoCazadorRuralSeRegistreEnCapturados()
			throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazador = new CazadorRural(60);
		Profugo profugo = new Profugo(34, 14, true);
		cazador.puedeCapturar(profugo);
		profugo.getNervioso();
		Integer valorEsperado = 1;
		Integer valorObtenido = cazador.getcantidadDeCapturados();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queUnCazadorSigilosoPuedaCapturarUnProfugo()
			throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazador = new CazadorSigiloso(60);
		Profugo profugo = new Profugo(34, 14, false);
		Boolean valorEsperado = true;
		Boolean valorObtenido = cazador.puedeCapturar(profugo);
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queAlCapturarUnProfugoComoCazadorSigilosoSeRegistreEnCapturados()
			throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazador = new CazadorRural(60);
		Profugo profugo = new Profugo(34, 14, true);
		cazador.puedeCapturar(profugo);
		profugo.getNervioso();
		Integer valorEsperado = 1;
		Integer valorObtenido = cazador.getcantidadDeCapturados();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queNoSePuedaCapturarUnProfugoCsonHabilidadMayorA50PorCazadorSigiloso()
			throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazadorUno = new CazadorSigiloso(75);
		Profugo profugoUno = new Profugo(60, 38, true);
		Profugo profugoDos = new Profugo(60, 51, true);
		Boolean valorEsperado = false;
		Boolean valorObtenido = cazadorUno.puedeCapturar(profugoDos);
		assertTrue(cazadorUno.puedeCapturar(profugoUno));
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queUnCazadorSigilosoIntimideAUnProfugoConMayorHabilidad()
			throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Profugo profugo = new Profugo(60, 55, false);
		Cazador cazador = new CazadorSigiloso(75);
		Zona zona = new Zona("Texas");
		zona.agregarProfugo(profugo);
		cazador.capturarEnZona(zona);
		assertTrue(cazador.intimidados.contains(profugo));
		assertEquals(58, profugo.getInocencia().intValue());
		assertEquals(50, profugo.getHabilidad().intValue());
	}

	@Test(expected = NoPuedeSerNerviosoException.class)
	public void queUnCazadorUrbanoNoPuedaCapturarUnProfugoElite()
			throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazador = new CazadorUrbano(30);
		Profugo profugo = new Profugo(34, 14, true);
		profugo.entrenarElite();
		assertFalse(cazador.puedeCapturar(profugo));
	}
	
	@Test()
	public void queUnCazadorNoPuedeCapturarUnProfugoConProteccionLegal()
			throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazador = new CazadorUrbano(30);
		Profugo profugo = new Profugo(34, 14, true);
		profugo.proteccionLegal();
		assertFalse(cazador.puedeCapturar(profugo));
	}

}