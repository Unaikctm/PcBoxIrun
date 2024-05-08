package modelo.pedido;

import java.util.Date;

import modelo.cliente.Cliente;
import modelo.lineapedido.LineaPedido;

import java.util.ArrayList;

public class Pedido {
	private int id;
	private Date fecha;
	private Cliente cliente;
	
	private ArrayList<LineaPedido> lineapedidos;

	public Pedido() {}
	
	public Pedido(int id, Date fecha, ArrayList<LineaPedido> lineapedidos) {
		this.id = id;
		Double total = 0.0;
		for (LineaPedido lineaPedido : lineapedidos) {
			total=total+(lineaPedido.getProducto().getPrecio()*lineaPedido.getCantidad());
		}
		this.fecha=fecha;
		this.lineapedidos = lineapedidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getTotal() {
		Double total = 0.0;
		for (LineaPedido lineaPedido : lineapedidos) {
			total=total+(lineaPedido.getProducto().getPrecio()*lineaPedido.getCantidad());
		}
        return total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<LineaPedido> getLineapedidos() {
		return lineapedidos;
	}

	public void setLineapedidos(ArrayList<LineaPedido> lineapedidos) {
		this.lineapedidos = lineapedidos;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", total=" + getTotal() + ", fecha=" + fecha;
	}

}