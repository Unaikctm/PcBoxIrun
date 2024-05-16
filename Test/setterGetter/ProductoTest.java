package setterGetter;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import modelo.producto.Producto;

class ProductoTest {
	
	private Producto producto;
	
	 @Before
	    public void setUp() {
	        producto = new Producto();
	    }
	
	 @Test
	    public void testConstructorCompleto() {
	        Producto producto1 = new Producto(10,"Producto", "Tipo", 10.0, "Marca", 10);

	        assertEquals(1, producto1.getId());
	        assertEquals("Producto", producto1.getNombre());
	        assertEquals("Tipo", producto1.getTipo());
	        assertEquals(10.0, producto1.getPrecio(), 0.01);
	        assertEquals("Marca", producto1.getMarca());
	        assertEquals(10, producto1.getStock());
	    }
	
	 @Test
	 public void testConstructorPorDefecto() {
	     assertEquals(producto,producto);
	 }


	
    @Test
    void testSetYGetId() {
        Producto producto = new Producto();
        producto.setId(1);
        assertEquals(1, producto.getId());
    }

    @Test
    void testSetYGetNombre() {
        Producto producto = new Producto();
        producto.setNombre("Producto A");
        assertEquals("Producto A", producto.getNombre());
    }

    @Test
    void testSetYGetTipo() {
        Producto producto = new Producto();
        producto.setTipo("Electrónica");
        assertEquals("Electrónica", producto.getTipo());
    }

    @Test
    void testSetYGetPrecio() {
        Producto producto = new Producto();
        producto.setPrecio(99.99);
        assertEquals(99.99, producto.getPrecio());
    }

    @Test
    void testSetYGetMarca() {
        Producto producto = new Producto();
        producto.setMarca("Marca X");
        assertEquals("Marca X", producto.getMarca());
    }

    @Test
    void testSetYGetStock() {
        Producto producto = new Producto();
        producto.setStock(10);
        assertEquals(10, producto.getStock());
    }
}
