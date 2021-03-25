package alarmas;

public class Sonando extends AlarmasState {

	public void entryAction(Alarmas context) {
		context.activarMelodia();
	}
	 public void doAction(Alarmas context) {
		 context.eliminaAlarma(context.alarmaMasProxima());
	 }
	 
	 public void exitAction(Alarmas context) {
		 context.desactivarMelodia();
	 }
	 
	 public void apagar(Alarmas context) {
		 this.exitAction(context);
		 if (context.alarmasActivas().length == 0) {
			 context.setState(estadoDesprogramado);
		 } else {
			 context.setState(estadoProgramado);

		 }
	 }
}
