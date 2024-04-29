package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Pedido {
	private int id;
	private Double total;
	private Date fecha;
	private ArrayList<Producto> productos;
	private Factura factura;

	public Pedido() {}
	
	public Pedido(int id, Date fecha, ArrayList<Producto> productos,Factura factura) {
		this.id = id;
		Double total = 0.0;
		for (Producto producto : productos) {
			total=total+producto.getPrecio();
		}
		this.total = total;
		this.fecha=fecha;
		this.productos = productos;
		this.factura=factura;
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

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", total=" + total + ", fecha=" + fecha + ", productos=" + productos + factura;
	}

}