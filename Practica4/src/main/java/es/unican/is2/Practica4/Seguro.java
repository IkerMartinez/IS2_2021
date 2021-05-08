package es.unican.is2.Practica4;

import java.time.LocalDate;

public class Seguro {

	//es tipo date la fecha pero no la meto bien al contrsutor y me da error asique ponog int
	private LocalDate fechaUltimoSiniestro;
	private int potenciaCV;
	
	public Cobertura cobertura;
	public Cliente tomadorSeguro;
	
	@SuppressWarnings("serial")
	public static class DatoIncorrectoException extends RuntimeException {
	}
	
	public Seguro( int potenciaCV, Cliente cli, Cobertura cobertura) {
		/*this.potenciaCV = potenciaCV;
		this.tomadorSeguro = cli;
		this.cobertura =cobertura;*/
		
		this.setPotenciaCV(potenciaCV);
		this.setTomadorSeguro(cli);
		this.setCobertura(cobertura);
	}

	public Cliente getTomadorSeguro() {
		return tomadorSeguro;
	}

	public void setTomadorSeguro(Cliente tomadorSeguro) {
		this.tomadorSeguro = tomadorSeguro;
	}

	
	public LocalDate getFechaUltimoSiniestro() {
		return fechaUltimoSiniestro;
	}

	public void setFechaUltimoSiniestro(LocalDate fechaUltimoSiniestro) {
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
		LocalDate hoy = LocalDate.now();
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
		
		if(getFechaUltimoSiniestro().isAfter(hoy)){
			throw new DatoIncorrectoException();
		} else if(getFechaUltimoSiniestro().plusYears(1).isAfter(hoy)) { //la mierda esta gigante es el numero de milisegundos en 1 año
			precio = precio + 200;
		} else if (getFechaUltimoSiniestro().plusYears(3).isAfter(hoy)) {
			precio = precio + 50;
		}
		if (tomadorSeguro.isMinusvalia() == true) {
			precio = precio*0.75;
		}
	return precio;
	}
	
}
