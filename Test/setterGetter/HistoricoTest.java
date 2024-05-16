package setterGetter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.historico.Historico;
import modelo.producto.Producto;

import java.util.Date;

public class HistoricoTest {

    private Historico historico;
    private int id;
    private Date mes;
    private Producto producto;
    private int cantidad;

    @BeforeEach
    public void setUp() {
        id = 1;
        mes = new Date();
        producto = new Producto();
        cantidad = 100;

        historico = new Historico();
    }

    @Test
    public void testConstructorCompleto() {
        Producto producto = new Producto();
        Date mes = new Date();
        Historico historico1 = new Historico(1, mes, producto, 5);

        assertEquals(1, historico1.getId());
        assertEquals(mes, historico1.getMes());
        assertEquals(producto, historico1.getProducto());
        assertEquals(5, historico1.getCantidad());
    }

    @Test
    public void testConstructorPorDefecto() {
        assertNotNull(historico);
        assertNull(historico.getMes());
        assertNull(historico.getProducto());
        assertEquals(0, historico.getCantidad());
    }
    
    @Test
    public void testSetYGetId() {
        historico.setId(id);
        assertEquals(id, historico.getId());
    } 

    @Test
    public void testSetYGetMes() {
        historico.setMes(mes);
        assertEquals(mes, historico.getMes());
    }

    @Test
    public void testSetYGetProducto() {
        historico.setProducto(producto);
        assertEquals(producto, historico.getProducto());
    }

    @Test
    public void testSetYGetCantidad() {
        historico.setCantidad(cantidad);
        assertEquals(cantidad, historico.getCantidad());
    }
}
