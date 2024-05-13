package controlador.producto;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.lineapedido.LineaPedido;
import modelo.lineapedido.ModeloLineaPedido;
import modelo.producto.ModeloProducto;
import modelo.utils.Validador;

/**
 * Servlet implementation class Destroy_producto
 */
@WebServlet("/Destroy_producto")
public class Destroy_producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Destroy_producto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibir la id
		int id = Integer.parseInt(request.getParameter("id")); 
		
		ModeloLineaPedido mlp = new ModeloLineaPedido();
		ArrayList<LineaPedido> lineapedidos = mlp.getLineaPedidosByIdProducto(id);
		
		if (Validador.tieneLineaPedidosRelacionados(lineapedidos)==false) {
			//eliminar la tarea
			ModeloProducto mp = new ModeloProducto();
			mp.delete(id);
			response.sendRedirect("Index_producto?msg=okayDelete");
		}else {
			response.sendRedirect("Index_producto?msg=failDelete");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
