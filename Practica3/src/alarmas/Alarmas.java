package alarmas;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Alarmas {

	protected final static int INTERVALO_SONAR = 5000;
	private AlarmasState state;
	private ArrayList<Alarma> alarmas = new ArrayList<Alarma>();
	private ArrayList<Alarma> alarmasActivas = new ArrayList<Alarma>();
	private ArrayList<Alarma> alarmasDesactivadas = new ArrayList<Alarma>();
	private PriorityQueue<Alarma> alarmasPrioridad = new PriorityQueue<Alarma>();
	
	public Alarmas() {
		state = AlarmasState.init(this);
	}
	
	public void setState(AlarmasState value) {
		this.state = value;
	}
	
	public void activarMelodia() {
		System.out.println("Musica suena");
	}
	public boolean eliminaAlarma(Alarma a) {
		if (buscaAlarma(a.getId()) == a) {
			alarmas.remove(a);
			return true;
		}
		
		return false;
	}
	public boolean anhadeAlarma(Alarma a) {
		alarmas.add(a);
		alarmasActivas.add(a);
		return true;
	}
	//TODO Substitute all alarmasActivas por alarmas Prioridad
	public Alarma alarmaMasProxima() {
		return alarmasPrioridad.poll();
	}
	
	public void desactivaAlarma(Alarma a) {
		alarmasActivas.remove(a);
		alarmasDesactivadas.add(a);
	}
	public void activaAlarma(Alarma a) {
		alarmasDesactivadas.remove(a);
		alarmasActivas.add(a);
	}
	public ArrayList<Alarma> alarmasActivas() {
		return alarmasActivas;
	}
	public ArrayList<Alarma> alarmasDesactivadas() {
		return alarmasDesactivadas;
	}
	
	public void desactivarMelodia() {
		System.out.println("Musica deja de sonar");
	}
	
	public void apagar() {
		state.apagar(this);
	}
	public void alarmaOn() {
		state.alarmaOn(this);
	}
	public void alarmaOff() {
		state.alarmaOff(this);
	}
	public void nuevaAlarma() {
		state.nuevaAlarma(this);
	}
	public void borraAlarma() {
		state.borraAlarma(this);
	}
	
	public Alarma buscaAlarma(String id) {
		for (int i = 0; i < alarmas.size(); i++) {
			if (alarmas.get(i).getId() == id) {
				return alarmas.get(i);
			}
		}
		return null;
	}
}
