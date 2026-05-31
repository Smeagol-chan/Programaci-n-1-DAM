package org.example.practica4.ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    static void crearJSON()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<Videojuego> inventario = new ArrayList<>();

        inventario.add(new Videojuego("Balatro", Plataforma.PC, 14.99, true, Arrays.asList("Rogue-like", "Construcción de mazos")));
        inventario.add(new Videojuego("Children of the sun", Plataforma.PC, 14.79, true, Arrays.asList("Puzzle", "Disparos")));
        inventario.add(new Videojuego("Outer Wilds", Plataforma.PC, 22.99, true, Arrays.asList("Aventura", "Puzzle")));

        inventario.add(new Videojuego("Splatoon 3", Plataforma.SWITCH, 59.99, true, Arrays.asList("Multijugador competitivo", "Shooter")));
        inventario.add(new Videojuego("Pokémon Leyendas Arceus", Plataforma.SWITCH, 59.99, true, Arrays.asList("RPG", "Aventura", "Combate por turnos")));
        inventario.add(new Videojuego("Super Mario Odyssey", Plataforma.SWITCH, 59.99, true, Arrays.asList("Aventura", "Plataforma")));

        inventario.add(new Videojuego("Bloodborne", Plataforma.PS4, 19.99, true, Arrays.asList("RPG", "Acción")));
        inventario.add(new Videojuego("The Last of Us Remastered", Plataforma.PS4, 19.99, true, Arrays.asList("Disparos", "Acción-Aventura")));
        inventario.add(new Videojuego("God of War", Plataforma.PS4, 19.99, true, Arrays.asList("Hack and Slash", "Single player")));

        String json = gson.toJson(inventario);
        System.out.println("Videojuegos: "+ json);

        try (FileWriter writer = new FileWriter("src/main/resources/practica4/ejercicio1/videojuegos.json"))
        {
            gson.toJson(inventario, writer);
            System.out.println("Inventario guardado en videojuegos.json");
        }
        catch (IOException e)
        {
            System.out.println("Algo ha salido mal.");
            e.printStackTrace();
        }
    }

    static void anyadirJuegoAlJSON()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try
        {
            FileReader reader = new FileReader("src/main/resources/practica4/ejercicio1/videojuegos.json");
            ArrayList<Videojuego> inventario = new ArrayList<>(Arrays.asList(gson.fromJson(reader, Videojuego[].class)));

            inventario.add(new Videojuego("Hollow Knight", Plataforma.PC, 14.79, true, Arrays.asList("Metroidvania", "Acción-Aventura")));
            juegosMenores30Euros(inventario);

            FileWriter writer = new FileWriter("src/main/resources/practica4/ejercicio1/videojuegos.json");
            gson.toJson(inventario, writer);
            System.out.println("Inventario guardado en videojuegos.json");
        }
        catch(IOException e)
        {
            System.out.println("Algo ha salido mal.");
            e.printStackTrace();
        }
    }

    static void juegosMenores30Euros(List<Videojuego> inventario)
    {
        for(Videojuego videojuego : inventario)
            if(videojuego.getPrecio() < 30) System.out.println(videojuego);
    }

    static void main()
    {
        crearJSON();
        anyadirJuegoAlJSON();
    }
}
