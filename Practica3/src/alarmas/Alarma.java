package alarmas;

import java.util.Date;

public class Alarma {

	private  String id;
	private Date hora;
	public Alarma(String id, Date hora) {
		
		this.id = id;
		this.hora = hora;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
}
