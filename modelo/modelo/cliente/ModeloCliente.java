package modelo.cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.conexion.Conector;
import modelo.pedido.ModeloPedido;

public class ModeloCliente extends Conector{

	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> clientes = new ArrayList<>();

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cliente");
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setDni(rs.getString("dni"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setCodigopostal(rs.getInt("codigopostal"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefono(rs.getInt("telefono"));
				cliente.setPedidos(new ModeloPedido().getPedidosByDNI(rs.getString("dni")));

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return clientes;
	}

	public Cliente getCliente(String dni) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM cliente WHERE dni=?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setDni(rs.getString("dni"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setCodigopostal(rs.getInt("codigopostal"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefono(rs.getInt("telefono"));
				cliente.setPedidos(new ModeloPedido().getPedidosByDNI(rs.getString("dni")));


				return cliente;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(String dni) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("DELETE FROM cliente WHERE dni=?");
			pst.setString(1, dni);
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	} 

	public int update(Cliente cliente) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("UPDATE cliente SET nombre = ?, apellido = ?, direccion = ?, codigopostal = ?, email = ?, telefono = ? WHERE dni = ?");
			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getApellido());
			pst.setString(3, cliente.getDireccion());
			pst.setInt(4, cliente.getCodigopostal());
			pst.setString(5, cliente.getEmail());
			pst.setInt(6, cliente.getTelefono());
			pst.setString(7, cliente.getDni());

			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void insert(Cliente cliente) {
		try {
			PreparedStatement pst = this.cn.prepareStatement("INSERT INTO cliente (dni, nombre, apellido, direccion, codigopostal, email, telefono) VALUES (?,?,?,?,?,?,?)");
			pst.setString(1, cliente.getDni());
			pst.setString(2, cliente.getNombre());
			pst.setString(3, cliente.getApellido());
			pst.setString(4, cliente.getDireccion());
			pst.setInt(5, cliente.getCodigopostal());
			pst.setString(6, cliente.getEmail());
			pst.setInt(7, cliente.getTelefono());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean testDNI(String dni) {

		try {
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM cliente WHERE dni=?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}