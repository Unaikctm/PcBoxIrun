package controlador.pedido;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.carrito.ArticuloCarrito;
import modelo.carrito.ModeloArticuloCarrito;
import modelo.cliente.ModeloCliente;
import modelo.pedido.ModeloPedido;
import modelo.pedido.Pedido;
import modelo.producto.ModeloProducto;
import modelo.producto.Producto;
import modelo.utils.Validador;
/**
 * Servlet implementation class Store_pedido
 */
@WebServlet("/Store_pedido")
public class Store_pedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store_pedido() {
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
		ModeloPedido mp = new ModeloPedido();
		Pedido pedido = new Pedido();
			
		pedido.setFecha(Date.valueOf(request.getParameter("fecha")));
	
		ModeloCliente mc = new ModeloCliente();
		String dni = mc.getCliente(request.getParameter("dni")).getDni();
		pedido.setCliente(mc.getCliente(dni));
		
		if(Validador.esFechaValida(pedido.getFecha())==true){
			mp.insert(pedido);
			
			ModeloProducto mpro = new ModeloProducto();
			Producto producto = mpro.getProductoByNombre(request.getParameter("producto"));
			
			ArticuloCarrito articuloCarrito = new ArticuloCarrito(producto, 1);
			ModeloArticuloCarrito mac = new ModeloArticuloCarrito();
			mac.insertLineaPedido(articuloCarrito, mp.getUltimaID());
			
			
			response.sendRedirect("Index_pedido?msg=okayInsertar");
		}
		else {
			response.sendRedirect("Index_pedido?msg=failInsertar");
		}
		
	}

}
