package org.example;
import org.example.mercadam.Cliente;
import org.example.mercadam.Mercadam;
import java.util.Set;

public class AppZonaClientes
{
    private static final Mercadam mercadam = new Mercadam();
    private static Cliente cliente = null;

    public static void autentificacion(Set<Cliente> listaClientes)
    {
        String usuario = "";
        String contrasenya = "";
        for(int i = 2; i >= 0; i--)
        {
            System.out.print("Usuario: ");
            usuario = FuncionesComunes.solicitarString();
            System.out.print("Contrasenya: ");
            contrasenya = FuncionesComunes.solicitarString();

            if(listaClientes.contains(new Cliente(usuario, contrasenya))) break;
            else
            {
                System.out.println("Credenciales inválidas. Intentos: "+ i);
                if(i == 0) return;
            }
        }
        cliente = new Cliente(usuario, contrasenya);
    }

    public static void iniciarCompra()
    {

    }

    public static void imprimirProductos()
    {

    }

    public static void imprimirResumen()
    {

    }

    public static void imprimirDespedida()
    {

    }

    public static void mostrarOpciones()
    {

    }

    public static boolean validarInicioSesion()
    {
        if(cliente == null)
        {
            System.out.println("ERROR DE AUTENTIFICACIÓN");
            return false;
        }
        else
        {
            System.out.println("Bienvenido, "+ cliente.getUsuario());
            return true;
        }
    }

    public static void recuperarDatos()
    {
        for(int i = 0; i < 10; i++)
            mercadam.generarClientes();
        System.out.println(mercadam.getListaClientes().size() +" clientes generados:"+ mercadam.getListaClientes());
    }

    static void main()
    {
        recuperarDatos();
        System.out.println("\t === COMPRA ONLINE EN MERCADAM ===");
        autentificacion(mercadam.getListaClientes());

        if(validarInicioSesion())
        {
        }
    }
}
