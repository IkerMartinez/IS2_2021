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

		// Comprobamos que realice el cálculo mal
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("02-12-2012");

		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("120");

		demo.radioButton().click();
		demo.comboBox("comboCobertura").selectItem(0);

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("900.0");

		// Comprobamos que metiendo un formato de fecha incorrecto salga el mensaje indicado

		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("2012-12-02");

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("Formato de fecha no válido");

		// Comprobamos que metiendo una fecha incorrecta salga el mensaje indicado

		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("02-12-2022");

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("¡Dato de entrada erróneo!");

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
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
