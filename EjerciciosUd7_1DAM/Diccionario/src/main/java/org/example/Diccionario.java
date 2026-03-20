package org.example;


import java.util.*;

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
        if(diccionario.isEmpty()) throw new EmptyDiccionaryException();
        else if(!diccionario.containsKey(palabra)) throw new KeyNotExistException();
        else return diccionario.get(palabra);
    }

    public String palabraAleatoria()
    {
        if(diccionario.isEmpty()) throw new EmptyDiccionaryException();
        else
        {
            Random random = new Random();
            List<String> palabrasEspannol = new LinkedList<>(diccionario.keySet());
            return palabrasEspannol.get(random.nextInt(diccionario.size()));
        }
    }

    public char primeraLetraTraduccion(String palabraEspannol)
    {
        if(diccionario.isEmpty()) throw new EmptyDiccionaryException();
        else if(!diccionario.containsKey(palabraEspannol)) throw new KeyNotExistException();
        else return diccionario.get(palabraEspannol).charAt(0);
    }
}