package modelo;

public class Producto {
	private int id;
	private String nombre;
	private String tipo;
	private Double precio;
	private String marca;
	private int stock;
	
	public Producto() {}

	public Producto(int id, String nombre, String tipo, Double precio, String marca, int stock) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return id + ". " + nombre + ", tipo=" + tipo + ", precio=" + precio + ", marca="
				+ marca + ", stock=" + stock;
	}
	
	
}
