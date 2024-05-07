package modelo;

public class ArticuloCarrito {

	private Producto producto;
	private int cantidad;
	private double precio;
	
	public ArticuloCarrito() {}

	public ArticuloCarrito(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return this.producto;
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
	

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ArticuloCarrito [id_producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + ",]";
	}


	
}