package controlador.cliente;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.cliente.Cliente;
import modelo.cliente.ModeloCliente;
import modelo.pedido.ModeloPedido;
import modelo.pedido.Pedido;

/**
 * Servlet implementation class Show_pedido_de_cliente
 */
@WebServlet("/Show_pedido_de_cliente")
public class Show_pedido_de_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show_pedido_de_cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DNI = request.getParameter("dni");
		
		ModeloCliente mc = new ModeloCliente();
		Cliente cliente = mc.getCliente(DNI);
		
		ModeloPedido mp = new ModeloPedido();
		ArrayList<Pedido> pedidos = mp.getPedidosByDNI(DNI);
		
		for (Pedido pedido : pedidos) {
			pedido.setCliente(cliente);
		}
		
		request.setAttribute("cliente", cliente);
		
		request.setAttribute("pedidos", pedidos);
		
		request.getRequestDispatcher("cliente/show_pedido_de_cliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
