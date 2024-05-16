package testCrud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.producto.ModeloProducto;
import modelo.producto.Producto;

public class ModeloProductoTest {

	
	@Test
	public void testInsertUpdateDeleteProducto() {
		
		ModeloProducto mp = new ModeloProducto();
		Producto producto1 = new Producto();
		
		producto1.setNombre("nombreprueba");
		producto1.setTipo("tipo");
		producto1.setPrecio(120.0);
		producto1.setStock(20);
		producto1.setMarca("marca");
		
		mp.insert(producto1);
		producto1 = mp.getProductoByNombre("nombreprueba");
		
		producto1.setNombre("nombre2");
		producto1.setTipo("tipo2");
		producto1.setPrecio(110.0);
		producto1.setStock(10);
		producto1.setMarca("marca2");
		
		mp.update(producto1);

		boolean del = mp.delete(producto1.getId());
	}
	
}
