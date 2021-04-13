package alarmas;

public abstract class AlarmasState {

	protected static Desprogramado estadoDesprogramado = new Desprogramado();
	protected static Programado estadoProgramado = new Programado();
	protected static Sonando estadoSonando = new Sonando();
	
	public static AlarmasState init(Alarmas context) {
		return estadoDesprogramado;
	}
	public void alarmaOn(Alarmas context, Alarma a) {
		
	}
	 public void alarmaOff(Alarmas context, Alarma a) {
		 
	 }
	 public void apagar(Alarmas context) {
		 
	 }
	 public void nuevaAlarma(Alarmas context, Alarma a) {
		 
	 }
	 public void borraAlarma(Alarmas context, Alarma a) {
		 
	 }
	 public void entryAction(Alarmas context) {
		 
	 }
	 public void doAction(Alarmas context) {
	 }
	 public void exitAction(Alarmas context) {
		 
	 }
	 
	 public static AlarmasState getEstadoProgramado() {
		 return estadoProgramado;
	 }
	 public static AlarmasState getEstadoSonando() {
		 return estadoSonando;
	 }
	 public static AlarmasState getEstadoDesprogramado() {
		 return estadoDesprogramado;
	 }
}
