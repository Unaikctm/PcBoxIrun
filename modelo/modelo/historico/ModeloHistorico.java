package modelo.historico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.conexion.Conector;
import modelo.producto.ModeloProducto;

public class ModeloHistorico extends Conector{
	
	public ArrayList<Historico> getHistoricos() {

		ModeloProducto modeloProducto = new ModeloProducto();
		
		ArrayList<Historico> historicos = new ArrayList<Historico>();

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM historico");
			while (rs.next()) {
				Historico historico= new Historico();
				historico.setId(rs.getInt("id"));
				historico.setMes(rs.getDate("mes"));
				historico.setProducto(modeloProducto.getProducto(rs.getInt("id_producto")));
				historico.setCantidad(rs.getInt("cantidad_vendida"));
				
				historicos.add(historico);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return historicos;
	}

	public Historico getHistorico(int id) {
		
		ModeloProducto modeloProducto = new ModeloProducto();
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM historico WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Historico historico= new Historico();
				historico.setId(rs.getInt("id"));
				historico.setMes(rs.getDate("mes"));
				historico.setProducto(modeloProducto.getProducto(rs.getInt("id_producto")));
				historico.setCantidad(rs.getInt("cantidad_vendida"));

				return historico;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
