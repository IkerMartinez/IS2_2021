package es.unican.is2.Practica5_refactorizada;

import java.time.LocalDate;

public class Debito extends Tarjeta { // Añadir método check salario disponible. Mantiene WMC incrementa n, so WMCn menor
										// Ini: WMCn=1.33; Fi: WMCn=1.14
	
	private double saldoDiarioDisponible;

	public Debito(String numero, String titular, CuentaAhorro c) {														// WMC +1
		super(numero, titular, c);
	}
	
	
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {								// WMC +1
		
		checkSalarioDisponible(x);
		this.mCuentaAsociada.retirar("Retirada en cajero autom�tico", x);
		saldoDiarioDisponible-=x;
	}
	
	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException {	// WMC +1
		
		checkSalarioDisponible(x);
		this.mCuentaAsociada.retirar("Compra en : " + datos, x);
		saldoDiarioDisponible-=x;
	}
	
	public boolean checkSalarioDisponible(double x) throws saldoInsuficienteException{									// WMC +1
		if (saldoDiarioDisponible < x) {																				// WMC +1	Ccog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		return true;
	}
	
	public LocalDate getCaducidadDebito() {																				// WMC +1
		return this.mCuentaAsociada.getCaducidadDebito();
	}
	
	/**
	 * M�todo invocado autom�ticamente a las 00:00 de cada d�a
	 */
	public void restableceSaldo() {																						// WMC +1
		saldoDiarioDisponible = mCuentaAsociada.getLimiteDebito();
	}
	
	public CuentaAhorro getCuentaAsociada() {																			// WMC +1
		return mCuentaAsociada;
	}

}