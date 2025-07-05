package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AgenciaDeSeguridadTest {
	AgenciaDeSeguridad agencia;

	@Before
	public void setUp() throws Exception {
		agencia = new AgenciaDeSeguridad();
	}

	@Test
	public void queExisteLaAgenciaDeSeguridadDeCazadoresDeRecompenzas() {
		assertNotNull(agencia);
	}

	@Test
	public void queSePuedaObtenerElProfugoMasHabilCapturadoPorCazadorSigiloso() throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazadorUno = new CazadorSigiloso(75);
		Profugo profugoUno = new Profugo(60, 38,true);
		Profugo profugoDos = new Profugo(60, 47,true);
		Profugo profugoTres = new Profugo(60, 27,true);
		Zona zona = new Zona("Texas");
		zona.agregarProfugo(profugoUno);
		zona.agregarProfugo(profugoDos);
		zona.agregarProfugo(profugoTres);
		agencia.agregarCazador(cazadorUno);
		cazadorUno.capturarEnZona(zona);
		Profugo valorEsperado = profugoDos;
		Profugo valorObtenido = agencia.profugoMasHabilCapturado();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	
	@Test
	public void queSePuedanObtenerElCazadorConMasCapturasRealizadas() throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazadorUno = new CazadorSigiloso(75);
		Cazador cazadorDos = new CazadorSigiloso(75);
		Profugo profugoUno = new Profugo(60, 38,true);
		Profugo profugoDos = new Profugo(60, 47,true);
		Profugo profugoTres = new Profugo(60, 27,true);
		Zona zona = new Zona("Texas");
		Zona zonaDos = new Zona("Atlanta");
		zona.agregarProfugo(profugoUno);
		zonaDos.agregarProfugo(profugoDos);
		zonaDos.agregarProfugo(profugoTres);
		agencia.agregarCazador(cazadorUno);
		agencia.agregarCazador(cazadorDos);
		cazadorUno.capturarEnZona(zona);
		cazadorDos.capturarEnZona(zonaDos);
		Cazador valorEsperado = cazadorDos;
		Cazador valorObtenido = agencia.cazadorConMasCapturas();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSeObtenganTodosLosProfugosCapturadosPorSusCazadores() throws NoPuedeSerNerviosoException, HabilidadInvalidaException {
		Cazador cazadorUno = new CazadorSigiloso(75);
		Cazador cazadorDos = new CazadorSigiloso(75);
		Profugo profugoUno = new Profugo(60, 38,true);
		Profugo profugoDos = new Profugo(60, 47,true);
		Profugo profugoTres = new Profugo(60, 27,true);
		Zona zona = new Zona("Texas");
		Zona zonaDos = new Zona("Atlanta");
		zona.agregarProfugo(profugoUno);
		zonaDos.agregarProfugo(profugoDos);
		zonaDos.agregarProfugo(profugoTres);
		agencia.agregarCazador(cazadorUno);
		agencia.agregarCazador(cazadorDos);
		cazadorUno.capturarEnZona(zona);
		cazadorDos.capturarEnZona(zonaDos);
		Map<Cazador, Set<Profugo>> valorObtenido = agencia.capturasPorCazadores();
		assertTrue(valorObtenido.get(cazadorUno).contains(profugoUno));
		assertTrue(valorObtenido.get(cazadorDos).contains(profugoDos));
		assertTrue(valorObtenido.get(cazadorDos).contains(profugoTres));	
	}
	
}
