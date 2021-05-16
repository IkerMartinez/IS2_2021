package es.unican.is2.Practica5_refactorizada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class Credito extends Tarjeta {// Añadir método check salario disponible. Mantiene WMC incrementa n, so WMCn menor
										// Ini: WMCn=1.33; Fi: WMCn=1.14
										// Replace Magic Number with Symbolic Constant: retirar 0.05 comision. 
										// Extract method for movimientos mensuales
										// Ini: WMCn=1.33; Fi: WMCn=1.14
	
	private static final double COMISION = 0.05;
	private double credito;
	private List<Movimiento> movimientosMensuales;
	private List<Movimiento> historicoMovimientos;
	
	
	public Credito(String numero, String titular, CuentaAhorro c, double credito) { //			WMC +1
		super(numero, titular, c);
		this.credito = credito;
		this.movimientosMensuales = new LinkedList<Movimiento>();
		this.historicoMovimientos = new LinkedList<Movimiento>();
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. Se aplica una comisi�n del 5%.
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {//	WMC +1
		
		checkDatoErroneo(x);
		
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Retirada en cajero autom�tico");
		x += x * COMISION; // A�adimos una comisi�n de un 5%
		m.setImporte(-x);
		
		if (getGastosAcumulados()+x > credito)											//		WMC +1		Ccog +1
			throw new saldoInsuficienteException("Cr�dito insuficiente");
		else {
			movimientosMensuales.add(m);
		}
	}

	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException {
																						//		WMC +1
		checkDatoErroneo(x);
		
		if (getGastosAcumulados() + x > credito)										//		WMC +1		Ccog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Compra a cr�dito en: " + datos);
		m.setImporte(-x);
		movimientosMensuales.add(m);
	}
	
	public boolean checkDatoErroneo(double x) throws datoErroneoException {				//			WMC +1
		if (x < 0) {																	//			WMC +1	Ccog +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		}
		return true;
	}
	
    public double getGastosAcumulados() {												//		WMC +1
		double r = buscaMovimientoMensual();
		return -r;
	}
	
	
	public LocalDate getCaducidadCredito() {											//		WMC +1
		return this.mCuentaAsociada.getCaducidadCredito();
	}

	/**
	 * M�todo que se invoca autom�ticamente el d�a 1 de cada mes
	 */
	public void liquidar() {															//		WMC +1
		Movimiento liq = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		liq.setFecha(now);
		liq.setConcepto("Liquidaci�n de operaciones tarjeta cr�dito");
		double r = buscaMovimientoMensual();
		liq.setImporte(r);
	
		if (r != 0)																		//		WMC +1		Ccog +1
			mCuentaAsociada.addMovimiento(liq);
		
		historicoMovimientos.addAll(movimientosMensuales);
		movimientosMensuales.clear();
	}
	
	public double buscaMovimientoMensual() {											//			WMC +1
		double r = 0.0;
		for (int i = 0; i < this.movimientosMensuales.size(); i++) {					//			WMC +1	Ccog +1
			Movimiento m = (Movimiento) movimientosMensuales.get(i);
			r += m.getImporte();
		}
		return r;
	}

	public List<Movimiento> getMovimientosUltimoMes() {									//		WMC +1
		return movimientosMensuales;
	}
	
	public Cuenta getCuentaAsociada() {													//		WMC +1
		return mCuentaAsociada;
	}
	
	public List<Movimiento> getMovimientos() {											//		WMC +1
		return historicoMovimientos;
	}

}