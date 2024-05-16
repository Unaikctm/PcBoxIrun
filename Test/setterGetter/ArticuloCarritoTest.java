package setterGetter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import modelo.carrito.ArticuloCarrito;
import modelo.producto.Producto;

public class ArticuloCarritoTest {

	private ArticuloCarrito articulo;

	@Before
	public void setUp() {
		Producto producto = new Producto();
		articulo = new ArticuloCarrito(producto, 2);
	}

	@Test
	public void testConstructorPorDefecto() {
		ArticuloCarrito nuevoArticulo = new ArticuloCarrito();
		assertNotNull(nuevoArticulo);
		assertEquals(null, nuevoArticulo.getProducto());
		assertEquals(0, nuevoArticulo.getCantidad());
		assertEquals(0.0, nuevoArticulo.getPrecio(), 0.001);
	}

	@Test
	public void testConstructorConProductoYCantidad() {
		Producto producto = new Producto();
		ArticuloCarrito nuevoArticulo = new ArticuloCarrito(producto, 3);
		assertNotNull(nuevoArticulo);
		assertEquals(producto, nuevoArticulo.getProducto());
		assertEquals(3, nuevoArticulo.getCantidad());
		assertEquals(0.0, nuevoArticulo.getPrecio(), 0.001);
	}
	
	@Test
	public void testSetAndGetProducto() {
		Producto nuevoProducto = new Producto();
		articulo.setProducto(nuevoProducto);
		assertEquals(nuevoProducto, articulo.getProducto());
	}

	@Test
	public void testSetAndGetCantidad() {
		articulo.setCantidad(3);
		assertEquals(3, articulo.getCantidad());
	}

	@Test
	public void testSetAndGetPrecio() {
		articulo.setPrecio(200.0);
		assertEquals(200.0, articulo.getPrecio(), 0.001);
	}

}
