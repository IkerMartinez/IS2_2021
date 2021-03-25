package alarmas;

public class Desprogramado extends AlarmasState {

	public void alarmaOn(Alarmas context) {
		context.alarmaOn();
		context.setState(estadoProgramado);
	}
	public void nuevaAlarma(Alarmas context) {
		context.nuevaAlarma();
		context.setState(estadoProgramado);
	}
	public void borraAlarma(Alarmas context) {
		context.borraAlarma();
		
	}
}
