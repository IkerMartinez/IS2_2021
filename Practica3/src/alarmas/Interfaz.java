package alarmas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class Interfaz {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JLabel lblAplicacionDeAlarmas = new JLabel("Aplicacion de Alarmas");
		toolBar.add(lblAplicacionDeAlarmas);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnOff = new JButton("OFF");
		btnOff.setBounds(265, 169, 53, 23);
		panel.add(btnOff);
		
		JButton btnOn = new JButton("ON");
		btnOn.setBounds(351, 169, 47, 23);
		panel.add(btnOn);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(265, 203, 133, 23);
		panel.add(btnEliminar);
		
		JButton btnNewButton = new JButton("Nueva Alarma");
		btnNewButton.setBounds(21, 109, 99, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("!Apagar!");
		btnNewButton_1.setBounds(21, 143, 99, 49);
		panel.add(btnNewButton_1);
		
		JLabel lblIdAlarma = new JLabel("Id Alarma");
		lblIdAlarma.setBounds(21, 24, 46, 14);
		panel.add(lblIdAlarma);
		
		JLabel lblHoraAlarma = new JLabel("Hora Alarma");
		lblHoraAlarma.setBounds(21, 66, 59, 14);
		panel.add(lblHoraAlarma);
		
		textField = new JTextField();
		textField.setBounds(77, 21, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblAlarmasActivas = new JLabel("Alarmas Activas");
		lblAlarmasActivas.setBounds(298, 11, 76, 14);
		panel.add(lblAlarmasActivas);
		
		JLabel lblAlarmasDesactivadas = new JLabel("Alarmas Desactivadas");
		lblAlarmasDesactivadas.setBounds(298, 83, 111, 14);
		panel.add(lblAlarmasDesactivadas);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(286, 33, 112, 47);
		panel.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(286, 111, 112, 47);
		panel.add(textPane_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1618264800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(90, 63, 92, 20);
		panel.add(spinner);
	}
}
