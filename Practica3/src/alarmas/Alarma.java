package alarmas;

public class Alarma {

	private  String id;
	private int hora;
	public Alarma(String id, int hora) {
		
		this.id = id;
		this.hora = hora;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
}
