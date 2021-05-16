package es.unican.is2.Practica5_refactorizada;

import java.util.LinkedList;
import java.util.List;

public class Cliente { // Extract class (direccion); introduce parameter object (direccion); hacer método busca (extract method); 
	
	public String nombre;
	public String calle;
	public String zip;
	public String localidad;
	public String telefono;
	public String dni;
	
    private List<Cuenta> Cuentas = new LinkedList<Cuenta>();

 	public Cliente(String titular, String calle, String zip, String localidad, 
 			String telefono, String dni) {  								//WMC +1
		this.nombre = titular;
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
		this.telefono = telefono;
		this.dni = dni;
	}
	
	public void cambiaDireccion(String calle, String zip, String localidad) { //WMC +1
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
	
	public double getSaldoTotal() { 										//WMC +1
		double total = 0.0;
		for (Cuenta c: Cuentas) {  //										WMC +1		Ccog +1
			if (c instanceof CuentaAhorro) { //								WMC +1		Ccog +2
				total += ((CuentaAhorro) c).getSaldo();
			} else if (c instanceof CuentaValores)  { //					WMC +1		Ccog +2
				for (Valor v: ((CuentaValores) c).getValores()) { //		WMC +1		Ccog +3
					total += v.getCotizacionActual()*v.getNumValores();
				}
			}
		}
		return total;
	}
	
	public void anhadeCuenta(Cuenta c) { 									//WMC +1
		Cuentas.add(c);
	}
	
}