package colecciones;

import java.util.Objects;

public class Cliente {
	
	
	public Cliente(String nombre, String Nocuenta, double saldo) {
		
		this.nombre=nombre;
		
		this.Nocuenta=Nocuenta;
		
		this.saldo=saldo;
		
		
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNocuenta() {
		return Nocuenta;
	}

	public void setNocuenta(String nocuenta) {
		Nocuenta = nocuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(Nocuenta);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(Nocuenta, other.Nocuenta);
	}



	private String nombre;
	
	private String Nocuenta;
	
	private double saldo;

}
