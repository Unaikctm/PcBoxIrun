package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloFactura extends Conector{
	
	public ArrayList<Factura> getFacturas() {
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		
		ModeloPedido mP = new ModeloPedido();

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
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM factura WHERE id=? AND tipo_factura=?");
			pst.setInt(1, id);
			pst.setString(2, tipo);
			ResultSet rs = pst.executeQuery();
			System.out.println("LLega aqui");
			if (rs.next()) {
				System.out.println("Encuentra algo");
				Factura factura = new Factura();
				factura.setId(rs.getInt("id"));
				factura.setFecha(rs.getDate("fecha"));
				if ((rs.getString("pagado").equals("Si"))) {
					factura.setPagado(true);
				}else if ((rs.getString("pagado").equals("No"))) {
					factura.setPagado(false);
				}
				factura.setPedido(mP.getPedido(rs.getInt("id")));
				factura.setTotal(factura.getTotal());
				System.out.println(factura);
				return factura;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void pagar(int id, String tipo) {
		Factura factura = getFactura(id, tipo);
		try {
			PreparedStatement pst = this.cn.prepareStatement("UPDATE factura SET pagado = ? WHERE id = ? AND tipo_factura=?");
			
			if (factura.getPagado()==true){
				pst.setString(1, "Si");
			}else if (factura.getPagado()==false) {
				pst.setString(1, "No");
			}
			pst.setInt(2, id);
			pst.setString(3, tipo);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
