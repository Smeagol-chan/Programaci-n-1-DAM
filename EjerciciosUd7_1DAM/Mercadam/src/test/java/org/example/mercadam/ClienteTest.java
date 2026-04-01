package org.example.mercadam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest
{
    Cliente clienteTest = new Cliente("Eric", "1234");

    @BeforeEach
    void iniciarCliente()
    {
        clienteTest.crearPedido();
        for(int i = 1; i <= 6; i++)
            clienteTest.anyadirAlCarrito(Producto.PAN);
        for(int i = 1; i <= 3; i++)
            clienteTest.anyadirAlCarrito(Producto.TOMATES);
    }

    @Test
    void aplicarPromociones()
    {
        double importeEsperado = clienteTest.getPedido().getImporteTotal();
        Map<Producto, Integer> carritoEsperadoAlAplicar = new HashMap<>();

        for(Map.Entry<Producto, Integer> producto : clienteTest.getPedido().getPedido().entrySet())
            carritoEsperadoAlAplicar.put(producto.getKey(), producto.getValue());

        clienteTest.aplicarPromociones();
        double importePromoAplicada_1vez = clienteTest.getPedido().getImporteTotal();
        clienteTest.aplicarPromociones();
        double importePromoAplicada_2veces = clienteTest.getPedido().getImporteTotal();

        importeEsperado -= Producto.PAN.getPrecio() * 2;
        importeEsperado -= Producto.TOMATES.getPrecio();
        importeEsperado *= 0.9;

        final double FINAL_IMPORTE_ESPERADO = importeEsperado;

        assertAll(
                () -> assertEquals(FINAL_IMPORTE_ESPERADO, importePromoAplicada_1vez),
                () -> assertEquals(FINAL_IMPORTE_ESPERADO, importePromoAplicada_2veces)
        );
    }
}