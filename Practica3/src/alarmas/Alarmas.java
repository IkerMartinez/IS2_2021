package alarmas;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Alarmas {

	protected final static int INTERVALO_SONAR = 5000;
	private AlarmasState state;
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
		if (alarmasPrioridad.contains(a)) {
			alarmasPrioridad.remove(a);
			return true;
		} else if(buscaAlarmaDesactivada(a.getId()) != null){
			alarmasDesactivadas.remove(a);
			return true;
		}
		
		return false;
	}
	public boolean anhadeAlarma(Alarma a) {
		alarmasPrioridad.add(a);
		return true;
	}
	//TODO Substitute all alarmasActivas por alarmas Prioridad
	public Alarma alarmaMasProxima() {
		return alarmasPrioridad.peek();
	}
	
	public void desactivaAlarma(Alarma a) {
		alarmasPrioridad.remove(a);
		alarmasDesactivadas.add(a);
	}
	public void activaAlarma(Alarma a) {
		alarmasDesactivadas.remove(a);
		alarmasPrioridad.add(a);
	}
	public PriorityQueue<Alarma> alarmasActivas() {
		return alarmasPrioridad;
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
	public void alarmaOn(Alarma a) {
		state.alarmaOn(this,a);
	}
	public void alarmaOff(Alarma a) {
		state.alarmaOff(this,a);
	}
	public void nuevaAlarma(Alarma a) {
		state.nuevaAlarma(this,a);
	}
	public void borraAlarma(Alarma a) {
		state.borraAlarma(this,a);
	}
	
	public Alarma buscaAlarmaDesactivada(String id) {
		for (int i = 0; i < alarmasDesactivadas.size(); i++) {
			if (alarmasDesactivadas.get(i).getId().equals(id)) {
				return alarmasDesactivadas.get(i);
			}
		}
		return null;
	}
	
}
