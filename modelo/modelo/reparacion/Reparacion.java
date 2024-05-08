package modelo.reparacion;

import modelo.cliente.Cliente;

public class Reparacion {
	private int id;
	private String tipo;
	private String descripcion;
	private int horas; 
	private Double precio;
	private Cliente cliente;

	public Reparacion() {}
	
	public Reparacion(int id, String tipo, String descripcion, int horas, Double precio) {
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.horas = horas;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Reparacion [id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + ", horas=" + horas
				+ ", precio=" + precio;
	}
	
	
}
