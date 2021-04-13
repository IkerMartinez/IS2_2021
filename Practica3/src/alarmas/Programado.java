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
		context.alarmaOn(a);
	}
	
	//TODO Pasarle la alrma que vayamos a apagar y cancelar el timer si la alarma es la más próxima
	public void alarmaOff(Alarmas context, Alarma a) {
		context.alarmaOff(a);
		
	}
	public void nuevaAlarma(Alarmas context, Alarma a) {
		context.nuevaAlarma(a);
	}
	public void borraAlarma(Alarmas context, Alarma a) {
		context.eliminaAlarma(a);
		
	}
	
	
	
}
