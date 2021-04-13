package alarmas;

public class Desprogramado extends AlarmasState {

	public void alarmaOn(Alarmas context, Alarma a) {
		context.activaAlarma(a);;
		context.setState(estadoProgramado);
		estadoProgramado.entryAction(context);
	}
	public void nuevaAlarma(Alarmas context, Alarma a) {
		context.anhadeAlarma(a);
		context.setState(estadoProgramado);
		estadoProgramado.entryAction(context);
	}
	public void borraAlarma(Alarmas context, Alarma a) {
		context.eliminaAlarma(a);
		
	}
}
