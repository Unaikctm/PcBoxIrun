package modelo.pedido;

import java.util.Date;

import modelo.producto.Producto;

import java.util.ArrayList;

public class Pedido {
	private int id;
	private Double total;
	private Date fecha;
	private ArrayList<Producto> productos;

	public Pedido() {}
	
	public Pedido(int id, Date fecha, ArrayList<Producto> productos) {
		this.id = id;
		Double total = 0.0;
		for (Producto producto : productos) {
			total=total+producto.getPrecio();
		}
        this.total = total;
		this.fecha=fecha;
		this.productos = productos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getTotal() {
		Double total = 0.0;
		for (Producto producto : productos) {
			total=total+producto.getPrecio();
		}
        return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public String getDni() {
		ModeloPedido mp = new ModeloPedido();
		return mp.getDni(this.id);
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", total=" + total + ", fecha=" + fecha + ", productos=" + productos;
	}

}