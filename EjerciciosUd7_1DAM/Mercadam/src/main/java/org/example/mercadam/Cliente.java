package org.example.mercadam;
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
        setPromociones(false);
    }

    public void anyadirAlCarrito(Producto producto)
    {
        pedido.agregarProducto(producto);
    }

    public void quitarDelCarrito(Producto producto)
    {
        pedido.eliminarProducto(producto);
    }

    public void crearPedido()
    {
        pedido = new Pedido();
    }

    public void aplicarPromociones()
    {
        if(!promociones)
        {
            pedido.aplicarPromo3x2();
            pedido.aplicarPromo10();
            setPromociones(true);
            System.out.println(" ======================================");
            System.out.println(" PROMO 3x2 y 10% DESC. APLICADAS");
            System.out.println(" ======================================");
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean getPromociones() {
        return promociones;
    }

    private void setPromociones(boolean promociones) {
        this.promociones = promociones;
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
                (pedido == null ? "" : "\n"+ pedido) +
                "\nPromociones: "+ (promociones ? "Canjeadas" : "Disponibles") +
                "\n";
    }
}
