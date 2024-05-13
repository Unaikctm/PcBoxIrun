package controlador.reparacion;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.cliente.Cliente;
import modelo.cliente.ModeloCliente;
import modelo.reparacion.ModeloReparacion;
import modelo.reparacion.Reparacion;

/**
 * Servlet implementation class SolicitarReparacion
 */
@WebServlet("/SolicitarReparacion")
public class SolicitarReparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitarReparacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<Cliente> clientes = new ModeloCliente().getClientes();
		ArrayList<String> listaDNI = new ArrayList<String>();
		for (Cliente cliente : clientes) {
			listaDNI.add(cliente.getDni());
		}
		
		request.setAttribute("listaDNI", listaDNI);
		
		request.getRequestDispatcher("solicitarReparacion.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		response.sendRedirect("Main_page");
	}

}
