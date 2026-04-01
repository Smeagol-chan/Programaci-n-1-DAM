package org.example.mercadam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest
{
    Pedido pedidoTest = new Pedido();

    @BeforeEach
    void iniciarPedido()
    {
        pedidoTest.agregarProducto(Producto.PAN);
        pedidoTest.agregarProducto(Producto.TOMATES);
        pedidoTest.agregarProducto(Producto.TOMATES);
    }

    @Test
    void agregarProducto()
    {
        double importeEsperado = pedidoTest.getImporteTotal();
        Map<Producto, Integer> carritoEsperado = new HashMap<>();

        for(Map.Entry<Producto, Integer> producto : pedidoTest.getPedido().entrySet())
            carritoEsperado.put(producto.getKey(), producto.getValue());

        pedidoTest.agregarProducto(Producto.ARROZ);
        pedidoTest.agregarProducto(Producto.PAN);

        importeEsperado += Producto.ARROZ.getPrecio() + Producto.PAN.getPrecio();
        carritoEsperado.put(Producto.ARROZ, 1);
        carritoEsperado.put(Producto.PAN, 2);

        final double FINAL_IMPORTE_ESPERADO = importeEsperado;

        assertAll(
                () -> assertEquals(FINAL_IMPORTE_ESPERADO, pedidoTest.getImporteTotal()),
                () -> assertEquals(carritoEsperado, pedidoTest.getPedido())
        );
    }

    @Test
    void eliminarProducto()
    {
        double importeEsperado = pedidoTest.getImporteTotal();
        Map<Producto, Integer> carritoEsperado = new HashMap<>();

        for(Map.Entry<Producto, Integer> producto : pedidoTest.getPedido().entrySet())
            carritoEsperado.put(producto.getKey(), producto.getValue());

        pedidoTest.eliminarProducto(Producto.PAN);
        pedidoTest.eliminarProducto(Producto.TOMATES);

        importeEsperado -= Producto.PAN.getPrecio();
        importeEsperado -= Producto.TOMATES.getPrecio();
        carritoEsperado.remove(Producto.PAN);
        carritoEsperado.put(Producto.TOMATES, 1);

        final double FINAL_IMPORTE_ESPERADO = importeEsperado;

        assertAll(
                () -> assertEquals(FINAL_IMPORTE_ESPERADO, pedidoTest.getImporteTotal()),
                () -> assertEquals(carritoEsperado, pedidoTest.getPedido())
        );
    }

    @Test
    void eliminarProductoFueraDelCarrito()
    {
        final String resultadoEsperado = "El producto no está presente en el carrito";
        String resultadoDado;

        try
        {
            pedidoTest.eliminarProducto(Producto.ARROZ);
            resultadoDado = "Producto eliminado";
        }
        catch(ProductoNoEnCarritoException e)
        {
            resultadoDado = "El producto no está presente en el carrito";
        }

        assertEquals(resultadoEsperado, resultadoDado);
    }

    @Test
    void aplicarPromo3x2()
    {
        for(int i = 1; i <= 5; i++)
            pedidoTest.agregarProducto(Producto.PAN);
        pedidoTest.agregarProducto(Producto.TOMATES);

        double importeEsperado = pedidoTest.getImporteTotal();

        pedidoTest.aplicarPromo3x2();

        importeEsperado -= Producto.PAN.getPrecio() * 2;
        importeEsperado -= Producto.TOMATES.getPrecio();

        final double FINAL_IMPORTE_ESPERADO = importeEsperado;

        assertEquals(FINAL_IMPORTE_ESPERADO, pedidoTest.getImporteTotal());
    }

    @Test
    void aplicarPromo10()
    {
        double importeEsperado = pedidoTest.getImporteTotal();

        pedidoTest.aplicarPromo10();
        importeEsperado *= 0.9;

        final double FINAL_IMPORTE_ESPERADO = importeEsperado;

        assertEquals(FINAL_IMPORTE_ESPERADO, pedidoTest.getImporteTotal());
    }
}