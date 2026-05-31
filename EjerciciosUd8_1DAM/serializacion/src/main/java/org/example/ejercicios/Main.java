package org.example.ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main
{
    static void serializarAct1(String archivo)
    {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Eric", 25));
        listaPersonas.add(new Persona("Raúl", 45));
        listaPersonas.add(new Persona("María", 19));
        listaPersonas.add(new Persona("Raquel", 22));
        listaPersonas.add(new Persona("Manuel", 52));

        try
        {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/ejercicios/"+ archivo));

            out.writeObject(listaPersonas);

            out.close();

        }
        catch (IOException e)
        {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }

        System.out.println("Objeto serializado en "+ archivo);
    }

    static void deserializarAct1()
    {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/ejercicios/clase_prueba.ser"));
            ArrayList<Persona> listaPersonas = (ArrayList<Persona>) in.readObject();
            in.close();
            System.out.println("Personas listadas:");
            for(Persona persona : listaPersonas)
                System.out.println("\t- "+ persona);
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }
    }

    static void serializarAct2()
    {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Eric", 25, "Alicante"));
        listaPersonas.add(new Persona("Raúl", 45, "Valencia"));
        listaPersonas.add(new Persona("María", 19, "Madrid"));
        listaPersonas.add(new Persona("Raquel", 22, "Málaga"));
        listaPersonas.add(new Persona("Manuel", 52, "Barcelona"));

        try
        {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/ejercicios/clase_prueba.ser"));

            out.writeObject(listaPersonas);

            out.close();

        }
        catch (IOException e)
        {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }

        System.out.println("Objeto serializado en clase_prueba.ser");
    }

    static void deserializarAct2()
    {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/ejercicios/clase_prueba.ser"));
            ArrayList<Persona> listaPersonas = (ArrayList<Persona>) in.readObject();
            in.close();
            System.out.println("Personas listadas:");
            for(Persona persona : listaPersonas)
                System.out.println("\t- "+ persona +" Provincia: "+ persona.getProvincia());
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }
    }

    static void actividad3()
    {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/ejercicios/actividad3.ser"));
            ArrayList<Persona> listaPersonas = (ArrayList<Persona>) in.readObject();
            in.close();
            System.out.println("Personas listadas:");
            for(Persona persona : listaPersonas)
                System.out.println("\t- "+ persona);
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Algo ha ido mal. Generando archivo por defecto");
            serializarAct1("actividad3.ser");
            e.printStackTrace();
        }
    }

    static void serializarAct4()
    {
        TreeMap<String, Mascota> mascotas = new TreeMap<>();
        mascotas.put("Calcetines", new Mascota(6, "Calico"));
        mascotas.put("Carlo Magno", new Mascota(1, "Hamster"));
        mascotas.put("Thor", new Mascota(4, "Pastor alemán"));
        mascotas.put("Acelga", new Mascota(12, "Loro"));

        try
        {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/ejercicios/mapa.ser"));

            out.writeObject(mascotas);

            out.close();

        }
        catch (IOException e)
        {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }

        System.out.println("Objeto serializado en mapa.ser");
    }

    static void deserializarAct4()
    {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/ejercicios/mapa.ser"));
            TreeMap<String, Mascota> mascotas = (TreeMap<String, Mascota>) in.readObject();
            in.close();
            System.out.println("Mascotas:");
            for(Map.Entry<String, Mascota> mascota : mascotas.entrySet())
                System.out.println("\t- "+ mascota.getKey() +". "+ mascota.getValue());
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Algo ha ido mal. Generando archivo por defecto");
            serializarAct4();
            e.printStackTrace();
        }
    }

    static void serializarAct5()
    {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Jefe("Macarena", 4050, "Recursos Humanos"));
        listaEmpleados.add(new Empleado("Marcos", 2400));
        listaEmpleados.add(new Jefe("Juan", 3900, "Testing"));
        listaEmpleados.add(new Empleado("María", 2620));
        listaEmpleados.add(new Empleado("Encarna", 2455));

        try
        {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/ejercicios/actividad5.ser"));

            out.writeObject(listaEmpleados);

            out.close();

        }
        catch (IOException e)
        {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }

        System.out.println("Objeto serializado en actividad5.ser");
    }

    static void deserializarAct5()
    {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/ejercicios/actividad5.ser"));
            ArrayList<Empleado> listaEmpleados = (ArrayList<Empleado>) in.readObject();
            in.close();

            for(Empleado empleado : listaEmpleados)
            {
                if(empleado.getClass() == Jefe.class) System.out.println("Jefe:");
                else System.out.println("Empleado:");

                System.out.println(empleado);

                System.out.println();
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Algo ha ido mal. Generando archivo por defecto");
            serializarAct5();
            e.printStackTrace();
        }
    }

    static void main()
    {
        System.out.println("Actividad 1");
        serializarAct1("clase_prueba.ser");
        deserializarAct1();

        System.out.println("\nActividad 2");
        serializarAct2();
        deserializarAct2();

        System.out.println("\nActividad 3");
        actividad3();

        System.out.println("\nActividad 4");
        serializarAct4();
        deserializarAct4();

        System.out.println("\nActividad 5");
        serializarAct5();
        deserializarAct5();
    }
}
