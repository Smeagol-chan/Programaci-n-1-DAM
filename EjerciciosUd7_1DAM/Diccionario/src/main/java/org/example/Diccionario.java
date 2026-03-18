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
        if(!diccionario.containsKey(palabra)) throw new KeyNotExistException();
        else return diccionario.get(palabra);
    }

    public String palabraAleatoria()
    {
        Random random = new Random();
        LinkedList<String> palabrasEspannol = new LinkedList<>(diccionario.keySet());
        return palabrasEspannol.get(random.nextInt(diccionario.size()));
    }

    public char primeraLetraTraduccion(String palabraEspannol)
    {
        if(!diccionario.containsKey(palabraEspannol)) throw new KeyNotExistException();
        else return diccionario.get(palabraEspannol).charAt(0);
    }
}