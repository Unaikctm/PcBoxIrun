package testCrud;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import modelo.cliente.Cliente;
import modelo.cliente.ModeloCliente;
import modelo.pedido.ModeloPedido;

public class ModeloClienteTest {

	@Test
	public void testInsertUpdateDelete() {
	
	ModeloCliente mc = new ModeloCliente();
	Cliente cliente = new Cliente("12345678M","Pac","Oloco");
	cliente.setDireccion("Calle palomino");
	cliente.setEmail("pacoloco@gmail.com");
	cliente.setTelefono(600672270);
	
	mc.insert(cliente);
	
	cliente.setNombre("Paco");
	cliente.setApellido("Jones");
	
	mc.update(cliente);
	mc.delete(cliente.getDni());
	
	}
	
	@Test
	public void getClientes() {
		
		ModeloCliente mc = new ModeloCliente();
		mc.getClientes();
		
	}
	
	@Test
	public void getCliente() {
		
		ModeloCliente mc = new ModeloCliente();
		Cliente cliente = new Cliente();
		cliente.setDni("12345678M");
		cliente.setNombre("Pac");
		cliente.setApellido("Oloco");	
		cliente.setDireccion("Calle palomino");
		cliente.setEmail("pacoloco@gmail.com");
		cliente.setTelefono(600672270);
		
		mc.getCliente(cliente.getDni());
		
	}
	
	@Test
	public void testDNI() {
		
		ModeloCliente mc = new ModeloCliente();
		Cliente cliente = new Cliente();
		cliente.setDni("12345678M");
		mc.testDNI(cliente.getDni());
		
	}
	
}
