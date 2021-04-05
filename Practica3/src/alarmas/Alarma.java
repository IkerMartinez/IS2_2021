package alarmas;

import java.util.Date;

public class Alarma implements Comparable<Alarma>{

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
	
	// Compare two employee objects by their salary
    @Override
    public int compareTo(Alarma a) {
        if(this.getHora().after(a.getHora())) {
            return 1;
        } else if (this.getHora().before(a.getHora())) {
            return -1;
        } else {
            return 0;
        }
    }
}
