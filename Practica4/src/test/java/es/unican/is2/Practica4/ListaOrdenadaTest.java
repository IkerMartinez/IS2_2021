package es.unican.is2.Practica4;

import static org.junit.Assert.assertTrue;


import static org.junit.Assert.fail;


import org.junit.Before;
import org.junit.Test;

import es.unican.is2.containers.ListaOrdenada;

public class ListaOrdenadaTest {


	private ListaOrdenada<Integer>lista;
	private ListaOrdenada<Integer>lista2;
	private ListaOrdenada<Integer>lista3;
	private ListaOrdenada<Integer>lista4;
	private ListaOrdenada<Integer>lista5;
	private ListaOrdenada<Integer>lista6;
	private ListaOrdenada<Integer>lista7;

	@Before
	public void setUp() throws Exception {
		lista = new ListaOrdenada<Integer>();
		lista2 = new ListaOrdenada<Integer>();
		lista3 = new ListaOrdenada<Integer>();
		lista4 = new ListaOrdenada<Integer>();
		lista5 = new ListaOrdenada<Integer>();
		lista6 = new ListaOrdenada<Integer>();
		lista7 = new ListaOrdenada<Integer>();


	}
	
	@Test
	public void testget() {
		try {
			lista.get(2);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true); // Para asegurar que pasa por el catch
		}
		
		try {
			lista.add(1);
			assertTrue(lista.get(0)==1);

			lista.add(2);
			lista.add(3);
			lista.add(4);
			assertTrue(lista.get(3)==4);

		} catch (Exception e) {
			fail("No deberia lanzar la excepcion");
		}

	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testgetNotValid() {

	    lista4.get(0);

	}

	@Test
	public void testadd() {
		try {
			lista2.add(1);
			assertTrue(lista2.get(0)==1);

			lista2.add(3);
			assertTrue(lista2.get(0)==1);
			assertTrue(lista2.get(1)==3);

			lista2.add(2);
			assertTrue(lista2.get(0)==1);
			assertTrue(lista2.get(1)==2);
			assertTrue(lista2.get(2)==3);

		} catch (Exception e) {
			fail("No deberia lanzar la excepcion");
		}
	}

	@Test
	public void testremove() {
		
		
		
		try {
			lista3.add(2);
			assertTrue(lista3.remove(0)==2);

			lista3.add(1);
			lista3.add(2);
			lista3.add(3);
			lista3.add(4);
			assertTrue(lista3.remove(2)==3);

		} catch (Exception e) {
			fail("No deberia lanzar la excepcion");
		}
		
		try {
			lista.get(2);
		} catch (IndexOutOfBoundsException e) {
			
		}

	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testremoveNotValid() {

		lista5.add(1);
		lista5.add(2);
		lista5.add(3);
	    lista5.remove(4);

	}

	@Test
	public void testclear() {
		try {
			lista7.clear();
			assertTrue(lista7.size()==0);
			
			lista7.add(1);
			assertTrue(lista7.size()==0);
			
			lista7.add(2);
			lista7.add(3);
			lista7.add(4);
			lista7.add(5);
			assertTrue(lista7.size()==0);
			
		} catch (Exception e) {
			fail("No deberia lanzar la excepcion");
		}

	}

	@Test
	public void testsize() {
		try {
			lista6.size();
			assertTrue(lista6.size()==0);
			
			lista6.add(1);
			assertTrue(lista6.size()==1);
			
			
			lista6.add(2);
			lista6.add(3);
			lista6.add(4);
			lista6.add(5);
			assertTrue(lista6.size()==5);
			

		} catch (Exception e) {
			fail("No deberia lanzar la excepcion");
		}
	}


}
