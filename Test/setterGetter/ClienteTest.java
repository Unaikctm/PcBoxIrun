package setterGetter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modelo.carrito.ArticuloCarrito;
import modelo.cliente.Cliente;
import modelo.pedido.Pedido;
import modelo.reparacion.Reparacion;

public class ClienteTest {

	private Cliente cliente;

	@Before
	public void setUp() {
		cliente = new Cliente("12345678A", "Juan", "González", "Calle Principal 123", "juan@example.com", 123456789,
				new ArrayList<Pedido>(), new ArrayList<Reparacion>());
	}
	
	@Test
	public void testConstructorPorDefecto() {
	    Cliente cliente = new Cliente();
	    assertNotNull(cliente);
	    assertNull(cliente.getDni());
	    assertNull(cliente.getNombre());
	    assertNull(cliente.getApellido());
	    assertNull(cliente.getDireccion());
	    assertEquals(0, cliente.getCodigopostal());
	    assertNull(cliente.getEmail());
	    assertEquals(0, cliente.getTelefono());
	    assertNull(cliente.getPedidos());
	    assertNull(cliente.getReparaciones());
	}

	
		@Test
	    public void testConstructorCompleto() {
	        Cliente cliente1 = new Cliente("12345678A", "John", "Doe", "Calle Falsa 123", "john@example.com", 123456789,
	                new ArrayList<Pedido>(), new ArrayList<Reparacion>());

	        assertEquals("12345678A", cliente1.getDni());
	        assertEquals("John", cliente1.getNombre());
	        assertEquals("Doe", cliente1.getApellido());
	        assertEquals("Calle Falsa 123", cliente1.getDireccion());
	        assertEquals("john@example.com", cliente1.getEmail());
	        assertEquals(123456789, cliente1.getTelefono());
	        assertNotNull(cliente1.getPedidos());
	        assertNotNull(cliente1.getReparaciones());
	    }

	    @Test
	    public void testConstructorConDatos() {
	        Cliente cliente2 = new Cliente("87654321B", "Jane", "Smith");

	        assertEquals("87654321B", cliente2.getDni());
	        assertEquals("Jane", cliente2.getNombre());
	        assertEquals("Smith", cliente2.getApellido());
	        assertEquals(0, cliente2.getCodigopostal());
	        assertNull(cliente2.getDireccion());
	        assertNull(cliente2.getEmail());
	        assertEquals(0, cliente2.getTelefono());
	        assertNull(cliente2.getPedidos());
	        assertNull(cliente2.getReparaciones());
	    }
	
	@Test
	public void testSetAndGetDni() {
		cliente.setDni("87654321B");
		assertEquals("87654321B", cliente.getDni());
	}

	@Test
	public void testSetAndGetNombre() {
		cliente.setNombre("Pedro");
		assertEquals("Pedro", cliente.getNombre());
	}

	@Test
	public void testSetAndGetApellido() {
		cliente.setApellido("Martínez");
		assertEquals("Martínez", cliente.getApellido());
	}

	@Test
	public void testSetAndGetDireccion() {
		cliente.setDireccion("Avenida Central 456");
		assertEquals("Avenida Central 456", cliente.getDireccion());
	}

	@Test
	public void testSetAndgetCodigopostal() {
		cliente.setCodigopostal(28001);
		assertEquals(28001, cliente.getCodigopostal());
	}

	@Test
	public void testSetAndGetEmail() {
		cliente.setEmail("pedro@example.com");
		assertEquals("pedro@example.com", cliente.getEmail());
	}

	@Test
	public void testSetAndGetTelefono() {
		cliente.setTelefono(987654321);
		assertEquals(987654321, cliente.getTelefono());
	}

	@Test
	public void testSetAndGetPedidos() {
		ArrayList<Pedido> pedidos = new ArrayList<>();
		Pedido pedido1 = new Pedido();
		Pedido pedido2 = new Pedido();
		pedidos.add(pedido1);
		pedidos.add(pedido2);

		cliente.setPedidos(pedidos);

		assertEquals(pedidos, cliente.getPedidos());
	}

	@Test
	public void testSetAndGetReparaciones() {
		ArrayList<Reparacion> reparaciones = new ArrayList<>();
		Reparacion reparacion1 = new Reparacion();
		Reparacion reparacion2 = new Reparacion();
		reparaciones.add(reparacion1);
		reparaciones.add(reparacion2);

		cliente.setReparaciones(reparaciones);

		assertEquals(reparaciones, cliente.getReparaciones());
	}

}
