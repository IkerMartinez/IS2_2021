package es.unican.is2.Practica4;

import static org.junit.Assert.assertTrue;


import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class SeguroTest {

	private Seguro seguro;
	private Seguro seguro2;
	private Seguro seguro3;
	
	@Before
	public void setUp() throws Exception {
		seguro = new Seguro(80,new Cliente("1234","luis",false),Cobertura.TERCEROS);
		seguro.setFechaUltimoSiniestro(LocalDate.of(2021, 1, 1));
		
		seguro2 = new Seguro(120,new Cliente("1235","elena",true),Cobertura.TODORIESGO);
		seguro2.setFechaUltimoSiniestro(LocalDate.of(2012, 12, 2));
		
		seguro3 = new Seguro(100,new Cliente("1236","paco",false),Cobertura.TERCEROSLUNAS);
		seguro3.setFechaUltimoSiniestro(LocalDate.of(2018, 12, 2));
		
		
	}
	
	@Test
	public void testConstructor() {
		assertTrue(seguro.getPotenciaCV()==80);
		assertTrue(seguro.getTomadorSeguro().getNombre().equals("luis"));
		assertTrue(seguro.getTomadorSeguro().getDni().equals("1234"));
		assertTrue(seguro.getTomadorSeguro().isMinusvalia()==false);
		assertTrue(seguro.getCobertura().equals(Cobertura.TERCEROS));
		
	}
	
	@Test
	public void testPrecio() {
		try {
			seguro.precio();
			System.out.println(seguro.precio());
			assertTrue(seguro.precio()==600);
		} catch (Exception e) {
			fail("No deberia lanzar la excepcion");
		}
		try {
			seguro2.precio();
			assertTrue(seguro2.precio()==900);
		} catch (Exception e2) {
			fail ("No deberia...");
		}
		try {
			seguro3.precio();
			assertTrue(seguro3.precio()==680);
		} catch (Exception e3) {
			fail ("No deberia...");
		}
	}
}
