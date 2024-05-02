package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update_pedido
 */
@WebServlet("/Update_pedido")
public class Update_pedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_pedido() {
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
		// TODO Auto-generated method stub
		/*Pedido pedido = new Pedido();
		pedido.setId(Integer.parseInt(request.getParameter("id")));
		pedido.setTotal(request.getParameter("nombre"));
		pedido.setFecha(request.getParameter("tipo"));
		pedido.setCliente(request.getParameter("marca"));
		pedido.setPrecio(Double.parseDouble(request.getParameter("precio")));
		pedido.setStock(Integer.parseInt(request.getParameter("stock")));
		
		ModeloPedido mp = new ModeloPedido();
		//mp.update(pedido);*/
		
		response.sendRedirect("Index_pedido");
	}

}
