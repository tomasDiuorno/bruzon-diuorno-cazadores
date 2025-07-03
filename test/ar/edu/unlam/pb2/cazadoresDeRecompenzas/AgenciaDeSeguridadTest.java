package ar.edu.unlam.pb2.cazadoresDeRecompenzas;

import static org.junit.Assert.*;

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
}
