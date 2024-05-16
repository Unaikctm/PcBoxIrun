package testCrud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.carrito.ArticuloCarrito;
import modelo.carrito.ModeloArticuloCarrito;
import modelo.producto.ModeloProducto;
import modelo.producto.Producto;

public class ModeloArticuloCarritoTest {

	@Test
    public void testInsertUpdateDeleteCarrito() {
    	
    	
    	Producto producto = new Producto();
    	Producto producto1 = new Producto();
    	producto1.setId(3);
    	producto.setId(1);
    	ModeloArticuloCarrito mac = new ModeloArticuloCarrito();
    	mac.insert(new ArticuloCarrito(producto,1));
    	mac.insert(new ArticuloCarrito(producto1,1));
    	
    	mac.deleteArticulo(producto.getId());
    	mac.delete();
    }
	
	@Test
	public void testGetArticulo() {
		
		ModeloProducto mp = new ModeloProducto();
    	ModeloArticuloCarrito mac = new ModeloArticuloCarrito();
		Producto producto = new Producto();
		producto.setId(1);
		
		mac.getArticulo(producto.getId());
		
	}
	
	@Test
	public void testGetCarrito() {
		
		ModeloProducto mp = new ModeloProducto();
    	ModeloArticuloCarrito mac = new ModeloArticuloCarrito();
    	
    	mac.getCarrito();
		
	}
	
}
