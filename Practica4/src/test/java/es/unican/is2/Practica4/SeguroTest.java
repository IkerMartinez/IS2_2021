package es.unican.is2.Practica4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class SeguroTest {

	private Seguro seguro;
	
	@Before
	public void setUp() throws Exception {
		seguro = new Seguro( 100);
	}
	
	@Test
	public void testConstructor() {
		assertTrue(seguro.getPotenciaCV()==100);
		
	}
	
	@Test
	public void testPrecio() {
		try {
			seguro.precio();
			assertTrue(seguro.precio()==0);
		} catch (Exception e) {
			fail("No deberia lanzar la excepcion");
		}
	}
}
