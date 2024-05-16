package testCrud;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import modelo.cliente.Cliente;
import modelo.pedido.ModeloPedido;
import modelo.pedido.Pedido;

class ModeloPedidoTest {

	@Test
	void testInsertUpdateDelete() {
		
		ModeloPedido mp = new ModeloPedido();
		Cliente cliente = new Cliente();
		Pedido pedido = new Pedido();
		
		cliente.setDni("21376754C");
		pedido.setFecha(new Date());
		pedido.setCliente(cliente);
		
		mp.insert(pedido);
		mp.update(new java.sql.Date(pedido.getFecha().getTime()), pedido.getId());
		pedido = mp.getPedidoByDNI(cliente.getDni());
		mp.delete(pedido.getId());
		
	}
	
	@Test
	void testGetPedidos() {
		
		ModeloPedido mp = new ModeloPedido();
		mp.getPedidos();
		
	}
	
	@Test
	void testGetPedido() {
		
		ModeloPedido mp = new ModeloPedido();
		mp.getPedido(1);
		
	}
	
	@Test 
	void testGetPedidosByDNI(){
		
		ModeloPedido mp = new ModeloPedido();
		mp.getPedidosByDNI("21376754C");
		
	}
	
}
