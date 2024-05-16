package setterGetter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.lineapedido.LineaPedido;
import modelo.pedido.Pedido;
import modelo.producto.Producto;

public class LineaPedidoTest {

    private LineaPedido lineaPedido;
    private Pedido pedido;
    private Producto producto;
    private int cantidad;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido(); 
        producto = new Producto(); 
        cantidad = 5;

        lineaPedido = new LineaPedido();
    }
    
    @Test
    public void testConstructorPorDefecto() {
        assertNotNull(lineaPedido);
        assertNull(lineaPedido.getProducto());
        assertNull(lineaPedido.getPedido());
        assertEquals(0, lineaPedido.getCantidad());
    }

    
    @Test
    public void testConstructorCompleto() {
        Producto producto = new Producto();
        Pedido pedido = new Pedido();
        LineaPedido lineaPedido1 = new LineaPedido(producto, pedido, 5);

        assertEquals(producto, lineaPedido1.getProducto());
        assertEquals(pedido, lineaPedido1.getPedido());
        assertEquals(5, lineaPedido1.getCantidad());
    }

    @Test
    public void testSetYGetProducto() {
        lineaPedido.setProducto(producto);
        assertEquals(producto, lineaPedido.getProducto());
    }

    @Test
    public void testSetYGetPedido() {
        lineaPedido.setPedido(pedido);
        assertEquals(pedido, lineaPedido.getPedido());
    }

    @Test
    public void testSetYGetCantidad() {
        lineaPedido.setCantidad(cantidad);
        assertEquals(cantidad, lineaPedido.getCantidad());
    }
}
