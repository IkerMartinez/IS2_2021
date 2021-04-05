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
	public void alarmaOn(Alarmas context) {
		context.alarmaOn();
	}
	
	//TODO Pasarle la alrma que vayamos a apagar y cancelar el timer si la alarma es la más próxima
	public void alarmaOff(Alarmas context) {
		context.alarmaOff();
		
	}
	public void nuevaAlarma(Alarmas context) {
		context.nuevaAlarma();
	}
	public void borraAlarma(Alarmas context, Alarma a) {
		context.eliminaAlarma(a);
		
	}
	
	
	
}
