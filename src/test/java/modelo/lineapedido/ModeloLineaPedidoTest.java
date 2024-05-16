package modelo.lineapedido;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.pedido.Pedido;
import modelo.producto.Producto;

class ModeloLineaPedidoTest {

	@Test
	void testInsertDeleteUpdate() {
		
		ModeloLineaPedido ml = new ModeloLineaPedido();
		Pedido pedido = new Pedido();
		Producto producto = new Producto();
		LineaPedido lp = new LineaPedido();
		
		pedido.setId(1);
		producto.setId(1);
		lp.setPedido(pedido);
		lp.setProducto(producto);
		lp.setCantidad(10);
		
		ml.insert(lp);
		
		pedido.setId(2);
		lp.setProducto(producto);
		
		ml.update(lp);
		ml.delete(pedido.getId());
		
	}

	@Test
	void testGetLineaPedidos() {
		
		ModeloLineaPedido ml = new ModeloLineaPedido();
		ml.getLineaPedidos();
		
	}
	
	@Test
	void testGetLineaPedidosByIdPedido(){
		
		ModeloLineaPedido ml = new ModeloLineaPedido();
		ml.getLineaPedidosByIdPedido(1);
		
	}
	
}
