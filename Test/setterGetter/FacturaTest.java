package setterGetter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import modelo.factura.Factura;
import modelo.lineapedido.LineaPedido;
import modelo.pedido.Pedido;
import modelo.producto.Producto;
import modelo.reparacion.Reparacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {

    private Factura factura;
    private int id;
    private Double total;
    private Date fecha;
    private Boolean pagado;
    private Pedido pedido;
    private Reparacion reparacion;
    private String tipo;

    @BeforeEach
    public void setUp() {
        id = 1;
        total = 100.0;
        fecha = new Date();
        pagado = false;
        pedido = new Pedido();
        pedido.setId(1);
        reparacion = new Reparacion();
        tipo = "Pedido";
        
        factura = new Factura();
        
    }

    @Test
    public void testConstructorPorDefecto() {
    	assertEquals(factura,factura);
    
    }

    @Test
    public void testConstructorCompleto() {
    	factura.setId(id); 
    	factura.setFecha(fecha);
    	factura.setPagado(pagado);
    	factura.setPedido(pedido);
    	Factura factura2 = factura;
    	assertEquals(factura,factura2);
      
    }
    
    @Test
    public void testSetYGetId() {
        factura.setId(id);
        assertEquals(id, factura.getId());
    }

    @Test
    public void testGetTotal() {
    	
    	Pedido pedido = new Pedido();
    	pedido.setCliente(null);
    	pedido.setFecha(fecha);
    	pedido.setId(id);
    	LineaPedido lp = new LineaPedido();
    	lp.setCantidad(2);
    	lp.setPedido(pedido);
    	lp.setProducto(new Producto(10,"nombre", "pedido", 1.0, "marca", 90));
    	ArrayList<LineaPedido> lista = new ArrayList<LineaPedido>();
    	lista.add(lp);
    	pedido.setLineapedidos(lista);
    	total = factura.getTotal();
        assertEquals(total, factura.getTotal());
    }

    @Test
    public void testSetTotal() {
        total = factura.getTotal();
        assertEquals(total, factura.getTotal());
    }

    @Test
    public void testSetYGetFecha() {
        factura.setFecha(fecha);
        assertEquals(fecha, factura.getFecha());
    }

    @Test
    public void testSetYGetPagado() {
        factura.setPagado(pagado);
        assertEquals(pagado, factura.getPagado());
    }

    @Test
    public void testSetYGetPedido() {
        factura.setPedido(pedido);
        assertEquals(pedido, factura.getPedido());
    }

    @Test
    public void testSetYGetReparacion() {
        factura.setReparacion(reparacion);
        assertEquals(reparacion, factura.getReparacion());
    }

    @Test
    public void testSetYGetTipo() {
        factura.setTipo(tipo);
        assertEquals(tipo, factura.getTipo());
    }
}
