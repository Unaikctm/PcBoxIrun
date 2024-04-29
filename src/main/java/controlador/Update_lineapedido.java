package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;

/**
 * Servlet implementation class Update_lineapedido
 */
@WebServlet("/Update_lineapedido")
public class Update_lineapedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_lineapedido() {
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
		ModeloLineaPedido mlp = new ModeloLineaPedido();
		
		LineaPedido lineapedido = new LineaPedido();
		lineapedido.setPedido(new ModeloPedido().getPedido(Integer.parseInt(request.getParameter("id_pedido"))));
		lineapedido.setProducto(new ModeloProducto().getProducto(Integer.parseInt(request.getParameter("id_producto"))));
		lineapedido.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		
		mlp.update(lineapedido);
		
		response.sendRedirect("Index_lineapedido");
	}

}
