package setterGetter;

import static org.junit.jupiter.api.Assertions.*;

import modelo.cliente.Cliente;
import modelo.pedido.Pedido;
import modelo.reparacion.Reparacion;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ReparacionTest {

	 private Reparacion reparacion;

	@Before
	public void setUp() {
	     reparacion = new Reparacion();
	}
	
	@Test
	public void testConstructorPorDefecto() {
	    assertEquals(reparacion,reparacion);
	 }
	  
	@Test
    public void testConstructorCompleto() {
        Reparacion reparacion1 = new Reparacion(1, "Tipo", "Descripción", 10, 100.0);

        assertEquals(1, reparacion1.getId());
        assertEquals("Tipo", reparacion1.getTipo());
        assertEquals("Descripción", reparacion1.getDescripcion());
        assertEquals(10, reparacion1.getHoras());
        assertEquals(100.0, reparacion1.getPrecio(), 0.01);
        assertNull(reparacion1.getCliente());
    }
	
    @Test
    void testSetYGetId() {
        Reparacion reparacion = new Reparacion();
        reparacion.setId(1);
        assertEquals(1, reparacion.getId());
    }

    @Test
    void testSetYGetTipo() {
        Reparacion reparacion = new Reparacion();
        reparacion.setTipo("Electrónica");
        assertEquals("Electrónica", reparacion.getTipo());
    }

    @Test
    void testSetYGetDescripcion() {
        Reparacion reparacion = new Reparacion();
        reparacion.setDescripcion("Reparación de pantalla");
        assertEquals("Reparación de pantalla", reparacion.getDescripcion());
    }

    @Test
    void testSetYGetHoras() {
        Reparacion reparacion = new Reparacion();
        reparacion.setHoras(5);
        assertEquals(5, reparacion.getHoras());
    }

    @Test
    void testSetYGetPrecio() {
        Reparacion reparacion = new Reparacion();
        reparacion.setPrecio(250.0);
        assertEquals(250.0, reparacion.getPrecio());
    }

    @Test
    void testSetYGetCliente() {
        Cliente cliente = new Cliente();
        Reparacion reparacion = new Reparacion();
        reparacion.setCliente(cliente);
        assertEquals(cliente, reparacion.getCliente());
    }

}
