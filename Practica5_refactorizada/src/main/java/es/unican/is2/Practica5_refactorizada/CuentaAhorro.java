package es.unican.is2.practica5_refactorizada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CuentaAhorro extends Cuenta { 	

	private List<Movimiento> movimientos;
	private LocalDate fechaDeCaducidadTarjetaDebito;
	private LocalDate fechaDeCaducidadTarjetaCredito;
	private double limiteDebito;

	public CuentaAhorro(String numCuenta, LocalDate date, LocalDate date2) {				//	WMC +1
		super(numCuenta);
		this.fechaDeCaducidadTarjetaDebito = date;
		this.fechaDeCaducidadTarjetaCredito = date2;
		movimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}

	public void ingresar(double x) throws DatoErroneoException {							//	WMC +1
		checkIngresarNegativa(x);
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Ingreso en efectivo");
		m.setImporte(x);
		this.movimientos.add(m);
	}

	public void retirar(double x) throws SaldoInsuficienteException, DatoErroneoException {	//	WMC +1
		checkRetirarNegativa(x);
		checkSaldo(x);
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Retirada de efectivo");
		m.setImporte(-x);
		this.movimientos.add(m);
	}

	public void ingresar(String concepto, double x) throws DatoErroneoException {			//	WMC +1
		checkIngresarNegativa(x);
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto(concepto);
		m.setImporte(x);
		this.movimientos.add(m);
	}

	private void checkIngresarNegativa(double x) throws DatoErroneoException {				//	WMC +1
		if (x <= 0)																			//	WMC +1		Ccog +1
			throw new DatoErroneoException("No se puede ingresar una cantidad negativa");
	}

	public void retirar(String concepto, double x) throws SaldoInsuficienteException, DatoErroneoException {//	WMC +1
		checkSaldo(x);
		checkRetirarNegativa(x);
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto(concepto);
		m.setImporte(-x);
		this.movimientos.add(m);
	}

	private void checkRetirarNegativa(double x) throws DatoErroneoException {				//	WMC +1
		if (x <= 0)																			//	WMC +1		Ccog +1
			throw new DatoErroneoException("No se puede retirar una cantidad negativa");
	}

	private void checkSaldo(double x) throws SaldoInsuficienteException {					//	WMC +1
		if (getSaldo() < x)																	//	WMC +1		Ccog +1
			throw new SaldoInsuficienteException("Saldo insuficiente");
	}

	public double getSaldo() {																//	WMC +1
		double r = 0.0;
		for (int i = 0; i < this.movimientos.size(); i++) {								//	WMC +1		Ccog +1
			Movimiento m = movimientos.get(i);
			r += m.getImporte();
		}
		return r;
	}

	public void addMovimiento(Movimiento m) {												//	WMC +1
		movimientos.add(m);
	}

	public List<Movimiento> getMovimientos() {												//	WMC +1
		return movimientos;
	}

	public LocalDate getCaducidadDebito() {													//	WMC +1
		return this.fechaDeCaducidadTarjetaDebito;
	}

	public LocalDate getCaducidadCredito() {												//	WMC +1
		return this.fechaDeCaducidadTarjetaCredito;
	}

	public double getLimiteDebito() {														//	WMC +1
		return limiteDebito;
	}

}