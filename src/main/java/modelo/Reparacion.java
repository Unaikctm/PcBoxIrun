package modelo;

public class Reparacion {
	private int id;
	private String tipo;
	private String descripcion;
	private int horas; 
	private double precio;
	private Factura factura;
	
	public Reparacion() {}
	
	public Reparacion(int id, String tipo, String descripcion, int horas, double precio, Factura factura) {
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.horas = horas;
		this.precio = precio;
		this.factura = factura;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Reparacion [id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + ", horas=" + horas
				+ ", precio=" + precio + ", factura=" + factura + "]";
	}
	
	
}
