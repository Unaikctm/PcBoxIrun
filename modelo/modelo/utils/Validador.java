package modelo.utils;

import modelo.cliente.ModeloCliente;

public class Validador {

	public static boolean testDNI(String dni) {
		ModeloCliente mc = new ModeloCliente();
		return mc.testDNI(dni);
	}

	public static boolean testNumerico(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
