package modelo.historico;

import java.util.Date;

import modelo.producto.Producto;

public class Historico {
	private int id;
	private Date mes;
	private Producto producto;
	private int cantidad;
	
	public Historico() {}
	 
	public Historico(int id, Date mes, Producto producto, int cantidad) {
		this.id = id;
		this.mes = mes;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getMes() {
		return mes;
	}
	public void setMes(Date mes) {
		this.mes = mes;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Historico [id=" + id + ", mes=" + mes + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}

}
