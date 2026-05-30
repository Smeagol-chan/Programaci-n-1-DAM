package org.example;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class ActividadesFicheros
{
    static Scanner key = new Scanner(System.in);

    static void actividad1()
    {
        File archivo = new File("src/main/resources/prueba.txt");

        try
        {
            if (archivo.createNewFile()) System.out.println("Archivo creado: " + archivo.getName());
            else System.out.println("El archivo " + archivo.getName() + " ya existe.");

        }
        catch (IOException e)
        {
            System.out.println("Ha habido algún problema.");
            e.printStackTrace();
        }
    }

    static void actividad2()
    {
        File archivo = new File("src/main/resources/ejemplo1.txt");

        try
        {
            if (archivo.createNewFile()) System.out.println("Archivo creado: " + archivo.getName());
            else System.out.println("El archivo " + archivo.getName() + " ya existe.");

        }
        catch (IOException e)
        {
            System.out.println("Ha habido algún problema.");
            e.printStackTrace();
        }
    }

    static void actividad3()
    {
        File archivo = new File("src/main/resources/ejemplo1.txt");

        System.out.println("Ruta absoluta: "+ archivo.getAbsolutePath());
        System.out.println("Tamaño: "+ archivo.length());
    }

    static void actividad4()
    {
        System.out.println("¿Cuántos ficheros quieres crear?");
        int cantidad = key.nextInt();
        key.nextLine();
        System.out.println("¿En qué carpeta?");
        String directorioPath = key.nextLine();

        File directorio = new File("src/main/resources/"+ directorioPath);
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

    static void actividad5()
    {
        File directorio = new File("src/main/resources/act5");

        if(directorio.exists())
        {
            if(directorio.isDirectory())
            {
                File[] listaArchivos = directorio.listFiles();
                if(listaArchivos != null && listaArchivos.length > 0)
                {
                    System.out.println("Los archivos .txt:");
                    for(File f : listaArchivos)
                        // El regex empieza con .* (cualquier cosa en cualquier cantidad) y depués \\.txt (la primera barra escapa la segunda y esta escapa el punto)
                        if(f.isFile() && f.getName().matches("^.*\\.txt$"))
                            System.out.println("- "+ f.getName());

                    System.out.println("\nTodos los archivos:");
                    for(File f : listaArchivos)
                        if(f.isFile())
                            System.out.println("- "+ f.getName());
                }
            }
        }
        else System.out.println("El directorio no existe.");
    }

    static void actividad6(String palabraBuscar)
    {
        int apariciones = 0;
        try
        {
            BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/act6.txt"));
            String linea;

            while((linea = lector.readLine()) != null)
            {
                for(String palabra : linea.split(" "))
                    if(palabra.equals(palabraBuscar)) apariciones++;
            }
            lector.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e);
        }
        System.out.println("Número de coincidencias: "+ apariciones);
    }

    static void actividad7()
    {
        try
        {
            File archivo = new File("src/main/resources/act7.txt");
            Scanner lector = new Scanner(archivo);
            int contador = 0;

            while(lector.hasNextLine())
            {
//                Con queues es bastante más complicado de implementar de lo que lo es un array simple y de lo que lo fue el stack
//                Queue<String> nombre_edad = new ArrayDeque<>();
//                nombre_edad.addAll(Arrays.asList(lector.nextLine().split(", ")));

                String[] nombre_edad = lector.nextLine().split(", ");
                System.out.println("Línea "+ (++contador)+ ": "+ nombre_edad[0] + " de "+ nombre_edad[1] +" años");
            }
            lector.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    static void actividad8()
    {
        System.out.println("¿Cuántos ficheros quieres crear?");
        int cantidad = key.nextInt();
        key.nextLine();
        String directorioPath = "src/main/resources/act8";

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
            fichero = new File(directorioPath +"/fichero"+ i +".txt");
            try
            {
                if(fichero.createNewFile())
                {
                    System.out.println("Fichero "+ fichero.getName() +" creado.");
                    BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero));
                    escribir.write("Este es el fichero "+ fichero.getName());
                    escribir.close();
                }
                else System.out.println("El fichero "+ fichero.getName() +" no se puede crear.");
            }
            catch(IOException e)
            {
                System.out.println("ERROR\n"+ e.getMessage());
            }
        }
    }

    static void actividad9()
    {
        try
        {
            File archivoOriginal = new File("src/main/resources/act9.txt");
            File archivoTemporal = new File("src/main/resources/act9_temp.txt");

            BufferedReader leerArchivoOriginal = new BufferedReader(new FileReader(archivoOriginal));
            String linea;

            if(!archivoTemporal.createNewFile()) return;

            BufferedWriter escribirArchivoTemporal = new BufferedWriter(new FileWriter(archivoTemporal));

            while((linea = leerArchivoOriginal.readLine()) != null)
            {
                String[] palabras = linea.split(" ");
                String lineaConvertida = "";

                for(int i = 0; i < palabras.length; i++)
                {
                    lineaConvertida += String.valueOf(palabras[i].charAt(0)).toUpperCase();
                    lineaConvertida += palabras[i].substring(1) +" ";
                }
                escribirArchivoTemporal.write(lineaConvertida);
                escribirArchivoTemporal.flush();
            }
            leerArchivoOriginal.close();
            escribirArchivoTemporal.close();

            if(archivoOriginal.delete())
                archivoTemporal.renameTo(archivoOriginal);
        }
        catch (IOException e)
        {
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    static void actividad10()
    {
        try
        {
            boolean archivo1_tieneContenido, archivo2_tieneContenido;
            String directorio = "src/main/resources/act10/", lineaArchivo1, lineaArchivo2;
            File archivoCombinado = new File(directorio +"archivoCombinado.txt");

            if(!archivoCombinado.createNewFile()) throw new IOException("El archivo ya existe.");

            BufferedReader archivo1 = new BufferedReader(new FileReader(directorio +"archivo1.txt"));
            BufferedReader archivo2 = new BufferedReader(new FileReader(directorio +"archivo2.txt"));
            PrintWriter writer = new PrintWriter(new FileWriter(archivoCombinado));

            do
            {
                lineaArchivo1 = archivo1.readLine();
                lineaArchivo2 = archivo2.readLine();

                archivo1_tieneContenido = lineaArchivo1 != null;
                archivo2_tieneContenido = lineaArchivo2 != null;

                if(archivo1_tieneContenido && archivo2_tieneContenido)

            } while(archivo1_tieneContenido || archivo2_tieneContenido);
        }
        catch(IOException e)
        {
            System.out.println("Ha habido algún problema.");
            e.printStackTrace();

        }
    }

    static void main()
    {
//        System.out.println("Actividad 1");
//        actividad1();
//
//        System.out.println("\nActividad 2");
//        actividad2();
//
//        System.out.println("\nActividad 3");
//        actividad3();
//
//        System.out.println("\nActividad 4");
//        actividad4();
//
//        System.out.println("\nActividad 5");
//        actividad5();
//
//        System.out.println("\nActividad 6");
//        System.out.print("Introduzca una palabra a buscar: ");
//        actividad6(key.nextLine());
//
//        System.out.println("\nActividad 7");
//        actividad7();
//
//        System.out.println("\nActividad 8");
//        actividad8();
//
//        System.out.println("\nActividad 9");
//        actividad9();

        System.out.println("\nActividad 10");
        actividad10();
    }
}
