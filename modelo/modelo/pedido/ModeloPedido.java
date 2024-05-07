package modelo.pedido;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.conexion.Conector;
import modelo.lineapedido.ModeloLineaPedido;


public class ModeloPedido extends Conector{

	
	public ArrayList<Pedido> getPedidos() {
		ModeloLineaPedido modeloLineaPedido = new ModeloLineaPedido();
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
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pedidos;
	}

	public ArrayList<Pedido> getPedidosByDNI(String dni) {
		ModeloLineaPedido modeloLineaPedido = new ModeloLineaPedido();
		ArrayList<Pedido> pedidos = new ArrayList<>();

		try {
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM pedido WHERE DNI_Cliente=?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setFecha(rs.getDate("fecha"));
				pedido.setProductos(modeloLineaPedido.getProductosByIdPedido(rs.getInt("id")));
				pedido.getTotal();

				pedidos.add(pedido);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pedidos;
	}
	
	public Pedido getPedido(int id) {
		
		ModeloLineaPedido modeloLineaPedido = new ModeloLineaPedido();
		
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM pedido WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			Pedido pedido = new Pedido();
			rs.next();
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
	
	public String getDni(int id) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT dni_cliente FROM pedido WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			String dni;
			rs.next();
			dni = rs.getString("dni_cliente");
			
			return dni;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean delete(int id) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("{call Eliminar_Pedido(?)}");
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
			cs.setDate(2, new java.sql.Date(pedido.getFecha().getTime()));
			cs.setDouble(3, pedido.getTotal());
			cs.setString(4, dni);

			// Ejecutar el procedimiento almacenado
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

