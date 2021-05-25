package es.unican.is2.practica5_refactorizada;

import java.util.LinkedList;
import java.util.List;

public class Cliente { 
	
	private String nombre;
	private Direccion direccion;
	private String telefono;
	private String dni;
	
    private List<Cuenta> cuentas = new LinkedList<Cuenta>();

 	public Cliente(String titular, Direccion direccion, String telefono, String dni) {  								//WMC +1
		this.nombre = titular;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
	}
	
	public void cambiaDireccion(String calle, String zip, String localidad) { //WMC +1
		this.direccion.setCalle(calle);
		this.direccion.setZip(zip);
		this.direccion.setLocalidad(localidad);
	}
	
	public double getSaldoTotal() { 										//WMC +1
		double total = 0.0;
		for (Cuenta c: cuentas) {  //										WMC +1		Ccog +1
			total += getSaldoCuenta(total, c);
		}
		return total;
	}

	private double getSaldoCuenta(double total, Cuenta c) {			//  WMC +1
		if (c instanceof CuentaAhorro) { //								WMC +1		Ccog +1
			total += ((CuentaAhorro) c).getSaldo();
		} else if (c instanceof CuentaValores)  { //					WMC +1		Ccog +1
			for (Valor v: ((CuentaValores) c).getValores()) { //		WMC +1		Ccog +2
				total += v.getCotizacionActual()*v.getNumValores();
			}
		}
		return total;
	}
	
	public void anhadeCuenta(Cuenta c) { 									//WMC +1
		cuentas.add(c);
	}
	
}