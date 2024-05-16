package setterGetter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.cliente.Cliente;
import modelo.lineapedido.LineaPedido;
import modelo.pedido.Pedido;
import modelo.producto.Producto;

public class PedidoTest {

    private Pedido pedido;
    private int id;
    private Date fecha;
    private Cliente cliente;
    private ArrayList<LineaPedido> lineapedidos;

    @BeforeEach
    public void setUp() {
        id = 1;
        fecha = new Date();
        cliente = new Cliente();
        lineapedidos = new ArrayList<>();

        pedido = new Pedido();
    }

    @Test
    public void testConstructorPorDefecto() {
        assertNotNull(pedido);
        assertEquals(0, pedido.getId());
        assertNull(pedido.getFecha());
        assertNull(pedido.getCliente());
        assertNull(pedido.getLineapedidos());
    }
    
    @Test
    public void testConstructorCompleto() {
        ArrayList<LineaPedido> lineapedidos = new ArrayList<>();
        Producto producto = new Producto(10,"Luciernaga","Insecto",128.2,"Salvaje",89);
        LineaPedido lineaPedido = new LineaPedido(producto, pedido, 5);
        lineapedidos.add(lineaPedido);
        Date fecha = new Date();
        Pedido pedido = new Pedido(1, fecha, lineapedidos);

        assertEquals(1, pedido.getId());
        assertEquals(fecha, pedido.getFecha());
        assertEquals(1, pedido.getLineapedidos().size());
    }
    
    @Test
    public void testSetYGetId() {
        pedido.setId(id);
        assertEquals(id, pedido.getId());
    }

    @Test
    public void testSetYGetFecha() {
        pedido.setFecha(fecha);
        assertEquals(fecha, pedido.getFecha());
    }

    @Test
    public void testSetYGetCliente() {
        pedido.setCliente(cliente);
        assertEquals(cliente, pedido.getCliente());
    }

    @Test
    public void testSetYGetLineapedidos() {
        pedido.setLineapedidos(lineapedidos);
        assertEquals(lineapedidos, pedido.getLineapedidos());
    }
}
