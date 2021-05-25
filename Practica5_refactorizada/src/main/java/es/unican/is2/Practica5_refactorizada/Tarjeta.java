package es.unican.is2.practica5_refactorizada;

public abstract class Tarjeta { 
	protected String mNumero;
	protected String mTitular;
	protected CuentaAhorro mCuentaAsociada;

	protected Tarjeta(String numero, String titular, CuentaAhorro c) {										// WMC +1
		mNumero = numero;
		mTitular = titular;
		mCuentaAsociada = c;
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. 
	 * @throws SaldoInsuficienteException
	 * @throws DatoErroneoException
	 */
	public abstract void retirar(double x) throws SaldoInsuficienteException, DatoErroneoException;

	/**
	 * Pago en establecimiento con la tarjeta
	 * @param datos Concepto del pago
	 * @param x Cantidada a pagar
	 * @throws SaldoInsuficienteException
	 * @throws DatoErroneoException
	 */
	public abstract void pagoEnEstablecimiento(String datos, double x)									
			throws SaldoInsuficienteException, DatoErroneoException;
	
}