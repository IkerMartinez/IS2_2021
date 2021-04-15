package es.unican.is2.Practica4;

import java.util.Date;

public class Seguro {

	//es tipo date la fecha pero no la meto bien al contrsutor y me da error asique ponog int
	private int fechaUltimoSiniestro;
	private int potenciaCV;
	
	public Seguro( int potenciaCV) {
		
		this.potenciaCV = potenciaCV;
	}

	public int getFechaUltimoSiniestro() {
		return fechaUltimoSiniestro;
	}

	public void setFechaUltimoSiniestro(int fechaUltimoSiniestro) {
		this.fechaUltimoSiniestro = fechaUltimoSiniestro;
	}

	public int getPotenciaCV() {
		return potenciaCV;
	}

	public void setPotenciaCV(int potenciaCV) {
		this.potenciaCV = potenciaCV;
	}
	
	public double precio() {
		return 0;
	}
	
	
}
