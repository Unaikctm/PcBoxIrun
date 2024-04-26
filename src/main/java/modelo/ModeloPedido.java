package modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ModeloPedido extends Conector{
	
	private ModeloLineaPedido modeloLineaPedido = new ModeloLineaPedido();
	
	public ArrayList<Pedido> getPedidos() {
		ArrayList<Pedido> pedidos = new ArrayList<>();

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM pedido");
			while (rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setFecha(rs.getDate("fecha"));
				pedido.setProductos(modeloLineaPedido.getProductosByIdPedido(rs.getInt("id")));
				pedido.getTotal();

				pedidos.add(pedido);
				System.out.println(pedido);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pedidos;
	}

	public Pedido getPedido(int id) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM pedido WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setFecha(rs.getDate("fecha"));
				pedido.setProductos(modeloLineaPedido.getProductosByIdPedido(rs.getInt("id")));
				pedido.getTotal();

				return pedido;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int id) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("DELETE FROM pedido WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public void insert(Pedido pedido, String dni) {
		try {
			CallableStatement cs = this.cn.prepareCall("{call Insertar_Pedido(?, ?, ?, ?)}");

			// Establecer los parámetros del procedimiento almacenado
			cs.setInt(1, pedido.getId());
			cs.setDate(2, pedido.getFecha());
			cs.setDouble(3, pedido.getTotal());
			cs.setString(4, dni);

			// Ejecutar el procedimiento almacenado
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

