package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.LineaPedido;
import modelo.ModeloCliente;
import modelo.ModeloLineaPedido;

/**
 * Servlet implementation class Show_lineapedido
 */
@WebServlet("/Show_lineapedido")
public class Show_lineapedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show_lineapedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_pedido = Integer.parseInt(request.getParameter("pedido.id"));
		
		ModeloLineaPedido mlp = new ModeloLineaPedido();
		LineaPedido lineaPedido = mlp.getLineaPedidoByIdPedido(id_pedido);
		
		request.setAttribute("lineapedido", lineaPedido);
		
		request.getRequestDispatcher("show_lineapedido.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
