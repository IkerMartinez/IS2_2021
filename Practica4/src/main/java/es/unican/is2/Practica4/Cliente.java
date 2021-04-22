package es.unican.is2.Practica4;

public class Cliente {

	private String dni;
	private String nombre;
	private boolean minusvalia;
	
	public Cliente(String dni, String nombre, boolean minusvalia) {
		this.dni = dni;
		this.nombre = nombre;
		this.minusvalia = minusvalia;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isMinusvalia() {
		return minusvalia;
	}

	public void setMinusvalia(boolean minusvalia) {
		this.minusvalia = minusvalia;
	}
	
	
}
