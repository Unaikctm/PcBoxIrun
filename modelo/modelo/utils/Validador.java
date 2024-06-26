package modelo.utils;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import modelo.cliente.ModeloCliente;
import modelo.lineapedido.LineaPedido;
import modelo.pedido.Pedido;

public class Validador {
	
	public static boolean testDNI(String dni) {
		ModeloCliente mc = new ModeloCliente();
		return mc.testDNI(dni);
	}

	public static boolean testNumerico(String num) {
		//Si puede convertirlo en double devuelve true
		try {
			Double.parseDouble(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean esFechaValida(Date fecha) {
		/// Crear un objeto Calendar y establecer la fecha como 1 de enero de 2025
        Calendar cal2025 = Calendar.getInstance();
        cal2025.set(2025, Calendar.JANUARY, 1);
        
        // Obtener la fecha de referencia para 2025
        Date fecha2025 = cal2025.getTime();
        
        // Si es posterior a 2025 devuelve false, ya que no es valida
        return !(fecha.after(fecha2025));
    }

	public static boolean tienePedidosRelacionados(ArrayList<Pedido> pedidos) {
		if (pedidos.isEmpty()) {
			return false;
		}else {
			return true;
		}	
	}

	public static boolean tieneLineaPedidosRelacionados(ArrayList<LineaPedido> lineapedidos) {
		if (lineapedidos.isEmpty()) {
			return false;
		}else {
			return true;
		}	
	}
}
