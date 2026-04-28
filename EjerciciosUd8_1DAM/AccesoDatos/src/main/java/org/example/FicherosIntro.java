package org.example;

import java.io.File;
import java.io.IOException;

public class FicherosIntro
{
    static void main()
    {
        File archivo = new File("src/main/resources/prueba.txt");
//        File archivoOriginal = new File("prueba.txt");
//
//        archivoOriginal.deleteOnExit();
//
//        Estos dos son iguales
//
//        if(archivoOriginal.createNewFile()) System.out.println("Archivo eliminado.");
//        else System.out.println("Archivo NO eliminado");

        //Crear fichero
        try
        {
            if(archivo.createNewFile()) System.out.println("Archivo creado.");
            else System.out.println("Ruta inválida || Archivo ya existe");
        }
        catch(IOException e)
        {
            System.out.println("ERROR\n"+ e.getMessage());
        }

        System.out.println("Ruta absoluta: "+ archivo.getAbsolutePath());
        System.out.println("Tamaño: "+ archivo.length());

        //Eliminar fichero
        if(archivo.delete()) System.out.println("Archivo "+ archivo.getName() +" eliminado.");
        else System.out.println("El archivo "+ archivo.getName() +" no se puede eliminar");

        File carpeta = new File("src/main/resources/pruebas");

        //Crear directorio
        if(carpeta.mkdir()) System.out.println("Carpeta "+ carpeta.getName() +" creada.");
        else System.out.println("La carpeta "+ carpeta.getName() +" no se puede crear.");
    }
}