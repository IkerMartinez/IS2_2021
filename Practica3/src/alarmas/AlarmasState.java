package alarmas;

public class AlarmasState {

	private static Desprogramado estadoDesprogramado = new Desprogramado();
	
	public static AlarmasState init(Alarmas context) {
		return estadoDesprogramado;
	}
	public void alarmaOn(AlarmasState context) {
		
	}
}
