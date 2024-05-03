package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;

/**
 * Servlet implementation class Show_factura_de_pedido
 */
@WebServlet("/Show_factura_de_pedido")
public class Show_factura_de_pedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show_factura_de_pedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String tipo = "Pedido";
		
		ModeloFactura mf = new ModeloFactura();
		Factura factura = mf.getFactura(id, tipo);
		
		ModeloPedido mp = new ModeloPedido();
		Pedido pedido = mp.getPedido(id);
		
		
		request.setAttribute("factura", factura);
		
		request.setAttribute("pedido", pedido);
		
		request.getRequestDispatcher("show_factura_de_pedido.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
