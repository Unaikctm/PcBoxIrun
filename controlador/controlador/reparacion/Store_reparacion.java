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
import modelo.utils.Validador;

/**
 * Servlet implementation class Store_reparacion
 */
@WebServlet("/Store_reparacion")
public class Store_reparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store_reparacion() {
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
		request.setAttribute("msg", request.getParameter("msg"));
		
		String tipo = request.getParameter("tipo");
		String desc = request.getParameter("descripcion");
		String horas = request.getParameter("horas");
		String precio =  request.getParameter("precio");
		
		
		if (Validador.testNumerico(horas)==true && Validador.testNumerico(precio)==true) {
			//almacenar la tarea en BBDD
			Reparacion reparacion = new Reparacion();
			reparacion.setTipo(tipo);
			reparacion.setDescripcion(desc);
			reparacion.setHoras(Integer.parseInt(horas));
			reparacion.setPrecio(Double.parseDouble(precio));

			ModeloCliente mc = new ModeloCliente();
			String dni = mc.getCliente(request.getParameter("dni")).getDni();
			ModeloReparacion mr = new ModeloReparacion();
			mr.insert(reparacion,dni);
			
					
			//abrir lo que quiera, en mi caso inicio
			response.sendRedirect("Index_reparacion?msg=okayInsertar");
		} else {
			response.sendRedirect("Index_reparacion?msg=failInsertar");
		}
	}

}
