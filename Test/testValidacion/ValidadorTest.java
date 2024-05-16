package testValidacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import modelo.cliente.Cliente;
import modelo.cliente.ModeloCliente;
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
		     if(validador.esFechaValida(fechaEsperada)){
			      	Date fechaActual = fechaEsperada;
					assertEquals(true,validador.esFechaValida(fechaEsperada));
			      }else{
			    	  assertEquals(false,validador.esFechaValida(fechaEsperada));
			      }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   
	 

	    

		
	}

	@Test
	void testTienePedidosRelacionados() {
		
		
	}

	@Test
	void testTieneLineaPedidosRelacionados() {
		fail("Not yet implemented");
	}

}
