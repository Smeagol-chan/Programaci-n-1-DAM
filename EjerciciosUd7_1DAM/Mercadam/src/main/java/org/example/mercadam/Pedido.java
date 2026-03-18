package org.example.mercadam;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Pedido
{
    private Map<Producto, Integer> pedido;
    private double importeTotal;

    public Pedido()
    {
        pedido = new HashMap<>();
        importeTotal = 0;
    }

    private void actualizarImporteTotal(double importe)
    {

    }

    public void actualizarPedido(Producto producto)
    {

    }

    public void aplicarPromo3x2()
    {

    }

    public void aplicarPromo10()
    {
        importeTotal *= 0.90;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public Map<Producto, Integer> getPedido() {
        return Collections.unmodifiableMap(pedido);
    }

    @Override
    public String toString()
    {
        String carrito = "";
        for(Map.Entry<Producto, Integer> producto : pedido.entrySet())
            carrito += producto.getKey() +", Unidades: "+ producto.getValue();

        return "Carrito: ["+ carrito +
                "], Importe total: "+ importeTotal;
    }
}