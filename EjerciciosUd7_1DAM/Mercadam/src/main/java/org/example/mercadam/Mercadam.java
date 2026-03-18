package org.example.mercadam;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Mercadam
{
    private Set<Cliente> listaClientes;

    public Mercadam()
    {
        listaClientes = new HashSet<>();
    }

    public void generarClientes()
    {
        //Pedir datos del cliente
    }

    public Set<Cliente> getListaClientes()
    {
        return Collections.unmodifiableSet(listaClientes);
    }
}
