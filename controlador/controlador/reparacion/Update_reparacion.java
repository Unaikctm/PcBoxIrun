package controlador.reparacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.reparacion.ModeloReparacion;
import modelo.reparacion.Reparacion;

/**
 * Servlet implementation class Update_reparacion
 */
@WebServlet("/Update_reparacion")
public class Update_reparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_reparacion() {
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
		Reparacion reparacion = new Reparacion();
		reparacion.setId(Integer.parseInt(request.getParameter("id")));
		reparacion.setTipo(request.getParameter("tipo"));
		reparacion.setDescripcion(request.getParameter("descripcion"));
		reparacion.setHoras(Integer.parseInt(request.getParameter("horas")));
		reparacion.setPrecio(Double.parseDouble(request.getParameter("precio")));

		ModeloReparacion mr = new ModeloReparacion();
		mr.update(reparacion);

		response.sendRedirect("Index_reparacion");

	}

}
