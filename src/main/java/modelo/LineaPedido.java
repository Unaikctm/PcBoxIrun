package modelo;

public class LineaPedido {
	private Pedido pedido;
	private Producto producto;
	private int cantidad;
	
	public LineaPedido() {}
	
	public LineaPedido(Producto producto, Pedido pedido, int cantidad) {
		this.producto = producto;
		this.pedido = pedido;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "LineaPedido [producto=" + producto + ", pedido=" + pedido + ", cantidad=" + cantidad + "]";
	}
	
}
