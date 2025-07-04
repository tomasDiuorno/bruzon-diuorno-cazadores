package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CazadoresTest {

	@Test
	public void queUnCazadorUrbanoPuedaCapturarUnProfugo() {
		Cazador cazador = new CazadorUrbano(60);
		Profugo profugo =  new Profugo(34,14,false);
		Boolean valorEsperado = true;
		Boolean valorObtenido = cazador.puedeCapturar(profugo);
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queAlCapturarUnProfugoSeRegistreEnCapturados() {
		Cazador cazador = new CazadorUrbano(60);
		Profugo profugo =  new Profugo(34,14,false);
		cazador.puedeCapturar(profugo);
		profugo.getNervioso();
		Integer valorEsperado = 1;
		Integer valorObtenido = cazador.getCapturados();
		assertEquals(valorEsperado,valorObtenido);
	}

	@Test
	public void queUnCazadorRuralPuedaCapturarUnProfugo() {
		Cazador cazador = new CazadorRural(60);
		Profugo profugo =  new Profugo(34,14,false);
		Boolean valorEsperado = false;
		Boolean valorObtenido = cazador.puedeCapturar(profugo);
		assertEquals(valorEsperado,valorObtenido);
	}
	
	
	@Test
	public void queAlCapturarUnProfugoComoCazadorRuralSeRegistreEnCapturados() {
		Cazador cazador = new CazadorRural(60);
		Profugo profugo =  new Profugo(34,14,true);
		cazador.puedeCapturar(profugo);
		profugo.getNervioso();
		Integer valorEsperado = 1;
		Integer valorObtenido = cazador.getCapturados();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queUnCazadorSigilosoPuedaCapturarUnProfugo() {
		Cazador cazador = new CazadorSigiloso(60);
		Profugo profugo =  new Profugo(34,14,false);
		Boolean valorEsperado = true;
		Boolean valorObtenido = cazador.puedeCapturar(profugo);
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queAlCapturarUnProfugoComoCazadorSigilosoSeRegistreEnCapturados() {
		Cazador cazador = new CazadorRural(60);
		Profugo profugo =  new Profugo(34,14,true);
		cazador.puedeCapturar(profugo);
		profugo.getNervioso();
		Integer valorEsperado = 1;
		Integer valorObtenido = cazador.getCapturados();
		assertEquals(valorEsperado,valorObtenido);
	}
	
}