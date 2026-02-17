package org.example.intro_interface;

import java.util.ArrayList;

public class VoladoresApp
{
    static void main()
    {
        Superman superman = new Superman();
        Spiderman spiderman = new Spiderman();

        ArrayList<Superhero> listaHeroes = new ArrayList<>();
        listaHeroes.add(superman);
        listaHeroes.add(spiderman);

        for(Superhero superhero : listaHeroes)
        {
            if(superhero instanceof Superman) break;
                //superhero.cogelar(); Es porque los métodos NO están en la clase madre.
        }
    }
}
