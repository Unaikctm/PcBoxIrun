package modelo.lineapedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.conexion.Conector;
import modelo.pedido.ModeloPedido;
import modelo.pedido.Pedido;
import modelo.producto.ModeloProducto;
import modelo.producto.Producto;

public class ModeloLineaPedido extends Conector{
	
	public ArrayList<LineaPedido> getLineaPedidos() {
		
		
		ModeloPedido modeloPedido = new ModeloPedido();
		ModeloProducto modeloProducto = new ModeloProducto();
		
		ArrayList<LineaPedido> lineapedidos = new ArrayList<LineaPedido>();

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM lineapedido");
			while (rs.next()) {
				LineaPedido lineapedido = new LineaPedido();
				lineapedido.setPedido(modeloPedido.getPedido(rs.getInt("id_pedido")));
				lineapedido.setProducto(modeloProducto.getProducto(rs.getInt("id_producto")));
				lineapedido.setCantidad(rs.getInt("cantidad"));

				lineapedidos.add(lineapedido);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return lineapedidos;
	}

	public ArrayList<LineaPedido> getLineaPedidosByIdPedido(int id_pedido) {
		ModeloProducto modeloProducto = new ModeloProducto();
		ArrayList<LineaPedido> listaLineaPedidos = new ArrayList<LineaPedido>();
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM lineapedido WHERE id_pedido=?");
			pst.setInt(1, id_pedido);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				LineaPedido lineapedido = new LineaPedido();
//				lineapedido.setPedido(modeloPedido.getPedido(rs.getInt("id_pedido")));
				Pedido pedido = new Pedido();
				pedido.setId(id_pedido);
				lineapedido.setPedido(pedido);
				lineapedido.setProducto(modeloProducto.getProducto(rs.getInt("id_producto")));
				lineapedido.setCantidad(rs.getInt("cantidad"));
				
				listaLineaPedidos.add(lineapedido);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listaLineaPedidos;
	}
	
	public ArrayList<LineaPedido> getLineaPedidosByIdProducto(int id_producto) {
		ModeloProducto modeloProducto = new ModeloProducto();
		ArrayList<LineaPedido> listaLineaPedidos = new ArrayList<LineaPedido>();
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM lineapedido WHERE id_producto=?");
			pst.setInt(1, id_producto);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				LineaPedido lineapedido = new LineaPedido();
				lineapedido.setProducto(modeloProducto.getProducto(rs.getInt("id_producto")));
				lineapedido.setCantidad(rs.getInt("cantidad"));
				
				listaLineaPedidos.add(lineapedido);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listaLineaPedidos;
	}
		
	public LineaPedido getLineaPedidoByBothIds(int id_pedido, int id_producto) {
		ModeloProducto modeloProducto = new ModeloProducto();
		
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM lineapedido WHERE id_pedido=? AND id_producto=?");
			pst.setInt(1, id_pedido);
			pst.setInt(2, id_producto);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				LineaPedido lineapedido = new LineaPedido();
				//lineapedido.setPedido(modeloPedido.getPedido(rs.getInt("id_pedido")));
				Pedido pedido = new Pedido();
				pedido.setId(id_pedido);
				lineapedido.setPedido(pedido);
				lineapedido.setProducto(modeloProducto.getProducto(rs.getInt("id_producto")));
				lineapedido.setCantidad(rs.getInt("cantidad"));

				return lineapedido;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
		
	public ArrayList<Producto> getProductosByIdPedido(int id_pedido) {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		ModeloProducto modeloProducto = new ModeloProducto();
		
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT id_producto FROM lineapedido WHERE id_pedido=?");
			pst.setInt(1, id_pedido);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Producto producto = new Producto();
				producto=modeloProducto.getProducto(rs.getInt("id_producto"));
				productos.add(producto);
			}
			return productos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}

	public boolean delete(int id_pedido) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("DELETE FROM lineapedido WHERE id_pedido=?");
			pst.setInt(1, id_pedido);
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int update(LineaPedido lineaPedido) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("UPDATE lineapedido SET id_producto = ?, cantidad = ? WHERE id_pedido=?");
			pst.setInt(1, lineaPedido.getProducto().getId());
			pst.setInt(2, lineaPedido.getCantidad());
			pst.setInt(3, lineaPedido.getPedido().getId());

			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void insert(LineaPedido lineaPedido) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("INSERT INTO lineaPedido (id_pedido, id_producto, cantidad) VALUES (?,?,?)");
			pst.setInt(1, lineaPedido.getPedido().getId());
			pst.setInt(2, lineaPedido.getProducto().getId());
			pst.setInt(3, lineaPedido.getCantidad());

			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
