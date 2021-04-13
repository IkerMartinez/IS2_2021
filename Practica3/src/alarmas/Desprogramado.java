package alarmas;

public class Desprogramado extends AlarmasState {

	public void alarmaOn(Alarmas context, Alarma a) {
		context.alarmaOn(a);
		context.setState(estadoProgramado);
		estadoProgramado.entryAction(context);
	}
	public void nuevaAlarma(Alarmas context, Alarma a) {
		context.nuevaAlarma(a);
		context.setState(estadoProgramado);
		estadoProgramado.entryAction(context);
	}
	public void borraAlarma(Alarmas context, Alarma a) {
		context.borraAlarma(a);
		
	}
}
