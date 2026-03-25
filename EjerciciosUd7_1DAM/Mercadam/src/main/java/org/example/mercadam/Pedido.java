package org.example.mercadam;
import java.util.*;

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
        importeTotal += importe;
    }

    public void agregarProducto(Producto producto)
    {
        if(pedido.containsKey(producto)) pedido.put(producto, pedido.get(producto)+1);
        else pedido.put(producto, 1);

        actualizarImporteTotal(producto.getPrecio());
    }

    public void eliminarProducto(Producto producto)
    {
        if(!pedido.containsKey(producto)) throw new ProductoNoEnCarritoException();

        pedido.put(producto, pedido.get(producto)-1);
        actualizarImporteTotal(-producto.getPrecio());

        if(pedido.get(producto) == 0)
        {
            Iterator<Map.Entry<Producto, Integer>> iterator = pedido.entrySet().iterator();
            while(iterator.hasNext())
            {
                if(iterator.next().getValue() == 0) iterator.remove();
            }
        }
    }

    public void aplicarPromo3x2()
    {
        int cantidadReducir;
        for(Map.Entry<Producto, Integer> producto : pedido.entrySet())
        {
            if(producto.getValue() >= 3)
            {
                cantidadReducir = producto.getValue()/3;
                actualizarImporteTotal(-cantidadReducir*producto.getKey().getPrecio());
            }
        }
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
        StringBuilder carrito = new StringBuilder();
        for(Map.Entry<Producto, Integer> producto : pedido.entrySet())
            carrito.append(producto.getKey() +", Unidades: "+ producto.getValue());

        return "Carrito: "+ carrito +
                "\nImporte total: "+ importeTotal;
    }
}