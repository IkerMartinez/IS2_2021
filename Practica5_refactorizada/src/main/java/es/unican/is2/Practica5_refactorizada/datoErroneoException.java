package es.unican.is2.practica5_refactorizada;

@SuppressWarnings("serial")
public class DatoErroneoException extends RuntimeException {
	
	public DatoErroneoException (String mensaje) {
		super(mensaje);
	}

}
