package alarmas;

public class Sonando extends AlarmasState {

	public void entryAction(Alarmas context) {
		context.activarMelodia();
	}
	 public void doAction(Alarmas context) {
		 context.eliminaAlarma(context.alarmaMasProxima());
	 }
	 
	 public void exitAction(Alarmas context) {
		 
	 }
	 
	 public void apagar() {
		 
	 }
}
