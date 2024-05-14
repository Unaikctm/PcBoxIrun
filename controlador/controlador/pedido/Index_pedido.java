package controlador.pedido;

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
import modelo.producto.ModeloProducto;
import modelo.producto.Producto;

/**
 * Servlet implementation class Index_pedido
 */
@WebServlet("/Index_pedido")
public class Index_pedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index_pedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloPedido mPedido = new ModeloPedido();
		
		ArrayList<Pedido> pedidos = mPedido.getPedidos();
		
		request.setAttribute("pedidos", pedidos);
		
		ArrayList<Cliente> clientes = new ModeloCliente().getClientes();; 
		ArrayList<String> listaDNI = new ArrayList<String>();
		for (Cliente cliente : clientes) {
			listaDNI.add(cliente.getDni());
		}
		
		request.setAttribute("listaDNI", listaDNI);
		
		ArrayList<Producto> productos = new ModeloProducto().getProductos();; 
		ArrayList<String> listaNombresProducto = new ArrayList<String>();
		for (Producto producto : productos) {
			listaNombresProducto.add(producto.getNombre());
		}
		
		request.setAttribute("listaNombresProducto", listaNombresProducto);
		
		request.getRequestDispatcher("pedido/pedido.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
