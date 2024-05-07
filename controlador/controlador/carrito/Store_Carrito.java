package controlador.carrito;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;
import modelo.carrito.ArticuloCarrito;
import modelo.carrito.ModeloArticuloCarrito;
import modelo.producto.ModeloProducto;

/**
 * Servlet implementation class Store_Carrito
 */
@WebServlet("/Store_Carrito")
public class Store_Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store_Carrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		int id = Integer.parseInt(request.getParameter("productId"));

		
		ArticuloCarrito  ac = new ArticuloCarrito();
		ModeloProducto mp = new ModeloProducto();
		ModeloArticuloCarrito mac = new ModeloArticuloCarrito();
		
		ac.setProducto(mp.getProducto(id));
		ac.setCantidad(cantidad);
		ac.setPrecio(mp.getProducto(id).getPrecio());
		
		mac.insert(ac);
		
		response.sendRedirect("Main_page");
	}

}
