package modelo;

import java.util.Date;

public class Factura {
	private int id;
	private Double total;
	private Date fecha;
	private Boolean pagado;
	private Pedido pedido;
	private Reparacion reparacion;
	private String tipo;
	private static final double IVA = 0.21; // Suponiendo un IVA del 21%
	
	public Factura() {}

	public Factura(int id, Date fecha, Boolean pagado, Pedido pedido) {
		this.id = id;
		if (pedido==null) {
			this.total = reparacion.getPrecio()*(1+IVA);
		}
		else if (reparacion==null) {
			this.total = pedido.getTotal()*(1+IVA);
		}
		this.fecha = fecha;
		this.pagado = pagado;
		this.pedido = pedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getTotal() {
		Double total = 0.0;
		if (reparacion==null) {
			total = pedido.getTotal()*(1+IVA);
		}
		//else if (pedido==null) {
				//	total = reparacion.getPrecio()*(1+IVA);
				//}
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
	
	public void pagar() {
		pagado=true;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public static double getIva() {
		return IVA;
	}
	
	public String getTipo(){
		String tipo="";
		if (reparacion==null) {
			tipo = "Pedido";
		}
		return tipo;
	}
	@Override
	public String toString() {
		return id + ", total=" + total + ", fecha=" + fecha + ", pagado=" + pagado + "]";
	}
}
