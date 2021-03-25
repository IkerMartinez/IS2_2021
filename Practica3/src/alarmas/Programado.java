package alarmas;

public class Programado extends AlarmasState {

	public void alarmaOn(Alarmas context) {
		context.alarmaOn();
	}
	public void alarmaOff(Alarmas context) {
		context.alarmaOff();
		if (context.alarmasActivas().length == 0) {
			 context.setState(estadoDesprogramado);
		 }
	}
	public void nuevaAlarma(Alarmas context) {
		context.nuevaAlarma();
	}
	public void borraAlarma(Alarmas context) {
		//context.eliminaAlarma(a);
		if (context.alarmasActivas().length == 0) {
			 context.setState(estadoDesprogramado);
		 }
	}
	
}
