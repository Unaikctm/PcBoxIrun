package modelo.producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.conexion.Conector;

public class ModeloProducto extends Conector{
	public ArrayList<Producto> getProductos() {
		ArrayList<Producto> productos = new ArrayList<>();

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM producto");
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setTipo(rs.getString("tipo"));
				producto.setMarca(rs.getString("marca"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setStock(rs.getInt("stock"));


				productos.add(producto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return productos;
	}

	public Producto getProducto(int id) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM producto WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setTipo(rs.getString("tipo"));
				producto.setMarca(rs.getString("marca"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setStock(rs.getInt("stock"));

				return producto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Producto getProductoByNombre(String nombre) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM producto WHERE nombre=?");
			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setTipo(rs.getString("tipo"));
				producto.setMarca(rs.getString("marca"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setStock(rs.getInt("stock"));

				return producto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int id) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("DELETE FROM producto WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int update(Producto producto) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("UPDATE producto SET nombre = ?, tipo = ?, marca = ?, precio = ?, stock = ? WHERE id = ?");
			pst.setString(1, producto.getNombre());
			pst.setString(2, producto.getTipo());
			pst.setString(3, producto.getMarca());
			pst.setDouble(4, producto.getPrecio());
			pst.setInt(5, producto.getStock());
			pst.setInt(6, producto.getId());

			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void insert(Producto producto) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("INSERT INTO producto (nombre, tipo, marca, precio, stock) VALUES (?,?,?,?,?)");
			pst.setString(1, producto.getNombre());
			pst.setString(2, producto.getTipo());
			pst.setString(3, producto.getMarca());
			pst.setDouble(4, producto.getPrecio());
			pst.setInt(5, producto.getStock());

			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
