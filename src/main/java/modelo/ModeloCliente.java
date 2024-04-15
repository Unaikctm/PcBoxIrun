package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCliente extends Conector{
	
	 public ArrayList<Cliente> getClientes() {
	        ArrayList<Cliente> clientes = new ArrayList<>();

	        try {
	            Statement st = cn.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM clientes");
	            while (rs.next()) {
	                Cliente cliente = new Cliente();
	                cliente.setDni(rs.getString("id"));
	                cliente.setNombre(rs.getString("nombre"));
	                cliente.setApellido(rs.getString("apellido"));
	                cliente.setDireccion(rs.getString("direccion"));
	                cliente.setTelefono(rs.getInt("telefono"));
	                cliente.setPedidos(null);
	                cliente.setPedidos(null);

	                clientes.add(cliente);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        return clientes;
	    }
}
