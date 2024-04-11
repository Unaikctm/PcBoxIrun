package modelo;

import java.util.Date;

public class Factura {
	private int id;
	private Double total;
	private Date fecha;
	private Boolean pagado;
	
	public Factura() {}

	public Factura(int id, Double total, Date fecha, Boolean pagado) {
		this.id = id;
		this.total = total;
		this.fecha = fecha;
		this.pagado = pagado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getTotal() {
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

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	@Override
	public String toString() {
		return id + ", total=" + total + ", fecha=" + fecha + ", pagado=" + pagado + "]";
	}
	
}
