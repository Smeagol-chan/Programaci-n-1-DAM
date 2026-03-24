package org.example.mercadam;
import org.example.FuncionesComunes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Mercadam
{
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TAM_STRING_AUTOGENERADO = 8;

    private Set<Cliente> listaClientes;

    public Mercadam()
    {
        listaClientes = new HashSet<>();
    }

    public void generarClientes()
    {
        listaClientes.add(new Cliente(generarString(), generarString()));
    }

    private String generarString()
    {
        StringBuilder stringGenerado = new StringBuilder();
        for(int i = 0; i < TAM_STRING_AUTOGENERADO; i++)
            stringGenerado.append(CARACTERES.charAt(FuncionesComunes.random.nextInt(CARACTERES.length())));

        return stringGenerado.toString();
    }

    public Set<Cliente> getListaClientes()
    {
        return Collections.unmodifiableSet(listaClientes);
    }
}