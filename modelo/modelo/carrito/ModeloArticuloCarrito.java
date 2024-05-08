package modelo.carrito;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import modelo.conexion.Conector;
import modelo.producto.ModeloProducto;

public class ModeloArticuloCarrito extends Conector{

	public ArrayList<ArticuloCarrito> getCarrito(){
		
		ModeloProducto mp = new ModeloProducto();
		ArrayList<ArticuloCarrito> lineaCarritos = new ArrayList<ArticuloCarrito>();
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM carrito");
			
			while(rs.next()) {
				ArticuloCarrito lc = new ArticuloCarrito();
				
				lc.setProducto(mp.getProducto(rs.getInt("ID_Producto")));
				lc.setCantidad(rs.getInt("cantidad"));
				lc.setPrecio(rs.getDouble("precio"));
				
				lineaCarritos.add(lc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return lineaCarritos;
		
	}
	
public ArticuloCarrito getArticulo(int ID_Producto){
		
		ModeloProducto mp = new ModeloProducto();
		
		try {
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM carrito WHERE ID_Producto=?");
			pst.setInt(1, ID_Producto);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				ArticuloCarrito lc = new ArticuloCarrito();
				
				lc.setProducto(mp.getProducto(rs.getInt("ID_Producto")));
				lc.setCantidad(rs.getInt("cantidad"));
				lc.setPrecio(rs.getDouble("precio"));
				
				return lc;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return null;
		
	}

	public void insert(ArticuloCarrito articuloCarrito) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("INSERT INTO carrito (ID_Producto, cantidad,precio) VALUES (?,?,?)");
			int idProducto = articuloCarrito.getProducto().getId();
			pst.setInt(1, idProducto);
			pst.setInt(2, articuloCarrito.getCantidad());
			pst.setDouble(3, articuloCarrito.getPrecio());
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		PreparedStatement pst;
		try {
			pst = this.cn.prepareStatement("DELETE FROM carrito");
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return;
	}
	
	public void deleteArticulo(int id) {

		try {
			PreparedStatement pst = this.cn.prepareStatement("DELETE FROM carrito WHERE ID_Producto=?");
			pst.setInt(1, id);
			pst.execute();
			return;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	} 
	
}
	
