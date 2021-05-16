package es.unican.is2.Practica5_refactorizada;

import java.time.LocalDateTime;

public class Movimiento { // Rename methods (getI() to getImporte); rename attributes (mConcepto to concepto) 
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;

	public double getI() {								// WMC +1
		return mImporte;
	}

	public String getC() {								// WMC +1
		return mConcepto;
	}

	public void setC(String newMConcepto) {				// WMC +1
		mConcepto = newMConcepto;
	}

	public LocalDateTime getF() {						// WMC +1
		return mFecha;
	}

	public void setF(LocalDateTime newMFecha) {			// WMC +1
		mFecha = newMFecha;
	}

	public void setI(double newMImporte) {				// WMC +1
		mImporte = newMImporte;
	}
}