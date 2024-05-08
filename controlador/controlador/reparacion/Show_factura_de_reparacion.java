package controlador.reparacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.factura.Factura;
import modelo.factura.ModeloFactura;
import modelo.reparacion.ModeloReparacion;
import modelo.reparacion.Reparacion;
/**
 * Servlet implementation class Show_factura_de_reparacion
 */
@WebServlet("/Show_factura_de_reparacion")
public class Show_factura_de_reparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show_factura_de_reparacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String tipo = "Reparacion";
		
		ModeloFactura mf = new ModeloFactura();
		Factura factura = mf.getFactura(id, tipo);
		
		ModeloReparacion mr = new ModeloReparacion();
		Reparacion reparacion = mr.getReparacion(id);
		
		request.setAttribute("factura", factura);
		
		request.setAttribute("reparacion", reparacion);
		
		request.getRequestDispatcher("show_factura_de_reparacion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
