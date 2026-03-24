package org.example.mercadam;

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
