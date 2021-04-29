package es.unican.is2.Practica4;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SegurosGUITest {
	private FrameFixture demo;

	@Before
	public void setUp() {
		SegurosGUI gui = new SegurosGUI();
		demo = new FrameFixture(gui);
		gui.setVisible(true);	
	}
	
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void test() {
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnCalcular").requireText("CALCULAR");
		demo.textBox("txtFechaUltimoSiniestro").requireText("dd-mm-yyyy");
		
		demo.comboBox("comboCobertura").requireItemCount(3);
		
		demo.textBox("txtPotencia").requireText("75");
		demo.radioButton("btnMinusvalia").requireNotSelected();
		
		demo.textBox("txtPrecio").requireText("");
		
		
		// Prueba 
		
		// Escribimos una fecha de siniestro
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("02-12-2012");
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtPotencia").enterText("120");
		demo.radioButton().click();
		demo.comboBox("comboCobertura").selectItem(0);
		
		demo.button("btnCalcular").click();
		
		demo.textBox("txtPrecio").requireText("");
		
		/*//  Prueba de saludo con nombre
		// Escribimos un nombre
		demo.textBox("txtFechaUltimoSiniestro").enterText("01/01/2021");
		// Pulsamos el botón
		demo.button("btnPulsar").click();		
		// Comprobamos la salida
		demo.textBox("txtSaludo").requireText("¡Hola Patri!");
		
		// Prueba de saludo sin nombre
		demo.textBox("txtNombre").setText("");
		demo.button("btnPulsar").click();
		demo.textBox("txtSaludo").requireText("¡Hola!");*/
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
