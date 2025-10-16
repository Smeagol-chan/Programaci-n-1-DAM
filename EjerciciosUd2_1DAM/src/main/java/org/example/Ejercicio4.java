package org.example;

//Este lo hizo un compañero. Bastante fresco.
public class Ejercicio4
{
    static void main()
    {
        String texto = "Hola Mundo, bienvenido a Mundo. Mundo es genial", mundo = "Mundo", txtAux;
        /*
        int posicion = 0, posicionAux = 0, contador = 0, ;

        posicion = texto.indexOf(texto, 0);
        if(posicion != posicionAux) contador++;
        */
        int tamT = texto.length(), tamM = mundo.length(), tamAux, resto;

        txtAux = texto.replace(mundo, "");
        tamAux = txtAux.length();
        resto = tamT - tamAux;
        System.out.println((resto/tamM));
    }
}
