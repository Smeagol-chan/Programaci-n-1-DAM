package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DiccionarioTest
{
    Diccionario diccionario = new Diccionario();

    @BeforeEach
    void inicializarDiccionario()
    {
        diccionario.nuevoPar("Herida", "wound");
    }

    @Test
    void nuevoPar()
    {
        String valorEsperado = "La palabra en español ya está presente.";
        String valorDevuelto = "";

        try
        {
            diccionario.nuevoPar("Herida", "wound");
        }
        catch(KeyDuplicatedException e)
        {
            valorDevuelto = e.getMessage();
        }

        assertEquals(valorEsperado, valorDevuelto);
    }

    @ParameterizedTest
    @CsvSource({
            "Herida, wound",
            "Crujido, La palabra no está en el diccionario."
    })
    void traduce(String palabraClave, String palabraEsperada)
    {
        String resultado;
        try
        {
            resultado = diccionario.traduce(palabraClave);
        }
        catch(KeyNotExistException e)
        {
            resultado = e.getMessage();
        }

        assertEquals(palabraEsperada, resultado);
    }

    @Test
    void palabraAleatoria()
    {
        String resultado = diccionario.palabraAleatoria();
        assertEquals("Herida", resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "Herida, w",
            "Crujir, La palabra no está en el diccionario."
    })
    void primeraLetraTraduccion(String palabraDada, String palabraEsperada)
    {
        String resultado;

        try
        {
            resultado = String.valueOf(diccionario.primeraLetraTraduccion(palabraDada));
        }
        catch(KeyNotExistException e)
        {
            resultado = e.getMessage();
        }

        assertEquals(palabraEsperada, resultado);
    }

    @Test
    void diccionarioVacio()
    {
        Diccionario diccionarioVacio = new Diccionario();
        String resultadoEsperado = "El diccionario está vacío.";
        String resultado_traduce;
        String resultado_palabraAleatoria;
        String resultado_primeraLetraTraduccion;

        try
        {
            resultado_traduce = diccionarioVacio.traduce("Herida");
        }
        catch(EmptyDiccionaryException e)
        {
            resultado_traduce = e.getMessage();
        }

        try
        {
            resultado_palabraAleatoria = diccionarioVacio.palabraAleatoria();
        }
        catch(EmptyDiccionaryException e)
        {
            resultado_palabraAleatoria = e.getMessage();
        }

        try
        {
            resultado_primeraLetraTraduccion = String.valueOf(diccionarioVacio.primeraLetraTraduccion("Herida"));
        }
        catch(EmptyDiccionaryException e)
        {
            resultado_primeraLetraTraduccion = e.getMessage();
        }

        assertEquals(resultadoEsperado, resultado_traduce);
        assertEquals(resultadoEsperado, resultado_palabraAleatoria);
        assertEquals(resultadoEsperado, resultado_primeraLetraTraduccion);
    }
}