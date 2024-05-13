package modelo.factura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.conexion.Conector;
import modelo.pedido.ModeloPedido;
import modelo.reparacion.ModeloReparacion;

public class ModeloFactura extends Conector{
	
	public ArrayList<Factura> getFacturas() {
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		
		ModeloPedido mP = new ModeloPedido();
		
		ModeloReparacion mr = new ModeloReparacion();

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM factura");
			while (rs.next()) {
				Factura factura = new Factura();
				factura.setId(rs.getInt("id"));
				factura.setFecha(rs.getDate("fecha"));
				if ((rs.getString("pagado").equals("Si"))) {
					factura.setPagado(true);
				}else if ((rs.getString("pagado").equals("No"))) {
					factura.setPagado(false);
				}
				factura.setTipo(rs.getString("tipo_factura"));
				if (factura.getTipo()=="Pedido") {
					factura.setPedido(mP.getPedido(rs.getInt("id")));
				}
				else if (factura.getTipo()=="Reparacion") {
					factura.setReparacion(mr.getReparacion(rs.getInt("id")));
				}
				factura.setPedido(mP.getPedido(rs.getInt("id")));
				factura.setTotal(factura.getTotal());
				facturas.add(factura);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return facturas;
	}

	public Factura getFactura(int id, String tipo) {
		ModeloPedido mP = new ModeloPedido();
		ModeloReparacion mr = new ModeloReparacion();
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM factura WHERE id=? AND tipo_factura=?");
			pst.setInt(1, id);
			pst.setString(2, tipo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Factura factura = new Factura();
				factura.setId(rs.getInt("id"));
				factura.setFecha(rs.getDate("fecha"));
				if ((rs.getString("pagado").equals("Si"))) {
					factura.setPagado(true);
				}else if ((rs.getString("pagado").equals("No"))) {
					factura.setPagado(false);
				}
				factura.setTipo(tipo);
				if (tipo=="Pedido") {
					factura.setPedido(mP.getPedido(rs.getInt("id")));
				}
				else if (tipo=="Reparacion") {
					factura.setReparacion(mr.getReparacion(rs.getInt("id")));
				}
				factura.setTotal(factura.getTotal());
				return factura;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int pagar(int id, String tipo, boolean pagado) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("UPDATE factura SET pagado = ? WHERE id = ? AND tipo_factura=?");
			
			if (pagado==true){
				pst.setString(1, "Si");
			}else if (pagado==false) {
				pst.setString(1, "No");
			}
			pst.setInt(2, id);
			pst.setString(3, tipo);

			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
