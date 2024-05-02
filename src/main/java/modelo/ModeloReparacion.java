package modelo;

import java.sql.*;
import java.util.ArrayList;

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
                reparacion.setHoras(rs.getInt("id"));
                reparacion.setPrecio(rs.getDouble("precio"));
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
                reparacion.setHoras(rs.getInt("id"));
                reparacion.setPrecio(rs.getDouble("precio"));

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
            reparacion.setHoras(rs.getInt("id"));
            reparacion.setPrecio(rs.getDouble("precio"));

            return reparacion;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getDni(int id) {
        try {
            PreparedStatement pst = this.cn.prepareStatement("SELECT dni_cliente FROM reparacion WHERE id=?");
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
            CallableStatement cs = this.cn.prepareCall("{call Insertar_Reparacion(?, ?, ?, ?, ?, ?, ?, ?)}");

            // Establecer los parámetros del procedimiento almacenado
            cs.setInt(1, reparacion.getId());
            cs.setString(2, reparacion.getTipo());
            cs.setString(3, reparacion.getDescripcion());
            cs.setInt(4, reparacion.getHoras());
            cs.setDouble(5, reparacion.getPrecio());
            cs.setDouble(6, (reparacion.getPrecio()*reparacion.getHoras()*1.21)); //total de la factura
            cs.setDate(7, new java.sql.Date(new java.util.Date().getTime()));
            cs.setString(8, dni);

            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void update(Reparacion reparacion) {

		try {
			PreparedStatement pst = this.cn.prepareStatement("UPDATE reparacion SET tipo = ?, descripcion = ?, horas = ?, precio = ? WHERE dni_cliente = ? AND id = ?");
			pst.setString(1, reparacion.getTipo());
			pst.setString(2, reparacion.getDescripcion());
			pst.setInt(3, reparacion.getHoras());
			pst.setDouble(4, reparacion.getPrecio());
			pst.setString(5, reparacion.getDni());
			pst.setInt(6, reparacion.getId());
			
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
