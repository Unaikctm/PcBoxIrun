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
 * Servlet implementation class Index_reparacion
 */
@WebServlet("/Index_reparacion")
public class Index_reparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index_reparacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloReparacion mr = new ModeloReparacion();
		
		ArrayList<Reparacion> reparaciones = mr.getReparaciones();
		
		request.setAttribute("reparaciones", reparaciones);
		
		ArrayList<Cliente> clientes = new ModeloCliente().getClientes();
		ArrayList<String> listaDNI = new ArrayList<String>();
		for (Cliente cliente : clientes) {
			listaDNI.add(cliente.getDni());
		}
		
		request.setAttribute("listaDNI", listaDNI);
		
		request.getRequestDispatcher("reparacion/reparacion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
