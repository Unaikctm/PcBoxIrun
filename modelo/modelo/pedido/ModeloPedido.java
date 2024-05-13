package modelo.pedido;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.cliente.Cliente;
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
				pedido.setLineapedidos(modeloLineaPedido.getLineaPedidosByIdPedido(rs.getInt("id")));
				Cliente cliente = new Cliente();
				cliente.setDni(rs.getString("DNI_cliente"));
				pedido.setCliente(cliente);
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
				pedido.setLineapedidos(modeloLineaPedido.getLineaPedidosByIdPedido(rs.getInt("id")));
				Cliente cliente = new Cliente();
				cliente.setDni(rs.getString("DNI_cliente"));
				pedido.setCliente(cliente);
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
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM pedido WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			Pedido pedido = new Pedido();
			rs.next();
			pedido.setId(rs.getInt("id"));
			pedido.setFecha(rs.getDate("fecha"));
			pedido.setLineapedidos(new ModeloLineaPedido().getLineaPedidosByIdPedido(rs.getInt("id")));
			Cliente cliente = new Cliente();
			cliente.setDni(rs.getString("DNI_cliente"));
			pedido.setCliente(cliente);
			pedido.getTotal();
			
			return pedido;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getPedidoId() {
		int id=0;
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT id FROM pedido WHERE id=LAST_INSERT_ID()");

			if(rs.next()) {
				id=rs.getInt("id");
			}
			return id;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
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


	public void insert(Pedido pedido) {
		try {
			CallableStatement cs = this.cn.prepareCall("{call Insertar_Pedido(?, ?)}");
			
			// Establecer los parámetros del procedimiento almacenado
			cs.setDate(1, new java.sql.Date(pedido.getFecha().getTime()));
			cs.setString(2, pedido.getCliente().getDni());

			// Ejecutar el procedimiento almacenado
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

