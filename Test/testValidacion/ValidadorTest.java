package testValidacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import modelo.cliente.Cliente;
import modelo.cliente.ModeloCliente;
import modelo.lineapedido.LineaPedido;
import modelo.pedido.Pedido;
import modelo.utils.Validador;

class ValidadorTest {

	@Test
	void testTestDNI() {
		
		Validador validador = new Validador();
		
		assertEquals(true,validador.testDNI("21376754C"));
		assertEquals(false,validador.testDNI("12345678K"));
				
		}

	@Test
	void testTestNumerico() {
		
		Validador validador = new Validador();
		
		assertEquals(true,validador.testNumerico("612095941"));
		
		assertEquals(false,validador.testNumerico("60067227O"));
		
	}

	@Test
	void testEsFechaValida() {
		
		Validador validador = new Validador();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date fechaEsperada = null;
	    String fecha = "2024-02-08";
	    
			try {
				fechaEsperada = sdf.parse(fecha);
				Date fechaActual = fechaEsperada;
				assertEquals(true,validador.esFechaValida(fechaEsperada));
			} catch (ParseException e) {
				
			}



	}

	@Test
	void testTienePedidosRelacionados() {
		
		Validador validador = new Validador();
		Pedido pedido = new Pedido();
		ModeloCliente mc = new ModeloCliente();
		ArrayList<LineaPedido> lineapedidos = new ArrayList<LineaPedido>();
		ArrayList<Pedido>pedidos = new ArrayList<Pedido>();
		ArrayList<Pedido>pedidos1 = new ArrayList<Pedido>();
		
		pedido.setCliente(mc.getCliente("21376754C"));
		pedido.setFecha(new Date());
		lineapedidos.add(new LineaPedido());
		pedido.setLineapedidos(lineapedidos);
		pedidos.add(pedido);
		pedidos1 = null;
		
		assertEquals(true,validador.tienePedidosRelacionados(pedidos));
		assertEquals(false,validador.tienePedidosRelacionados(pedidos1));
	}

	@Test
	void testTieneLineaPedidosRelacionados() {
		
		Validador validador = new Validador();
		ArrayList<LineaPedido> lineapedidos = new ArrayList<LineaPedido>();
		ArrayList<LineaPedido> lineapedidos1 = new ArrayList<LineaPedido>();
		lineapedidos.add(new LineaPedido());
		
		assertEquals(true,validador.tieneLineaPedidosRelacionados(lineapedidos));
		assertEquals(false,validador.tieneLineaPedidosRelacionados(lineapedidos1));
		
	}

}
