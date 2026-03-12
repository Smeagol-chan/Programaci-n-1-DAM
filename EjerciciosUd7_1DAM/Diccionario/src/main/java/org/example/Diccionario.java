package org.example;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Diccionario
{
    private HashMap<String, String> diccionario;

    public Diccionario()
    {
        diccionario = new HashMap<>();
    }

    public void nuevoPar(String clave, String valor)
    {
        if(diccionario.containsKey(clave)) throw new KeyDuplicatedException();
        else diccionario.put(clave, valor);
    }

    public String traduce(String palabra)
    {
        if(!diccionario.containsKey(palabra)) throw new KeyNotExistException();
        else return diccionario.get(palabra);
    }

    public String palabraAleatoria()
    {
        Random random = new Random();
        Set<String> palabrasEspannol = diccionario.keySet();
        return palabrasEspannol.
    }
}