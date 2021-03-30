package alarmas;

import java.util.Timer;

public class Sonando extends AlarmasState {
	
	
	protected Timer timer = new Timer();
	protected ApagarTask apagarTask;

	public void entryAction(Alarmas context) {
		context.activarMelodia();
		
	}
	 public void doAction(Alarmas context) {
		 context.eliminaAlarma(context.alarmaMasProxima());
		 apagarTask = new ApagarTask(context);
		 timer.schedule(apagarTask, context.INTERVALO_SONAR);
		 
	 }
	 
	 public void exitAction(Alarmas context) {
		 context.desactivarMelodia();
		 
	 }
	 
	 public void apagar(Alarmas context) {
		 this.exitAction(context);
		 
		 context.setState(estadoProgramado);
		 estadoProgramado.entryAction(context);
	 }
}
