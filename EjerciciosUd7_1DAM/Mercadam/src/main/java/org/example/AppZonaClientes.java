package org.example;
import org.example.mercadam.Cliente;
import org.example.mercadam.Mercadam;

import java.util.List;
import java.util.Set;

public class AppZonaClientes
{
    private static final Mercadam mercadam = new Mercadam();
    private static Cliente cliente = null;

    public static void autentificacion(Set<Cliente> clientes)
    {
        String usuario;
        String contrasenya;
        for(int i = 0; i < 3; i++)
        {
            System.out.print("Usuario: ");
            usuario = FuncionesComunes.solicitarString();
            System.out.print("Contrasenya: ");
            contrasenya = FuncionesComunes.solicitarString();

            if(clientes.)
        }
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

    static void main()
    {
        for(int i = 0; i < 10; i++)
            mercadam.generarClientes();
        System.out.println(mercadam.getListaClientes().size() +" clientes generados:"+ mercadam.getListaClientes());

        System.out.println("\t === COMPRA ONLINE EN MERCADAM ===");
        autentificacion(mercadam.getListaClientes());
    }
}
