package es.unican.is2.Practica4;

import static org.junit.Assert.assertTrue;


import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import es.unican.is2.containers.ListaOrdenada;

public class ListaOrdenadaTest {
	
	
	private ListaOrdenada<Integer>lista;
	
	public void setUp() throws Exception {
		lista = new ListaOrdenada<Integer>();
		
	
		
	}
	
	public void testadd() {
		
		lista.
		
	}
	public void testget() {
		
	}

	public void testremove() {
		
	}
	
	public void testclear() {
		try {
			lista.clear();
			assertTrue(lista.size()==0);
		} catch (Exception e) {
			fail("No deberia lanzar la excepcion");
		}
		
	}
	
	public void testsize() {
		try {
			lista.size();
			assertTrue(lista.size()==lista.size());
			
		} catch (Exception e) {
			fail("No deberia lanzar la excepcion");
		}
	}
	
	
}
