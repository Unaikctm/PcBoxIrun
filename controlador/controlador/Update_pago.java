package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.factura.*;

/**
 * Servlet implementation class Update_Pago
 */
@WebServlet("/Update_pago")
public class Update_pago extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_pago() {
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
		// Obtener el valor del radio button pagado desde el formulario
		boolean pagado=false;
		String pagadoStr = request.getParameter("pagado");
	    if (pagadoStr.equalsIgnoreCase("Si")) {
			pagado=true;
		}
	    else{
	    	pagado=false;
	    }
	    
	    String tipoString = request.getParameter("factura_tipo");
	    int facturaId = Integer.parseInt(request.getParameter("factura_id")); 
	    
	    ModeloFactura mf = new ModeloFactura();
	    mf.pagar(facturaId, tipoString, pagado);
	    
	    String linkString = "Show_factura_de_"+tipoString.toLowerCase()+"?id="+facturaId;
	    
	    response.sendRedirect(linkString);
	}

}
