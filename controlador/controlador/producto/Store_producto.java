package controlador.producto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;
import modelo.producto.ModeloProducto;
import modelo.producto.Producto;

/**
 * Servlet implementation class Store_producto
 */
@WebServlet("/Store_producto")
public class Store_producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store_producto() {
        super();
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
		Producto producto = new Producto();
		producto.setNombre(request.getParameter("nombre"));
		producto.setTipo(request.getParameter("tipo"));
		producto.setMarca(request.getParameter("marca"));
		producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
		producto.setStock(Integer.parseInt(request.getParameter("stock")));
				
		ModeloProducto mp = new ModeloProducto();
		mp.insert(producto);
				
		response.sendRedirect("Index_producto");
	}

}
