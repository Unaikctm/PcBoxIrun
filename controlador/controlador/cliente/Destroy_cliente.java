package controlador.cliente;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.cliente.ModeloCliente;
import modelo.pedido.ModeloPedido;
import modelo.pedido.Pedido;
import modelo.utils.Validador;

/**
 * Servlet implementation class Destroy
 */
@WebServlet("/Destroy_cliente")
public class Destroy_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Destroy_cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibir la id
		String DNI = request.getParameter("dni"); 
		
		ModeloPedido mp = new ModeloPedido();
		ArrayList<Pedido> pedidos = mp.getPedidosByDNI(DNI);
		
		if (Validador.tienePedidosRelacionados(pedidos)==false) {
			//eliminar la tarea
			ModeloCliente mc = new ModeloCliente();
			mc.delete(DNI);
			response.sendRedirect("Index_cliente?msg=okayDelete");
		}else {
			response.sendRedirect("Index_cliente?msg=failDelete");
		}
		//abrir lo que quiera, en mi caso inicio
		//como ya tengo un controlador que abra el inicio redirijo a ese controlador
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
