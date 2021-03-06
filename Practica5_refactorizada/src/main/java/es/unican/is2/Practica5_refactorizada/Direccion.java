package es.unican.is2.practica5_refactorizada;

public class Direccion {
	private String calle;
	private String zip;
	private String localidad;

	public Direccion(String calle, String zip, String localidad) {
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
}