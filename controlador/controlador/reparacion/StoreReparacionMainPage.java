package controlador.reparacion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.cliente.ModeloCliente;
import modelo.reparacion.ModeloReparacion;
import modelo.reparacion.Reparacion;

/**
 * Servlet implementation class Store_reparacion
 */
@WebServlet("/StoreReparacionMainPage")
public class StoreReparacionMainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreReparacionMainPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reparacion reparacion = new Reparacion();
		reparacion.setTipo(request.getParameter("tipo"));
		reparacion.setDescripcion(request.getParameter("descripcion"));
		reparacion.setHoras(Integer.parseInt(request.getParameter("horas")));
		reparacion.setPrecio(Double.parseDouble(request.getParameter("precio")));

		ModeloCliente mc = new ModeloCliente();
		String dni = mc.getCliente(request.getParameter("dni")).getDni();
		ModeloReparacion mr = new ModeloReparacion();
		
		mr.insert(reparacion,dni);
		
		
		response.sendRedirect("Main_page");
	}

}
