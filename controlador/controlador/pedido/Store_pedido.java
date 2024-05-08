package controlador.pedido;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.cliente.ModeloCliente;
import modelo.pedido.ModeloPedido;
import modelo.pedido.Pedido;
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
		// TODO Auto-generated method stub
		/*
		Pedido pedido = new Pedido();
		pedido.setTotal(Double.parseDouble(request.getParameter("total")));
		pedido.setFecha(Date.valueOf(request.getParameter("fecha")));
	
		ModeloCliente mc = new ModeloCliente();
		String dni = mc.getCliente(request.getParameter("dni")).getDni();
		ModeloPedido mp = new ModeloPedido();
		mp.insert(pedido,dni);*/
				
		response.sendRedirect("Index_pedido");
	}

}
