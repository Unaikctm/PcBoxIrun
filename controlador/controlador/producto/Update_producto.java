package controlador.producto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.producto.ModeloProducto;
import modelo.producto.Producto;
import modelo.utils.Validador;
/**
 * Servlet implementation class Update_producto
 */
@WebServlet("/Update_producto")
public class Update_producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_producto() {
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
		
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("tipo");
		String marca = request.getParameter("marca");
		String precio = request.getParameter("precio");
		String stock = request.getParameter("stock");
		
		if (Validador.testNumerico(precio)==true && Validador.testNumerico(stock)==true) {
			Producto producto = new Producto();
			producto.setId(Integer.parseInt(request.getParameter("id")));
			producto.setNombre(nombre);
			producto.setTipo(tipo);
			producto.setMarca(marca);
			producto.setPrecio(Double.parseDouble(precio));
			producto.setStock(Integer.parseInt(stock));
					
			ModeloProducto mp = new ModeloProducto();
			mp.update(producto);
					
			response.sendRedirect("Index_producto?msg=okayUpdate");
		} else {
			response.sendRedirect("Index_producto?msg=failUpdate");
		}
	}

}
