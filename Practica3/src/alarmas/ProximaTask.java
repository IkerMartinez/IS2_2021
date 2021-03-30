package alarmas;

import java.util.TimerTask;

public class ProximaTask extends TimerTask {

	private Alarmas context;
	public ProximaTask(Alarmas a) {
		context = a;
	}
	public void run() {
		context.setState(AlarmasState.estadoSonando);
		AlarmasState.estadoSonando.entryAction(context);
		AlarmasState.estadoSonando.doAction(context);
	}
}
