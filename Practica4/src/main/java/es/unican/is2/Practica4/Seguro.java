package es.unican.is2.Practica4;

import java.util.Date;

public class Seguro {

	//es tipo date la fecha pero no la meto bien al contrsutor y me da error asique ponog int
	private Date fechaUltimoSiniestro;
	private int potenciaCV;
	
	public Cobertura cobertura;
	public Cliente tomadorSeguro;
	
	@SuppressWarnings("serial")
	public static class DatoIncorrectoException extends RuntimeException {
	}
	
	public Seguro( int potenciaCV, Cliente cli, Cobertura cobertura) {
		this.potenciaCV = potenciaCV;
		this.tomadorSeguro = cli;
		this.cobertura =cobertura;
	}

	public Cliente getTomadorSeguro() {
		return tomadorSeguro;
	}

	public void setTomadorSeguro(Cliente tomadorSeguro) {
		this.tomadorSeguro = tomadorSeguro;
	}

	
	public Date getFechaUltimoSiniestro() {
		return fechaUltimoSiniestro;
	}

	public void setFechaUltimoSiniestro(Date fechaUltimoSiniestro) {
		this.fechaUltimoSiniestro = fechaUltimoSiniestro;
	}

	public Cobertura getCobertura() {
		return cobertura;
	}

	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}

	public int getPotenciaCV() {
		return potenciaCV;
	}

	public void setPotenciaCV(int potenciaCV) {
		this.potenciaCV = potenciaCV;
	}
	
	public double precio() throws DatoIncorrectoException{
		Date hoy = new Date();
		double precio = 0;
		switch(cobertura) {
		case TERCEROS:
				precio = 400;
			break;
		case TODORIESGO:
				precio = 1000;
			break;
		case TERCEROSLUNAS:
				precio = 600;
			break;
		}
		if(getPotenciaCV()>110) {
			precio = precio*1.2;
		} else if(getPotenciaCV()>90 && getPotenciaCV()<110) {
			precio = precio*1.05;
		} else if(getPotenciaCV()<0) {
			throw new DatoIncorrectoException();
		}
		if(hoy.getTime() - getFechaUltimoSiniestro().getTime() < 3156000000.0) { //la mierda esta gigante es el numero de milisegundos en 1 año
			precio = precio + 200;
		} else if (hoy.getTime()-getFechaUltimoSiniestro().getTime()>3156000000.0 && hoy.getTime()-getFechaUltimoSiniestro().getTime()<94608000000.0) {
			precio = precio + 50;
		}
		if (tomadorSeguro.isMinusvalia() == true) {
			precio = precio*0.75;
		}
	return precio;
	}
	
}
