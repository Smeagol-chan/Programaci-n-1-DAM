package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ActividadesFicheros
{
    static Scanner key = new Scanner(System.in);

    static void actividad4()
    {
        System.out.println("¿Cuántos ficheros quieres crear?");
        int cantidad = key.nextInt();
        key.nextLine();
        System.out.println("¿En qué carpeta?");
        String directorioPath = key.nextLine();

        File directorio = new File(directorioPath);
        File fichero;

        if(!directorio.exists())
        {
            if(directorio.mkdir()) System.out.println("Directiorio "+ directorio.getName() +" creado.");
            else
            {
                System.out.println("No se puede crear la carpeta "+ directorio.getName() +".");
                return;
            }
        }
        else System.out.println("El directorio ya existe. Creando dentro los nuevos archivos.");

        for (int i = 0; i < cantidad; i++)
        {
            fichero = new File(directorioPath +"/"+ i);
            try
            {
                if(fichero.createNewFile()) System.out.println("Fichero "+ fichero.getName() +" creado.");
                else System.out.println("El fichero "+ fichero.getName() +" no se puede crear.");
            }
            catch(IOException e)
            {
                System.out.println("ERROR\n"+ e.getMessage());
            }
        }
    }

    static void actividad5(String directorioPath)
    {
        File directorio = new File(directorioPath);

        if(directorio.exists())
        {
            if(directorio.isDirectory())
            {
                File[] listaArchivos = directorio.listFiles();
                if(listaArchivos != null && listaArchivos.length > 0)
                {
                    for(File f : listaArchivos)
                        if(f.isFile() && f.getName().matches("^.*/.txt$"));
                }
            }
        }
        else System.out.println("El directorio no existe.");
    }

    static void main()
    {
        System.out.println("Actividad 4: Creación de archivos.");
        actividad4();

        System.out.println("\nActividad 5: Listado del contenido.");
        System.out.println("Introduzca el directorio que quieras consultar.");
        actividad5(key.nextLine());
    }
}
