package alarmas;

public class Alarmas {

	private AlarmasState state;
	
	public Alarmas() {
		state = AlarmasState.init(this);
	}
	
	public void setState(AlarmasState value) {
		this.state = value;
	}
	
	public void activarMelodia() {
		
	}
	public boolean eliminaAlarma(Alarma a) {
		return false;
	}
	public boolean anhadeAlarma(Alarma a) {
		return false;
	}
	public Alarma alarmaMasProxima() {
		return null;
	}
	public void desactivaAlarma(Alarma a) {
		
	}
	public void activaAlarma(Alarma a) {
	}
	public Alarma[] alarmasActivas() {
		return null;
	}
	public Alarma[] alarmasDesactivadas() {
		return null;
	}
	public void desactivarMelodia() {
	}
	public void apagar() {
	}
	public void alarmaOn() {
		
	}
	public void alarmaOff() {
	}
	public void nuevaAlarma() {
	}
	public void borraAlarma() {
	}
	
}
