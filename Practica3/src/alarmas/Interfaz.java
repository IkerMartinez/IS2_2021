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
import java.util.Iterator;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz {

	private JFrame frame;
	private JTextField textField;
	private static Alarmas sistemaAlarmas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		sistemaAlarmas = new Alarmas();
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
		frame.setBounds(100, 100, 493, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JLabel lblAplicacionDeAlarmas = new JLabel("Aplicacion de Alarmas");
		toolBar.add(lblAplicacionDeAlarmas);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(286, 33, 112, 76);
		panel.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(286, 145, 112, 82);
		panel.add(textPane_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1618264800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(90, 117, 99, 20);
		panel.add(spinner);
		
		textField = new JTextField();
		textField.setBounds(77, 21, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnOff = new JButton("OFF");
		btnOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Iterator<Alarma> iter = sistemaAlarmas.alarmasActivas().iterator();
				Alarma a=null;
				while(iter.hasNext()) {
					Alarma i = iter.next();
					if(i.getId().equals(textField.getText())) a = i;
				}
				
				sistemaAlarmas.desactivaAlarma(a);
				textPane.setText("");
				for(Alarma i:sistemaAlarmas.alarmasActivas()) {
					textPane.setText(textPane.getText()
							+i.getId()
							+"\n");
				}
				
				textPane_1.setText("");
				for(Alarma i:sistemaAlarmas.alarmasDesactivadas()) {
					textPane_1.setText(textPane_1.getText()
							+i.getId()
							+"\n");
				}
				
			}
		});
		btnOff.setBounds(286, 238, 55, 23);
		panel.add(btnOff);
		
		JButton btnOn = new JButton("ON");
		btnOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Alarma a=sistemaAlarmas.buscaAlarmaDesactivada(textField.getText());
				
				sistemaAlarmas.activaAlarma(a);
				textPane.setText("");
				for(Alarma i:sistemaAlarmas.alarmasActivas()) {
					textPane.setText(textPane.getText()
							+i.getId()
							+"\n");
				}
				
				textPane_1.setText("");
				for(Alarma i:sistemaAlarmas.alarmasDesactivadas()) {
					textPane_1.setText(textPane_1.getText()
							+i.getId()
							+"\n");
				}
			}
		});
		btnOn.setBounds(343, 238, 55, 23);
		panel.add(btnOn);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Iterator<Alarma> iter = sistemaAlarmas.alarmasActivas().iterator();
				Alarma a=null;
				while(iter.hasNext()) {
					Alarma i = iter.next();
					if(i.getId().equals(textField.getText())) a = i;
				}
				
				if(a==null) {
					a = sistemaAlarmas.buscaAlarmaDesactivada(textField.getText());
				}
				
				sistemaAlarmas.borraAlarma(a);
				textPane.setText("");
				for(Alarma i:sistemaAlarmas.alarmasActivas()) {
					textPane.setText(textPane.getText()
							+i.getId()
							+"\n");
				}
				
				textPane_1.setText("");
				for(Alarma i:sistemaAlarmas.alarmasDesactivadas()) {
					textPane_1.setText(textPane_1.getText()
							+i.getId()
							+"\n");
				}
				
			}
		});
		btnEliminar.setBounds(287, 272, 111, 23);
		panel.add(btnEliminar);
		
		JButton btnNewButton = new JButton("Nueva Alarma");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Alarma a = new Alarma(textField.getText(),(Date)spinner.getValue());
				sistemaAlarmas.nuevaAlarma(a);
				textPane.setText("");
				for(Alarma i:sistemaAlarmas.alarmasActivas()) {
					textPane.setText(textPane.getText()
							+i.getId()
							+"\n");
				}
				
			}
		});
		btnNewButton.setBounds(21, 191, 99, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("!Apagar!");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sistemaAlarmas.apagar();
				textPane.setText("");
				for(Alarma i:sistemaAlarmas.alarmasActivas()) {
					textPane.setText(textPane.getText()
							+i.getId()
							+"\n");
				}
				
				textPane_1.setText("");
				for(Alarma i:sistemaAlarmas.alarmasDesactivadas()) {
					textPane_1.setText(textPane_1.getText()
							+i.getId()
							+"\n");
				}
			}
		});
		btnNewButton_1.setBounds(21, 225, 99, 49);
		panel.add(btnNewButton_1);
		
		JLabel lblIdAlarma = new JLabel("Id Alarma");
		lblIdAlarma.setBounds(21, 24, 59, 14);
		panel.add(lblIdAlarma);
		
		JLabel lblHoraAlarma = new JLabel("Hora Alarma");
		lblHoraAlarma.setBounds(21, 120, 59, 14);
		panel.add(lblHoraAlarma);
		
		
		
		JLabel lblAlarmasActivas = new JLabel("Alarmas Activas");
		lblAlarmasActivas.setBounds(286, 11, 119, 14);
		panel.add(lblAlarmasActivas);
		
		JLabel lblAlarmasDesactivadas = new JLabel("Alarmas Desactivadas");
		lblAlarmasDesactivadas.setBounds(286, 120, 134, 14);
		panel.add(lblAlarmasDesactivadas);
		
		
	}
}
