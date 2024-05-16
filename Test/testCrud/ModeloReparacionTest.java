package testCrud;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.cliente.Cliente;
import modelo.reparacion.ModeloReparacion;
import modelo.reparacion.Reparacion;

class ModeloReparacionTest {

	@Test
	void testInsertarUpdateDelete() {
		
		ModeloReparacion mr = new ModeloReparacion();
		Reparacion reparacion = new Reparacion();
		Cliente cliente = new Cliente();
		
		String dni = "12345678J";
		cliente.setDni(dni);
		reparacion.setCliente(cliente);
		reparacion.setTipo("lk");
		reparacion.setDescripcion("descripcion");
		reparacion.setHoras(2);
		reparacion.setPrecio(100.0);
		
		mr.insert(reparacion, dni);
		mr.update(reparacion);
		mr.delete(reparacion.getId());
	}
	
	@Test
	void testGetReparaciones() {
		
		ModeloReparacion mr = new ModeloReparacion();
		mr.getReparaciones();
		
	}
	
	@Test
	void testGetReparacionesByDNI() {
		
		ModeloReparacion mr = new ModeloReparacion();
		mr.getReparacionesByDNI("21376754C");
		
	}
	
	@Test
	void testGetReparacion() {
		
		ModeloReparacion mr = new ModeloReparacion();
		mr.getReparacion(1);
		
	}
	
}
