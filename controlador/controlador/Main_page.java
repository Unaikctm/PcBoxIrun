package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.carrito.*;
import modelo.cliente.*;
import modelo.pedido.*;
import modelo.producto.*;

/**
 * Servlet implementation class main_page
 */
@WebServlet("/Main_page")
public class Main_page extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	       
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public Main_page() {
	    super();
	    // TODO Auto-generated constructor stub
	}
	
	public void init(ServletConfig config) throws ServletException {
	    
	    
	}
	    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ModeloProducto mp = new ModeloProducto();
		ModeloArticuloCarrito mc = new ModeloArticuloCarrito();
		ArrayList<Producto> productos = mp.getProductos();
		ModeloCliente mcl = new ModeloCliente();
		
		double precioTotal = 0.0;
		
		for (ArticuloCarrito articulo : mc.getCarrito()) {
		    precioTotal += (articulo.getPrecio()* articulo.getCantidad());
		}
		
		request.setAttribute("clientes", mcl.getClientes());
		request.setAttribute("precioTotal", precioTotal);
		request.setAttribute("productos", productos);
		request.setAttribute("articulos", mc.getCarrito());
		
		request.getRequestDispatcher("main_page.jsp").forward(request, response);
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloArticuloCarrito mc = new ModeloArticuloCarrito();
		
		ArrayList<ArticuloCarrito> articulos = mc.getCarrito();
		String dni = request.getParameter("dni");




		// Realizar una consulta a la base de datos para verificar el DNI
		// Supongamos que tienes un m�todo en tu clase ModeloUsuario para verificar el DNI
		ModeloCliente mcl = new ModeloCliente();
		boolean dniValido = mcl.testDNI(dni); // Este m�todo debe devolver true si el DNI es v�lido
		    
		if (dniValido) {
		        
		    // Si el DNI es v�lido, puedes permitir que se finalice la compra
			
			//insertar pedideo
			//Creo el pedido en Java
			Pedido pedido = new Pedido();
			pedido.setFecha(new Date());
			
			Cliente cliente = new Cliente();
			cliente.setDni(dni);
			pedido.setCliente(cliente);
			
			//Inserto el pedido vacio sin asignarle ningun pedido
			ModeloPedido mp = new ModeloPedido();
			mp.insert(pedido);
			
			//conseguir el id del pedido insertado
			int id_pedido = mp.getPedidoId();
			//int idPedido = metodo para conseguirlo()
			
			for (ArticuloCarrito articulo : articulos) {
				mc.insertLineaPedido(articulo, id_pedido);
			}
			
			//limpiar carrito
			mc.delete();
			
		    response.sendRedirect("Main_page");
		    
		} else {
		    // Si el DNI no es v�lido, puedes mostrar un mensaje de error o redirigir al usuario a otra p�gina
			
			
			
		    // Por ejemplo, aqu� redirigimos al usuario de nuevo a la p�gina del carrito con un mensaje de error
		    response.sendRedirect("Main_page?error=dni_invalido");
		}
	}
}
