package controlador.reparacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.reparacion.ModeloReparacion;
import modelo.reparacion.Reparacion;
import modelo.utils.Validador;

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
		request.setAttribute("msg", request.getParameter("msg"));
		
		String tipo = request.getParameter("tipo");
		String desc = request.getParameter("descripcion");
		String horas = request.getParameter("horas");
		String precio =  request.getParameter("precio");
		
		
		if (Validador.testNumerico(horas)==true && Validador.testNumerico(precio)==true) {
			Reparacion reparacion = new Reparacion();
			reparacion.setId(Integer.parseInt(request.getParameter("id")));
			reparacion.setTipo(tipo);
			reparacion.setDescripcion(desc);
			reparacion.setHoras(Integer.parseInt(horas));
			reparacion.setPrecio(Double.parseDouble(precio));

			ModeloReparacion mr = new ModeloReparacion();
			mr.update(reparacion);
					
			//abrir lo que quiera, en mi caso inicio
			response.sendRedirect("Index_reparacion?msg=okayUpdate");
		} else {
			response.sendRedirect("Index_reparacion?msg=failUpdate");
		}

	}

}
