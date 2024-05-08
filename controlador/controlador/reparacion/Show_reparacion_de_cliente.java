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
 * Servlet implementation class Show_reparacion_de_cliente
 */
@WebServlet("/Show_reparacion_de_cliente")
public class Show_reparacion_de_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show_reparacion_de_cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DNI = request.getParameter("dni");
		
		ModeloCliente mc = new ModeloCliente();
		Cliente cliente = mc.getCliente(DNI);
		
		ModeloReparacion mr = new ModeloReparacion();
		ArrayList<Reparacion> reparaciones = mr.getReparacionesByDNI(DNI);
		
		for (Reparacion reparacion : reparaciones) {
			reparacion.setCliente(cliente);
		}
		
		request.setAttribute("reparaciones", reparaciones);
		
		request.getRequestDispatcher("show_reparacion_de_cliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
