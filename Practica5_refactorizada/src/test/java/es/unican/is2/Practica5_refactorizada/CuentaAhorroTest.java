package es.unican.is2.practica5_refactorizada;

import java.time.LocalDate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CuentaAhorroTest {
	private CuentaAhorro sut;
	private static Movimiento m1, m2, m3;
	
	@BeforeClass
	public static void inicializarMovimientos() {
		m1 = new Movimiento();
		m1.setImporte(100);
		m2 = new Movimiento();
		m2.setImporte(200);
		m3 = new Movimiento();
		m3.setImporte(1500);
	}

	@Before
	public void setUpBeforeClass() throws Exception {
		sut = new CuentaAhorro("794311", LocalDate.now().plusYears(3), LocalDate.now().plusYears(4));
	}


	@Test
	public void testConstructor() {		
		assertEquals(sut.getCaducidadDebito(),LocalDate.now().plusYears(3));
		assertEquals(sut.getCaducidadCredito(),LocalDate.now().plusYears(4));
		assertTrue(sut.getLimiteDebito()==1000);
		assertEquals(0,sut.getMovimientos().size());
		assertEquals("794311",sut.getNumCuenta());
	}


	@Test
	public void testGetSaldoYAddMovimiento() {
		assertTrue(sut.getSaldo()==0);

		sut.addMovimiento(m1);
		assertTrue(sut.getSaldo()==100);
		
		sut.addMovimiento(m2);
		sut.addMovimiento(m3);
		assertTrue(sut.getSaldo()==1800);
	}


	@Test
	public void testRetirarSinConcepto() {
		
		try {
			sut.retirar(-10);
			fail("Deber�a lanzar DatoErroneoException");
		} catch (DatoErroneoException e) {
		} catch (SaldoInsuficienteException e) {
			fail("Deber�a lanzar DatoErroneoException");
		}
		
		sut.addMovimiento(m1);
		
		try {
			sut.retirar(50);
			assertTrue(sut.getSaldo()==50);
			assertEquals(2,sut.getMovimientos().size());
			assertEquals("Retirada de efectivo",sut.getMovimientos().get(1).getConcepto());
		} catch (DatoErroneoException e) {
			fail("No deber�a lanzar DatoErroneoException");
		} catch (SaldoInsuficienteException e) {
			fail("No deber�a lanzar SaldoInsuficienteException");
		}
		
		
		try {
			sut.retirar(100);
			fail("Deber�a lanzar SaldoInsuficienteException");
		} catch (DatoErroneoException e) {
			fail("Deber�a lanzar SaldoInsuficienteException");
		} catch (SaldoInsuficienteException e) {
			
		}
	
	}
	
	
	@Test
	public void testIngresarSinConcepto () {
	
		// Test ingresar negativo
		try {
			sut.ingresar(-1);
			fail("Deber�a lanzar DatoErroneoException");
		} catch (DatoErroneoException e) {
		}

		// Test ingresar el limite
		try {
			sut.ingresar(0.01);
			assertTrue(sut.getSaldo()==0.01);
			assertEquals(1,sut.getMovimientos().size());
			assertEquals("Ingreso en efectivo",sut.getMovimientos().get(0).getConcepto());
			
			sut.ingresar(100);
			assertTrue(sut.getSaldo()==100.01);
			assertEquals(2,sut.getMovimientos().size());
			
		} catch (DatoErroneoException e) {
			fail("No deber�a lanzar la excepci�n");
		}
		
	}

	
}
