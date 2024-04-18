package modelo;

import java.util.ArrayList;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private int codigopostal;
	private String email;
	private int telefono;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Reparacion> reparaciones;
	
	public Cliente() {}
	
	public Cliente(String dni, String nombre, String apellido, String direccion,String email, int telefono,
			ArrayList<Pedido> pedidos, ArrayList<Reparacion> reparaciones) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.pedidos = pedidos;
		this.reparaciones = reparaciones;
	}
	public Cliente(String dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<Reparacion> getReparaciones() {
		return reparaciones;
	}

	public void setReparaciones(ArrayList<Reparacion> reparaciones) {
		this.reparaciones = reparaciones;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", codigopostal=" + codigopostal + ", email=" + email + ", telefono=" + telefono + ", pedidos="
				+ pedidos + ", reparaciones=" + reparaciones + "]";
	}

	
	
}
