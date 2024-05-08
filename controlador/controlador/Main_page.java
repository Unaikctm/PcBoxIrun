package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.carrito.ArticuloCarrito;
import modelo.carrito.ModeloArticuloCarrito;
import modelo.cliente.ModeloCliente;
import modelo.pedido.ModeloPedido;
import modelo.pedido.Pedido;
import modelo.producto.ModeloProducto;
import modelo.producto.Producto;

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

		String dni = request.getParameter("dni");
		//int id = request.getParameter("");
		System.out.println(dni);

		
		// Realizar una consulta a la base de datos para verificar el DNI
		// Supongamos que tienes un m�todo en tu clase ModeloUsuario para verificar el DNI
		ModeloCliente mc = new ModeloCliente();
		boolean dniValido = mc.testDNI(dni); // Este m�todo debe devolver true si el DNI es v�lido
		    
		if (dniValido) {
			
		        	//ModeloPedido mp = new ModeloPedido();
		        	//Pedido pedido = new Pedido();
		        	//Date fechaActual = new Date();
		        	
		        	//pedido.setFecha(fechaActual);
		        	
		        	//mp.insert(,pedido.getFecha(), dni);
		        	
		        
		    // Si el DNI es v�lido, puedes permitir que se finalice la compra
		    // Puedes redirigir al usuario a otra p�gina, o realizar alguna otra acci�n
		    // Por ejemplo, aqu� simplemente redirigimos al usuario a una p�gina de confirmaci�n de compra
		    response.sendRedirect("Main_page");
		    
		} else {
		    // Si el DNI no es v�lido, puedes mostrar un mensaje de error o redirigir al usuario a otra p�gina
		    // Por ejemplo, aqu� redirigimos al usuario de nuevo a la p�gina del carrito con un mensaje de error
		    response.sendRedirect("Main_page?error=dni_invalido");
		}
	}
}
