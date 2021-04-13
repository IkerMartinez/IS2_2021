package alarmas;

import java.util.Timer;

public class Programado extends AlarmasState {

	protected Timer timer = new Timer();
	protected ProximaTask proximaTask;
	
	public void entryAction (Alarmas context) {
		if (context.alarmasActivas().size() == 0) {
			context.setState(estadoDesprogramado);
		}
		if (context.alarmaMasProxima() != null) {
			 proximaTask = new ProximaTask(context);
			 timer.schedule(proximaTask, context.alarmaMasProxima().getHora());
		}
		
	}
	public void alarmaOn(Alarmas context, Alarma a) {
		context.activaAlarma(a);
		estadoProgramado.entryAction(context);
	}
	
	public void alarmaOff(Alarmas context, Alarma a) {
		context.desactivaAlarma(a);;
		if (a.equals(context.alarmaMasProxima())) {
			timer.cancel();
			timer = new Timer();
		}
		estadoProgramado.entryAction(context);
		
	}
	public void nuevaAlarma(Alarmas context, Alarma a) {
		context.anhadeAlarma(a);
		estadoProgramado.entryAction(context);
	}
	public void borraAlarma(Alarmas context, Alarma a) {
		context.eliminaAlarma(a);
		if (a.equals(context.alarmaMasProxima())) {
			timer.cancel();
		}
		estadoProgramado.entryAction(context);
		
	}
	
	
	
}
