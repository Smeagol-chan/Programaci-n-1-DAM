package org.example.mercadam;
import java.util.HashSet;
import java.util.Objects;

public class Cliente
{
    private static final String DEFAULT_DIRECCION = "Calle falsa, 123";

    private String usuario;
    private String contrasenya;
    private String direccion;
    private Pedido pedido;
    private boolean promociones;

    public Cliente(String usuario, String contrasenya)
    {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        pedido = null;
        direccion = DEFAULT_DIRECCION;
        promociones = false;
    }

    public void insertarProducto(Producto producto)
    {
        pedido.actualizarPedido(producto);
    }

    public void crearPedido()
    {
        pedido = new Pedido();
    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return Objects.equals(usuario, cliente.usuario) && Objects.equals(contrasenya, cliente.contrasenya);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(usuario, contrasenya);
    }

    @Override
    public String toString()
    {
        return "\nUsuario: "+ usuario +
                "\nContraseña: "+ contrasenya +
                "\nDirección: "+ direccion +
                (pedido == null ? "" : pedido) +
                "\nPromociones: "+ (promociones ? "Disponibles" : "Canjeados") +
                "\n";
    }
}
