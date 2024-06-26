package modelo.reparacion;

import java.sql.*;
import java.util.ArrayList;

import modelo.cliente.Cliente;
import modelo.conexion.Conector;

public class ModeloReparacion extends Conector{

    
    public ArrayList<Reparacion> getReparaciones() {
        ArrayList<Reparacion> reparaciones = new ArrayList<>();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reparacion");
            while (rs.next()) {
                Reparacion reparacion = new Reparacion();
                reparacion.setId(rs.getInt("id"));
                reparacion.setTipo(rs.getString("tipo"));
                reparacion.setDescripcion(rs.getString("descripcion"));;
                reparacion.setHoras(rs.getInt("horas"));
                reparacion.setPrecio(rs.getDouble("precio"));
                Cliente cliente = new Cliente();
    			cliente.setDni(rs.getString("DNI_cliente"));
    			reparacion.setCliente(cliente);
                reparaciones.add(reparacion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return reparaciones;
    }

    public ArrayList<Reparacion> getReparacionesByDNI(String dni) {
        ArrayList<Reparacion> reparaciones = new ArrayList<>();

        try {
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM reparacion WHERE DNI_Cliente=?");
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	Reparacion reparacion = new Reparacion();
                reparacion.setId(rs.getInt("id"));
                reparacion.setTipo(rs.getString("tipo"));
                reparacion.setDescripcion(rs.getString("descripcion"));;
                reparacion.setHoras(rs.getInt("horas"));
                reparacion.setPrecio(rs.getDouble("precio"));
                Cliente cliente = new Cliente();
    			cliente.setDni(rs.getString("DNI_cliente"));
    			reparacion.setCliente(cliente);
                reparaciones.add(reparacion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return reparaciones;
    }
    
    public Reparacion getReparacion(int id) {
        
        try {
            PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM reparacion WHERE id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            Reparacion reparacion = new Reparacion();
            rs.next();
            reparacion.setId(rs.getInt("id"));
            reparacion.setTipo(rs.getString("tipo"));
            reparacion.setDescripcion(rs.getString("descripcion"));;
            reparacion.setHoras(rs.getInt("horas"));
            reparacion.setPrecio(rs.getDouble("precio"));
            Cliente cliente = new Cliente();
			cliente.setDni(rs.getString("DNI_cliente"));
			reparacion.setCliente(cliente);
            return reparacion;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Reparacion getReparacion(Reparacion r) {
        
        try {
            PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM reparacion WHERE DNI_CLIENTE=? AND Descripcion=?");
            pst.setString(1, r.getCliente().getDni());
            pst.setString(2, r.getDescripcion());
            ResultSet rs = pst.executeQuery();

            Reparacion reparacion = new Reparacion();
            rs.next();
            reparacion.setId(rs.getInt("id"));
            reparacion.setTipo(rs.getString("tipo"));
            reparacion.setDescripcion(rs.getString("descripcion"));;
            reparacion.setHoras(rs.getInt("horas"));
            reparacion.setPrecio(rs.getDouble("precio"));
            Cliente cliente = new Cliente();
			cliente.setDni(rs.getString("DNI_cliente"));
			reparacion.setCliente(cliente);
            return reparacion;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id) {
        try {
            PreparedStatement pst = this.cn.prepareStatement("{call Eliminar_Reparacion(?)}");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public void insert(Reparacion reparacion, String dni) {
        try {
            CallableStatement cs = this.cn.prepareCall("{call Insertar_Reparacion(?, ?, ?, ?, ?, ?, ?)}");

            // Establecer los parámetros del procedimiento almacenado
            cs.setString(1, reparacion.getTipo());
            cs.setString(2, reparacion.getDescripcion());
            cs.setInt(3, reparacion.getHoras());
            cs.setDouble(4, reparacion.getPrecio());
            cs.setDouble(5, (reparacion.getPrecio()*reparacion.getHoras()*1.21)); //total de la factura
            cs.setDate(6, new java.sql.Date(new java.util.Date().getTime()));
            cs.setString(7, dni);

            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void update(Reparacion reparacion) {

		try {
			PreparedStatement pst = this.cn.prepareStatement("UPDATE reparacion SET tipo = ?, descripcion = ?, horas = ?, precio = ? WHERE id = ?");
			pst.setString(1, reparacion.getTipo());
			pst.setString(2, reparacion.getDescripcion());
			pst.setInt(3, reparacion.getHoras());
			pst.setDouble(4, reparacion.getPrecio());
			pst.setInt(5, reparacion.getId());
			
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
