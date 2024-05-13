package controlador.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.cliente.Cliente;
import modelo.cliente.ModeloCliente;
import modelo.utils.Validador;

/**
 * Servlet implementation class Store_cliente
 */
@WebServlet("/Store_cliente")
public class Store_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store_cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", request.getParameter("msg"));
		
		String DNI = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String codPostal = request.getParameter("codigopostal");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono"); 
		
		if (Validador.testNumerico(telefono)==true && Validador.testNumerico(codPostal)==true && Validador.testDNI(DNI)==false) {
			//almacenar la tarea en BBDD
			Cliente cliente = new Cliente();
			cliente.setDni(DNI);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setDireccion(direccion);
			cliente.setCodigopostal(Integer.parseInt(codPostal));
			cliente.setEmail(email);
			cliente.setTelefono(Integer.parseInt(telefono));
			
			ModeloCliente mc = new ModeloCliente();
			mc.insert(cliente);
					
			//abrir lo que quiera, en mi caso inicio
			//como ya tengo un controlador que abra el inicio redirijo a ese controlador
			response.sendRedirect("Index_cliente?msg=okayRegistro");
		} else if ( Validador.testDNI(DNI)==true) {
			response.sendRedirect("Index_cliente?msg=failRegistroDNI");
		}
		else {
			response.sendRedirect("Index_cliente?msg=failRegistro");
		}
		
		
		
		
	}

}
