package alarmas;

import java.util.TimerTask;

public class ApagarTask extends TimerTask {

	private Alarmas context;
	public ApagarTask(Alarmas a) {
		context = a;
	}
	public void run() {
		AlarmasState.estadoSonando.exitAction(context);
		context.setState(AlarmasState.estadoProgramado);
		AlarmasState.estadoProgramado.entryAction(context);
	}
}
