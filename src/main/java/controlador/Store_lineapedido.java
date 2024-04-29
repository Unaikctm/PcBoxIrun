package controlador;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;
/**
 * Servlet implementation class Store_lineapedido
 */
@WebServlet("/Store_lineapedido")
public class Store_lineapedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store_lineapedido() {
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
		ModeloLineaPedido mLPedido = new ModeloLineaPedido();
		LineaPedido lPedido = new LineaPedido();
		lPedido.setPedido(new ModeloPedido().getPedido(Integer.parseInt(request.getParameter("id_pedido"))));
		lPedido.setProducto(new ModeloProducto().getProducto(Integer.parseInt(request.getParameter("id_producto"))));
		lPedido.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
	
		mLPedido.insert(lPedido);
				
		response.sendRedirect("Index_lineapedido");
	}

}
