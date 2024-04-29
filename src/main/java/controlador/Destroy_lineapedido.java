package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;

/**
 * Servlet implementation class Destroy_lineapedido
 */
@WebServlet("/Destroy_lineapedido")
public class Destroy_lineapedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Destroy_lineapedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibir la id
		int id_pedido = Integer.parseInt(request.getParameter("id_pedido")); 
		//eliminar la tarea
		ModeloLineaPedido mlp = new ModeloLineaPedido();
		mlp.delete(id_pedido);
						
		//abrir lo que quiera, en mi caso inicio
		//como ya tengo un controlador que abra el inicio redirijo a ese controlador
		response.sendRedirect("Index_lineapedido");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
